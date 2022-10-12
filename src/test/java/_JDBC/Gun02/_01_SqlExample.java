package _JDBC.Gun02;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _01_SqlExample extends JDBCParent {

    //last, first, getRow, getInd, getDouble

    @Test
    public void test1() throws SQLException
    {
        ResultSet rs= statement.executeQuery("select city_id, city, country_id from city");

        rs.last();   //sonuncu row a gider

        String id=rs.getString(1);   //city_id
        System.out.println("id = " + id);   //id = 600

        int idInt=rs.getInt(1);
        System.out.println("idInt = " + idInt);   //idInt = 600

        String name= rs.getString(2);
        System.out.println("name = " + name);   //name = Ziguinchor

//        int nameInt=rs.getInt(2);
//        System.out.println("nameInt = " + nameInt);

        //tipi uygun olan dönüşüm ile, mesela hepsi String olarak alınabilir
        //ancak tipi uygun olmayan, mesela isimler int olarak alınamaz

        int kacinciSatir=rs.getRow();
        //bir sorgunun sonucunda kaç satır olduğu
        //rs.last() yazıp rs.getRow() ile bulunur.

        rs.first();  //ilk satıra gider

    }

}
