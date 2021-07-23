public class MainEditAdres {
    public static void main(String[] args) {
        TestMetod testMetod = new TestMetod();

        testMetod.openSite();
        testMetod.singIn();
        testMetod.changeAdress();
        testMetod.closeDriver();
    }
}
