package my.gov.kpn.quiz.manual;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ExcelReader {
    private final int MAX_ROW = 56;


    public StudentAnswerModel readAnswer(String fileName) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(fileName);
        XSSFSheet sheet = workbook.getSheetAt(0);

        StudentAnswerModel answer = new StudentAnswerModel();
        String val = "";
        for (int i = 0; i < 56; i++) {

            XSSFRow row = sheet.getRow(i);
            XSSFCell cell = row.getCell(1);
            int cellType = cell.getCellType();
            if (0 == cellType){
                val = String.valueOf(cell.getNumericCellValue());
                val = val.substring(0,val.indexOf("."));
            }
            else
            val = cell.getStringCellValue();
            if (i == 0) answer.setName(val);
            else if (i == 1) answer.setNric(val);
            else if (i == 2) answer.setSchool(val);
            else if (i == 3) answer.setState(val);
            else if (i == 4) {}
            else
            answer.setNextAnswer(val);

        }
        return answer;
    }

}
