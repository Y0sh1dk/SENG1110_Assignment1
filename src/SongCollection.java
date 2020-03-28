import java.util.*;

/**
 * Write a description of class Album here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SongCollection
{
	private Album album1, album2, album3;

	public void run(){
		Scanner console = new Scanner(System.in);
		String name = console.nextLine();
		Song s = new Song();
		s.setName("Garota de Ipanema");
		System.out.println("Name: " + s.getName());
	}
	public static void main(String[] args) {
		SongCollection sg = new SongCollection();
		sg.run();
	}
}

