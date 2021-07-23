public class MainQuit {
    public static void main(String[] args) {


        TestMetod testMetod = new TestMetod();
        testMetod.openSite();
        testMetod.singIn();
        testMetod.quit();
        testMetod.closeDriver();
    }

}