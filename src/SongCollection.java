import java.util.*;



//TODO: Make not case sensitive, strip white space



public class SongCollection
{
	private Album album1, album2, album3;


	public void run(){
		Scanner scanner = new Scanner(System.in);
//		TODO: Create user interface
	}





	private void createAlbum(Scanner scanner) {
		String albumName;
		System.out.println("Please enter a Album name:");
		albumName = scanner.nextLine().strip();
		if (album1 != null) {
			album1 = new Album(albumName);
		} else if (album2 != null) {
			album2 = new Album(albumName);
		} else if (album3 != null) {
			album3 = new Album(albumName);
		} else {
			System.out.println("Fail!");
		}
	}

	private void addSongToAlbum(Scanner scanner) {
		String albumName;
		int code = 0;
		System.out.println("Please enter album name you would like to add a song too:");
		albumName = scanner.nextLine();
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
				code = album1.addSong(songName, songArtist, songDuration, songGenre);
			} else {
				code = 2;
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
				code = album2.addSong(songName, songArtist, songDuration, songGenre);
			} else {
				code = 2;
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
				code = album3.addSong(songName, songArtist, songDuration, songGenre);
			} else {
				code = 2;
			}
		} if (code == 1) {
			System.out.println("Success!");
		} else if (code == 2) {
			System.out.println("No Such album Name");
		} else {
			System.out.println("Fail!");
		}
	}


	private void listSongsFromAlbum(Scanner scanner) {
		String albumName;
		System.out.println("Please Enter Album Name:");
		albumName = scanner.nextLine();
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
		} else {
			System.out.println("No such Album!");
		}
	}

//	TODO: test listAlbums()
	private void listAlbums() {
		String albumList = "";
		if (album1 != null) {
			albumList += "Album1 Name:" + album1.getName() + "\n";
		}
		if (album2 != null) {
			albumList += "Album2 Name:" + album2.getName() + "\n";
		}
		if (album3 != null) {
			albumList += "Album3 Name:" + album3.getName() + "\n";
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


	private void deleteSongFromAlbum(Scanner scanner) {
		int code = 0;
		String albumName;
		String songName;
		System.out.println("Please Enter Album Name:");
		albumName = scanner.nextLine();
		System.out.println("Please enter Song Name");
		songName = scanner.nextLine();
		if (album1 != null) {
			if (album1.getName().equals(albumName)) {
				code = album1.deleteSong(songName);
			}
		} else if (album2 != null) {
			if (album2.getName().equals(albumName)) {
				code = album2.deleteSong(songName);
			}
		} else if (album3 != null) {
			if (album3.getName().equals(albumName)) {
				code = album3.deleteSong(songName);
			}
		}
		if (code == 1) {
			System.out.println("Success!");
		} else {
			System.out.println("Fail!");
		}
	}



	public static void main(String[] args) {
		SongCollection sg = new SongCollection();
		sg.run();
	}
}

