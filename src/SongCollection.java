import java.util.*;

public class SongCollection
{
	private Album album1, album2, album3;

	public void run(){
	}

	private void createAlbum() {

	}

	private void addSongtoAlbum() {

	}

	private void listSongsFromAlbum(String albumName) {


	}
//	TODO: test listAlbums()
	private void listAlbums() {
		String albumList = null;
		if (album1.getName() != null) {
			albumList += album1.getName();
		}
		if (album2.getName() != null) {
			albumList += album2.getName();
		}
		if (album3.getName() != null) {
			albumList += album3.getName();
		}
	}

	private void listSongsUnderTime(int maxtime) {

	}

	private void listSongsOfGenre(String genre) {

	}

	private void deleteAlbum(String albumName) {

	}

	private void deleteSongFromAlbum(String songName, String AlbumName) {

	}

	public static void main(String[] args) {
		SongCollection sg = new SongCollection();
		sg.run();
	}
}

