package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _07_Soru {
    /*
       Bir önceki soruda kullanıcıdan sütun numarası istenilecek
       ve o sütundaki bütün bilgiler yazdırılacak
     */

    public static void main(String[] args) {

        System.out.print("Sütun No : ");
        Scanner oku = new Scanner(System.in);
        int sutun = oku.nextInt();

        String donenSonuc=bul(sutun);
        System.out.println("donenSonuc = " + donenSonuc);
    }

    public static String bul(int sutun)
    {

        String donecek="";

        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";

        Workbook workbook = null;

        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++)
            if (sheet.getRow(i).getPhysicalNumberOfCells() > sutun)  //o satırda bilgi olmayan sutunları yazmaması için eklendi
                donecek+=sheet.getRow(i).getCell(sutun)+"\n";

            return donecek;
    }
}
