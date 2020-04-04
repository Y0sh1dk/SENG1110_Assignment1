import java.util.Scanner;

public class test {


    public static String getValidGenre(Scanner scanner) {
        boolean valid = false;
        String genre = "";
        while (!valid) {
            System.out.println("Please enter song Genre:");
            genre = scanner.nextLine();
            if (genre.equals("rock") || genre.equals("pop") || genre.equals("hip-hop") || genre.equals("bossa nova")) {
                valid = true;
            } else {
                System.out.println("Invalid Genre");
            }
        }
        return genre;
    }


    public static void main(String[] args) {
        Album album1, album2, album3;
        album1 = new Album();
        int a;

        Scanner scanner = new Scanner(System.in);

        String str = getValidGenre(scanner);
        System.out.println(str);

    }




}
