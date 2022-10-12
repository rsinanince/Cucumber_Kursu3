package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_WriteInTheExcel {
    public static void main(String[] args) throws IOException {
        // Var olan bir excel e yazma işlemi

        String path = "src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream = new FileInputStream(path);  //okuma modunda açar
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheet("Sheet1");

        //hafızada oluşturma ve yazma işlemleri yapılıyor
        Row yeniSatir= sheet.createRow(0);  //satır oluşturuldu 0.yerde
        Cell yeniHucre= yeniSatir.createCell(0); //yeni satırda ilk hücre oluşturuldu
        yeniHucre.setCellValue("Merhaba Dünya");  //bilgi yazıldı

        for (int i = 1; i < 10; i++) {     //1.satırdan başlatmamız gerekiyor
            yeniSatir.createCell(i).setCellValue(i);
        }

        //bütün bilgiler şu an hafızada, sıra kaydetmeye geldi
        inputStream.close();  //okuma modu kapatıldı. çünkü yazma modunda açılması gerekiyor.

        //yazma işlemi yazma modunda açılarak yapılacak
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();  //hafıza boşaltıldı
        outputStream.close();   //kapatıldı
        System.out.println("işlem tamamlandı");


    }
}
