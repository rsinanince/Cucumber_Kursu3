package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _03_ApachePOIStart {
    public static void main(String[] args) throws IOException {

        //Excel dosyasının yolu alındı
        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        //Dosya okuma işlemcisine dosyanın yolunu veriyoruz.
        //Böylece program ile dosya arasında bağlantı oluşur.
        FileInputStream dosyaOkumaBaglantisi=new FileInputStream(path);

        //Dosya okuma işlemcisi üzerinden Workbook u alıyoruz
        //hafızada workbook u alıp oluşturdu
        Workbook calismaKitabi= WorkbookFactory.create(dosyaOkumaBaglantisi);

        //istediğimiz çalışma sayfasını alıyoruz
        Sheet calismaSayfasi= calismaKitabi.getSheet("Sheet1");

        //istediğimiz satır
        Row satir= calismaSayfasi.getRow(0);

        //istediğimiz hucre
        Cell hucre= satir.getCell(0);

        System.out.println("hucre = " + hucre);





    }
}
