import java.util.ArrayList;

public class Text {

    //menu buttons
    public ArrayList<String> play = new ArrayList<>();
    public ArrayList<String> topscores = new ArrayList<>();
    public ArrayList<String> language = new ArrayList<>();
    public ArrayList<String> about = new ArrayList<>();
    public ArrayList<String> leave = new ArrayList<>();

    //choose language
    public ArrayList<String> choosealanguage = new ArrayList<>();
    public ArrayList<String> english = new ArrayList<>();
    public ArrayList<String> french = new ArrayList<>();
    public ArrayList<String> backtomenu = new ArrayList<>();

    //top scores
    public ArrayList<String> top7scores = new ArrayList<>();
    public ArrayList<String> first = new ArrayList<>();
    public ArrayList<String> second = new ArrayList<>();
    public ArrayList<String> third = new ArrayList<>();
    public ArrayList<String> fourth = new ArrayList<>();
    public ArrayList<String> fifth = new ArrayList<>();
    public ArrayList<String> sixth = new ArrayList<>();
    public ArrayList<String> seventh = new ArrayList<>();

    //map choice
    public ArrayList<String> mapOne = new ArrayList<>();
    public ArrayList<String> mapTwo = new ArrayList<>();
    public ArrayList<String> choosethemap = new ArrayList<>();

    //game panel
    public ArrayList<String> mapOneName = new ArrayList<>();
    public ArrayList<String> carte = new ArrayList<>();
    public ArrayList<String> timeToComplete = new ArrayList<>();
    public ArrayList<String> instruction1 = new ArrayList<>();
    public ArrayList<String> instruction2 = new ArrayList<>();
    public ArrayList<String> instruction3 = new ArrayList<>();
    public ArrayList<String> instruction4 = new ArrayList<>();
    public ArrayList<String> instruction5 = new ArrayList<>();
    public ArrayList<String> progress = new ArrayList<>();



    public Text() {
        
        //menu buttons
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

        //choose language panel
        choosealanguage.add("Choose a language :");
        choosealanguage.add("Choisissez la langue :");
        english.add("English");
        english.add("Anglais");
        french.add("French");
        french.add("Français");

        //top scores panel
        top7scores.add("Top 7 Scores :");
        top7scores.add("7 Meilleurs Scores :");
        first.add("1 st     :    ");
        first.add("1 er        :    ");
        second.add("2 nd    :    ");
        second.add("2 eme    :    ");
        third.add("3 nd    :    ");
        third.add("3 eme    :    ");
        fourth.add("4 nd    :    ");
        fourth.add("4 eme    :    ");
        fifth.add("5 nd    :    ");
        fifth.add("5 eme    :    ");
        sixth.add("6 nd    :    ");
        sixth.add("6 eme    :    ");
        seventh.add("7 nd    :    ");
        seventh.add("7 eme    :    ");

        //map choice
        mapOne.add("Map 1");
        mapOne.add("Carte 1");
        mapTwo.add("Map 2");
        mapTwo.add("Carte 2");
        choosethemap.add("Choose the map :");
        choosethemap.add("Choisissez la carte :");


        //game panel
        mapOneName.add("PARIS");
        mapOneName.add("PARIS");
        carte.add("Map");
        carte.add("Carte");
        timeToComplete.add("Time to complete : ");
        timeToComplete.add("Temps pour finir : ");
        instruction1.add("- Press SPACE to start the game");
        instruction1.add("- Appuyez sur ESPACE pour démarrer la partie");
        instruction2.add("- Press SPACE or UP to jump");
        instruction2.add("- Appuyez sur ESPACE ou HAUT pour sauter");
        instruction3.add("- Press DOWN to lower");
        instruction3.add("- Appuyez sur BAS pour s'accroupir");
        instruction4.add("- Press T to see the top scores");
        instruction4.add("- Appuyez sur T pour voir les meilleurs scores");
        instruction5.add("- Press ENTER to go back to the menu");
        instruction5.add("- Appuyez sur ENTRER pour revenir au menu");
        progress.add("Progress : ");
        progress.add("Progression : ");

        // back to menu
        backtomenu.add("Back to Menu");
        backtomenu.add("Retour au Menu");
    }

}
