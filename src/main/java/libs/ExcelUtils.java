package libs;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;


    /**
     * Set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
     * @param Path
     * @param SheetName
     * @throws Exception
     */
    public static void setExcelFile(String Path,String SheetName) throws Exception {
        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(Path);

            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);

        } catch (Exception e){
            throw (e);
        }

    }


    public static int getRowCount() {
        try {
            return ExcelWSheet.getLastRowNum();
        } catch (Exception e) {
            return -1;
        }
    }
    /**
     * Read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
     * @param RowNum
     * @param ColNum
     * @return
     * @throws Exception
     */
    public static String getCellData(int RowNum, int ColNum) throws Exception {
        try {
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            String CellData = Cell.getStringCellValue();
            return CellData;
        } catch (Exception e) {
            return"";
        }

    }


    /**
     * Write in the Excel cell, Row num and Col num are the parameters
     * @param Result
     * @param RowNum
     * @param ColNum
     * @param outputFile
     * @throws Exception
     */
    public static void setCellData(String Result,  int RowNum, int ColNum, String outputFile) throws Exception {
        try {
            System.out.println("set cell value");
            Row  = ExcelWSheet.getRow(RowNum);
            //Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
            Cell = Row.getCell(ColNum);
            if (Cell == null) {
                System.out.println("the cell is null, set cell value");
                Cell = Row.createCell(ColNum);
                Cell.setCellValue(Result);
            } else {
                System.out.println("the cell is NOT null, set cell value");
                Cell.setCellValue(Result);
            }

            // Constant variables Test Data path and Test Data file name
            FileOutputStream fileOut = new FileOutputStream(outputFile);
            ExcelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();

        } catch(Exception e) {
            throw (e);
        }

    }

}