public class test {
    public static void main(String[] args) {
        Album album1, album2, album3;
        album1 = new Album();
        int a;


        a = album1.addSong("testsongname1","testartistname1",600,"Rock");
        if ( a == 1) {
            System.out.println("Sucess");
        } else {
            System.out.println("fail");
        }
        a = album1.addSong("testsongname2","testartistname2",50,"Rock2");
        if ( a == 1) {
            System.out.println("Sucess");
        } else {
            System.out.println("fail");
        }
        a = album1.addSong("testsongname3","testartistname3",50,"Rock2");
        if ( a == 1) {
            System.out.println("Sucess");
        } else {
            System.out.println("fail");
        }
        a = album1.addSong("testsongname4","testartistname4",50,"Rock2");
        if ( a == 1) {
            System.out.println("Sucess");
        } else {
            System.out.println("fail");
        }
        System.out.println(album1.listSongs());
    }
}
