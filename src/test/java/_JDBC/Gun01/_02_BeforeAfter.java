package _JDBC.Gun01;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class _02_BeforeAfter {

    private static Connection connection;
    private static Statement statement;

    @BeforeTest
    public void DBConnectionOpen()
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

    @AfterTest
    public void DBConnectionClose()
    {
        //close işlemleri
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test1() throws SQLException {
        //sorgu çalışacak
        ResultSet rs= statement.executeQuery("select * from language");   //MySQL komutu

        rs.next();   //sonraki satır
        String dilAdi= rs.getString("name");
        System.out.println("dil adı = " + dilAdi);   //dil adı = English

        rs.next();   //sonraki satır
        dilAdi= rs.getString("name");
        System.out.println("dil adı = " + dilAdi);  //dil adı = Italian

        rs.next();   //sonraki satır
        dilAdi= rs.getString("name");
        System.out.println("dil adı = " + dilAdi);  //dil adı = Japanese
    }

    @Test
    public void test2() throws SQLException {
        ResultSet rs= statement.executeQuery("select * from language");

        rs.next();   //sonraki satır
        String dilAdi= rs.getString(2);
        System.out.println("dil adı = " + dilAdi);  //English

        rs.next();   //sonraki satır
        dilAdi= rs.getString(2);
        System.out.println("dil adı = " + dilAdi);  //Italian

        rs.next();   //sonraki satır
        dilAdi= rs.getString(2);
        System.out.println("dil adı = " + dilAdi);  //Japanese
    }

    @Test
    public void test3() throws SQLException {
        ResultSet rs= statement.executeQuery("select * from language");

        rs.next();
        String dilAdi= rs.getString(2);
        System.out.println("dil adı = " + dilAdi);  //English

        rs.next();
        dilAdi= rs.getString(2);
        System.out.println("dil adı = " + dilAdi);  //Italian

        rs.previous();   //bulunduğu yerden bir önceki satıra gider. bu örnekte English e geri gitti
        dilAdi= rs.getString(2);
        System.out.println("dil adı = " + dilAdi);
    }

}
