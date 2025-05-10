import java.util.ArrayList;

public class Text {

    public ArrayList<String> play = new ArrayList<>();
    public ArrayList<String> topscores = new ArrayList<>();
    public ArrayList<String> language = new ArrayList<>();
    public ArrayList<String> about = new ArrayList<>();
    public ArrayList<String> leave = new ArrayList<>();
    public ArrayList<String> english = new ArrayList<>();
    public ArrayList<String> french = new ArrayList<>();
    public ArrayList<String> back = new ArrayList<>();

    public Text() {
        
        play.add("Play");
        play.add("Jouer");

        topscores.add("Top Scores");
        topscores.add("Meilleurs scores");

        language.add("Language");
        language.add("Langage");

        about.add("About");
        about.add("À propos");

        leave.add("Leave");
        leave.add("Quitter");

        english.add("English");
        english.add("Anglais");

        french.add("French");
        french.add("Français");

        back.add("Back");
        back.add("Retour");
    }

}
