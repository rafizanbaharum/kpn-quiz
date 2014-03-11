package my.gov.kpn.quiz;

import my.gov.kpn.quiz.manual.ExcelReader;
import my.gov.kpn.quiz.manual.StudentAnswerModel;

import java.io.IOException;

public class TestReadAnswer {

    public static void main(String[] args) throws IOException {

        ExcelReader reader = new ExcelReader();
        StudentAnswerModel studentAnswer = reader.readAnswer("c:\\temp\\borang jawapan.xlsx");
        System.out.println(studentAnswer);

    }
}
