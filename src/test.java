public class test {
    public static void main(String[] args) {
        Song testsong = new Song("test","test",5,"test");
        Song testsong2 = new Song();
        System.out.println(testsong.getDuration());
        System.out.println(testsong2.getDuration());
    }
}
