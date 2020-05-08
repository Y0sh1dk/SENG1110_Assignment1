/**
 * Class: Album
 * A Class used to represent a Album. Is used to store instances of the Song class and provide all functionality
 * relating to a album.
 *
 * @author Yosiah de Koeyer
 * @Student_Number c3329520
 */

public class Album {

    private String name;
    private Song song1 = null , song2 = null, song3 = null, song4 = null;
    private boolean isFull = false;
    private int totalTime = 0;
    private final int MAX_TIME = 720; //12 minutes


    //  Constructor if args given
    public Album(String inputName) {
        this.name = inputName;

    }

    //  Constructor if no args given
    public Album() {
        this.name = null;
//        song1 = new Song();
//        song2 = new Song();
//        song3 = new Song();
//        song4 = new Song();
    }


    public void setName(String inputName) {
        this.name = inputName;
    }

    public String getName() {
        return this.name;
    }

    //    TODO: test listSongs method
    public String listAllSongs(boolean details) {
        String songList = "";
        if (details == true) {
            if (song1 != null) {
                songList += "\tSong1:" + "\n\tName:" + song1.getName() + "\n\tArtist:" + song1.getArtist() + "\n\tDuration:" + song1.getDuration() + "\n\tGenre:" + song1.getGenre() + "\n\n";
            }
            if (song2 != null) {
                songList += "\tSong2:" + "\n\tName:" + song2.getName() + "\n\tArtist:" + song2.getArtist() + "\n\tDuration:" + song2.getDuration() + "\n\tGenre:" + song2.getGenre() + "\n\n";
            }
            if (song3 != null) {
                songList += "\tSong3:" + "\n\tName:" + song3.getName() + "\n\tArtist:" + song3.getArtist() + "\n\tDuration:" + song3.getDuration() + "\n\tGenre:" + song3.getGenre() + "\n\n";
            }
            if (song4 != null) {
                songList += "\tSong4:" + "\n\tName:" + song4.getName() + "\n\tArtist:" + song4.getArtist() + "\n\tDuration:" + song4.getDuration() + "\n\tGenre:" + song4.getGenre() + "\n\n";
            }
        }
        else { // If details == false
            if (song1 != null) {
                songList += "\tSong1:" + "\n\tName:" + song1.getName() + "\n\tArtist:" + song1.getArtist() + "\n\n";
            }
            if (song2 != null) {
                songList += "\tSong2:" + "\n\tName:" + song2.getName() + "\n\tArtist:" + song1.getArtist() + "\n\n";
            }
            if (song3 != null) {
                songList += "\tSong3:" + "\n\tName:" + song3.getName() + "\n\tArtist:" + song3.getArtist() + "\n\n";
            }
            if (song4 != null) {
                songList += "\tSong4:" + "\n\tName:" + song4.getName() + "\n\tArtist:" + song4.getArtist() + "\n\n";
            }
        }
        return songList;
    }


    public String listSongsUnderTime(int timeMax) {
        String songList = "";
        if (this.song1 != null) {
            if (this.song1.getDuration() <= timeMax) {
                songList += this.song1.getArtist() + " - " + this.song1.getName() + "\n";
            }
        }
        if (this.song2 != null) {
            if (this.song2.getDuration() <= timeMax) {
                songList += this.song2.getArtist() + " - " + this.song2.getName() + "\n";
            }
        }
        if (this.song3 != null) {
            if (this.song3.getDuration() <= timeMax) {
                songList += this.song3.getArtist() + " - " + this.song3.getName() + "\n";
            }
        }
        return  songList;
    }


    public int deleteSong(String songName) {
        if (this.song1 != null) {
            if (this.song1.getName().equalsIgnoreCase(songName)) {
                this.song1 = null;
                return 1;
            }
        } if (this.song2 != null) {
            if (this.song2.getName().equalsIgnoreCase(songName)) {
                this.song2 = null;
                return 1;
            }
        } if (this.song3 != null) {
            if (this.song3.getName().equalsIgnoreCase(songName)) {
                this.song3 = null;
                return 1;
            }
        }
        return 0;
    }


    //    Adds song to Album, Will try song1 first, then song2, song3...
//    Return 1 if successful, return 0 if unsucessful
    public int addSong(String inputName, String inputArtist, int inputDuration, String inputGenre) {
        if (!this.doesSongExist(inputName, inputArtist, inputDuration)) { // if song doesnt exist, continue
            this.calculateTotalTime();
            if (this.totalTime + inputDuration <= this.MAX_TIME) {
                if (this.song1 == null) {
                    this.song1 = new Song(inputName, inputArtist, inputDuration, inputGenre);
                    this.calculateTotalTime();
                    return 1;
                } else if (this.song2 == null) {
                    this.song2 = new Song(inputName, inputArtist, inputDuration, inputGenre);
                    this.calculateTotalTime();
                    return 1;
                } else if (this.song3 == null) {
                    this.song3 = new Song(inputName, inputArtist, inputDuration, inputGenre);
                    this.calculateTotalTime();
                    return 1;
                } else if (this.song4 == null) {
                    this.song4 = new Song(inputName, inputArtist, inputDuration, inputGenre);
                    this.calculateTotalTime();
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 2;
            }
        } else {
            return 3;
        }
    }

    //    Calculate total runtime of all songs
    private void calculateTotalTime() {
        this.totalTime = 0;
        int time = 0;
        if (this.song1 != null) {
            time += this.song1.getDuration();
        }
        if (this.song2 != null) {
            time += this.song2.getDuration();
        }
        if (this.song3 != null) {
            time += this.song3.getDuration();
        }
        if (this.song4 != null) {
            time += this.song4.getDuration();
        }
        this.totalTime = time;
    }

//  Returns true of song of same name, artist and duration exists, else returns false
    private boolean doesSongExist(String inputName, String inputArtist, int inputDuration) {
        if (this.song1 != null) {
            if (this.song1.getName().equalsIgnoreCase(inputName) && this.song1.getArtist().equalsIgnoreCase(inputArtist) && this.song1.getDuration() == inputDuration) {
                return true;
            }
        } if (this.song2 != null) {
            if (this.song2.getName().equalsIgnoreCase(inputName) && this.song2.getArtist().equalsIgnoreCase(inputArtist) && this.song2.getDuration() == inputDuration) {
                return true;
            }
        } if (this.song3 != null) {
            if (this.song3.getName().equalsIgnoreCase(inputName) && this.song3.getArtist().equalsIgnoreCase(inputArtist) && this.song3.getDuration() == inputDuration) {
                return true;
            }
        } if (this.song4 != null) {
            if (this.song4.getName().equalsIgnoreCase(inputName) && this.song4.getArtist().equalsIgnoreCase(inputArtist) && this.song4.getDuration() == inputDuration) {
                return true;
            }
        }
        return false;
    }


    //    Returns songs of certain genre
    public String songsOfGenre(String inputgenre) {
        String songOfGenreList = "";
        if (this.song1 != null) {
            if (this.song1.getGenre().equalsIgnoreCase(inputgenre)) {
                songOfGenreList += "Song1: " + this.song1.getArtist() + " - " + this.song1.getName() + "\n";
            }
        }
        if (this.song2 != null) {
            if (this.song2.getGenre().equalsIgnoreCase(inputgenre)) {
                songOfGenreList += "Song2: " + this.song2.getArtist() + " - " + this.song2.getName() + "\n";
            }
        }
        if (this.song3 != null) {
            if (this.song3.getGenre().equalsIgnoreCase(inputgenre)) {
                songOfGenreList += "Song3: " + this.song3.getArtist() + " - " + this.song3.getName() + "\n";
            }
        }
        if (this.song4 != null) {
            if (this.song4.getGenre().equalsIgnoreCase(inputgenre)) {
                songOfGenreList += "Song4: " + this.song3.getArtist() + " - " + this.song4.getName() + "\n";
            }
        }
        return songOfGenreList;
    }


    public int howManySongs() {
        int n=0;
        if (song1 != null) {
            n++;
        }
        if (song2 != null) {
            n++;
        }
        if (song3 != null) {
            n++;
        }
        if (song4 != null) {
            n++;
        }
        return n;
    }
}
