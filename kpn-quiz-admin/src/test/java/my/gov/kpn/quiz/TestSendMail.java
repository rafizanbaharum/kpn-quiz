package my.gov.kpn.quiz;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class TestSendMail {

    private JavaMailSender mailSender;
    private AnnotationConfigApplicationContext context;

    public static void main(String[] args) {

        TestSendMail mail = new TestSendMail();
        mail.testMail();

    }

    public TestSendMail() {
        context = new AnnotationConfigApplicationContext(TestAppConfig.class);
    }

    public void testMail() {

        mailSender = context.getBean(JavaMailSender.class);

        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(new InternetAddress("fs.error@digitalspace.com.my", "KPN ASEAN Quiz"));
            InternetAddress[] addresses = {new InternetAddress("faizal.manan@gmail.com"),
                        new InternetAddress("rafizan.baharum@gmail.com"),
                        new InternetAddress("mysafie@gmail.com")};
            helper.setTo(addresses);
            helper.setSubject("Test send mail with attachment");
            helper.setSentDate(new Date());
            helper.setText("Should find attachment in this mail\n\n\nSalam tok,\ndah bleh anta email ikut attachment,\ntp kene buat another standalone app, " +
                    "tak leh nak create module, coz nnt kene timeout! ");



            FileSystemResource file = new FileSystemResource("C:\\temp\\borang_jawapan.xlsx");
            helper.addAttachment(file.getFilename(), file);
            mailSender.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
