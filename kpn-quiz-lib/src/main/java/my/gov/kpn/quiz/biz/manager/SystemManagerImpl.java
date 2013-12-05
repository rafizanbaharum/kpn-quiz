package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.dao.*;
import my.gov.kpn.quiz.core.exception.LockedGroupException;
import my.gov.kpn.quiz.core.exception.RecursiveGroupException;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.QaInstructorImpl;
import my.gov.kpn.quiz.core.model.impl.QaStudentImpl;
import my.gov.kpn.quiz.core.model.impl.QaUserImpl;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
@Service("systemManager")
@Transactional
public class SystemManagerImpl implements SystemManager {

    private static final Logger log = Logger.getLogger(SystemManagerImpl.class);

    public static final String ADMIN = "root";
    public static final String GROUP_INSTRUCTOR = "GROUP_INSTRUCTOR";
    public static final String GROUP_STUDENT = "GROUP_STUDENT";

    @Autowired
    private QaUserDao userDao;

    @Autowired
    private QaActorDao actorDao;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void recoverPassword(final QaUser user) {
        mailSender.send(new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom(new InternetAddress("fs.error@digitalspace.com.my", "KPN ASEAN Quiz"));
                mimeMessage.setSender(new InternetAddress("fs.error@digitalspace.com.my"));
                InternetAddress[] addresses = {new InternetAddress("alifhaikal88@gmail.com"),
                        new InternetAddress("rafizan.baharum@gmail.com"),
                        new InternetAddress("faizal.manan@gmail.com")};
                mimeMessage.setRecipients(Message.RecipientType.TO, addresses);
                mimeMessage.setSubject("Password Recovery");
                mimeMessage.setSentDate(new Date());
                mimeMessage.setText("Hello! \n This is your password: " + user.getPassword());
                mimeMessage.saveChanges();
            }
        });
    }
}
