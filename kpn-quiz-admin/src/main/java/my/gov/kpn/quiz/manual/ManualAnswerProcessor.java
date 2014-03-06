package my.gov.kpn.quiz.manual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

@Service
public class ManualAnswerProcessor {

    private String inputDir = "";

    @Autowired
    private ExcelReader excelReader;

    public void start(){

        File dir = new File(inputDir);
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.contains(".xls")) return true;
                if (name.contains(".xlsx")) return true;
                return false;
            }
        };

        File[] files = dir.listFiles(filter);
        for (File file : files) {
            if (file.canRead()){
                try {
                    StudentAnswerModel studentAnswerModel = excelReader.readAnswer(file.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
