package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        Helpers help = new Helpers();

        FileReaderek readerek = new FileReaderek();
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

            File myObj2 = new File("filename2.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

            FirefoxBinary firefoxBinary = new FirefoxBinary();
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary(firefoxBinary);
            //options.setHeadless(true);  // <-- headless set here
            WebDriver driver = new FirefoxDriver(options);

            Random rn = new Random();
            int answer = rn.nextInt(6) + 1;
            //answer = 0;

            Thread.sleep(answer * 60000);
            List<String[]> listaPierwszej = new ArrayList<>();
            List<String[]> listaDrugej = new ArrayList<>();
            List<String[]> listaTrzeciej = new ArrayList<>();

            listaTrzeciej.add(new String[]{"37", "1", "Warsztat Płatnerza", "military"});
            listaTrzeciej.add(new String[]{"24", "3", "Rynek", "infra"});
            listaTrzeciej.add(new String[]{"20", "10", "Magazyn", "infra"});
            listaTrzeciej.add(new String[]{"21", "10", "Spichlerz", "infra"});
            listaTrzeciej.add(new String[]{"19", "10", "Kryjówka", "infra"});
            listaTrzeciej.add(new String[]{"27", "1", "Kryjówka", "infra"});
            listaTrzeciej.add(new String[]{"28", "1", "Kryjówka", "infra"});
            listaTrzeciej.add(new String[]{"27", "10", "Kryjówka", "infra"});
            listaTrzeciej.add(new String[]{"24", "5", "Rynek", "infra"});
            listaTrzeciej.add(new String[]{"36", "5", "Akademia", "military"});
            listaTrzeciej.add(new String[]{"36", "10", "Akademia", "military"});
            listaTrzeciej.add(new String[]{"38", "1", "Ratusz", "infra"});
            listaTrzeciej.add(new String[]{"20", "11", "Magazyn", "infra"});
            listaTrzeciej.add(new String[]{"21", "11", "Spichlerz", "infra"});
            listaTrzeciej.add(new String[]{"30", "10", "Dwór bohatera", "infra"});
            listaTrzeciej.add(new String[]{"25", "10", "Rezydencja", "infra"});
            listaTrzeciej.add(new String[]{"26", "13", "Główny budynek", "infra"});
            listaTrzeciej.add(new String[]{"20", "13", "Magazyn", "infra"});
            listaTrzeciej.add(new String[]{"21", "13", "Spichlerz", "infra"});

//        listaPierwszej.add(new String[]{"32", "5", "Cegielnia", "infra"});
//        listaPierwszej.add(new String[]{"34", "10", "Dwór bohatera", "infra"});
//        listaPierwszej.add(new String[]{"20", "16", "Magazyn", "infra"});
//        listaPierwszej.add(new String[]{"21", "17", "Spichlerz", "infra"});
//        listaPierwszej.add(new String[]{"20", "17", "Magazyn", "infra"});
//        listaPierwszej.add(new String[]{"21", "17", "Spichlerz", "infra"});
//        listaPierwszej.add(new String[]{"21", "18", "Spichlerz", "infra"});
//        listaPierwszej.add(new String[]{"20", "18", "Magazyn", "infra"});
//        listaPierwszej.add(new String[]{"21", "18", "Spichlerz", "infra"});


//        listaDrugej.add(new String[]{"27", "10", "Dwór bohatera", "infra"});
//        listaDrugej.add(new String[]{"30", "5", "Szpital", "infra"});
//        listaDrugej.add(new String[]{"24", "10", "Rynek", "infra"});


//        listaDrugej.add(new String[]{"26", "16", "Główny budynek", "infra"});
//        listaDrugej.add(new String[]{"20", "16", "Magazyn", "infra"});
//        listaDrugej.add(new String[]{"21", "16", "Spichlerz", "infra"});
//        listaDrugej.add(new String[]{"26", "17", "Główny budynek", "infra"});
//        listaDrugej.add(new String[]{"20", "17", "Magazyn", "infra"});
//        listaDrugej.add(new String[]{"21", "17", "Spichlerz", "infra"});
//        listaDrugej.add(new String[]{"26", "18", "Główny budynek", "infra"});
//        listaDrugej.add(new String[]{"20", "18", "Magazyn", "infra"});
//        listaDrugej.add(new String[]{"21", "18", "Spichlerz", "infra"});


//        listaTrzeciej.add(new String[]{"19", "1", "Kryjówka", "infra"});
//        listaTrzeciej.add(new String[]{"20", "1", "Magazyn", "infra"});
//        listaTrzeciej.add(new String[]{"21", "1", "Spichlerz", "infra"});
//        listaTrzeciej.add(new String[]{"26", "5", "Główny budynek", "infra"});
//        //listaTrzeciej.add(new String[]{"23", "1", "Koszary", "military"});
//        listaTrzeciej.add(new String[]{"20", "2", "Magazyn", "infra"});
//        listaTrzeciej.add(new String[]{"21", "2", "Spichlerz", "infra"});
//        listaTrzeciej.add(new String[]{"20", "3", "Magazyn", "infra"});
//        listaTrzeciej.add(new String[]{"21", "3", "Spichlerz", "infra"});
//        listaTrzeciej.add(new String[]{"19", "3", "Kryjówka", "infra"});
//        listaTrzeciej.add(new String[]{"24", "1", "Rynek", "infra"});
//        listaTrzeciej.add(new String[]{"26", "7", "Główny budynek", "infra"});
//        listaTrzeciej.add(new String[]{"20", "5", "Magazyn", "infra"});
//        listaTrzeciej.add(new String[]{"21", "5", "Spichlerz", "infra"});
//        listaTrzeciej.add(new String[]{"20", "7", "Magazyn", "infra"});
//        listaTrzeciej.add(new String[]{"21", "7", "Spichlerz", "infra"});
//        listaTrzeciej.add(new String[]{"23", "3", "Koszary", "military"});
//        listaTrzeciej.add(new String[]{"36", "1", "Akademia", "military"});

//
//
//        //listaPierwszej.add(new String[]{"29", "1", "Kryjówka", "infra"});
//        //listaTrzeciej.add(new String[]{"37", "5", "Warsztat Płatnerza", "military"});
////        listaPierwszej.add(new String[]{"20", "8", "Magazyn", "infra"});
////        listaPierwszej.add(new String[]{"21", "8", "Spichlerz", "infra"});
////        listaPierwszej.add(new String[]{"36", "10", "Akademia", "military"});
////        listaPierwszej.add(new String[]{"37", "3", "Warsztat Płatnerza", "military"});
////        listaPierwszej.add(new String[]{"33", "5", "Stajnia", "military"});
////        listaPierwszej.add(new String[]{"26", "10", "Główny budynek", "infra"});
////        listaPierwszej.add(new String[]{"20", "12", "Magazyn", "infra"});
////        listaPierwszej.add(new String[]{"21", "12", "Spichlerz", "infra"});
////        listaPierwszej.add(new String[]{"25", "10", "Rezydencja", "infra"});
////        listaPierwszej.add(new String[]{"38", "1", "Ratusz", "infra"});
////        listaPierwszej.add(new String[]{"21", "12", "Spichlerz", "infra"});
////        listaPierwszej.add(new String[]{"20", "12", "Magazyn", "infra"});
////        listaPierwszej.add(new String[]{"26", "13", "Główny budynek", "infra"});
////        listaPierwszej.add(new String[]{"21", "14", "Spichlerz", "infra"});
//
//
//        listaDrugej.add(new String[]{"29", "3", "Tartak", "resources"});
//        listaDrugej.add(new String[]{"32", "3", "Cegielnia", "resources"});
//        listaDrugej.add(new String[]{"33", "8", "Stajnia", "military"});
//        listaDrugej.add(new String[]{"29", "4", "Tartak", "resources"});
//        listaDrugej.add(new String[]{"24", "6", "Rynek", "infra"});
//        listaDrugej.add(new String[]{"20", "13", "Magazyn", "infra"});
//        listaDrugej.add(new String[]{"23", "5", "Koszary", "military"});
//        listaDrugej.add(new String[]{"31", "5", "Warsztat", "military"});
//        listaDrugej.add(new String[]{"20", "14", "Magazyn", "infra"});
//        listaDrugej.add(new String[]{"21", "16", "Spichlerz", "infra"});
//        listaDrugej.add(new String[]{"31", "10", "Warsztat", "military"});
//        listaDrugej.add(new String[]{"36", "15", "Akademia", "military"});
//        listaDrugej.add(new String[]{"22", "3", "Huta Stali", "resources"});
//        listaDrugej.add(new String[]{"26", "15", "Główny budynek", "infra"});
//        listaDrugej.add(new String[]{"20", "16", "Magazyn", "infra"});
//        listaDrugej.add(new String[]{"21", "17", "Spichlerz", "infra"});
//        listaDrugej.add(new String[]{"20", "18", "Magazyn", "infra"});
//        listaDrugej.add(new String[]{"21", "18", "Spichlerz", "infra"});
//
//        listaPierwszej.add(new String[]{"26", "15", "Główny budynek", "infra"});
//        listaPierwszej.add(new String[]{"20", "14", "Magazyn", "infra"});
//        listaPierwszej.add(new String[]{"21", "16", "Spichlerz", "infra"});
//        listaPierwszej.add(new String[]{"20", "16", "Magazyn", "infra"});
//        listaPierwszej.add(new String[]{"21", "17", "Spichlerz", "infra"});
//        listaPierwszej.add(new String[]{"20", "18", "Magazyn", "infra"});
//        listaPierwszej.add(new String[]{"21", "18", "Spichlerz", "infra"});


            help.login("https://ts10.x1.international.travian.com/dorf1.php", "Majos", "qweasdzxc", driver);


//            grabi("https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&", "https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&",
//                    "https://ts10.x1.international.travian.com/build.php?id=39&gid=16&tt=99", driver);
//
//            //help.requestResources(driver, "https://ts10.x1.international.travian.com/dorf1.php?newdid=25296&", "https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&");//majo
//            help.requestResources(driver, "https://ts10.x1.international.travian.com/dorf1.php?newdid=25296&", "https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&");//piek
////        help.budujPierwszyRaz("https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&", "https://ts10.x1.international.travian.com/dorf2.php",
////                "https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&", driver, listaPierwszej);
////
////        help.budujDomki("https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&",
////                "https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&",
////                driver);
//////
////
//////
//            //////        //1 osadka
//            help.budujWojo("https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&",
//                    "https://ts10.x1.international.travian.com/dorf2.php",
//                    "https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&",
//                    "https://ts10.x1.international.travian.com/build.php?id=33&gid=20",
//                    driver, "5", "1");
//
//            help.budujWojo("https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&",
//                    "https://ts10.x1.international.travian.com/dorf2.php",
//                    "https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&",
//                    "https://ts10.x1.international.travian.com/build.php?id=33&gid=20",
//                    driver, "4", "1");
//////
//////
//////            help.budujWojo("https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&",
//////                    "https://ts10.x1.international.travian.com/dorf2.php",
//////                    "https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&",
//////                    "https://ts10.x1.international.travian.com/build.php?id=23&gid=19",
//////                    driver, "2", "1");
////////
////////
//////        //2 osadka
//////
//////
//            help.budujDomki("https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&",
//                    "https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&",
//                    driver);
//
//////
//            if (help.checkWeAreBuilding(driver, "https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&")) {
//////
//
//                help.budujWojo("https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&",
//                        "https://ts10.x1.international.travian.com/dorf2.php",
//                        "https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&",
//                        "https://ts10.x1.international.travian.com/build.php?id=23&gid=19",
//                        driver, "3", "2");
//
//                help.budujWojo("https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&",
//                        "https://ts10.x1.international.travian.com/dorf2.php",
//                        "https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&",
//                        "https://ts10.x1.international.travian.com/build.php?id=33&gid=20",
//                        driver, "5", "2");
//
//                help.budujWojo("https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&",
//                        "https://ts10.x1.international.travian.com/dorf2.php",
//                        "https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&",
//                        "https://ts10.x1.international.travian.com/build.php?id=31&gid=21",
//                        driver, "8", "1");
//            }
////
////        help.budujPierwszyRaz("https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&", "https://ts10.x1.international.travian.com/dorf2.php",
////                "https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&", driver, listaDrugej);
////
//
//////
//////
////////        //3 osada
//            help.budujDomki("https://ts10.x1.international.travian.com/dorf1.php?newdid=25296&",
//                    "https://ts10.x1.international.travian.com/dorf1.php?newdid=25296&",
//                    driver);
//
//
//            help.budujPierwszyRaz("https://ts10.x1.international.travian.com/dorf1.php?newdid=25296&", "https://ts10.x1.international.travian.com/dorf2.php",
//                    "https://ts10.x1.international.travian.com/dorf1.php?newdid=25296&", driver, listaTrzeciej);
//
//
////

//
            try {
                readerek.replace(driver);
            } catch (Exception e) {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                String sStackTrace = sw.toString(); // stack trace as a string
                System.out.println(sStackTrace);


                e.printStackTrace();
                FileWriter fw = new FileWriter("filename2.txt", true); //the true will append the new data
                fw.write(sStackTrace);//appends the string to the file
                fw.close();
            }


            driver.close();

            myObj.delete();

        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String sStackTrace = sw.toString(); // stack trace as a string
            System.out.println(sStackTrace);


            e.printStackTrace();
            FileWriter fw = new FileWriter("filename.txt", true); //the true will append the new data
            fw.write(sStackTrace);//appends the string to the file
            fw.close();
        }


        //int random = (int) (Math.random() * 5 + 1);

        //Thread.sleep(random * 60000);

//        Map<Integer, Integer> planbudowy1 = new LinkedHashMap<>();
//
//
//        planbudowy1.put(24, 12);// spichlerz na 12
//        planbudowy1.put(26, 12);// gb na 12
//        planbudowy1.put(23, 7);// koszary na 7
//        planbudowy1.put(22, 7); // rynek na 7
//        planbudowy1.put(24, 14);// spichlerz na 14
//        planbudowy1.put(19, 14);// magazyn na 14


//        List<int[]> lista = new ArrayList<int[]>();
//        lista.add(new int[] { 24, 12 }); // spichlerz na 12
//        lista.add(new int[] { 26, 12 }); // gb na 12
//        lista.add(new int[] { 23, 7 });// koszary na 7
//        lista.add(new int[] { 22, 7 }); // rynek na 7
//        lista.add(new int[] { 24, 15 }); //spichlerz na 14
//        lista.add(new int[] { 19, 15 }); //magazyn na 14
//        List<String[]> listaPierwszej = new ArrayList<>();
//        List<String[]> listaDrugej = new ArrayList<>();
//        List<String[]> listaTrzeciej = new ArrayList<>();
//
//        listaTrzeciej.add(new String[]{"37", "1", "Warsztat Płatnerza", "military"});
//        listaTrzeciej.add(new String[]{"24", "3", "Rynek", "infra"});
//        listaTrzeciej.add(new String[]{"20", "10", "Magazyn", "infra"});
//        listaTrzeciej.add(new String[]{"21", "10", "Spichlerz", "infra"});
//        listaTrzeciej.add(new String[]{"19", "10", "Kryjówka", "infra"});
//        listaTrzeciej.add(new String[]{"27", "1", "Kryjówka", "infra"});
//        listaTrzeciej.add(new String[]{"28", "1", "Kryjówka", "infra"});
//        listaTrzeciej.add(new String[]{"27", "10", "Kryjówka", "infra"});
//        listaTrzeciej.add(new String[]{"24", "5", "Rynek", "infra"});
//        listaTrzeciej.add(new String[]{"36", "5", "Akademia", "military"});
//        listaTrzeciej.add(new String[]{"25", "10", "Rezydencja", "infra"});
//        listaTrzeciej.add(new String[]{"26", "13", "Główny budynek", "infra"});
//        listaTrzeciej.add(new String[]{"20", "13", "Magazyn", "infra"});
//        listaTrzeciej.add(new String[]{"21", "13", "Spichlerz", "infra"});
//
//        listaPierwszej.add(new String[]{"32", "5", "Cegielnia", "infra"});
//        listaPierwszej.add(new String[]{"34", "10", "Dwór bohatera", "infra"});
//        listaPierwszej.add(new String[]{"20", "16", "Magazyn", "infra"});
//        listaPierwszej.add(new String[]{"21", "17", "Spichlerz", "infra"});
//        listaPierwszej.add(new String[]{"20", "17", "Magazyn", "infra"});
//        listaPierwszej.add(new String[]{"21", "17", "Spichlerz", "infra"});
//        listaPierwszej.add(new String[]{"21", "18", "Spichlerz", "infra"});
//        listaPierwszej.add(new String[]{"20", "18", "Magazyn", "infra"});
//        listaPierwszej.add(new String[]{"21", "18", "Spichlerz", "infra"});
//
//
//        listaDrugej.add(new String[]{"27", "10", "Dwór bohatera", "infra"});
//        listaDrugej.add(new String[]{"30", "5", "Szpital", "infra"});
//        listaDrugej.add(new String[]{"24", "10", "Rynek", "infra"});
//        listaDrugej.add(new String[]{"26", "16", "Główny budynek", "infra"});
//        listaDrugej.add(new String[]{"20", "16", "Magazyn", "infra"});
//        listaDrugej.add(new String[]{"21", "16", "Spichlerz", "infra"});
//        listaDrugej.add(new String[]{"26", "17", "Główny budynek", "infra"});
//        listaDrugej.add(new String[]{"20", "17", "Magazyn", "infra"});
//        listaDrugej.add(new String[]{"21", "17", "Spichlerz", "infra"});
//        listaDrugej.add(new String[]{"26", "18", "Główny budynek", "infra"});
//        listaDrugej.add(new String[]{"20", "18", "Magazyn", "infra"});
//        listaDrugej.add(new String[]{"21", "18", "Spichlerz", "infra"});
//
//
////        listaTrzeciej.add(new String[]{"19", "1", "Kryjówka", "infra"});
////        listaTrzeciej.add(new String[]{"20", "1", "Magazyn", "infra"});
////        listaTrzeciej.add(new String[]{"21", "1", "Spichlerz", "infra"});
////        listaTrzeciej.add(new String[]{"26", "5", "Główny budynek", "infra"});
////        //listaTrzeciej.add(new String[]{"23", "1", "Koszary", "military"});
////        listaTrzeciej.add(new String[]{"20", "2", "Magazyn", "infra"});
////        listaTrzeciej.add(new String[]{"21", "2", "Spichlerz", "infra"});
////        listaTrzeciej.add(new String[]{"20", "3", "Magazyn", "infra"});
////        listaTrzeciej.add(new String[]{"21", "3", "Spichlerz", "infra"});
////        listaTrzeciej.add(new String[]{"19", "3", "Kryjówka", "infra"});
////        listaTrzeciej.add(new String[]{"24", "1", "Rynek", "infra"});
////        listaTrzeciej.add(new String[]{"26", "7", "Główny budynek", "infra"});
////        listaTrzeciej.add(new String[]{"20", "5", "Magazyn", "infra"});
////        listaTrzeciej.add(new String[]{"21", "5", "Spichlerz", "infra"});
////        listaTrzeciej.add(new String[]{"20", "7", "Magazyn", "infra"});
////        listaTrzeciej.add(new String[]{"21", "7", "Spichlerz", "infra"});
////        listaTrzeciej.add(new String[]{"23", "3", "Koszary", "military"});
////        listaTrzeciej.add(new String[]{"36", "1", "Akademia", "military"});
//
////
////
////        //listaPierwszej.add(new String[]{"29", "1", "Kryjówka", "infra"});
////        //listaTrzeciej.add(new String[]{"37", "5", "Warsztat Płatnerza", "military"});
//////        listaPierwszej.add(new String[]{"20", "8", "Magazyn", "infra"});
//////        listaPierwszej.add(new String[]{"21", "8", "Spichlerz", "infra"});
//////        listaPierwszej.add(new String[]{"36", "10", "Akademia", "military"});
//////        listaPierwszej.add(new String[]{"37", "3", "Warsztat Płatnerza", "military"});
//////        listaPierwszej.add(new String[]{"33", "5", "Stajnia", "military"});
//////        listaPierwszej.add(new String[]{"26", "10", "Główny budynek", "infra"});
//////        listaPierwszej.add(new String[]{"20", "12", "Magazyn", "infra"});
//////        listaPierwszej.add(new String[]{"21", "12", "Spichlerz", "infra"});
//////        listaPierwszej.add(new String[]{"25", "10", "Rezydencja", "infra"});
//////        listaPierwszej.add(new String[]{"38", "1", "Ratusz", "infra"});
//////        listaPierwszej.add(new String[]{"21", "12", "Spichlerz", "infra"});
//////        listaPierwszej.add(new String[]{"20", "12", "Magazyn", "infra"});
//////        listaPierwszej.add(new String[]{"26", "13", "Główny budynek", "infra"});
//////        listaPierwszej.add(new String[]{"21", "14", "Spichlerz", "infra"});
////
////
////        listaDrugej.add(new String[]{"29", "3", "Tartak", "resources"});
////        listaDrugej.add(new String[]{"32", "3", "Cegielnia", "resources"});
////        listaDrugej.add(new String[]{"33", "8", "Stajnia", "military"});
////        listaDrugej.add(new String[]{"29", "4", "Tartak", "resources"});
////        listaDrugej.add(new String[]{"24", "6", "Rynek", "infra"});
////        listaDrugej.add(new String[]{"20", "13", "Magazyn", "infra"});
////        listaDrugej.add(new String[]{"23", "5", "Koszary", "military"});
////        listaDrugej.add(new String[]{"31", "5", "Warsztat", "military"});
////        listaDrugej.add(new String[]{"20", "14", "Magazyn", "infra"});
////        listaDrugej.add(new String[]{"21", "16", "Spichlerz", "infra"});
////        listaDrugej.add(new String[]{"31", "10", "Warsztat", "military"});
////        listaDrugej.add(new String[]{"36", "15", "Akademia", "military"});
////        listaDrugej.add(new String[]{"22", "3", "Huta Stali", "resources"});
////        listaDrugej.add(new String[]{"26", "15", "Główny budynek", "infra"});
////        listaDrugej.add(new String[]{"20", "16", "Magazyn", "infra"});
////        listaDrugej.add(new String[]{"21", "17", "Spichlerz", "infra"});
////        listaDrugej.add(new String[]{"20", "18", "Magazyn", "infra"});
////        listaDrugej.add(new String[]{"21", "18", "Spichlerz", "infra"});
////
////        listaPierwszej.add(new String[]{"26", "15", "Główny budynek", "infra"});
////        listaPierwszej.add(new String[]{"20", "14", "Magazyn", "infra"});
////        listaPierwszej.add(new String[]{"21", "16", "Spichlerz", "infra"});
////        listaPierwszej.add(new String[]{"20", "16", "Magazyn", "infra"});
////        listaPierwszej.add(new String[]{"21", "17", "Spichlerz", "infra"});
////        listaPierwszej.add(new String[]{"20", "18", "Magazyn", "infra"});
////        listaPierwszej.add(new String[]{"21", "18", "Spichlerz", "infra"});
//
//
//        //  help.login("https://ts10.x1.international.travian.com/dorf1.php", "Majos", "qweasdzxc", driver);
//
////////        //1 osadka
//////
//        // help.trySendResources(driver, "https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&", 500, 500, 500, 0, "-86", "33");
//
//
//////
//        try {
//
//
//            help.login("https://ts10.x1.international.travian.com/dorf1.php", "Majos", "qweasdzxc", driver);
//
//            grabi("https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&", "https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&",
//                    "https://ts10.x1.international.travian.com/build.php?id=39&gid=16&tt=99", driver);
//
//
//            help.budujPierwszyRaz("https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&", "https://ts10.x1.international.travian.com/dorf2.php",
//                    "https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&", driver, listaPierwszej);
//
//            help.budujDomki("https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&",
//                    "https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&",
//                    driver);
////
//
////
//            help.budujWojo("https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&",
//                    "https://ts10.x1.international.travian.com/dorf2.php",
//                    "https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&",
//                    "https://ts10.x1.international.travian.com/build.php?id=33&gid=20",
//                    driver, "4", "3");
//////
//////
//////            help.budujWojo("https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&",
//////                    "https://ts10.x1.international.travian.com/dorf2.php",
//////                    "https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&",
//////                    "https://ts10.x1.international.travian.com/build.php?id=23&gid=19",
//////                    driver, "2", "1");
//////
//////
////        //2 osadka
////
////
////
////
////
//
//            help.budujWojo("https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&",
//                    "https://ts10.x1.international.travian.com/dorf2.php",
//                    "https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&",
//                    "https://ts10.x1.international.travian.com/build.php?id=33&gid=20",
//                    driver, "5", "2");
////
//            help.budujWojo("https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&",
//                    "https://ts10.x1.international.travian.com/dorf2.php",
//                    "https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&",
//                    "https://ts10.x1.international.travian.com/build.php?id=23&gid=19",
//                    driver, "3", "2");
//            try {
//                help.budujWojo("https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&",
//                        "https://ts10.x1.international.travian.com/dorf2.php",
//                        "https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&",
//                        "https://ts10.x1.international.travian.com/build.php?id=31&gid=21",
//                        driver, "8", "1");
//            } catch (Exception rwfwer) {
//
//            }
//
//            help.budujPierwszyRaz("https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&", "https://ts10.x1.international.travian.com/dorf2.php",
//                    "https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&", driver, listaDrugej);
//
//            help.budujDomki("https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&",
//                    "https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&",
//                    driver);
////
////
//////        //3 osada
//            help.budujDomki("https://ts10.x1.international.travian.com/dorf1.php?newdid=25296&",
//                    "https://ts10.x1.international.travian.com/dorf1.php?newdid=25296&",
//                    driver);
//
//
//            help.budujPierwszyRaz("https://ts10.x1.international.travian.com/dorf1.php?newdid=25296&", "https://ts10.x1.international.travian.com/dorf2.php",
//                    "https://ts10.x1.international.travian.com/dorf1.php?newdid=25296&", driver, listaTrzeciej);
//
//
//            help.requestResources(driver, "https://ts10.x1.international.travian.com/dorf1.php?newdid=25296&", "https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&");
////
//
////
//            try {
//                readerek.replace(driver);
//            } catch (Exception e) {
//
//            }
//
//        } catch (Exception costam) {
//            try {
//                File myObj2 = new File("filename2.txt");
//                if (myObj2.createNewFile()) {
//                    System.out.println("File created: " + myObj2.getName());
//                } else {
//                    System.out.println("File already exists.");
//                }
//
//                StringWriter sw = new StringWriter();
//                PrintWriter pw = new PrintWriter(sw);
//                costam.printStackTrace(pw);
//                String sStackTrace = sw.toString(); // stack trace as a string
//                System.out.println(sStackTrace);
//
//
//                costam.printStackTrace();
//                FileWriter fw = new FileWriter("filename.txt", true); //the true will append the new data
//                fw.write(sStackTrace);//appends the string to the file
//                fw.close();
//            } catch (IOException e) {
//                System.out.println("An error occurred.");
//                e.printStackTrace();
//            }
//
//
//        }
//
//
//        try {
//            File myObj2 = new File("filename2.txt");
//            if (myObj2.createNewFile()) {
//                System.out.println("File created: " + myObj2.getName());
//            } else {
//                System.out.println("File already exists.");
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//

//
//        help.budujWojo("https://ts10.x1.international.travian.com/dorf1.php",
//                "https://ts10.x1.international.travian.com/dorf2.php",
//                "https://ts10.x1.international.travian.com/dorf2.php",
//                "https://ts10.x1.international.travian.com/build.php?id=23&gid=19",
//                driver, "3", "1");


//


//
        //help.grabListeOaz(driver, listaOaz, "https://ts10.x1.international.travian.com/dorf1.php");
        //
        // help.grabiWithDedication(driver, "https://ts10.x1.international.travian.com/dorf2.php");
        //help.grabFarmy(driver, listaFarm, "https://ts10.x1.international.travian.com/dorf1.php");


        // help.grabOazyInteligentnie(driver, inteligentnaListaOaz, );


        //     help.grabiWithDedication(driver, "https://ts8.x1.europe.travian.com/dorf1.php?newdid=35928&");

        // help.grabiWithDedication(driver, "https://ts8.x1.europe.travian.com/dorf1.php?newdid=29990&");// to z machiny

        // grabi("https://ts8.x1.europe.travian.com/dorf1.php?newdid=29990&",
//                "https://ts8.x1.europe.travian.com/dorf1.php?newdid=29990&",
//                "https://ts8.x1.europe.travian.com/build.php?id=39&gid=16&tt=99", driver);

        //help.trySendMilitary(driver, "https://ts8.x1.europe.travian.com/dorf1.php?newdid=29990&");
////
        //help.trySendResources(driver, "https://ts8.x1.europe.travian.com/dorf1.php?newdid=29990&", 666, 666, 666,0 );
////
//
//
//
//        //2 osadka


        //budujWojo("https://ts8.x1.europe.travian.com/dorf1.php?newdid=35928&",
//                "https://ts8.x1.europe.travian.com/dorf2.php",
//                "https://ts8.x1.europe.travian.com/dorf1.php?newdid=35928&",
//                "https://ts8.x1.europe.travian.com/build.php?id=28&gid=20",
//                driver, "5", "1");

        //budujDomki("https://ts8.x1.europe.travian.com/dorf1.php?newdid=35928&",
//                "https://ts8.x1.europe.travian.com/dorf1.php?newdid=29990&",
//                driver);


        //1 osadka

//        help.savingProtocol("https://ts8.x1.europe.travian.com/dorf1.php?newdid=29990&",
//                "https://ts8.x1.europe.travian.com/dorf1.php?newdid=29990&",
//                "https://ts8.x1.europe.travian.com/build.php?id=36&gid=24", driver);

//        help.budujPierwszyRaz("https://ts8.x1.europe.travian.com/dorf1.php?newdid=29990&",
//                "https://ts8.x1.europe.travian.com/dorf2.php",
//                "https://ts8.x1.europe.travian.com/dorf1.php?newdid=29990&", driver, listaPierwszej);


//        budujWojo("https://ts8.x1.europe.travian.com/dorf1.php?newdid=29990&",
//                "https://ts8.x1.europe.travian.com/dorf2.php",
//                "https://ts8.x1.europe.travian.com/dorf1.php?newdid=29990&",
//                "https://ts8.x1.europe.travian.com/build.php?id=35&gid=20",
//                driver, "5", "1");

//        budujWojo("https://ts8.x1.europe.travian.com/dorf1.php?newdid=29990&",
//                "https://ts8.x1.europe.travian.com/dorf2.php",
//                "https://ts8.x1.europe.travian.com/dorf1.php?newdid=29990&",
//                "https://ts8.x1.europe.travian.com/build.php?id=23&gid=19",
//                driver, "1", "4");
        //driver.close();
    }

    public static void projektujWnetrze(String wejscie, String wyjscie, WebDriver driver, List<int[]> planbudowy) {
        driver.get(wejscie);
        int currentLevel;

        for (int i = 0; i < planbudowy.size(); i++) {

            WebElement element = driver.findElement(By.cssSelector("div[class^='buildingSlot a" + planbudowy.get(i)[0] + "']"));
            currentLevel = Integer.parseInt(element.findElement(By.cssSelector("div[class='labelLayer']")).getText());
            if (currentLevel < planbudowy.get(i)[1]) {

                try {
                    element.click();
                    WebElement kupa = driver.findElement(By.xpath("//button[contains(text(),'do poziomu')]"));
                    kupa.click();
                    break;
                } catch (Exception e) {
                    break;
                }
            }
        }

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
        Helpers.waiterek();
        driver.get(linkGrabi);
        Helpers.waiterek();
        for (int i = 0; i < 1; i++) {
            try {
                WebElement e;


//            //majpsikarnia
                e = driver.findElement(By.cssSelector("div[id=\"raidList1973\"]"));
                e.findElement(By.cssSelector("button[value=\"Wyślij\"]")).click();

                //piekarnia

                Thread.sleep(2000);
                e = driver.findElement(By.cssSelector("div[id=\"raidList1972\"]"));
                e.findElement(By.cssSelector("button[value=\"Wyślij\"]")).click();


                Thread.sleep(2000);
                e = driver.findElement(By.cssSelector("div[id=\"raidList2464\"]"));
                e.findElement(By.cssSelector("button[value=\"Wyślij\"]")).click();


            } catch (Exception e) {

            }
        }
        Helpers.waiterek();

        driver.get(osadaKoncowa);
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
            level = Integer.parseInt(value.substring(value.length() - 5).replaceAll("\\D+", ""));
            if (level < lowest) {
                lowest = level;
                childToclick = child;
            }
        }
//        if(lowest == 8){
//            for (WebElement child : childs) {
//                value = child.getAttribute("class");
//                level = Integer.parseInt(value.substring(value.length() - 1));
//                if (level == 9) {
//                    childToclick = child;
//                    break;
//                }
//                else{
//
//                }
//            }
//
//        }
        try {
            if (level != 10) {
                childToclick.click();
            }

        } catch (Exception e) {

        }
    }
}