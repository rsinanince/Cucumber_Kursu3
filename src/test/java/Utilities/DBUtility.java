package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {

    private static Connection connection;
    protected static Statement statement;   //protected -> extend edilirse ulaşibilir

    private static void DBConnectionOpen()
    {
        //bağlantı işlemleri
        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila"; //hotstname,port,db adı (user db)
        String username="root"; //username
        String password="'\"-LhCB'.%k[4S]z"; // password

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement= connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void DBConnectionClose()
    {   //close işlemleri
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {   //test main   burayı veriler geliyor mu diye kontrol için yazdık
        List<List< String>> tablo = getListData("select * from actor");

        for(List<String> satir : tablo)
        System.out.println("satir = " + satir);
    }

    public static List<List<String>> getListData(String query) {   //static olmazsa nesne oluşturmak gerekir
        List<List<String>> tablo = new ArrayList<>();
        //db den bütün satırları ve sütunları okuyup bu liste atacak

        //db bağlantıyı aç
        DBConnectionOpen();

        try {
            //1-soruguyu çalıştır
            ResultSet rs = statement.executeQuery(query);
            //2-bütün satırları ve o satırlardaki sütunları oku tabloya ekle
            int columnCount = rs.getMetaData().getColumnCount();

//            for (int i = 1; i <= rsmd.getColumnCount(); i++)
//                System.out.printf("%-20s", rsmd.getColumnName(i));

            System.out.println();

            while (rs.next())   //her bir satıra gitmek için
            {
                List<String> satir=new ArrayList<>();
                for(int i=1; i<=columnCount; i++)
                {
                    satir.add(rs.getString(i));
                }

                tablo.add(satir);
            }
        }
        catch (Exception ex)
        {
            System.out.println("ex.getMessage() = " + ex.getMessage());  // hata olursa hatayı yazdırmak için
        }

        DBConnectionClose();
        //db bağlantısını kapat

        return tablo;
    }


}
