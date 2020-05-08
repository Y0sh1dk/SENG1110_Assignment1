/**
 * Class: SongCollection
 * Class that holds main program loop and allows for users to interact with Album and Song class's through a TIO
 *
 * @author Yosiah de Koeyer
 * @Student_Number c3329520
 * @Last_Edit 08/05/2020
 */

import java.util.*;

public class SongCollection
{
	private Album album1 = null, album2 = null, album3 = null;


	private void run() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			int option = 0;
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
			try {
				option = scanner.nextInt();
			} catch (Exception InputMismatchException){
				System.out.println("Did not Provide a integer");
			}

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
				default:
					break;
			}
		}
	}

	/** Method: listAlbums()
	 *
	 * Lists all current albums
	 *
	 * @param scanner scanner object
	 */
	private void listAlbums(Scanner scanner) {
		scanner.nextLine(); // to throw out '/n'
		String albumList = "";
		if (album1 != null) {
			albumList += "Album1 Name: " + album1.getName() + "\n"; // get album name
			albumList += album1.listAllSongs(false);
		}
		if (album2 != null) {
			albumList += "Album2 Name: " + album2.getName() + "\n"; // get album name
			albumList += album2.listAllSongs(false);
		}
		if (album3 != null) {
			albumList += "Album3 Name: " + album3.getName() + "\n"; // get album name
			albumList += album3.listAllSongs(false);
		}
		if (albumList.equals("")) {
			System.out.println("No albums have been created yet!");
		} else {
			System.out.println(albumList);
		}
		returnToMenu(scanner);
	}

	/** Method: createAlbum()
	 *
	 * Creates an album as specified by the user
	 *
	 * @param scanner scanner object
	 */
	private void createAlbum(Scanner scanner) {
		if (checkAlbums() != 0 ) {
			String albumName;
			System.out.println("Please enter a Album name:");
			scanner.nextLine();
			albumName = scanner.nextLine().strip();
			if (!doesAlbumExist(albumName)) {
				if (album1 == null) {
					album1 = new Album(albumName);
					System.out.println("Success!");
				} else if (album2 == null) {
					album2 = new Album(albumName);
					System.out.println("Success!");
				} else if (album3 == null) {
					album3 = new Album(albumName);
					System.out.println("Success!");
				}
			} else {
				System.out.println("An album with that name already exists!");
			}
		} else {
			System.out.println("Max number of albums reached! (Max 3)");
			scanner.nextLine();
		}
		returnToMenu(scanner);
	}

	/** Method: deleteAlbum()
	 *
	 * Deletes a album specified by the user
	 *
	 * @param scanner scanner object
	 */
	private void deleteAlbum(Scanner scanner) {
		if (checkAlbums() != 1 ) { // No albums left to delete
			int albumcode = 0;
			String albumName;
			System.out.println("Please enter album name to delete:");
			scanner.nextLine(); // to throw out '/n'
			albumName = scanner.nextLine().strip();
			if (album1 != null) {
				if (album1.getName().equalsIgnoreCase(albumName)) {
					album1 = null;
					albumcode = 1;
				}
			}
			if (album2 != null) {
				if (album2.getName().equalsIgnoreCase(albumName)) {
					album2 = null;
					albumcode = 1;
				}
			}
			if (album3 != null) {
				if (album3.getName().equalsIgnoreCase(albumName)) {
					album3 = null;
					albumcode = 1;
				}
			}
			if (albumcode == 1) {
				System.out.println("Success!");
			} else {
				System.out.println("No album with that name exists");
			}
		} else {
			System.out.println("There are currently no albums created!");
			scanner.nextLine();
		}
		returnToMenu(scanner);
	}

	/** Method: listSongsFromAlbum()
	 *
	 * Lists all songs from a Album
	 *
	 * @param scanner scanner object
	 */
	private void listSongsFromAlbum(Scanner scanner) {
		String albumName;
		System.out.println("Please Enter Album Name:");
		scanner.nextLine(); // to throw out '/n'
		albumName = scanner.nextLine().strip();
		if (doesAlbumExist(albumName)) {
			if (album1 != null) {
				if (album1.getName().equalsIgnoreCase(albumName)) {
					if (album1.listAllSongs(true).equals("")) {
						System.out.println("Album1: " + album1.getName() + "\nEmpty!");
					} else {
						System.out.println("Album1: " + album1.getName() + "\n" + album1.listAllSongs(true));
					}
				}
			}
			if (album2 != null) {
				if (album2.getName().equalsIgnoreCase(albumName)) {
					if (album2.listAllSongs(true).equals("")) {
						System.out.println("Album1: " + album2.getName() + "\nEmpty!");
					} else {
						System.out.println("Album1: " + album2.getName() + "\n" + album2.listAllSongs(true));
					}
				}
			}
			if (album3 != null) {
				if (album3.getName().equalsIgnoreCase(albumName)) {
					if (album3.listAllSongs(true).equals("")) {
						System.out.println("Album1: " + album3.getName() + "\nEmpty!");
					} else {
						System.out.println("Album1: " + album3.getName() + "\n" + album3.listAllSongs(true));
					}
				}
			}
		} else {
			System.out.println("No such Album!");
		}
		returnToMenu(scanner);
	}

	/** Method: addSongToAlbum()
	 *
	 * Adds a song specified by the user to a pre existing album
	 *
	 * @param scanner scanner object
	 */
	private void addSongToAlbum(Scanner scanner) {
		if (checkAlbums() != 1 ) {
			String albumName;
			int songcode = 0, albumcode = 0;
			System.out.println("Please enter album name you would like to add a song too:");
			scanner.nextLine(); // to throw out '/n'
			albumName = scanner.nextLine().strip();
			if (album1 != null) {
				if (album1.getName().equalsIgnoreCase(albumName)) {
					if (album1.howManySongs() != 4) {
						System.out.println("Please enter song Name:");
						String songName = scanner.nextLine();
						System.out.println("Please enter song Artist:");
						String songArtist = scanner.nextLine();
						System.out.println("Please enter song Duration (in seconds):");
						int songDuration = scanner.nextInt();
						String songGenre = getValidGenre(scanner);
						songcode = album1.addSong(songName, songArtist, songDuration, songGenre);
						albumcode = 1;
					} else {
						albumcode = 2;
					}
				}
			}
			if (album2 != null) {
				if (album2.getName().equalsIgnoreCase(albumName)) {
					if (album2.howManySongs() != 4) {
						System.out.println("Please enter song Name:");
						String songName = scanner.nextLine();
						System.out.println("Please enter song Artist:");
						String songArtist = scanner.nextLine();
						System.out.println("Please enter song Duration (in seconds):");
						int songDuration = scanner.nextInt();
						String songGenre = getValidGenre(scanner);
						songcode = album2.addSong(songName, songArtist, songDuration, songGenre);
						albumcode = 1;
					} else {
						albumcode = 2;
					}
				}
			}
			if (album3 != null) {
				if (album3.getName().equalsIgnoreCase(albumName)) {
					if (album3.howManySongs() != 4) {
						System.out.println("Please enter song Name:");
						String songName = scanner.nextLine();
						System.out.println("Please enter song Artist:");
						String songArtist = scanner.nextLine();
						System.out.println("Please enter song Duration (in seconds):");
						int songDuration = scanner.nextInt();
						String songGenre = getValidGenre(scanner);
						songcode = album3.addSong(songName, songArtist, songDuration, songGenre);
						albumcode = 1;
					} else {
						albumcode = 2;
					}
				}
			}
			if (albumcode == 0) {
				System.out.println("No such album exists");
			} else if (albumcode == 2) {
				System.out.println("Album currently contains the maximum number of songs (Max 4)");
			} else if (songcode == 0) {
				System.out.println("Album already contains 4 songs");
			} else if (songcode == 1) {
				System.out.println("Success!");
			} else if (songcode == 2) {
				System.out.println("Adding this song will exceed the time limit of album");
			} else if (songcode == 3) {
				System.out.println("That Song Already exists in album");
			}
		} else {
			System.out.println("No albums have been created yet!");
			scanner.nextLine(); // to throw out '/n'
		}
		returnToMenu(scanner);
	}

	/** Method: deleteSongFromAlbum()
	 *
	 * deletes a song specified by the user from a album
	 *
	 * @param scanner scanner object
	 */
	private void deleteSongFromAlbum(Scanner scanner) {
		if (checkAlbums() != 1 ) {
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
				if (album1.getName().equalsIgnoreCase(albumName)) {
					albumcode = 1;
					songcode = album1.deleteSong(songName);
				}
			}
			if (album2 != null) {
				if (album2.getName().equalsIgnoreCase(albumName)) {
					albumcode = 1;
					songcode = album2.deleteSong(songName);
				}
			}
			if (album3 != null) {
				if (album3.getName().equalsIgnoreCase(albumName)) {
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
		} else {
			System.out.println("No albums have been created yet!");
			scanner.nextLine(); // to throw out '/n'
		}
		returnToMenu(scanner);
	}

	/** Method: listSongsOfGenre()
	 *
	 * Lists all songs under a time specified by the user
	 *
	 * @param scanner scanner object
	 */
	private void listSongsUnderTime(Scanner scanner) {
		if (checkAlbums() != 1 ) {
			int time;
			String songList = "";
			System.out.println("Please enter Time to find songs under");
			scanner.nextLine(); // to throw out '/n'
			time = scanner.nextInt();
			scanner.nextLine(); // to throw out '/n'
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
			if (songList.equals("")) {
				System.out.println("None");
			} else {
				System.out.println(songList);
			}
		} else {
			System.out.println("No albums have been created yet!");
			scanner.nextLine(); // to throw out '/n'
		}
		returnToMenu(scanner);
	}

	/** Method: listSongsOfGenre()
	 *
	 * Lists all songs of a genre specified by the user
	 *
	 * @param scanner scanner object
	 */
	private void listSongsOfGenre(Scanner scanner) {
		if (checkAlbums() != 1 ) {
			String genre;
			System.out.println("Please Enter Genre:");
			scanner.nextLine(); // to throw out '/n'
			genre = scanner.nextLine().strip();
			System.out.println("All songs of the genre " + genre + ":");
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
		} else {
			System.out.println("No albums have been created yet!");
			scanner.nextLine(); // to throw out '/n'
		}
		returnToMenu(scanner);
	}

	/** Method: addSong()
	 *
	 * Gets a valid genre from the user, valid genres are "rock", "pop", "hip-hop" and "bossa nova"
	 *
	 * @param scanner scanner object
	 */
	private String getValidGenre(Scanner scanner) {
		boolean valid = false;
		String genre = "";
		scanner.nextLine(); // to throw out '/n'
		while (!valid) {
			System.out.println("Please enter song Genre:");
			genre = scanner.nextLine();
			if (genre.equalsIgnoreCase("rock") || genre.equalsIgnoreCase("pop") || genre.equalsIgnoreCase("hip-hop") || genre.equalsIgnoreCase("bossa nova")) {
				valid = true;
			} else {
				System.out.println("Invalid Genre");
			}
		}
		return genre;
	}

	/** Method: doesAlbumExist()
	 *
	 * @param albumName String containing name of album
	 * @return Boolean, true if album exists, false if doesnt exist
	 */
	private boolean doesAlbumExist(String albumName) {
		if (album1 != null) {
			if (album1.getName().equalsIgnoreCase(albumName)) {
				return true;
			}
		} if (album2 != null) {
			if (album2.getName().equalsIgnoreCase(albumName)) {
				return true;
			}
		} if (album3 != null) {
			if (album3.getName().equalsIgnoreCase(albumName)) {
				return true;
			}
		}
		return false;
	}

	/** Method: checkAlbums()
	 *
	 * Checks if all albums have been created, non have been created or in the middle
	 *
	 * @return Int, 0 if all created, 1 if non created, 2 if in the middle
	 */
	private int checkAlbums() {
		if (album1 != null && album2 != null && album3 != null) {
			// were full boys
			return  0;
		} if (album1 == null && album2 == null && album3 == null) {
			// were empty boys
			return 1;
		} else { // not empty, not full
			return 2;
		}
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

