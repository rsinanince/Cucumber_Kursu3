package _JDBC.Gun01;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsoluteRelative extends JDBCParent {

    @Test
    private void Test1() throws SQLException {
        //next() : bir sonraki row'a gider
        //previous() : bir önceki row'a gider
        //absolute(4) : verilen numaraya direkt gider,4.row, baştan itibaren sayar
        //relative(4)  : bulunduğu noktadan 4 sonraki Row'a gider

        ResultSet rs= statement.executeQuery("select * from film");

        rs.absolute(10);   //10.satıra gider
        String title= rs.getString("title");
        System.out.println("title = " + title);          //title = ALADDIN CALENDAR

        rs.absolute(15);   //15.satıra gider
        title= rs.getString("title");
        System.out.println("title = " + title);          //title = ALIEN CENTER

        rs.absolute(-15);   //sondan 15.satıra gider
        title= rs.getString("title");
        System.out.println("title = " + title);        //title = WONKA SEA

        rs.relative(5);   //en son bulunduğun yerden 5 satır ileri git
        title= rs.getString("title");
        System.out.println("title = " + title);         //title = WORST BANGER

        rs.relative(-5);   //en son bulunduğun yerden 5 satır geri git
        title= rs.getString("title");
        System.out.println("title = " + title);         //title = WONKA SEA




    }

}
