package my.gov.kpn.quiz.biz;

import my.gov.kpn.quiz.config.Config;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@SuppressWarnings({"SpringJavaAutowiringInspection"})
@ContextConfiguration(classes = {Config.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmailTest extends AbstractTransactionalJUnit4SpringContextTests {

    private static final Logger log = Logger.getLogger(EmailTest.class);

    @Autowired
    private JavaMailSender mailSender;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {

    }

    @Test
    @Rollback(true)
    public void sendEmail() throws Exception {
        mailSender.send(new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom(new InternetAddress("fs.error@digitalspace.com.my", "KPN ASEAN Quiz"));
                mimeMessage.setSender(new InternetAddress("fs.error@digitalspace.com.my"));
                InternetAddress[] addresses = {new InternetAddress("alifhaikal88@gmail.com"),
                        new InternetAddress("rafizan.baharum@gmail.com"),
                        new InternetAddress("faizal.manan@gmail.com")};
                mimeMessage.setRecipients(Message.RecipientType.TO, addresses);
                mimeMessage.setSubject("Test Email");
                mimeMessage.setSentDate(new Date());
                mimeMessage.setText("Hello! \n\nThis is a test mail from KPN Quiz Application");
                mimeMessage.saveChanges();
            }
        });
    }
}
