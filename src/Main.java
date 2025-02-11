import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.*;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        //toDo Grabierze
        System.setProperty("webdriver.chrome.driver", "E:\\Produkcje programistyczne\\chromedriver_win32\\chromedriver.exe");

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        WebDriver driver = new ChromeDriver(options);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        Map<Integer, Integer> planbudowy1 = new LinkedHashMap<>();
        planbudowy1.put(20, 5);
//        planbudowy1.put(22, 8);
//        planbudowy1.put(29, 10);

//        Map<Integer, Integer> planbudowy2 = new LinkedHashMap<>();
//        planbudowy2.put(25, 5);
//        planbudowy2.put(28, 10);
//        planbudowy2.put(27, 10);
//        planbudowy2.put(26, 10);
//        planbudowy2.put(21, 10);
//        planbudowy2.put(23, 7);
//        planbudowy2.put(25, 8);
//        planbudowy2.put(33, 10);

        login("https://ts8.x1.europe.travian.com/dorf1.php", "Majosicks", "qweasdzxc", driver);


//        //1

        budujDomki("https://ts8.x1.europe.travian.com/dorf1.php",
                "https://ts8.x1.europe.travian.com/dorf1.php",
                driver);

//        projektujWnetrze("https://ts8.x1.europe.travian.com/dorf2.php",
//                "https://ts8.x1.europe.travian.com/dorf2.php", driver, planbudowy1);



//        budujPałki("https://ts3.travian.pl/dorf1.php?newdid=8575&",
//                "https://ts3.travian.pl/dorf2.php?newdid=8575&",
//                "https://ts3.travian.pl/dorf1.php?newdid=8575&",
//                "https://ts3.travian.pl/build.php?id=24",
//                driver,"80");





        //2
        //projektujWnetrze("https://ts3.travian.pl/dorf2.php?newdid=18982&",
          //      "https://ts3.travian.pl/dorf1.php?newdid=8575&", driver, planbudowy2);

//        budujDomki("https://ts3.travian.pl/dorf1.php?newdid=18982&",
//                "https://ts3.travian.pl/dorf1.php?newdid=8575&",
//                driver);
//
//        budujPałki("https://ts3.travian.pl/dorf1.php?newdid=18982&",
//                "https://ts3.travian.pl/dorf2.php?newdid=18982&",
//                "https://ts3.travian.pl/dorf1.php?newdid=8575&",
//                "https://ts3.travian.pl/build.php?id=23",
//                driver,"60");
//        // wspolne
//        grabi("https://ts3.travian.pl/dorf1.php?newdid=8575&",
//                "https://ts3.travian.pl/dorf1.php?newdid=8575&",
//                "https://ts3.travian.pl/build.php?newdid=8575&id=39&gid=16",
//                driver);

//        budujKraski("https://ts3.travian.pl/dorf1.php?newdid=8575&",
//                "https://ts3.travian.pl/dorf2.php?newdid=8575&",
//                "https://ts3.travian.pl/dorf1.php?newdid=8575&",
//                "https://ts3.travian.pl/build.php?id=25",
//                driver,"1");
//
        driver.close();


// 2osada

//        budujPałki("https://ts29.travian.com/dorf1.php?newdid=22214&",
//                "https://ts29.travian.com/dorf2.php?newdid=22214&",
//                         "https://ts29.travian.com/dorf1.php?newdid=6201&",
//                "https://ts29.travian.com/build.php?id=19",
//                "Majos", "qweasdzxc", "50");
//
//        grabi("https://ts29.travian.com/dorf1.php?newdid=22214&",
//                "https://ts29.travian.com/dorf1.php?newdid=6201&",
//                "https://ts29.travian.com/build.php?newdid=22214&id=39&gid=16",
//                "Majos", "qweasdzxc", "raidListMarkAll571");

//        budujDomki("https://ts29.travian.com/dorf1.php?newdid=22214&",
//                "https://ts29.travian.com/dorf1.php?newdid=6201&",
//                "Majos", "qweasdzxc");

    }

    public static void projektujWnetrze(String wejscie, String wyjscie, WebDriver driver, Map<Integer, Integer> planbudowy) {
        driver.get(wejscie);
        int currentLevel;

        for (Map.Entry<Integer, Integer> entry : planbudowy.entrySet()) {

            WebElement element = driver.findElement(By.cssSelector("div[class^='buildingSlot a"+ entry.getKey() +"']"));
            currentLevel = Integer.parseInt(element.findElement(By.cssSelector("div[class='labelLayer']")).getText());
            if (currentLevel < entry.getValue())
            {

                try {
                    element.click();
                    WebElement kupa = driver.findElement(By.xpath("//button[contains(text(),'do poziomu')]"));
                    kupa.click();
                    break;
                }
                catch (Exception e)
                {
                    break;
                }
            }
        }

    }


    public static void budujDomki(String osadaStartowa, String osadaKoncowa, WebDriver driver) {

        driver.get(osadaStartowa);

        WebElement drewno = driver.findElement(By.id("l1"));
        String drewnoStr = drewno.getText();
        drewnoStr = drewnoStr.replace(" ", "");
        int valuedrewno = Integer.parseInt(drewnoStr);

        WebElement glina = driver.findElement(By.id("l2"));
        String glinaStr = glina.getText();
        glinaStr = glinaStr.replace(" ", "");
        int valueglina = Integer.parseInt(glinaStr);

        WebElement zelazo = driver.findElement(By.id("l3"));
        String zelazoStr = zelazo.getText();
        zelazoStr = zelazoStr.replace(" ", "");
        int valuezelazo = Integer.parseInt(zelazoStr);

        WebElement siano = driver.findElement(By.id("l4"));
        String sianoStr = siano.getText();
        sianoStr = sianoStr.replace(" ", "");
        int valuesiano = Integer.parseInt(sianoStr);

        List<Integer> surowce = new ArrayList<>();
        surowce.add(valuedrewno);
        surowce.add(valueglina);
        surowce.add(valuezelazo);
        surowce.add(valuesiano);

        int biggest = Collections.min(surowce);
        int index = surowce.indexOf(biggest);
        String zmienna;
        switch (index) {
            case 0:
                zmienna = "Woodcutter";
                break;
            case 1:
                zmienna = "Clay";
                break;
            case 2:
                zmienna = "Iron";
                break;
            case 3:
                zmienna = "Cropland";
                break;
            default:
                zmienna = "Clay";
        }
        char last;
        int lastlvl;
        int maxlvl = 10;
        int indextoRemem = 0;

        kliknijPole(zmienna, driver);


        try {
            WebElement x = driver.findElement(By.xpath("//button[contains(text(),'do poziomu')]"));
            x.click();
        } catch (Exception e) {

        } finally {
            driver.get(osadaKoncowa);
        }


    }

    public static void budujPałki(String osadaStartowa, String srodekOsady, String osadaKoncowa, String linkKoszar, WebDriver driver, String ilosc) {
        driver.get(osadaStartowa);
        int iloscPalek = Integer.parseInt(ilosc);

        WebElement drewno = driver.findElement(By.id("l1"));
        String drewnoStr = drewno.getText();
        drewnoStr = drewnoStr.replace(" ", "");
        int valuedrewno = Integer.parseInt(drewnoStr);

        WebElement glina = driver.findElement(By.id("l2"));
        String glinaStr = glina.getText();
        glinaStr = glinaStr.replace(" ", "");
        int valueglina = Integer.parseInt(glinaStr);

        WebElement zelazo = driver.findElement(By.id("l3"));
        String zelazoStr = zelazo.getText();
        zelazoStr = zelazoStr.replace(" ", "");
        int valuezelazo = Integer.parseInt(zelazoStr);

        WebElement siano = driver.findElement(By.id("l4"));
        String sianoStr = siano.getText();
        sianoStr = sianoStr.replace(" ", "");
        int valuesiano = Integer.parseInt(sianoStr);
        WebElement budowaauu = null;
        try {
            budowaauu = driver.findElement(By.xpath("//*[contains(text(), 'W budowie')]"));
        } catch (Exception e) {

        }
        if (valuedrewno > iloscPalek * 95 && valuezelazo > iloscPalek * 40 && valuesiano > iloscPalek * 40 && valueglina > iloscPalek * 75 && budowaauu != null) {


            driver.get(srodekOsady);
            driver.get(linkKoszar);

            WebElement okno = driver.findElement(By.name("t1"));
            okno.clear();
            okno.sendKeys(ilosc);
            okno = driver.findElement(By.name("s1"));
            okno.click();
        }

        driver.get(osadaKoncowa);
    }

    public static void budujZwiad(String osadaStartowa, String srodekOsady, String osadaKoncowa, String linkKoszar, WebDriver driver, String ilosc) {
        driver.get(osadaStartowa);
        int iloscPalek = Integer.parseInt(ilosc);

        WebElement drewno = driver.findElement(By.id("l1"));
        String drewnoStr = drewno.getText();
        drewnoStr = drewnoStr.replace(" ", "");
        int valuedrewno = Integer.parseInt(drewnoStr);

        WebElement glina = driver.findElement(By.id("l2"));
        String glinaStr = glina.getText();
        glinaStr = glinaStr.replace(" ", "");
        int valueglina = Integer.parseInt(glinaStr);

        WebElement zelazo = driver.findElement(By.id("l3"));
        String zelazoStr = zelazo.getText();
        zelazoStr = zelazoStr.replace(" ", "");
        int valuezelazo = Integer.parseInt(zelazoStr);

        WebElement siano = driver.findElement(By.id("l4"));
        String sianoStr = siano.getText();
        sianoStr = sianoStr.replace(" ", "");
        int valuesiano = Integer.parseInt(sianoStr);
        WebElement budowaauu = null;
        try {
            budowaauu = driver.findElement(By.xpath("//*[contains(text(), 'W budowie')]"));
        } catch (Exception e) {

        }
        if (valuedrewno > iloscPalek * 95 && valuezelazo > iloscPalek * 40 && valuesiano > iloscPalek * 40 && valueglina > iloscPalek * 75 && budowaauu != null) {


            driver.get(srodekOsady);
            driver.get(linkKoszar);

            WebElement okno = driver.findElement(By.name("t4"));
            okno.clear();
            okno.sendKeys(ilosc);
            okno = driver.findElement(By.name("s1"));
            okno.click();
        }

        driver.get(osadaKoncowa);
    }

    public static void budujKraski(String osadaStartowa, String srodekOsady, String osadaKoncowa, String linkKoszar, WebDriver driver, String ilosc) {
        driver.get(osadaStartowa);
        driver.get(srodekOsady);
        driver.get(linkKoszar);

        WebElement okno = driver.findElement(By.name("t10"));
        okno.clear();
        okno.sendKeys(ilosc);
        okno = driver.findElement(By.name("s1"));
        okno.click();
        driver.get(osadaKoncowa);
    }

    public static void grabi(String osadaStartowa, String osadaKoncowa, String linkGrabi, WebDriver driver) throws InterruptedException {
        driver.get(osadaStartowa);
        driver.get(linkGrabi);
        WebElement g1 = null;
        List<WebElement> g2 = null;

        for (int i = 0; i < 5; i++) {
            try {
                g1 = driver.findElement(By.cssSelector("input[id='raidListMarkAll1117']"));
                g2 = driver.findElements(By.xpath("//*[@value='Zacznij grabież']"));
                if (!g1.equals(null) && !g2.get(0).equals(null)) {
                    break;
                }
            } catch (Exception e) {

            }
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", g2.get(0));
        Thread.sleep(500);
        g1.click();
        g2.get(0).click();

        for (int i = 0; i < 5; i++) {
            try {
                g1 = driver.findElement(By.cssSelector("input[id='raidListMarkAll615']"));
                g2 = driver.findElements(By.xpath("//*[@value='Zacznij grabież']"));
                if (!g1.equals(null) && !g2.get(1).equals(null)) {
                    break;
                }
            } catch (Exception e) {

            }
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", g2.get(1));
        Thread.sleep(500);
        g1.click();
        g2.get(1).click();

        for (int i = 0; i < 5; i++) {
            try {
                g1 = driver.findElement(By.cssSelector("input[id='raidListMarkAll1015']"));
                g2 = driver.findElements(By.xpath("//*[@value='Zacznij grabież']"));
                if (!g1.equals(null) && !g2.get(2).equals(null)) {
                    break;
                }
            } catch (Exception e) {

            }
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", g2.get(2));
        Thread.sleep(500);
        g1.click();
        g2.get(2).click();

        driver.get(osadaKoncowa);
    }

    public static void login(String osadaStartowa, String login, String haslo, WebDriver driver) {
        driver.get(osadaStartowa);
        WebElement loginLink = driver.findElement(By.name("name"));
        loginLink.sendKeys(login);
        loginLink = driver.findElement(By.name("password"));
        loginLink.sendKeys(haslo);
        loginLink = driver.findElement(By.name("lowRes"));
        loginLink.click();
        loginLink = driver.findElement(By.name("s1"));
        loginLink.click();
    }

    public static void kliknijPole(String nazwaZasobu, WebDriver driver) {
        int gid = 0;

        switch (nazwaZasobu) {
            case "Woodcutter":
                gid = 1;
                break;
            case "Clay":
                gid = 2;
                break;
            case "Iron":
                gid = 3;
                break;
            case "Cropland":
                gid = 4;
                break;
            default:
                gid = 1;
        }

        List<WebElement> childs = driver.findElements(By.cssSelector("a[class*='gid" + gid + " buildingSlot']"));
        int lowest = 10;
        int level = 0;
        String value;
        WebElement childToclick = null;
        for (WebElement child : childs) {
            value = child.getAttribute("class");
            level = Integer.parseInt(value.substring(value.length() - 1));
            if (level < lowest) {
                lowest = level;
                childToclick = child;
            }
        }
        childToclick.click();
    }
}