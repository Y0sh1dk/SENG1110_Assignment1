import java.util.*;

//TODO: Make not case sensitive, strip white space


public class SongCollection
{
	private Album album1 = null, album2 = null, album3 = null;


	public void run() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			int option;
			System.out.println("\n1) List albums");
			System.out.println("2) Create album");
			System.out.println("3) Delete album");
			System.out.println("4) List songs from album");
			System.out.println("5) Add song to album");
			System.out.println("6) Delete song from album");
			System.out.println("7) List all songs whose duration is under a certain time");
			System.out.println("8) List all songs of a specific genre");
			System.out.println("9) Exit program\n");
			System.out.println("Please Select a Option:");
			option = scanner.nextInt();

			switch (option) {
				case 1:
					listAlbums(scanner);
					break;
				case 2:
					createAlbum(scanner);
					break;
				case 3:
					deleteAlbum(scanner);
					break;
				case 4:
					listSongsFromAlbum(scanner);
					break;
				case 5:
					addSongToAlbum(scanner);
					break;
				case 6:
					deleteSongFromAlbum(scanner);
					break;
				case 7:
					listSongsUnderTime(scanner);
					break;
				case 8:
					listSongsOfGenre(scanner);
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
		scanner.nextLine();
		albumName = scanner.nextLine().strip();
		if (album1 == null) {
			album1 = new Album(albumName);
			System.out.println("Success!");
		} else if (album2 == null) {
			album2 = new Album(albumName);
			System.out.println("Success!");
		} else if (album3 == null) {
			album3 = new Album(albumName);
			System.out.println("Success!");
		} else {
			System.out.println("Fail!");
		}
		returnToMenu(scanner);
	}


	private void addSongToAlbum(Scanner scanner) {
		String albumName;
		int songcode = 0, albumcode = 0;
		System.out.println("Please enter album name you would like to add a song too:");
		scanner.nextLine(); // to throw out '/n'
		albumName = scanner.nextLine().strip();
		if (album1 != null) {
			if (album1.getName().equals(albumName)) {
				System.out.println("Please enter song Name:");
				String songName = scanner.nextLine();
				System.out.println("Please enter song Artist:");
				String songArtist = scanner.nextLine();
				System.out.println("Please enter song Duration (in seconds):");
				int songDuration = scanner.nextInt();
				String songGenre = getValidGenre(scanner);
				songcode = album1.addSong(songName, songArtist, songDuration, songGenre);
				albumcode = 1;
			}
		} if (album2 != null) {
			if (album2.getName().equals(albumName)) {
				System.out.println("Please enter song Name:");
				String songName = scanner.nextLine();
				System.out.println("Please enter song Artist:");
				String songArtist = scanner.nextLine();
				System.out.println("Please enter song Duration (in seconds):");
				int songDuration = scanner.nextInt();
				String songGenre = getValidGenre(scanner);
				songcode = album2.addSong(songName, songArtist, songDuration, songGenre);
				albumcode = 1;
			}
		} if (album3 != null) {
			if (album3.getName().equals(albumName)) {
				System.out.println("Please enter song Name:");
				String songName = scanner.nextLine();
				System.out.println("Please enter song Artist:");
				String songArtist = scanner.nextLine();
				System.out.println("Please enter song Duration (in seconds):");
				int songDuration = scanner.nextInt();
				String songGenre = getValidGenre(scanner);
				songcode = album3.addSong(songName, songArtist, songDuration, songGenre);
				albumcode = 1;
			}
//			TODO: Test this madness
		} if (albumcode == 0) {
			System.out.println("No such album exists");
		} else if (songcode == 0) {
			System.out.println("Album already contains 4 songs");
		} else if (songcode == 1) {
			System.out.println("Success!");
		} else if (songcode == 2) {
			System.out.println("Adding this song will exceed the time limit of album");
		} else if (songcode == 3) {
			System.out.println("Song Already exists in album");
		}
		returnToMenu(scanner);
	}


	private String getValidGenre(Scanner scanner) {
		boolean valid = false;
		String genre = "";
		while (!valid) {
			System.out.println("Please enter song Genre:");
			scanner.nextLine(); // to throw out '/n'
			genre = scanner.nextLine();
			if (genre.equals("rock") || genre.equals("pop") || genre.equals("hip-hop") || genre.equals("bossa nova")) {
				valid = true;
			} else {
				System.out.println("Invalid Genre");
			}
		}
		return genre;
	}


	private void listSongsFromAlbum(Scanner scanner) {
		String albumName;
		System.out.println("Please Enter Album Name:");
		scanner.nextLine(); // to throw out '/n'
		albumName = scanner.nextLine().strip();
		if (album1 != null) {
			if (album1.getName().equals(albumName)) {
				System.out.println("Album1:\n" + album1.listAllSongs());
			}
		} if (album2 != null) {
			if (album2.getName().equals(albumName)) {
				System.out.println("Album2:\n" + album2.listAllSongs());
			}
		} if (album3 != null) {
			if (album3.getName().equals(albumName)) {
				System.out.println("Album3:\n" + album3.listAllSongs());
			}
		} else {
			System.out.println("No such Album!");
		}
		returnToMenu(scanner);
	}


	private void listAlbums(Scanner scanner) {
		scanner.nextLine(); // to throw out '/n'
		String albumList = "";
		if (album1 != null) {
			albumList += "Album1 Name: " + album1.getName() + "\n";
		}
		if (album2 != null) {
			albumList += "Album2 Name: " + album2.getName() + "\n";
		}
		if (album3 != null) {
			albumList += "Album3 Name: " + album3.getName() + "\n";
		}
		if (albumList.equals("")) {
			System.out.println("No albums have been created yet!");
		} else {
			System.out.println(albumList);
		}
		returnToMenu(scanner);
	}


	private void listSongsUnderTime(Scanner scanner) {
		int time;
		String songList = "";
		System.out.println("Please enter Time to find songs under");
		scanner.nextLine(); // to throw out '/n'
		time = scanner.nextInt();
		System.out.println("Songs under the time " + time + " seconds:");
		if (album1 != null) {
			songList += album1.listSongsUnderTime(time);
		}
		if (album2 != null) {
			songList += album2.listSongsUnderTime(time);
		}
		if (album3 != null) {
			songList += album3.listSongsUnderTime(time);
		}
		System.out.println(songList);
		returnToMenu(scanner);
	}


	private void listSongsOfGenre(Scanner scanner) {
		String genre;
		System.out.println("Please Enter Genre:");
		scanner.nextLine(); // to throw out '/n'
		genre = scanner.nextLine().strip();
		System.out.println("All songs of the genre" + genre + ":");
		String songsOfGenreList = "";
		if (album1 != null) {
			songsOfGenreList += "Album1:\n" + album1.songsOfGenre(genre) + "\n";
		}
		if (album2 != null) {
			songsOfGenreList += "Album2:\n" + album2.songsOfGenre(genre) + "\n";
		}
		if (album3 != null) {
			songsOfGenreList += "Album3:\n" + album3.songsOfGenre(genre) + "\n";
		}
		if (songsOfGenreList.equals("")) {
			System.out.println("None");
		} else {
			System.out.println(songsOfGenreList);
		}
		returnToMenu(scanner);
	}


	private void deleteAlbum(Scanner scanner) {
		int albumcode = 0;
		String albumName;
		System.out.println("Please enter album name to delete:");
		scanner.nextLine(); // to throw out '/n'
		albumName = scanner.nextLine().strip();
		if (album1 != null) {
			if (album1.getName().equals(albumName)) {
				album1 = null;
				albumcode = 1;
			}
		} if (album2 != null) {
			if (album2.getName().equals(albumName)) {
				album2 = null;
				albumcode = 1;
			}
		} if (album3 != null) {
			if (album3.getName().equals(albumName)) {
				album3 = null;
				albumcode = 1;
			}
		} if (albumcode == 1) {
			System.out.println("Success!");
		} else {
			System.out.println("No album with that name exists");
		}
		returnToMenu(scanner);
	}


	private void deleteSongFromAlbum(Scanner scanner) {
		int albumcode = 0, songcode = 0;
		String albumName;
		String songName;
		scanner.nextLine(); // to throw out '/n'
		System.out.println("Please Enter Album Name:");
		albumName = scanner.nextLine().strip();
		scanner.nextLine(); // to throw out '/n'
		System.out.println("Please enter Song Name");
		songName = scanner.nextLine().strip();
		if (album1 != null) {
			if (album1.getName().equals(albumName)) {
				albumcode = 1;
				songcode = album1.deleteSong(songName);
			}
		} if (album2 != null) {
			if (album2.getName().equals(albumName)) {
				albumcode = 1;
				songcode = album2.deleteSong(songName);
			}
		} if (album3 != null) {
			if (album3.getName().equals(albumName)) {
				albumcode = 1;
				songcode = album3.deleteSong(songName);
			}
		}
		if (albumcode == 1 && songcode == 1) {
			System.out.println("Success!");
		} else if (albumcode == 1 && songcode == 0) {
			System.out.println("Album Exists, but song does not exists in album");
		} else if (albumcode == 0) {
			System.out.println("Album does not exist");
		}
		returnToMenu(scanner);
	}

	private void returnToMenu(Scanner scanner) {
		System.out.println("\nPress \"ENTER\" Key to return to menu");
		scanner.nextLine();
	}




	public static void main(String[] args) {
		SongCollection sc = new SongCollection();
		sc.run();
	}
}

