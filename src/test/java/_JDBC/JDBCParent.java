package _JDBC;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCParent {    //buradan extend edilecek

    private static Connection connection;
    protected static Statement statement;   //protected -> extend edilirse ulaşibilir

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
    public void DBConnectionClose() {
        //close işlemleri
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
