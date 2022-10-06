package Utils;

import io.cucumber.java.Before;
import io.cucumber.java.After;
public class Hooks {

    //Senaryolardan önce tarayıcıyı başlartıyor.
    @Before
    public void before(){DriverManager.setupDriver();}

    //Senaryo bittiğinde tarayıcıyı kapatıyor.
    @After
    public void after(){DriverManager.quitDriver();}
}
