package StepDefinitions;

import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {


    @Before
    public void before()
    {
        System.out.println("Senaryo başladı");
    }

    @After
    public void after()
    {
        //senaryo hatalı ise ekran görüntüsü al komutu buraya gelecek
        GWD.quitDriver();
    }
}
