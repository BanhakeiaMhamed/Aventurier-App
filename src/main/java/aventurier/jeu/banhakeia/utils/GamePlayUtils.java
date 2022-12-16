package aventurier.jeu.banhakeia.utils;

import java.util.Random;

/**
 * @Auther: BANHAKEIA Mohamed
 *
 * Dans cette @Class: GamePlayUtils propose plusieurs methodes de Verifivations 
 * */
public class GamePlayUtils {
    
    public GamePlayUtils() {
    }

/**
 * Cette methode prend en parametres : 
 * @param a représente la direction du joueur : "Nord, Sud, Est, Ouest"
 * @param playerPosition
 * 
 * @return les coordonnées du prochain positon sous forme d'une liste de string[x][y]
* */
    public String[] getNextPosition(char a, String[] playerPosition){
        int px=Integer.parseInt(playerPosition[0]);
        int py=Integer.parseInt(playerPosition[1]);
        if(a=='n'){py=py-1;}
        else if(a=='s'){py=py+1;}
        else if(a=='o'){px=px-1;}
        else if(a=='e'){px=px+1;}
        else{
            return null;
        }
        return new String[]{String.valueOf(px), String.valueOf(py)};
    }

/**
 * cette méthode permet de verfifer si la position initial du joueur est Non valide
 * 
 * @param board represente la carte surlaquelle le joueur se déplace
 * @param playerPosition représente la posiiton initial du joueur
 *                       
 * @return false si la position initiale n'est pas valide
 * */
    public boolean isPositionNonValid(String[] playerPosition, String[][] board) {
        int px = Integer.parseInt(playerPosition[0]);
        int py = Integer.parseInt(playerPosition[1]);
        System.out.println("la position joueur sur la carte "+board[py][px].toLowerCase());
        if (px < 0) {
            return true;
        }
        if (py < 0) {
            return true;
        }
        if (py >= board.length) {
            return true;
        }
        if (px >= board[0].length) {
            return true;
        }
        if (board[py][px].toLowerCase().equals("x")) {
            System.out.println("hello wolrd");
            return true;
        }
        return false;
    }

/**
 * cette methode permet de generer aléatoirement des valeurs 0 et x
 * 
 * @param boardSize la taille de la carte par default 8.
 * 
 * @retur string x
 * */
    public String generateRandomValues(int boardSize){
        String alphabet = "00000000xxxx";
        Random rand = new Random();
        String x="";
        for (int i=0; i<boardSize; i++)
        {
            x=x+alphabet.charAt(rand.nextInt(alphabet.length()));
        }
        return x;
    }

/**
 * Cette methode est utilse pour afficher dans la console la carte.
 * @param board: carte
 * */
    public void displayCarteInConsole(String [][] board){
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]);
            }
            System.out.print("\n");

        }
    }
}
