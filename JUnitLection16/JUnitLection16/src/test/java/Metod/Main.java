package Metod;

import Utils.Driver;

public class Main {
    public static void main(String[] args) {

        Metods metod = new Metods();
        Driver.getChromeDriver();
        metod.openSite();
        metod.singIn();
        RepitMetod.quitDriver();
        Driver.getChromeDriver();
        metod.openSite();
        metod.singIn();
        metod.addAdress();
        RepitMetod.quitDriver();
        Driver.getChromeDriver();
        metod.openSite();
        metod.singIn();
        metod.changeAdress();
        RepitMetod.quitDriver();
        Driver.getChromeDriver();
        metod.openSite();
        metod.singIn();
        metod.delAdress();
        RepitMetod.quitDriver();
        Driver.getChromeDriver();
        metod.openSite();
        metod.singIn();
        metod.quit();
        RepitMetod.quitDriver();

    }
}
