import java.util.*;

public class SongCollection
{
	private Album album1, album2, album3;

	public void run(){

	}

	private void createAlbum(String albumName) {
		if (album1 != null) {
			album1 = new Album(albumName);
		} else if (album2 != null) {
			album2 = new Album(albumName);
		} else if (album3 != null) {
			album3 = new Album(albumName);
		}
	}

	private void addSongtoAlbum(String albumName) {
		if (album1 != null) {
			if (album1.getName().equals(albumName)) {
//				TODO: Add Song
			}
		} else if (album2 != null) {
			if (album2.getName().equals(albumName)) {
//				TODO: Add Song
			}
		} else if (album3 != null) {
			if (album3.getName().equals(albumName)) {
//				TODO: Add Song
			}
		}

	}

	private void listSongsFromAlbum(String albumName) {
		if (album1 != null) {
			if (album1.getName().equals(albumName)) {
				System.out.println(album1.listSongs());
			}
		} else if (album2 != null) {
			if (album2.getName().equals(albumName)) {
				System.out.println(album2.listSongs());
			}
		} else if (album3 != null) {
			if (album3.getName().equals(albumName)) {
				System.out.println(album3.listSongs());
			}
		}
	}

//	TODO: test listAlbums()
	private void listAlbums() {
		String albumList = null;
		if (album1 != null) {
			albumList += album1.getName() + "\n";
		}
		if (album2 != null) {
			albumList += album2.getName() + "\n";
		}
		if (album3 != null) {
			albumList += album3.getName() + "\n";
		}
		System.out.println(albumList);
	}

	private void listSongsUnderTime(int maxtime) {

	}

	private void listSongsOfGenre(String genre) {

	}

	private void deleteAlbum(String albumName) {
		if (album1 != null) {
			if (album1.getName().equals(albumName)) {
				album1 = null;
			}
		} else if (album2 != null) {
			if (album2.getName().equals(albumName)) {
				album2 = null;
			}
		} else if (album3 != null) {
			if (album3.getName().equals(albumName)) {
				album3 = null;
			}
		}

	}

	private void deleteSongFromAlbum(String songName, String AlbumName) {

	}

	public static void main(String[] args) {
		SongCollection sg = new SongCollection();
		sg.run();
	}
}

