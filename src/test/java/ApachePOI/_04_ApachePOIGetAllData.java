package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _04_ApachePOIGetAllData {
    public static void main(String[] args) throws IOException {


        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet= workbook.getSheet("Sheet1");

        //calisma sayfasındaki toplam satır sayısını verir
        int rowCount=sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < rowCount ; i++) {

            Row row= sheet.getRow(i);
            // saturdaki toplam hücre sayısı alındı.
            int cellCount = row.getPhysicalNumberOfCells();

            for (int j = 0; j < cellCount; j++) {  //i.satırındaki hucre sayısı kadar dönecek
                Cell cell = row.getCell(j);  //bu satırdaki sıradaki hucreyi aldık
                System.out.print(cell + " ");
            }

            System.out.println();
        }


    }
}
