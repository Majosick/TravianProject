import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main3 {

    public static void grabi(WebDriver driver)
    {
        driver.get("https://ts20.travian.pl/build.php?id=39");


        List<WebElement> g1 = null;
        List<WebElement> g2 = null;
        outerloop:
        for (int i =0; i <5; i++)
        {
            try
            {
                g1 = driver.findElements(By.id("raidListMarkAll43"));
                g2 =  driver.findElements(By.xpath("//*[@value='Zacznij grabież']"));
                if(!g1.isEmpty() && !g2.get(0).equals(null))
                {
                    break outerloop;
                }
            }
            catch(Exception e)
            {

            }
        }
        g1.get(0).click();
        g2.get(0).click();


        outerloop2:
    for (int i =0; i <5; i++)
    {
        try
        {
            g1 = driver.findElements(By.id("raidListMarkAll125"));
            g2 =  driver.findElements(By.xpath("//*[@value='Zacznij grabież']"));
            if(!g1.isEmpty() && !g2.get(1).equals(null))
            {
                break outerloop2;
            }
        }
        catch(Exception e)
        {

        }
    }
        g1.get(0).click();
        g2.get(1).click();
//
//        outerloop3:
//        for (int i =0; i <5; i++)
//        {
//            try
//            {
//                g1 = driver.findElements(By.id("raidListMarkAll731"));
//                g2 =  driver.findElements(By.xpath("//*[@value='Zacznij grabież']"));
//                if(!g1.isEmpty() && !g2.get(1).equals(null))
//                {
//                    break outerloop3;
//                }
//            }
//            catch(Exception e)
//            {
//
//            }
//        }
//        g1.get(0).click();
//        g2.get(2).click();


//        driver.findElement(By.id("raidListMarkAll922")).click();
//        List<WebElement> g =  driver.findElements(By.xpath("//div[@class='button-content'][contains(text(),'Zacznij grabież')]"));
//        g.get(1).click();
//
//        driver.findElement(By.id("raidListMarkAll1427")).click();
//        g =  driver.findElements(By.xpath("//div[@class='button-content'][contains(text(),'Zacznij grabież')]"));
//        g.get(2).click();
//
//
//        driver.findElement(By.id("raidListMarkAll1668")).click();
//        g =  driver.findElements(By.xpath("//div[@class='button-content'][contains(text(),'Zacznij grabież')]"));
//        g.get(5).click();
//
//
//        //sopot
//        driver.findElement(By.id("raidListMarkAll1169")).click();
//        g =  driver.findElements(By.xpath("//div[@class='button-content'][contains(text(),'Zacznij grabież')]"));
//        g.get(6).click();
//
//        //rydwan
//        driver.findElement(By.id("raidListMarkAll1596")).click();
//        g =  driver.findElements(By.xpath("//div[@class='button-content'][contains(text(),'Zacznij grabież')]"));
//        g.get(7).click();
    }

    public static void gromy(WebDriver driver, String adres1, String adres2, String count)
    {
        driver.get(adres1);
        driver.get(adres2);
        driver.findElement(By.name("t6")).clear();
        driver.findElement(By.name("t6")).sendKeys(count);
        driver.findElement(By.id("s1")).click();
    }

    public static void tary(WebDriver driver, String adres1, String adres2, String count)
    {
        driver.get(adres1);
        driver.get(adres2);
        driver.findElement(By.name("t7")).clear();
        driver.findElement(By.name("t7")).sendKeys(count);
        driver.findElement(By.id("s1")).click();
    }

    public static void katy(WebDriver driver, String adres1, String adres2, String count)
    {
        driver.get(adres1);
        driver.get(adres2);
        driver.findElement(By.name("t8")).clear();
        driver.findElement(By.name("t8")).sendKeys(count);
        driver.findElement(By.id("s1")).click();
    }

    public static void fal(WebDriver driver, String adres1, String adres2, String count)
    {
        driver.get(adres1);
        driver.get(adres2);
        driver.findElement(By.name("t1")).clear();
        driver.findElement(By.name("t1")).sendKeys(count);
        driver.findElement(By.id("s1")).click();
    }

    public static void miecz(WebDriver driver, String adres1, String adres2, String count)
    {
        driver.get(adres1);
        driver.get(adres2);
        driver.findElement(By.name("t2")).clear();
        driver.findElement(By.name("t2")).sendKeys(count);
        driver.findElement(By.id("s1")).click();
    }

    public static void buduj(WebDriver driver, String LinkOsady)
    {
        driver.get(LinkOsady);
        String tmp;
        WebElement drewno = driver.findElement(By.id("l1"));
        tmp = drewno.getText().replace(".","").replace(" ","");
        int StanDrewna = Integer.parseInt(tmp);

        WebElement glina = driver.findElement(By.id("l2"));
        tmp = glina.getText().replace(".","").replace(" ","");;
        int StanGliny = Integer.parseInt(tmp);

        WebElement zlom = driver.findElement(By.id("l3"));
        tmp = zlom.getText().replace(".","").replace(" ","");;
        int StanZlomu = Integer.parseInt(tmp);

        WebElement siano = driver.findElement(By.id("l4"));
        tmp = siano.getText().replace(".","").replace(" ","");;
        int StanSiana = Integer.parseInt(tmp);

        List<Integer> list = new ArrayList<Integer>();
        list.add(StanDrewna);
        list.add(StanGliny);
        list.add(StanZlomu);
        list.add(StanSiana);
        int minIndex = list.indexOf(Collections.min(list));

        List<WebElement> e = driver.findElements(By.cssSelector("area"));
        List<String> a = new ArrayList<String>();
        List<String> b = new ArrayList<String>();
        for (WebElement x:e
        ) {
            a.add(x.getAttribute("alt"));
        }

        int minlevel=10;
        int indextorememb=0;
        switch (minIndex)
        {
            case 0:
                for (String x:a
                ) {
                    if(x.contains("Las") && !x.contains("10"))
                    {
                        if(Integer.parseInt(x.substring(x.length() - 1))<minlevel)
                        {
                            minlevel=Integer.parseInt(x.substring(x.length() - 1));
                            indextorememb =a.indexOf(x);
                        }

                    }
                }
                break;
            case 1:
                for (String x:a
                ) {
                    if(x.contains("gliny") && !x.contains("10"))
                    {
                        if(Integer.parseInt(x.substring(x.length() - 1))<minlevel)
                        {
                            minlevel=Integer.parseInt(x.substring(x.length() - 1));
                            indextorememb =a.indexOf(x);
                        }
                    }
                }
                break;
            case 2:
                for (String x:a
                ) {
                    if(x.contains("żelaza")&& !x.contains("10"))
                    {
                        if(Integer.parseInt(x.substring(x.length() - 1))<minlevel)
                        {
                            minlevel=Integer.parseInt(x.substring(x.length() - 1));
                            indextorememb =a.indexOf(x);
                        }

                    }
                }
                break;
            case 3:
                for (String x:a
                ) {
                    if(x.contains("Pole")&& !x.contains("10"))
                    {
                        if(Integer.parseInt(x.substring(x.length() - 1))<minlevel)
                        {
                            minlevel=Integer.parseInt(x.substring(x.length() - 1));
                            indextorememb =a.indexOf(x);
                        }
                    }
                }
                break;

        }

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", e.get(indextorememb));

        Boolean isPresent = driver.findElements(By.xpath("//*[contains(text(),'Rozbuduj do poziomu')]")).size() > 0;
        if(isPresent)
        {
            WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Rozbuduj do poziomu')]"));
            element.click();
        }
    }

    public static void budujKonkret(WebDriver driver, String LinkOsady, String LinkBudynku)
    {
        driver.get(LinkOsady);
        driver.get(LinkBudynku);

        Boolean isPresent = driver.findElements(By.xpath("//*[contains(text(),'Rozbuduj do poziomu')]")).size() > 0;
        if(isPresent)
        {
            WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Rozbuduj do poziomu')]"));
            element.click();
        }
    }

    public static void budujRowno(WebDriver driver, String LinkOsady)
    {
        driver.get(LinkOsady);

        String tmp;
        WebElement drewno = driver.findElement(By.id("l1"));
        tmp = drewno.getText().replace(".","").replace(" ","");
        int StanDrewna = Integer.parseInt(tmp);

        WebElement glina = driver.findElement(By.id("l2"));
        tmp = glina.getText().replace(".","").replace(" ","");;
        int StanGliny = Integer.parseInt(tmp);

        WebElement zlom = driver.findElement(By.id("l3"));
        tmp = zlom.getText().replace(".","").replace(" ","");;
        int StanZlomu = Integer.parseInt(tmp);


//        List<Integer> list = new ArrayList<Integer>();
//        list.add(StanDrewna);
//        list.add(StanGliny);
//        list.add(StanZlomu);
//
//        int minIndex = list.indexOf(Collections.min(list));

        List<WebElement> e = driver.findElements(By.cssSelector("area"));
        List<String> a = new ArrayList<String>();

        for (WebElement x:e
        ) {
            a.add(x.getAttribute("alt"));
        }

        int minlevel=10;
        int indextorememb=0;

        for (String x:a
        ) {
            if(x.contains("Pole"))
            {
                if(Integer.parseInt(x.substring(x.length() - 1))<minlevel)
                {
                    minlevel=Integer.parseInt(x.substring(x.length() - 1));
                    indextorememb = a.indexOf(x);
                }
            }
        }

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", e.get(indextorememb));

        Boolean isPresent = driver.findElements(By.xpath("//*[contains(text(),'Rozbuduj do poziomu')]")).size() > 0;
        if(isPresent)
        {
            WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Rozbuduj do poziomu')]"));
            element.click();
        }
    }

    public static boolean moreImportant(String actual, int minIndex)
    {
        if(actual.contains("Las") && minIndex == 0)
        {
            return true;
        }
        if(actual.contains("gliny") && minIndex == 1)
        {
            return true;
        }
        if(actual.contains("żelaza") && minIndex == 2)
        {
            return true;
        }
        else return false;

    }

    public static void glowna(String login, String password,String world)
    {
        System.setProperty("webdriver.chrome.driver", "D:\\Programy\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(world);
        driver.findElement(By.name("name")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("s1")).click();

        //OCZY
       // grabi(driver);//wysylanie grabieży
//        budujKonkret(driver,"https://ts20.travian.pl/dorf2.php?newdid=154&",
//        "https://ts20.travian.pl/build.php?id=22");
//        fal(driver,"https://ts20.travian.pl/dorf1.php?newdid=154&",
//        "https://ts20.travian.pl/build.php?id=25",
//        "70");
        budujRowno(driver,"https://ts10.travian.pl/dorf1.php");
//        fal(driver,"https://ts20.travian.pl/dorf1.php?newdid=7758&",
//                "https://ts20.travian.pl/build.php?id=23",
//                "20");
//




//                tary(driver,"https://ts2.travian.pl/dorf2.php?newdid=6090&",
//                "https://ts2.travian.pl/build.php?id=34",
//                "3");

//        katy(driver,"https://ts2.travian.pl/dorf2.php?newdid=6090&",
//        "https://ts2.travian.pl/build.php?id=34",
//        "1");

//                gromy(driver,"https://ts2.travian.pl/dorf2.php?newdid=6090&",
//        "https://ts2.travian.pl/build.php?id=37",
//        "3");

//        budujKonkret(driver,"https://ts2.travian.pl/dorf2.php?newdid=14957&",
        //"https://ts2.travian.pl/build.php?id=25");


//

//

//



//        fal(driver,"https://ts2.travian.pl/dorf2.php?newdid=6090&",
//        "https://ts2.travian.pl/build.php?id=20",
//        "33");
//
//        gromy(driver,"https://ts2.travian.pl/dorf2.php?newdid=6090&",
//                "https://ts2.travian.pl/build.php?id=37",
//                "3");
//




//        budujRowno(driver,"https://ts2.travian.pl/dorf1.php?newdid=6090&");

        //Pszenica


//        miecz(driver,"https://ts2.travian.pl/dorf1.php?newdid=12698&",
//        "https://ts2.travian.pl/build.php?id=20",
//        "5");

        //PURPLE
        //buduj(driver,"https://ts2.travian.pl/dorf1.php?newdid=3546&");




//        katy(driver,"https://ts19.travian.pl/dorf1.php?newdid=13102&",
//                "https://ts19.travian.pl/build.php?id=36",
//                "1");
//        gromy(driver,"https://ts19.travian.pl/dorf1.php?newdid=13102&",
//                "https://ts19.travian.pl/build.php?id=24",
//                "7");

//        miecz(driver,"https://ts19.travian.pl/dorf1.php?newdid=13102&",
//                "https://ts19.travian.pl/build.php?id=22",
//                "7");

//        tary(driver,"https://ts19.travian.pl/dorf1.php?newdid=13102&",
//                "https://ts19.travian.pl/build.php?id=36",
//                "2");

        //sopot
//        fal(driver,"https://ts19.travian.pl/dorf1.php?newdid=4397&",
//                "https://ts19.travian.pl/build.php?id=24",
//                "9");





//        buduj(driver,"https://ts19.travian.pl/dorf1.php?newdid=13102&");

//          buduj(driver,"https://ts19.travian.pl/dorf1.php?newdid=21798&");

//        budujRowno(driver,"https://ts19.travian.pl/dorf1.php?newdid=4397&");


        driver.quit();
    }

    public static void main(String[] args) {
        glowna("majosick","qweasdzxc","https://ts10.travian.pl/dorf1.php");
    }
}
