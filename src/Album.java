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
    public String listAllSongs() {
        String songList = "";
        if (song1 != null) {
            songList += "Song1:" + song1.getName() + "\n";
        }
        if (song2 != null) {
            songList += "Song2:" + song2.getName() + "\n";
        }
        if (song3 != null) {
            songList += "Song3:" + song3.getName() + "\n";
        }
        if (song4 != null) {
            songList += "Song4:" + song4.getName() + "\n";
        }
        return songList;
    }


    public String listSongsUnderTime(int timeMax) {
        String songList = "";
        if (song1 != null) {
            if (song1.getDuration() <= timeMax) {
                songList += song1.getName();
            }
        }
        if (song2 != null) {
            if (song2.getDuration() <= timeMax) {
                songList += song2.getName();
            }
        }
        if (song3 != null) {
            if (song3.getDuration() <= timeMax) {
                songList += song3.getName();
            }
        }
        return  songList;
    }


    public int deleteSong(String songName) {
        if (this.song1 != null) {
            if (this.song1.getName().equals(songName)) {
                this.song1 = null;
                return 1;
            }
        } if (this.song2 != null) {
            if (this.song2.getName().equals(songName)) {
                this.song2 = null;
                return 1;
            }
        } if (this.song3 != null) {
            if (this.song3.getName().equals(songName)) {
                this.song3 = null;
                return 1;
            }
        }
        return 0;
    }


    //    Adds song to Album, Will try song1 first, then song2, song3...
//    Return 1 if successful, return 0 if unsucessful
    public int addSong(String inputName, String inputArtist, int inputDuration, String inputGenre) {
        if (this.doesSongExist(inputName, inputArtist, inputDuration)) {
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


    //  Sets attribute 'isFull' to true if all songs have names
    private void checkIsFull() {
        if (this.song1.getName() != null && this.song2.getName() != null && this.song3.getName() != null && this.song4.getName() != null) {
            this.isFull = true;
        }
    }

//  Returns true of song of same name, artist and duration exists, else returns false
    private boolean doesSongExist(String inputName, String inputArtist, int inputDuration) {
        if (this.song1 != null) {
            if (this.song1.getName().equals(inputName) && this.song1.getArtist().equals(inputArtist) && this.song1.getDuration() == inputDuration) {
                return true;
            }
        } if (this.song2 != null) {
            if (this.song2.getName().equals(inputName) && this.song2.getArtist().equals(inputArtist) && this.song2.getDuration() == inputDuration) {
                return true;
            }
        } if (this.song3 != null) {
            if (this.song3.getName().equals(inputName) && this.song3.getArtist().equals(inputArtist) && this.song3.getDuration() == inputDuration) {
                return true;
            }
        } if (this.song4 != null) {
            if (this.song4.getName().equals(inputName) && this.song4.getArtist().equals(inputArtist) && this.song4.getDuration() == inputDuration) {
                return true;
            }
        }
        return false;
    }


    //    Returns songs of certain genre
    public String songsOfGenre(String inputgenre) {
        String songOfGenreList = "";
        if (this.song1 != null) {
            if (this.song1.getGenre().equals(inputgenre)) {
                songOfGenreList += "Song1 Genre:" + this.song1.getName() + "\n";
            }
        }
        if (this.song2 != null) {
            if (this.song2.getGenre().equals(inputgenre)) {
                songOfGenreList += "Song2 Genre:" + this.song1.getName() + "\n";
            }
        }
        if (this.song3 != null) {
            if (this.song3.getGenre().equals(inputgenre)) {
                songOfGenreList += "Song3 Genre:" + this.song1.getName() + "\n";
            }
        }
        if (this.song4 != null) {
            if (this.song4.getGenre().equals(inputgenre)) {
                songOfGenreList += "Song4 Genre:" + this.song1.getName() + "\n";
            }
        }
        return songOfGenreList;
    }
}
