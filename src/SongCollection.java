import java.util.*;

//TODO: Make not case sensitive, strip white space


public class SongCollection
{
	private Album album1 = null, album2 = null, album3 = null;


	public void run() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			int option;
			System.out.println("1) List albums");
			System.out.println("2) Create album");
			System.out.println("3) Delete album");
			System.out.println("4) List songs from album");
			System.out.println("5) Add song to album");
			System.out.println("6) Delete song from album");
			System.out.println("7) List all songs whose duration is under a certain time");
			System.out.println("8) List all songs of a specific genre");
			System.out.println("9) Exit program");

			System.out.println("Please Select a Option:");
			option = scanner.nextInt();

			switch (option) {
				case 1:
					System.out.println("You selected option 1");
					break;
				case 2:
					System.out.println("You selected option 2");
					break;
				case 3:
					System.out.println("You selected option 3");
					break;
				case 4:
					System.out.println("You selected option 4");
					break;
				case 5:
					System.out.println("You selected option 5");
					break;
				case 6:
					System.out.println("You selected option 6");
					break;
				case 7:
					System.out.println("You selected option 7");
					break;
				case 8:
					System.out.println("You selected option 8");
					break;
				case 9:
					System.out.println("Exiting Program...");
					System.exit(0);
					break;
			}
		}
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
		albumName = scanner.nextLine().strip();
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
		albumName = scanner.nextLine().strip();
		if (album1 != null) {
			if (album1.getName().equals(albumName)) {
				System.out.println(album1.listAllSongs());
			}
		} else if (album2 != null) {
			if (album2.getName().equals(albumName)) {
				System.out.println(album2.listAllSongs());
			}
		} else if (album3 != null) {
			if (album3.getName().equals(albumName)) {
				System.out.println(album3.listAllSongs());
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


	private void listSongsUnderTime(Scanner scanner) {
		int time;
		String songList = "";
		System.out.println("Please enter Time to find songs under");
		time = scanner.nextInt();
		if (album1 != null) {
			songList += album1.listSongsUnderTime(time);
		}
		if (album2 != null) {
			songList += album2.listSongsUnderTime(time);
		}
		if (album3 != null) {
			songList += album2.listSongsUnderTime(time);
		}
	}


	private void listSongsOfGenre(Scanner scanner) {
		String genre;
		System.out.println("Please Enter Genre:");
		genre = scanner.nextLine().strip();
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


	private void deleteAlbum(Scanner scanner) {
		String albumName;
		System.out.println("Please enter Album Name:");
		albumName = scanner.nextLine().strip();
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
		albumName = scanner.nextLine().strip();
		System.out.println("Please enter Song Name");
		songName = scanner.nextLine().strip();
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
		SongCollection sc = new SongCollection();
		sc.run();
	}
}

