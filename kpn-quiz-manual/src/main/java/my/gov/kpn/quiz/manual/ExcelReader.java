package my.gov.kpn.quiz.manual;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.OldExcelFormatException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Component(value = "excelReader")
public class ExcelReader {

    private static final Logger log = Logger.getLogger(ExcelReader.class);


    private final int MAX_ROW = 56;


//    public StudentAnswerModel readAnswer(String fileName) throws IOException {
//
//        Workbook workbook = new XSSFWorkbook(fileName);
//        Sheet sheet = workbook.getSheetAt(0);
//
//        StudentAnswerModel answer = new StudentAnswerModel();
//        String val = "";
//        for (int i = 0; i < 56; i++) {
//
//            Row row = sheet.getRow(i);
//            Cell cell = row.getCell(1);
//            int cellType = cell.getCellType();
//            if (XSSFCell.CELL_TYPE_NUMERIC == cellType){
//                val = String.valueOf(cell.getNumericCellValue());
//                val = val.substring(0,val.indexOf(""));
//            }else if (XSSFCell.CELL_TYPE_BOOLEAN == cellType){
//                boolean bool = cell.getBooleanCellValue();
//                val = bool ? "T" : "F";
//            }
//            else
//            val = cell.getStringCellValue();
//
//            if (i >= 46 && i <= 55){
//                val = val.trim();
//                if (val.equalsIgnoreCase("true")) val = "T";
//                if (val.equalsIgnoreCase("false")) val = "F";
//            }
//
//            if (i == 0) answer.setName(val);
//            else if (i == 1) answer.setNric(val.replaceAll("-", ""));
//            else if (i == 2) answer.setSchool(val);
//            else if (i == 3) answer.setState(val);
//            else if (i == 4) {}
//            else
//                answer.setNextAnswer(val);
//        }
//        return answer;
//    }

    public StudentAnswerModel readAnswer(File fileName) throws IOException, OldExcelFormatException, WrongFormatException {


        Workbook workbook = null;
        if (fileName.getName().endsWith(".xls"))
            workbook = new HSSFWorkbook(new FileInputStream(fileName));
        else
            workbook = new XSSFWorkbook(fileName.getPath());
        Sheet sheet = workbook.getSheetAt(0);

        StudentAnswerModel answer = new StudentAnswerModel();
        String val = "";
        for (int i = 0; i < 56; i++) {

            Row row = sheet.getRow(i);
            Cell cell = row.getCell(1);

            if (null == cell) {
                throw new WrongFormatException("Unexpected column value at row " + i + " : " + fileName.getPath());
            }

            int cellType = cell.getCellType();
            if (HSSFCell.CELL_TYPE_NUMERIC == cellType) {
                val = String.valueOf(cell.getNumericCellValue());
                val = val.substring(0, val.indexOf(""));
            } else if (HSSFCell.CELL_TYPE_BOOLEAN == cellType) {
                boolean bool = cell.getBooleanCellValue();
                val = bool ? "T" : "F";
            } else
                val = cell.getStringCellValue();

            if (i >= 45 && i < 55) {
                val = val.trim();
                if (val.length() > 1) {
                    if (val.equalsIgnoreCase("true")) val = "T";
                    if (val.equalsIgnoreCase("false")) val = "F";
                    if (val.length() > 1) {
                        log.error("Unexpected answer:" + fileName.getName() + ",col " + i + ",answer:" + val);
                        val = "";
                    }
                }
            }

            if (i == 0) answer.setName(val);
            else if (i == 1) answer.setNric(val.replaceAll("-", ""));
            else if (i == 2) answer.setSchool(val);
            else if (i == 3) answer.setState(val);
            else if (i == 4) {
            } else
                answer.setNextAnswer(val);

        }
        return answer;
    }


}
