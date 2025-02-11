package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileReaderek {

    Helpers helper = new Helpers();
    public static boolean zwiadFlag = true;
    public void replace(WebDriver driver) throws InterruptedException {

        boolean attackFlag = false;
        boolean bohflag = false;
        int oddzialy = 0;
        driver.get("https://ts10.x1.international.travian.com/dorf1.php?newdid=21478&");
        helper.waiterek();
        int max = 0;
        int max2 = 0;
        String wielkoscoddzialu = "70";
        File oldFile;
        File newFile;


        try {
            WebElement p = driver.findElement(By.xpath("//*[contains(text(), 'Equites imperatoris')]"));
            WebElement root = p.findElement(By.xpath("./.."));
            int equinumber = Integer.parseInt(root.findElement(By.cssSelector("td[class=\"num\"]")).getText());
            oddzialy = equinumber / Integer.parseInt(wielkoscoddzialu);
            if (oddzialy > 0) {
                attackFlag = true;
//                oddzialy = 1;//hehe
            }
        } catch (Exception sex) {

        }

        try {
            WebElement p = driver.findElement(By.xpath("//*[contains(text(), 'Bohater')]"));
            WebElement root = p.findElement(By.xpath("./.."));
            int equinumber = Integer.parseInt(root.findElement(By.cssSelector("td[class=\"num\"]")).getText());
            bohflag = true;
        } catch (Exception sex) {

        }

        //attackFlag = true;//debug
        String oldFileName = "notes";
        String tmpFileName = "notes_tmp";
        String[] myLine;


        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;
        Date date = new Date();
        Date datee = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH");


        try {
            br = new BufferedReader(new FileReader(oldFileName));
            bw = new BufferedWriter(new FileWriter(tmpFileName));
            while ((line = br.readLine()) != null) {
                myLine = line.split(",");
                if (myLine[1].equals("true") && attackFlag) {
                    //
                    if (oddzialy > 0 && bohflag && Integer.parseInt(myLine[5]) +2 > Integer.parseInt(String.valueOf(date.getDate()) + String.valueOf(sdf.format(datee))) ) {
                        myLine[3] = String.valueOf(helper.thinkIfWeShouldAttack(driver, myLine[0], myLine[2], true, wielkoscoddzialu));
                        if (Integer.parseInt(myLine[3]) > 3000) {
                        } else {
                            myLine[1] = "false";
                        }
                    }

                    if (oddzialy > 0 && Integer.parseInt(myLine[5]) +2 > Integer.parseInt(String.valueOf(date.getDate()) + String.valueOf(sdf.format(datee)))) {
                        myLine[4] = String.valueOf(helper.thinkIfWeShouldAttack(driver, myLine[0], myLine[2], false, wielkoscoddzialu));
                    }
                }
                line = String.join(",", myLine);
                bw.write(line + "\n");
            }


        } catch (Exception e) {
            return;
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                //
            }
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                //
            }
        }
        // Once everything is complete, delete old file..
        oldFile = new File(oldFileName);
        oldFile.delete();

        // And rename tmp file's name to old file name
        newFile = new File(tmpFileName);
        newFile.renameTo(oldFile);
        //atak
        for(int i =0 ; i<oddzialy; i ++)
        {

            if (attackFlag == true && oddzialy > 0) {

                try {
                    br = new BufferedReader(new FileReader(oldFileName));
                    bw = new BufferedWriter(new FileWriter(tmpFileName));

                    while ((line = br.readLine()) != null) {
                         myLine = line.split(",");

                        if (myLine[1].equals("true") && attackFlag && bohflag) {
                            if (Integer.parseInt(myLine[3]) > max) {
                                max = Integer.parseInt(myLine[3]);
                            }
                        }

                        if (myLine[1].equals("true") && attackFlag) {
                            if (Integer.parseInt(myLine[4]) > max2) {
                                max2 = Integer.parseInt(myLine[4]);
                            }
                        }

                        line = String.join(",", myLine);
                        bw.write(line + "\n");
                    }

                } catch (Exception e) {
                    return;
                } finally {
                    try {
                        if (br != null)
                            br.close();
                    } catch (IOException e) {
                        //
                    }
                    try {
                        if (bw != null)
                            bw.close();
                    } catch (IOException e) {
                        //
                    }
                }

                // Once everything is complete, delete old file..
                oldFile = new File(oldFileName);
                oldFile.delete();

                // And rename tmp file's name to old file name
                newFile = new File(tmpFileName);
                newFile.renameTo(oldFile);


                try {
                    br = new BufferedReader(new FileReader(oldFileName));
                    bw = new BufferedWriter(new FileWriter(tmpFileName));

                    while ((line = br.readLine()) != null) {

                         myLine = line.split(",");
                        // zajebisty kod, którego nie widać
                        if (Integer.parseInt(myLine[3]) == max && max > 2500 && attackFlag && bohflag && myLine[1].equals("true")) {
                            if (helper.toFarm3(driver, myLine[0], myLine[2], true, wielkoscoddzialu)) {
                                myLine[1] = "false";
                                myLine[5] = String.valueOf(Integer.parseInt(String.valueOf(date.getDate()) + String.valueOf(sdf.format(datee)))+8);
                                bohflag = false;
                            }
                        }

                        line = String.join(",", myLine);
                        bw.write(line + "\n");
                    }

                } catch (Exception e) {
                    return;
                } finally {
                    try {
                        if (br != null)
                            br.close();
                    } catch (IOException e) {
                        //
                    }
                    try {
                        if (bw != null)
                            bw.close();
                    } catch (IOException e) {
                        //
                    }
                }

                // Once everything is complete, delete old file..
                oldFile = new File(oldFileName);
                oldFile.delete();

                // And rename tmp file's name to old file name
                newFile = new File(tmpFileName);
                newFile.renameTo(oldFile);


                try {
                    br = new BufferedReader(new FileReader(oldFileName));
                    bw = new BufferedWriter(new FileWriter(tmpFileName));

                    while ((line = br.readLine()) != null) {
                        myLine = line.split(",");
                        if (Integer.parseInt(myLine[4]) == max2 && max2 > 2500 && attackFlag && myLine[1].equals("true")) {
                            if (helper.toFarm3(driver, myLine[0], myLine[2], false, wielkoscoddzialu)) {
                                myLine[1] = "false";
                                myLine[5] = String.valueOf(Integer.parseInt(String.valueOf(date.getDate()) + String.valueOf(sdf.format(datee)))+3);
                                max2 = 0;
                            }
                        }

                        line = String.join(",", myLine);
                        bw.write(line + "\n");
                    }

                } catch (Exception e) {
                    return;
                } finally {
                    try {
                        if (br != null)
                            br.close();
                    } catch (IOException e) {
                        //
                    }
                    try {
                        if (bw != null)
                            bw.close();
                    } catch (IOException e) {
                        //
                    }
                }

                // Once everything is complete, delete old file..
                oldFile = new File(oldFileName);
                oldFile.delete();

                // And rename tmp file's name to old file name
                newFile = new File(tmpFileName);
                newFile.renameTo(oldFile);
            }

        }//tu sie konczy for

//////zwiady
        try {
            br = new BufferedReader(new FileReader(oldFileName));
            bw = new BufferedWriter(new FileWriter(tmpFileName));

            driver.get("https://ts10.x1.international.travian.com/dorf1.php?newdid=23051&");
            while ((line = br.readLine()) != null) {
                myLine = line.split(",");

                if (zwiadFlag) {
                    if (Integer.parseInt(myLine[5]) + 3 < Integer.parseInt(String.valueOf(date.getDate()) + String.valueOf(sdf.format(datee)))) {
                        myLine[1] = String.valueOf(helper.toZwiad(driver, myLine[0], myLine[2], zwiadFlag));
                        if (myLine[1].equals("true")) {
                            myLine[5] = String.valueOf(date.getDate()) + String.valueOf(sdf.format(datee));
                        }
                    }
                }


                line = String.join(",", myLine);
                bw.write(line + "\n");
            }

        } catch (Exception e) {
            return;
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                //
            }
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                //
            }
        }

        // Once everything is complete, delete old file..
        oldFile = new File(oldFileName);
        oldFile.delete();

        // And rename tmp file's name to old file name
        newFile = new File(tmpFileName);
        newFile.renameTo(oldFile);

    }

    static void setZwiadTofalse() {
        zwiadFlag = false;
    }
}