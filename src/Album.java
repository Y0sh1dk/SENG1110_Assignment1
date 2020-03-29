public class Album {

    private String name;
    private Song song1, song2, song3, song4;
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


    public void setName (String inputName) {
        name = inputName;
    }

    public String getName() {
        return name;
    }

//    TODO: test listSongs method
    public String listSongs() {
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



//    Adds song to Album, Will try song1 first, then song2, song3...
//    Return 1 if successful, return 0 if unsucessful
    public int addSong(String inputName, String inputArtist, int inputDuration, String inputGenre) {
        this.calculateTotalTime();
        if (this.totalTime + inputDuration <= this.MAX_TIME) {
            if (this.song1 == null) {
                this.song1 = new Song(inputName, inputArtist, inputDuration, inputGenre);
                return 1;
            } else if (this.song2 == null) {
                this.song2 = new Song(inputName, inputArtist, inputDuration, inputGenre);
                return 1;
            } else if (this.song3 == null) {
                this.song3 = new Song(inputName, inputArtist, inputDuration, inputGenre);
                return 1;
            } else if (this.song4 == null) {
                this.song4 = new Song(inputName, inputArtist, inputDuration, inputGenre);
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

//    Calculate total runtime of all songs
    private void calculateTotalTime() {
        this.totalTime = 0;
        int time = 0;
        if (this.song1 != null) {
            time += this.song1.getDuration();
        } if (this.song2 != null) {
            time += this.song2.getDuration();
        } if (this.song3 != null) {
            time += this.song3.getDuration();
        } if (this.song4 != null) {
            time += this.song4.getDuration();
        }
        this.totalTime = time;
    }


//  Sets attribute 'isFull' to true if all songs have names
    private void checkIsFull() {
        if (song1.getName() != null && song2.getName() != null && song3.getName() != null && song4.getName() != null) {
            this.isFull = true;
        }
    }
}
