/**
 * Write a description of class Song here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Song
{
	private String name;
	private String artist;
	private int duration;
	private String genre;
	
	//add comments
	public void setName(String inputName) {
		 name = inputName;
	}

	public String getName() {
		return name;
	}

	public void setArtist (String inputArtist) {
		artist = inputArtist;
	}

	public String getArtist() {
		return artist;
	}

	public void setDuration(int inputDuration) {
		duration = inputDuration;
	}

	public int getDuration() {
		return duration;
	}

	public void setGenre(String inputGenre) {
		genre = inputGenre;
	}

	public String getGenre() {
		return genre;
	}

	//add other methods
}
