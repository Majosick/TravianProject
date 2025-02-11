package com.company;

public class OazaObject {

    String link;
    boolean scanFlag;
    boolean renewalFlag;
    boolean attackFlag;

    public OazaObject(String link, boolean scanFlag, boolean renewalFlag, boolean attackFlag) {
        this.link = link;
        this.scanFlag = scanFlag;
        this.renewalFlag = renewalFlag;
        this.attackFlag = attackFlag;
    }
}
