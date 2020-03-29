import java.util.*;

public class SongCollection
{
	private Album album1, album2, album3;




	public void run(){
		Scanner scanner = new Scanner(System.in);
		addSongToAlbum("test");
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

	private void addSongToAlbum(String albumName) {
		Scanner scanner = new Scanner(System.in);
		if (album1 != null) {
			if (album1.getName().equals(albumName)) {
				System.out.println("Please enter song Name:");
				String songName = scanner.nextLine();
				System.out.println("Please enter song Artist:");
				String songArtist = scanner.nextLine();
				System.out.println("Please enter song Duration:");
				int songDuration = scanner.nextInt();
				System.out.println("Please enter song Genre:");
				String songGenre = scanner.nextLine();
				album1.addSong(songName, songArtist, songDuration, songGenre);
			}
		} else if (album2 != null) {
			if (album2.getName().equals(albumName)) {
				System.out.println("Please enter song Name:");
				String songName = scanner.nextLine();
				System.out.println("Please enter song Artist:");
				String songArtist = scanner.nextLine();
				System.out.println("Please enter song Duration:");
				int songDuration = scanner.nextInt();
				System.out.println("Please enter song Genre:");
				String songGenre = scanner.nextLine();
				album2.addSong(songName, songArtist, songDuration, songGenre);
			}
		} else if (album3 != null) {
			if (album3.getName().equals(albumName)) {
				System.out.println("Please enter song Name:");
				String songName = scanner.nextLine();
				System.out.println("Please enter song Artist:");
				String songArtist = scanner.nextLine();
				System.out.println("Please enter song Duration:");
				int songDuration = scanner.nextInt();
				System.out.println("Please enter song Genre:");
				String songGenre = scanner.nextLine();
				album3.addSong(songName, songArtist, songDuration, songGenre);
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
		String albumList = "";
		if (album1 != null) {
			albumList += "Album1:" + album1.getName() + "\n";
		}
		if (album2 != null) {
			albumList += "Album2:" + album2.getName() + "\n";
		}
		if (album3 != null) {
			albumList += "Album3:" + album3.getName() + "\n";
		}
		System.out.println(albumList);
	}


	private void listSongsUnderTime(int maxtime) {

	}


	private void listSongsOfGenre(String genre) {
		String songsOfGenreList = "";
		if (album1 != null) {
			songsOfGenreList += album1.songsOfGenre(genre);
		}
		if (album2 != null) {
			songsOfGenreList += album2.songsOfGenre(genre);
		}
		if (album3 != null) {
			songsOfGenreList += album3.songsOfGenre(genre);
		}
		System.out.println(songsOfGenreList);
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

