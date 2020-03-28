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
    }


    public void setName (String inputName) {
        name = inputName;
    }

    public String getName() {
        return name;
    }

//    TODO: test listSongs method
    public String listSongs() {
        String songList = null;
        if (song1.getName() != null) {
            songList += song1.getName();
        }
        if (song2.getName() != null) {
            songList += song2.getName();
        }
        if (song3.getName() != null) {
            songList += song3.getName();
        }
        if (song4.getName() != null) {
            songList += song4.getName();
        }
        return songList;
    }



//    Add song to Album
    public void addSong() {
        if (song1.getName() == null) {

        } else if (song2.getName() == null) {

        } else if (song3.getName() == null) {

        } else if (song4.getName() == null) {

        }
    }

//    Calculate total runtime of all songs
    private void calculateTotalTime() {
        this.totalTime = song1.getDuration() + song2.getDuration() + song3.getDuration() + song4.getDuration();
    }


//  Sets attribute 'isFull' to true if all songs have names
    private void checkIsFull() {
        if (song1.getName() != null && song2.getName() != null && song3.getName() != null && song4.getName() != null) {
            this.isFull = true;
        }
    }
}
