package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {

    public static WebDriver driver;

    public static WebDriver getDriver()
    {
        if (driver == null) {              //her çağırıldığında yeni driver oluşturmasın diye, ilk çağırıldıktan sonra aynı driver çağırılsın diye bunu yazdık

            Logger.getLogger("").setLevel(Level.SEVERE);
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            //firefox
//            WebDriverManager.firefoxdriver().setup();
//            driver=new FirefoxDriver();

        }

        return driver;
    }

    public static void quitDriver()
    {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver !=null) {  //driver varsa quit yap
            driver.quit();
            driver=null;  //driver ı boşalt
        }
    }

}
