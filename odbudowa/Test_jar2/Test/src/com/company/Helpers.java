package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.company.Main.kliknijPole;

public class Helpers {


    private Helpers help;
    public boolean flag;
    public boolean bohFlag = false;

    public Helpers() {
        flag = true;
    }

    public boolean timeToSave() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
        int hour = date.getHours();
        if (hour > 10 && hour < 17)
        //
        {
            return true;
        } else {
            return false;
        }


    }


    public void savingProtocol(String osadaStartowa, String osadaKoncowa, String linkRatusz, WebDriver driver) {
        List<Integer> surowce = getResourcesNumbers(driver);
//        if (timeToSave()) {
//            subtrackCelebrateCost(surowce);
//        } else {
//            subtrackNormalCost(surowce);
//        }

        subtrackCelebrateCost(surowce);
        if (!isAllResourcesPlus(surowce)) {
            driver.close();
            System.exit(0);
        } else {
            tryToCelebrate(osadaStartowa, osadaKoncowa, linkRatusz, driver);
        }
    }

    private void subtrackNormalCost(List<Integer> surowce) {
        surowce.set(0, surowce.get(0));
        surowce.set(1, surowce.get(1));
        surowce.set(2, surowce.get(2));
        surowce.set(3, surowce.get(3) - 1000);
    }


    public boolean isAllResourcesPlus(List<Integer> surowce) {
        for (int element : surowce
        ) {
            if (element < 0) {
                return false;
            }
        }
        return true;
    }

    public void subtrackCelebrateCost(List<Integer> surowce) {
        surowce.set(0, surowce.get(0) - 0);
        surowce.set(1, surowce.get(1) - 0);
        surowce.set(2, surowce.get(2) - 0);
        surowce.set(3, surowce.get(3) - 2000);
    }

    public List<Integer> getResourcesNumbers(WebDriver driver) {
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

        return surowce;
    }

    public void spendRest(WebDriver driver) {
        try {
            List<WebElement> list = driver.findElements(By.cssSelector("div[class=buildDuration]"));
            if (list.size() > 1) {
                budujWojo("https://ts8.x1.europe.travian.com/dorf1.php",
                        "https://ts8.x1.europe.travian.com/dorf2.php",
                        "https://ts8.x1.europe.travian.com/dorf1.php",
                        "https://ts8.x1.europe.travian.com/build.php?id=23&gid=19",
                        driver, "3", "4");
            }
        } catch (Exception e) {

        }


    }

    public void tryToCelebrate(String osadaStartowa, String osadaKoncowa, String linkRatusz, WebDriver driver) {
        driver.get(osadaStartowa);
        driver.get(linkRatusz);
        if (driver.findElements(By.cssSelector("td[class=\"desc\"]")).size() < 2) {
            try {
                driver.findElement(By.cssSelector("button[value=\"Organizuj\"]")).click();
            } catch (Exception e) {

            }
            try {
                driver.findElement(By.cssSelector("button[value=\"Dodaj do kolejki świąt.\"]")).click();
            } catch (Exception e) {

            }
        }
        driver.get(osadaKoncowa);
    }

    public void budujPierwszyRaz(String osadaStartowa, String srodekOsady, String osadaKoncowa, WebDriver driver, List<String[]> planbudowy) throws InterruptedException {

        driver.get(osadaStartowa);

        waiterek();
        driver.get(srodekOsady);

        waiterek();
        int currentLevel;

        for (int i = 0; i < planbudowy.size(); i++) {

            if (tryFindBuilding(driver, planbudowy.get(i)[0])) {
                WebElement element = driver.findElement(By.cssSelector("div[class^='buildingSlot a" + planbudowy.get(i)[0] + "']"));
                currentLevel = Integer.parseInt(element.findElement(By.cssSelector("div[class='labelLayer']")).getText());
                try {

                    if (element.findElement(By.cssSelector("a[class*='underConstruction']")).isDisplayed()) {
                        currentLevel++;
                    }
                } catch (Exception e) {
                }
                if (currentLevel < Integer.valueOf(planbudowy.get(i)[1])) {

                    try {
                        element.click();
                        waiterek();
                        WebElement kupa = driver.findElement(By.xpath("//button[contains(text(),'do poziomu')]"));
                        kupa.click();
                        waiterek();
                        break;
                    } catch (Exception e) {
                        break;
                    }
                }
            } else {
                try {
                    driver.findElement(By.cssSelector("div[class^='buildingSlot a" + planbudowy.get(i)[0] + "']")).findElement(By.cssSelector("path[d]")).click();
                    waiterek();
                    driver.findElement(By.cssSelector("a[class*='" + planbudowy.get(i)[3] + "']")).click();

                    WebElement childElement = driver.findElement(By.xpath("//h2[contains(text(), '" + planbudowy.get(i)[2] + "')]"));
                    WebElement parentElement = childElement.findElement(By.xpath("./.."));
                    parentElement.findElement(By.cssSelector("button[value=\"Postaw nowy budynek\"]")).click();
                    Thread.sleep(2000);

                } catch (Exception e) {
                    break;
                }
                Thread.sleep(2000);
                driver.get(osadaStartowa);

            }


        }
    }

    private boolean tryFindBuilding(WebDriver driver, String buildingid) {
        try {
            WebElement e = driver.findElement(By.cssSelector("a[href^=\"/build.php?id=" + buildingid + "\"]"));
            String clasas = e.getAttribute("class");
            if (clasas.contains("emptyBuildingSlot")) {
                return false;
            } else {
                return true;
            }
        } catch (Exception exe) {

        }
        return false;
    }

    public void trySendResources(WebDriver driver, String osadaStartowa, int drewno, int glina, int zelazo, int zboze, String x, String y) throws InterruptedException {
        driver.get(osadaStartowa);
        //driver.findElement(By.cssSelector("a[class*=\"round market green\"]")).click();
        driver.get("https://ts10.x1.international.travian.com/build.php?t=5&id=24&gid=17&t=5");
        driver.findElement(By.cssSelector("input[name=\"r1\"]")).sendKeys(String.valueOf(drewno));
        driver.findElement(By.cssSelector("input[name=\"r2\"]")).sendKeys(String.valueOf(glina));
        driver.findElement(By.cssSelector("input[name=\"r3\"]")).sendKeys(String.valueOf(zelazo));
        driver.findElement(By.cssSelector("input[name=\"r4\"]")).sendKeys(String.valueOf(zboze));
        driver.findElement(By.cssSelector("input[id=\"xCoordInput\"]")).sendKeys(x);
        driver.findElement(By.cssSelector("input[id=\"yCoordInput\"]")).sendKeys(y);
        driver.findElement(By.cssSelector("button[value=\"Przygotuj\"]")).click();
        Thread.sleep(2500);
        driver.findElement(By.cssSelector("button[value=\"Wyślij surowce\"]")).click();
        driver.get(osadaStartowa);
    }

    public void trySendMilitary(WebDriver driver, String osadaStartowa) {
        driver.get(osadaStartowa);
        driver.get("https://ts8.x1.europe.travian.com/build.php?id=39&gid=16&tt=2");
        try {
            driver.findElement(By.cssSelector("input[name=\"troops[0][t1]\"]")).sendKeys("6");
            driver.findElement(By.cssSelector("input[id=\"xCoordInput\"]")).sendKeys("48");
            driver.findElement(By.cssSelector("input[id=\"yCoordInput\"]")).sendKeys("160");
            //driver.findElement(By.cssSelector("button[value=\"Przygotuj\"]")).click();
            driver.findElement(By.cssSelector("button[value=\"ok\"]")).click();
            driver.findElement(By.cssSelector("button[value=\"troopsSend\"]")).click();
        } catch (Exception e) {

        }
        driver.get(osadaStartowa);
    }

    public void grabiWithDedication(WebDriver driver, String osadaStartowa) throws InterruptedException {
        driver.get(osadaStartowa);
        waiterek();
        driver.get("https://ts10.x1.international.travian.com/build.php?id=39&gid=16&tt=2");
        try {
            driver.findElement(By.cssSelector("input[name=\"troops[0][t5]\"]")).sendKeys("33");//legio
            driver.findElement(By.cssSelector("input[id=\"xCoordInput\"]")).sendKeys("-86");
            driver.findElement(By.cssSelector("input[id=\"yCoordInput\"]")).sendKeys("27");
            waiterek();
            driver.findElement(By.cssSelector("input[value=\"4\"]")).click();//graiez
            //driver.findElement(By.cssSelector("input[value=\"3\"]")).click();//normalny
            // https://ts10.x1.international.travian.com/position_details.php?x=-86&y=27 ,true,true,7432,112
            waiterek();
            driver.findElement(By.cssSelector("button[value=\"ok\"]")).click();
            waiterek();
            try {
                driver.findElement(By.xpath("//td[contains(text(), '33')]"));
                waiterek();
                driver.findElement(By.cssSelector("button[value=\"troopsSend\"]")).click();
            } catch (Exception exxeeee) {

            }

        } catch (Exception e) {

        }
        waiterek();
        driver.get(osadaStartowa);
    }

    public static void waiterek() throws InterruptedException {
        //int random = (int) ((2000 + Math.random() * 2500 + 1));
        //5000 +
        int random = 1200;
        Thread.sleep(random);
    }

    public static void waiterekSmall() throws InterruptedException {
        //int random = (int) ((2000 + Math.random() * 2500 + 1));
        //5000 +
        int random = 100;
        Thread.sleep(random);
    }

    public void login(String osadaStartowa, String login, String haslo, WebDriver driver) throws InterruptedException {
        driver.get(osadaStartowa);
        try {
            WebElement c = driver.findElement(By.cssSelector("span[id=\"cmpbntyestxt\"]"));
            c.click();
        } catch (Exception e) {

        }

        WebElement loginLink = driver.findElement(By.name("name"));
        loginLink.sendKeys(login);
        loginLink = driver.findElement(By.name("password"));
        loginLink.sendKeys(haslo);
        loginLink = driver.findElement(By.name("lowRes"));
        loginLink.click();
        loginLink = driver.findElement(By.name("s1"));


        try {
            driver.findElement(By.cssSelector("span[id=\"cmpbntyestxt\"]")).click();
        } catch (Exception e) {

        }
        loginLink.click();

        waiterek();
        driver.get(osadaStartowa);
    }

    public void budujDomki(String osadaStartowa, String osadaKoncowa, WebDriver driver) throws InterruptedException {

        driver.get(osadaStartowa);
        waiterek();

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
            waiterek();
            x.click();
        } catch (Exception e) {

        } finally {
            waiterek();
            driver.get(osadaKoncowa);
        }
    }

    public void grabListeOaz(WebDriver driver, List<String> listafarm, String osadaStartowa) throws InterruptedException {
        WebElement e;
        WebElement legionista;
        Boolean brak;

        waiterek();
        driver.get(osadaStartowa);
        waiterek();
        if (checkElementExistsByXpath("//*[contains(text(), 'Bohater')]", driver)) {
            bohFlag = true;
        }
        for (String link : listafarm) {
            e = null;
            legionista = null;
            brak = null;

            if (flag == false && bohFlag == false) {
                break;
            }
            waiterek();
            e = null;
            driver.get(link);
            waiterek();
            brak = checkElementExistsByXpath("//*[contains(text(), 'brak')]", driver);

            if (brak == true) {
                try {
                    e = driver.findElements(By.cssSelector("img[class*=\"reportInfoIcon\"]")).get(0);
                } catch (Exception ex) {
                }
                if (e == null) {
                    toFarm(driver);
                } else if (e.getAttribute("class").contains("full")) {
                    toFarm(driver);
                } else if (e.getAttribute("class").contains("half")) //ostatnio farmione bylo 2h temu)
                {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();
                    int hour = date.getHours();
                    String text = driver.findElements(By.cssSelector("a[href^=\"/report?id\"]")).get(0).getText();
                    boolean isDzis = text.contains("dziś");
                    text = text.substring(text.length() - 5);
                    int gettedHour = Integer.parseInt(text.substring(0, 2));
                    if (!isDzis) {
                        hour += 24;
                    }
                    if (hour - gettedHour > 4) {
                        toFarm(driver);
                    }

                } else if (e == null) {
                    toFarm(driver);
                }
            } else if (bohFlag == true) {
                waiterek();
                driver.findElement(By.xpath("//*[contains(text(), 'Symuluj grabież')]")).click();
                waiterek();
                int health = Integer.parseInt(driver.findElement(By.cssSelector("input[name=\"health\"]")).getAttribute("value"));
                if (health < 25) {
                    if (health > 15) {
                        tryWyprawa(driver);
                    }
                    bohFlag = false;
                } else {
                    List<WebElement> lista = driver.findElements(By.cssSelector("input[name^=\"unit\"]"));
                    for (int i = 0; i < 10; i++) {
                        lista.get(i).clear();
                        Thread.sleep(100);
                        lista.get(i).sendKeys("0");
                    }
                    waiterek();
                    driver.findElement(By.cssSelector("button[id=\"simulate\"]")).click();
                    waiterek();
                    if (isAttribtuePresent(driver.findElement(By.cssSelector("button[id=\"applyLosses\"]")), "disabled")) {
                        continue;
                    }
                    waiterek();
                    driver.findElement(By.cssSelector("button[id=\"applyLosses\"]")).click();
                    int health2 = Integer.parseInt(driver.findElement(By.cssSelector("input[name=\"health\"]")).getAttribute("value"));
                    if (health - health2 < 28 && health2 > 20) {
                        waiterek();
                        driver.get(link);
                        toAttack(driver);
                    }
                }
            }
        }
    }

    private void tryWyprawa(WebDriver driver) throws InterruptedException {

        try {
            waiterek();
            driver.findElement(By.cssSelector("a[class*=\"adventure\"]")).click();
            driver.findElements(By.xpath("//a[contains(text(), 'Podejmij wyzwanie')]")).get(0).click();
        } catch (Exception e) {

        }

    }

    public void toFarm(WebDriver driver) throws InterruptedException {
        String ilosc = "4";
        driver.findElement(By.xpath("//*[contains(text(), 'Atakuj')]")).click();
        waiterek();
        driver.findElement(By.cssSelector("input[name=\"troops[0][t1]\"]")).sendKeys(ilosc);
        waiterek();
        driver.findElement(By.cssSelector("button[value=\"ok\"]")).click();
        waiterek();

        try {
            driver.findElement(By.xpath("//td[contains(text(), '" + ilosc + "')]"));
            waiterek();
            driver.findElement(By.cssSelector("button[value=\"troopsSend\"]")).click();
        } catch (Exception exx) {
            flag = false;
        }
    }

    public void toFarm2(WebDriver driver, String link) throws InterruptedException {
        String ilosc = "3";


        waiterek();
        driver.findElement(By.cssSelector("input[name=\"troops[0][t1]\"]")).sendKeys("3");
        waiterek();

        driver.findElement(By.cssSelector("input[value=\"4\"]")).click();//graiez
        waiterek();
        driver.findElement(By.cssSelector("button[value=\"ok\"]")).click();
        waiterek();

        try {
            driver.findElement(By.xpath("//td[contains(text(), '3')]"));
            waiterek();
            driver.findElement(By.cssSelector("button[value=\"troopsSend\"]")).click();
        } catch (Exception exx) {
            driver.get(link);
            waiterek();
            driver.findElement(By.cssSelector("input[name=\"troops[0][t3]\"]")).sendKeys(ilosc);
            waiterek();
            driver.findElement(By.cssSelector("input[value=\"4\"]")).click();//graiez
            waiterek();
            driver.findElement(By.cssSelector("button[value=\"ok\"]")).click();
            waiterek();

            try {
                driver.findElement(By.xpath("//td[contains(text(), '" + ilosc + "')]"));
                waiterek();
                driver.findElement(By.cssSelector("button[value=\"troopsSend\"]")).click();
            } catch (Exception exxee) {

                driver.get("https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&");
                waiterek();
                driver.get(link);
                waiterek();
                driver.findElement(By.cssSelector("input[name=\"troops[0][t5]\"]")).sendKeys("2");
                waiterek();
                driver.findElement(By.cssSelector("input[value=\"4\"]")).click();//graiez
                waiterek();
                driver.findElement(By.cssSelector("button[value=\"ok\"]")).click();
                waiterek();

                try {
                    if (driver.findElement(By.cssSelector("tbody[class=\"units\"]")).findElement(By.xpath("//td[contains(text(), '2')]")).isDisplayed())
                        ;
                    {
                        waiterek();
                        driver.findElement(By.cssSelector("button[value=\"troopsSend\"]")).click();
                    }

                } catch (Exception exxeeee) {

                    flag = false;
                }
            }
        }
    }


    public boolean toFarm3(WebDriver driver, String link, String czyOsada, boolean czyBoh, String ilosc) throws InterruptedException {

        driver.get(link);
        waiterek();


        if (czyOsada.equals("true")) {
            driver.findElement(By.xpath("//*[contains(text(), 'Wyślij')]")).click();
        } else {
            try {
                if (!waitElementAppear(driver, By.xpath("//*[contains(text(), 'Atakują niezajętą oazę')]"))) {
                    return false;
                }
            } catch (Exception ex) {

            }
            waiterek();
            driver.findElement(By.xpath("//*[contains(text(), 'Atakuj')]")).click();
        }
        waiterek();
        driver.findElement(By.cssSelector("input[name=\"troops[0][t5]\"]")).sendKeys(ilosc);
        waiterek();
        if (czyBoh) {
            driver.findElement(By.cssSelector("input[name=\"troops[0][t11]\"]")).sendKeys("1");//boh
            waiterek();
        }

        driver.findElement(By.cssSelector("input[value=\"4\"]")).click();//graiez
        waiterek();
        driver.findElement(By.cssSelector("button[value=\"ok\"]")).click();
        waiterek();

        try {
            driver.findElement(By.xpath("//td[contains(text(), '" + ilosc + "')]"));
            waiterek();
            driver.findElement(By.cssSelector("button[value=\"troopsSend\"]")).click();
            return true;
        } catch (Exception exx) {
            return false;
        }
    }


    public boolean toZwiad(WebDriver driver, String link, String czyOsada, boolean zwiadFlag) throws InterruptedException {
        String ilosc = "1";
        WebElement e;
        driver.get(link);

        try {
            if (!waitElementAppear(driver, By.xpath("//*[contains(text(), 'Atakują niezajętą oazę')]"))) {
                return false;
            }
        } catch (Exception ex) {

        }

        waiterek();
        if (czyOsada.equals("true")) {
            driver.findElement(By.xpath("//*[contains(text(), 'Wyślij')]")).click();
        } else {
            driver.findElement(By.xpath("//*[contains(text(), 'Atakuj')]")).click();
        }

        waiterek();
        driver.findElement(By.cssSelector("input[name=\"troops[0][t4]\"]")).sendKeys(ilosc);
        waiterek();
        driver.findElement(By.cssSelector("input[value=\"4\"]")).click();//graiez
        waiterek();
        driver.findElement(By.cssSelector("button[value=\"ok\"]")).click();
        waiterek();

        try {
            driver.findElement(By.xpath("//td[contains(text(), '" + ilosc + "')]"));
            waiterek();
            driver.findElement(By.cssSelector("button[value=\"troopsSend\"]")).click();

            return true;
        } catch (Exception exx) {
            FileReaderek.setZwiadTofalse();
            return false;
        }
    }


    public void toAttack(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[contains(text(), 'Atakuj')]")).click();
        waiterek();
        driver.findElement(By.cssSelector("input[name=\"troops[0][t11]\"]")).sendKeys("1");//boh
        waiterek();
        driver.findElement(By.cssSelector("button[value=\"ok\"]")).click();
        waiterek();
        driver.findElement(By.cssSelector("button[value=\"troopsSend\"]")).click();
        bohFlag = false;

    }


    public void budujWojo(String osadaStartowa, String srodekOsady, String osadaKoncowa, String linkKoszar, WebDriver driver, String tier, String ilosc) throws InterruptedException {
        driver.get(osadaStartowa);
        waiterek();
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
//        if (valuedrewno > iloscPalek * 95 && valuezelazo > iloscPalek * 40 && valuesiano > iloscPalek * 40 && valueglina > iloscPalek * 75 && budowaauu != null) {
//        }

        driver.get(srodekOsady);
        waiterek();
        driver.get(linkKoszar);
        waiterek();
        try {

            WebElement okno = driver.findElement(By.name("t" + tier));
            okno.clear();
            okno.sendKeys(ilosc);
            okno = driver.findElement(By.name("s1"));
            okno.click();
            waiterek();
        } catch (Exception e) {

        }

        driver.get(osadaKoncowa);
    }


    public boolean checkElementExistsByXpath(String selector, WebDriver driver) {
        WebElement e = null;
        try {
            e = driver.findElement(By.xpath(selector));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean checkElementExistsByCss(String selector, WebDriver driver) {
        WebElement e = null;
        try {
            e = driver.findElement(By.cssSelector(selector));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean isAttribtuePresent(WebElement element, String attribute) {
        Boolean result = false;
        try {
            String value = element.getAttribute(attribute);
            if (value != null) {
                result = true;
            }
        } catch (Exception e) {
        }

        return result;
    }

    public void grabFarmy(WebDriver driver, List<String> listafarm, String osadaStartowa) throws InterruptedException {
        driver.get("https://ts10.x1.international.travian.com/dorf2.php?newdid=21478&");
        waiterek();

        WebElement e;
        WebElement legionista;
        Boolean brak;

        waiterek();
        driver.get(osadaStartowa);
        waiterek();


        if (flag == true) {
            for (String link : listafarm) {
                e = null;
                legionista = null;
                brak = null;

                if (flag == false) {
                    break;
                }
                waiterek();
                e = null;
                driver.get(link);
                waiterek();
                //brak = checkElementExistsByXpath(, driver);
                //e = driver.findElement(By.xpath("//*[contains(text(), 'Wyślij jednostki')]"));
                toFarm2(driver, link);

            }
        }
    }

    public void grabOazyInteligentnie(WebDriver driver, List<OazaObject> lista) {
    }

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }


    public int thinkIfWeShouldAttack(WebDriver driver, String s, String czyOsada, boolean czyZbohem, String ilosc) throws InterruptedException {
        WebElement e = null;
        waiterek();
        driver.get(s);
        try {
            if (!waitElementAppear(driver, By.xpath("//*[contains(text(), 'Atakują niezajętą oazę')]"))) {
                return 0;
            }
            e = driver.findElements(By.cssSelector("img[alt*=\"Zwiad\"]")).get(0);
            WebElement parent = e.findElement(By.xpath("./.."));
            parent.findElement(By.cssSelector("a[href]")).click();
        } catch (Exception ex) {
            System.out.println("802");
        }

        int suma = 0;
        waitElementAppear(driver, By.cssSelector("div[class^=\"role attacker\"]"));
        if (czyOsada.equals("true")) {
            int kryjówka = Integer.parseInt(driver.findElement(By.cssSelector("div[class=\"rArea\"]")).getText());

            for (WebElement eee : driver.findElements(By.cssSelector("div[class=\"inlineIcon resources\"]"))) {
                suma += Integer.parseInt(eee.getText()) - kryjówka;
            }

            WebElement gggg = driver.findElements(By.cssSelector("tbody[class=\"units\"]")).get(3);
            List<WebElement> wfewef = gggg.findElements(By.cssSelector("td[class^=\"unit\"]"));

            for (WebElement efef : wfewef) {
                if (Integer.parseInt(efef.getText()) > 0) {
                    suma = 0;
                    break;
                }
            }
        }


        if (czyOsada.equals("false")) {

            if (czyZbohem) {
                for (WebElement eee : driver.findElements(By.cssSelector("div[class=\"inlineIcon resources\"]"))) {
                    suma += Integer.parseInt(eee.getText());
                }
                waiterekSmall();
                driver.get(s);

                if (waitElementAppear(driver, By.xpath("//*[contains(text(), 'brak')]"))) {
                    return suma;
                }

                waitElementAppear(driver, By.xpath("//*[contains(text(), 'Atakują niezajętą oazę')]"));
                driver.findElement(By.xpath("//*[contains(text(), 'Symuluj grabież')]")).click();
                waiterekSmall();
                waitElementAppear(driver, By.cssSelector("div[class^=\"role attacker\"]"));
                int health = Integer.parseInt(driver.findElement(By.cssSelector("input[name=\"health\"]")).getAttribute("value"));
                if (health < 10) {
                    if (health > 10) {
                        tryWyprawa(driver);
                    }
                    return 0;
                } else {
                    List<WebElement> lista = driver.findElements(By.cssSelector("input[name^=\"unit\"]"));
                    for (int i = 0; i < 10; i++) {
                        if (i != 4) {
                            lista.get(i).clear();
                            Thread.sleep(100);
                            lista.get(i).sendKeys("0");
                        } else if (i == 4) {
                            lista.get(i).clear();
                            Thread.sleep(100);
                            lista.get(i).sendKeys(ilosc);
                        }
                    }
                    try {
                        driver.findElement(By.cssSelector("div[class=\"heroAttributes shown\"]"));
                    } catch (Exception oefiwjef) {
                        System.out.println("wlanczam hirosa");
                        driver.findElements(By.cssSelector("input[name=\"hero\"]")).get(0).click();
                    }
                    waiterekSmall();
                    waitElementAppear(driver, By.cssSelector("button[id=\"simulate\"]"));
                    driver.findElement(By.cssSelector("button[id=\"simulate\"]")).click();
                    Thread.sleep(1000);
                    waiterekSmall();
                    int health2 = 0;
                    waiterekSmall();
                    WebElement root = driver.findElements(By.cssSelector("tr[class = troopsInitial]")).get(0);
                    WebElement lower = root.findElement(By.cssSelector("td[class=\"u5\"]"));
                    String tyyxt = lower.getText();
                    String numberOnly = tyyxt.replaceAll("[^0-9]", "");
                    int initial = Integer.parseInt(numberOnly);
                    int potem = Integer.parseInt(driver.findElements(By.cssSelector("tr[class = troopsResult]")).get(0).findElement(By.cssSelector("td[class=\"u5\"]")).getText().replaceAll("[^0-9]", ""));
                    int roznica = initial - potem;
                    if (suma > potem * 100) {
                        suma = (potem * 100) - (roznica * 1410);
                    } else {
                        suma = suma - roznica * 1410;
                    }

                    for (int j = 0; j < 10; j++) {
                        if (j == 0 || j == 1 || j == 2 || j == 3) {
                            suma += 50 * 4 * Integer.parseInt(driver.findElements(By.cssSelector("tr[class = troopsLoss]")).get(1).findElements(By.cssSelector("td[class^=\"u\"]")).get(j).getText().replaceAll("[^0-9]", ""));
                        }

                        if (j == 4 || j == 5) {
                            suma += 100 * 4 * Integer.parseInt(driver.findElements(By.cssSelector("tr[class = troopsLoss]")).get(1).findElements(By.cssSelector("td[class^=\"u\"]")).get(j).getText().replaceAll("[^0-9]", ""));
                        }

                        if (j == 6 || j == 7 || j == 8) {
                            suma += 150 * 4 * Integer.parseInt(driver.findElements(By.cssSelector("tr[class = troopsLoss]")).get(1).findElements(By.cssSelector("td[class^=\"u\"]")).get(j).getText().replaceAll("[^0-9]", ""));
                        }

                        if (j == 9) {
                            suma += 250 * 4 * Integer.parseInt(driver.findElements(By.cssSelector("tr[class = troopsLoss]")).get(1).findElements(By.cssSelector("td[class^=\"u\"]")).get(j).getText().replaceAll("[^0-9]", ""));
                        }

                    }
                    waitElementAppear(driver, By.cssSelector("button[id=\"applyLosses\"]"));
                    driver.findElement(By.cssSelector("button[id=\"applyLosses\"]")).click();
                    Thread.sleep(1000);
                    waiterek();
                    waitElementAppear(driver, By.cssSelector("div[class^=\"role attacker\"]"));
                    waiterek();
                    waitElementsAppear(driver, By.cssSelector("input[name^=\"unit\"]"));
                    waiterekSmall();
                    waiterek();
                    lista.get(0).click();
                    lista.get(1).click();
                    waiterekSmall();
                    lista.get(1).click();
                    Thread.sleep(1000);
                    try {
                        health2 = Integer.parseInt(driver.findElement(By.cssSelector("input[name=\"health\"]")).getAttribute("value"));
                    } catch (Exception edvdv) {
                        System.out.println("909");
                    }
                    if (health2 > 5 && roznica < 5) {

                        return suma;
                    } else {
                        return 0;
                    }
                }
            }

            if (!czyZbohem) {
                for (WebElement eee : driver.findElements(By.cssSelector("div[class=\"inlineIcon resources\"]"))) {
                    suma += Integer.parseInt(eee.getText());
                }
                waiterekSmall();
                driver.get(s);

                if (waitElementAppear(driver, By.xpath("//*[contains(text(), 'brak')]"))) {
                    return suma;
                }

                waitElementAppear(driver, By.xpath("//*[contains(text(), 'Atakują niezajętą oazę')]"));
                driver.findElement(By.xpath("//*[contains(text(), 'Symuluj grabież')]")).click();
                waiterekSmall();
                waitElementAppear(driver, By.cssSelector("div[class^=\"role attacker\"]"));

                List<WebElement> lista = driver.findElements(By.cssSelector("input[name^=\"unit\"]"));
                for (int i = 0; i < 10; i++) {
                    if (i != 4) {
                        lista.get(i).clear();
                        Thread.sleep(100);
                        lista.get(i).sendKeys("0");
                    } else if (i == 4) {
                        lista.get(i).clear();
                        Thread.sleep(100);
                        lista.get(i).sendKeys(ilosc);
                    }
                }

                waiterekSmall();
                waitElementAppear(driver, By.cssSelector("button[id=\"simulate\"]"));
                driver.findElement(By.cssSelector("button[id=\"simulate\"]")).click();
                Thread.sleep(1000);
                waiterekSmall();
                WebElement root = driver.findElements(By.cssSelector("tr[class = troopsInitial]")).get(0);
                WebElement lower = root.findElement(By.cssSelector("td[class=\"u5\"]"));
                String tyyxt = lower.getText();
                String numberOnly = tyyxt.replaceAll("[^0-9]", "");
                int initial = Integer.parseInt(numberOnly);
                int potem = Integer.parseInt(driver.findElements(By.cssSelector("tr[class = troopsResult]")).get(0).findElement(By.cssSelector("td[class=\"u5\"]")).getText().replaceAll("[^0-9]", ""));
                int roznica = initial - potem;
                if (suma > potem * 100) {
                    suma = (potem * 100) - (roznica * 1410);
                } else {
                    suma = suma - roznica * 1410;
                }

                for (int j = 0; j < 10; j++) {
                    if (j == 0 || j == 1 || j == 2 || j == 3) {
                        suma += 50 * 4 * Integer.parseInt(driver.findElements(By.cssSelector("tr[class = troopsLoss]")).get(1).findElements(By.cssSelector("td[class^=\"u\"]")).get(j).getText().replaceAll("[^0-9]", ""));
                    }

                    if (j == 4 || j == 5) {
                        suma += 100 * 4 * Integer.parseInt(driver.findElements(By.cssSelector("tr[class = troopsLoss]")).get(1).findElements(By.cssSelector("td[class^=\"u\"]")).get(j).getText().replaceAll("[^0-9]", ""));
                    }

                    if (j == 6 || j == 7 || j == 8) {
                        suma += 150 * 4 * Integer.parseInt(driver.findElements(By.cssSelector("tr[class = troopsLoss]")).get(1).findElements(By.cssSelector("td[class^=\"u\"]")).get(j).getText().replaceAll("[^0-9]", ""));
                    }

                    if (j == 9) {
                        suma += 250 * 4 * Integer.parseInt(driver.findElements(By.cssSelector("tr[class = troopsLoss]")).get(1).findElements(By.cssSelector("td[class^=\"u\"]")).get(j).getText().replaceAll("[^0-9]", ""));
                    }

                }
                waitElementAppear(driver, By.cssSelector("button[id=\"applyLosses\"]"));
                driver.findElement(By.cssSelector("button[id=\"applyLosses\"]")).click();
                Thread.sleep(1000);
                waiterek();
                waitElementsAppear(driver, By.cssSelector("div[class^=\"role attacker\"]"));
                waiterekSmall();
                waiterek();
                lista.get(0).click();
                lista.get(1).click();
                waiterekSmall();
                lista.get(1).click();
                Thread.sleep(1000);
                if (roznica < 5) {
                    return suma;
                } else {
                    return 0;
                }
            }
        }
        return suma;
    }

    public void grabiWithDedication2(WebDriver driver, String osadaStartowa) throws InterruptedException {
        driver.get(osadaStartowa);
        waiterek();
        driver.get("https://ts10.x1.international.travian.com/build.php?id=39&gid=16&tt=2");
        try {
            driver.findElement(By.cssSelector("input[name=\"troops[0][t5]\"]")).sendKeys("10");//legio
            driver.findElement(By.cssSelector("input[id=\"xCoordInput\"]")).sendKeys("-86");
            driver.findElement(By.cssSelector("input[id=\"yCoordInput\"]")).sendKeys("31");
            waiterek();
            driver.findElement(By.cssSelector("input[value=\"4\"]")).click();//graiez
            //driver.findElement(By.cssSelector("input[value=\"3\"]")).click();//normalny
            // https://ts10.x1.international.travian.com/position_details.php?x=-86&y=27 ,true,true,7432,112
            waiterek();
            driver.findElement(By.cssSelector("button[value=\"ok\"]")).click();
            waiterek();
            try {
                driver.findElement(By.xpath("//td[contains(text(), '33')]"));
                waiterek();
                driver.findElement(By.cssSelector("button[value=\"troopsSend\"]")).click();
            } catch (Exception exxeeee) {

            }

        } catch (Exception e) {

        }
        waiterek();
        driver.get(osadaStartowa);
    }

    public boolean waitElementAppear(WebDriver driver, By by) {
        try {
            WebElement element = (new WebDriverWait(driver, 3))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean waitElementsAppear(WebDriver driver, By by) {
        try {
            List<WebElement> element = (new WebDriverWait(driver, 3))
                    .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            return true;
        } catch (Exception e) {
            return false;
        }

    }


    public void requestResources(WebDriver driver, String osadarządająca, String osadaZapewniająco) throws InterruptedException {
        driver.get(osadarządająca);
        waiterek();
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

        WebElement cwel = driver.findElements(By.cssSelector("div[class=\"capacity\"]")).get(0);
        WebElement dziecko = cwel.findElement(By.cssSelector("div[class=\"value\"]"));
        int magazinevalue = Integer.parseInt(dziecko.getText().replaceAll("[^0-9]", ""));


        WebElement cwel2 = driver.findElements(By.cssSelector("div[class=\"capacity\"]")).get(1);
        WebElement dziecko2 = cwel2.findElement(By.cssSelector("div[class=\"value\"]"));
        int spichlerzevalue = Integer.parseInt(dziecko2.getText().replaceAll("[^0-9]", ""));


        int lowest = Collections.max(surowce);
        int surkaInt = 0;


        if (lowest == surowce.get(3)) {
            // double obecnyProcent = surowce.get(3)/spichlerzevalue;

            double obecnyProcent = ((surowce.get(3) * 100.0f) / spichlerzevalue);
            double potrzebnyProcent = 60;

            double roznicaprocentow = potrzebnyProcent - obecnyProcent;
            double surkatosend = roznicaprocentow * spichlerzevalue / 100;
            if ((int) Math.round(surkatosend) < 0) {
                surkatosend = 0;
            }
            surkaInt = (int) Math.round(surkatosend);
        } else {
            double obecnyProcent = ((lowest * 100.0f) / magazinevalue);
            double potrzebnyProcent = 80;

            double roznicaprocentow = potrzebnyProcent - obecnyProcent;
            double surkatosend = roznicaprocentow * magazinevalue / 100;

            if ((int) Math.round(surkatosend) < 0) {
                surkatosend = 0;
            }
            surkaInt = (int) Math.round(surkatosend);
        }


        waiterek();
        driver.get(osadaZapewniająco);
        try {
            trySendResources(driver, osadaZapewniająco, surkaInt, surkaInt, surkaInt, surkaInt - 300, "-88", "37");
        } catch (Exception eff) {
            waiterek();
            driver.get(osadaZapewniająco);
            try {
                waiterek();
                driver.get(osadaZapewniająco);
                trySendResources(driver, osadaZapewniająco, surkaInt / 2, surkaInt / 2, surkaInt / 2, (surkaInt - 400) / 2, "-88", "37");
            } catch (Exception effdd) {
                try {
                    waiterek();
                    driver.get(osadaZapewniająco);
                    trySendResources(driver, osadaZapewniająco, surkaInt / 4, surkaInt / 4, surkaInt / 4, (surkaInt - 400) / 4, "-88", "37");
                } catch (Exception effdddd) {
                    try {
                        waiterek();
                        driver.get(osadaZapewniająco);
                        trySendResources(driver, osadaZapewniająco, surkaInt / 8, surkaInt / 8, surkaInt / 8, (surkaInt - 400) / 8, "-88", "37");
                    } catch (Exception tgeg) {

                    }
                }
            }
        }
    }


    public boolean checkWeAreBuilding(WebDriver driver, String osada) {
        driver.get(osada);
        int budowa = 0;
        try {
            budowa = driver.findElements(By.cssSelector("div[class=\"buildDuration\"]")).size();

        } catch (Exception e) {
            return false;
        }

        if (budowa == 2) {
            return true;
        } else return false;

    }


}
