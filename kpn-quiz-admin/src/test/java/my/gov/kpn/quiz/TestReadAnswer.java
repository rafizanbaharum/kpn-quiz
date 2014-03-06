package my.gov.kpn.quiz;

import java.io.IOException;

public class TestReadAnswer {

    public static void main(String[] args) throws IOException {

        ExcelReader reader = new ExcelReader();
        StudentAnswer studentAnswer = reader.readAnswer("c:\\temp\\borang jawapan.xlsx");
        System.out.println(studentAnswer);

    }
}
