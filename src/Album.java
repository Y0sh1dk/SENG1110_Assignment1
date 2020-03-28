public class Album {
    // instance variables 
    private String name;
    private Song song1, song2, song3, song4;
    private int totalTime;
    private final int MAX_TIME = 720; //12 minutes

    /**
     * Constructor for objects of class Album
     */
    public Album() {
        // initialise instance variables
        
    }


    
    public void setName (String inputName) {
        name = inputName;
    }

    public String getName() {
        return name;
    }

}
