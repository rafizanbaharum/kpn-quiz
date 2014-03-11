package my.gov.kpn.quiz.manual;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Faizal Abdul Manan on 3/10/14.
 */
public class ManualAnswer {

    public static void main(String[] args){


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);


    }
}
