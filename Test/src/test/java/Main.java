

public class Main {
    public static void main(String[] args) {
        TestMetod addAdress = new TestMetod();

        addAdress.openSite();
        addAdress.singIn();
        addAdress.addAdress();
        addAdress.closeDriver();


        TestMetod changeAdress = new TestMetod();
        changeAdress.openSite();
        changeAdress.singIn();
        changeAdress.changeAdress();
        changeAdress.closeDriver();

        TestMetod delAdress = new TestMetod();
        delAdress.openSite();
        delAdress.singIn();
        delAdress.delAdress();
        delAdress.closeDriver();

        TestMetod quit = new TestMetod();
        // testMetod.startDriver();
        quit.openSite();
        quit.singIn();
        quit.quit();
        quit.closeDriver();
    }

}


