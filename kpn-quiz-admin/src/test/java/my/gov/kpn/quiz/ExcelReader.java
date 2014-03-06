package my.gov.kpn.quiz;

<<<<<<< Updated upstream
public class ExcelReader {
=======
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    private final int MAX_ROW = 56;


    public StudentAnswer readAnswer(String fileName) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(fileName);
        XSSFSheet sheet = workbook.getSheetAt(0);

        StudentAnswer answer = new StudentAnswer();
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
//            Iterator<Row> rowIterator = sheet.iterator();
//            while (rowIterator.hasNext())
//            {
//                Row row = rowIterator.next();
//                //For each row, iterate through all the columns
//                Iterator<Cell> cellIterator = row.cellIterator();
//
//                while (cellIterator.hasNext())
//                {
//                    Cell cell = cellIterator.next();
//                    //Check the cell type and format accordingly
//                    switch (cell.getCellType())
//                    {
//                        case Cell.CELL_TYPE_NUMERIC:
//                            System.out.print(cell.getNumericCellValue() + "t");
//                            break;
//                        case Cell.CELL_TYPE_STRING:
//                            System.out.print(cell.getStringCellValue() + "t");
//                            break;
//                    }
//                }
//                System.out.println("");
//            }
        return answer;
    }

>>>>>>> Stashed changes
}
