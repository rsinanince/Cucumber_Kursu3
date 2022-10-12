package _JDBC.Gun01;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {

    @Test    //bu kısımda junit ve testng seçenekleri çıkıyor, testng yi seçiyoruz, daha kapsamlı, ikisi de aynı işi yapıyor
    public void test1() throws SQLException {
                       //türü    //yolu                                               //port no
        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila"; //hotstname,port,db adı (user db)
        String username="root"; //username
        String password="'\"-LhCB'.%k[4S]z"; // password

        Connection connection= DriverManager.getConnection(url, username, password);   //connection kuruldu

        Statement statement= connection.createStatement();  //sorguları çalıştırmak için page açıldı

        ResultSet rs = statement.executeQuery("select * from actor");  //mysql de açılan sonuç penceresi gibi
                                                                //sorgu sonucu oluşturuldu, db de bekliyor, gösterilmedi henüz
        rs.next();  //oluşan sorgu sonucunda tablonun satırlarını tek tek çağırmak için aşağıdaki yöntemi uyguluyoruz

        String firstName= rs.getString("first_name");
        String lastName= rs.getString("last_name");

        System.out.println("firstName = " + firstName);   //firstName = PENELOPE
        System.out.println("lastName = " + lastName);     //lastName = GUINESS

        rs.next(); //2.satır sonuçları

        firstName= rs.getString("first_name");  //firstName = NICK
        lastName= rs.getString("last_name");    //lastName = WAHLBERG

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        connection.close();

    }

}

// 1-Connection: Önce bağlantı ayarları yapılır, username, password, url(port,db,bağlantı yolu) -> connection
// 2-Query çalıştırma yolu: Sorguları çalıştırmak için bir sayfa açılır.
// 3-Sonuçların alınması : sorgunun çalışması sonucu veri tabanından gelen bilgiler
