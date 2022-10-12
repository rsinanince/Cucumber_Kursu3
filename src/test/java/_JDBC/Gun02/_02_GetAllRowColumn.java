package _JDBC.Gun02;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _02_GetAllRowColumn extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs= statement.executeQuery("select * from language");
        // ResultSet : data + meta (data dışındaki diğer bilgiler, kolon sayısı, vb.)

        ResultSetMetaData rsmd=rs.getMetaData();   //kolon başlıklarının alınacağı yer
        // sonuçların haricindeki diğer bilgiler : kolon sayısı, isimleri, tipleri

        int columnCount= rsmd.getColumnCount();  // kolon sayısı
        System.out.println("columnCount = " + columnCount);

        for(int i=1; i<= columnCount; i++){
            String columnName= rsmd.getColumnName(i);
            String columnType= rsmd.getColumnTypeName(i);

            System.out.println("columnName = "+" "+ columnName);
            System.out.println("columnType = "+" "+ columnType);
        }
//        sonuç:
//        columnName =  language_id
        //columnType =  TINYINT UNSIGNED
        //columnName =  name
        //columnType =  CHAR
        //columnName =  last_update
        //columnType =  TIMESTAMP
    }

    @Test
    public void test2() throws SQLException {
       // language tablosundaki tüm satırları ve tüm sutunları yazdırınız,
       // aynı MySQL sonuç ekranında olduğu gibi yazıdırınız

        ResultSet rs= statement.executeQuery("select * from language");

        ResultSetMetaData rsmd=rs.getMetaData();

        for(int i=1; i<= rsmd.getColumnCount(); i++)
            System.out.printf("%-20s",rsmd.getColumnName(i)+" ");    //"%20s" düzenli yazma yöntemi

        System.out.println();

            while (rs.next())   // sürekli bir sonraki satıra gider
            {
                for(int i=1; i<= rsmd.getColumnCount(); i++)
            System.out.printf("%-20s",rs.getString(i)+" ");

                System.out.println();
        }

//        language_id         name                last_update
//        1                   English             2006-02-15 05:02:19
//        2                   Italian             2006-02-15 05:02:19
//        3                   Japanese            2006-02-15 05:02:19
//        4                   Mandarin            2006-02-15 05:02:19
//        5                   French              2006-02-15 05:02:19
//        6                   German              2006-02-15 05:02:19

    }

    @Test
    public void test4() throws SQLException {
        // actor tablosundaki tüm satırları ve tüm sütunları yazdırınız, aynı mysql sonuç ekranında olduğu gibi
        // fakat metod kullanınız, metoda sorguyu gönderiniz ve orada yazdırınız.
        getTable("select * from actor");
    }

        public void getTable(String sorgu) throws SQLException{

            ResultSet rs= statement.executeQuery(sorgu);
            ResultSetMetaData rsmd=rs.getMetaData();

            for(int i=1; i<= rsmd.getColumnCount(); i++)
                System.out.printf("%-20s",rsmd.getColumnName(i));

            System.out.println();

            while (rs.next())
            {
                for(int i=1; i<= rsmd.getColumnCount(); i++)
                    System.out.printf("%-20s",rs.getString(i)+" ");

                System.out.println();
        }

//            actor_id            first_name          last_name           last_update
//            1                   PENELOPE            GUINESS             2006-02-15 04:34:33
//            2                   NICK                WAHLBERG            2006-02-15 04:34:33
//            3                   ED                  CHASE               2006-02-15 04:34:33
//            4                   JENNIFER            DAVIS               2006-02-15 04:34:33
//            5                   JOHNNY              LOLLOBRIGIDA        2006-02-15 04:34:33
//            6                   BETTE               NICHOLSON           2006-02-15 04:34:33
//            7                   GRACE               MOSTEL              2006-02-15 04:34:33
//            8                   MATTHEW             JOHANSSON           2006-02-15 04:34:33
//            9                   JOE                 SWANK               2006-02-15 04:34:33
//            10                  CHRISTIAN           GABLE               2006-02-15 04:34:33
//            11                  ZERO                CAGE                2006-02-15 04:34:33
//            12                  KARL                BERRY               2006-02-15 04:34:33
//            13                  UMA                 WOOD                2006-02-15 04:34:33
//            14                  VIVIEN              BERGEN
//            devam....

    }


}
