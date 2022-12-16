package aventurier.jeu.banhakeia.controller;

import aventurier.jeu.banhakeia.Requests.*;
import aventurier.jeu.banhakeia.utils.GamePlayUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Locale;


@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class controller {

    private GamePlayUtils utils = new GamePlayUtils();
    private GameRequest gameRequest;

    /**
     * cette méthode s'execute quand le front demande une carte
     *
     * @param size: la taille de la carte
     *
     * @return board: une matrice des 0 et des x
     * */
    @RequestMapping("/board")
    @ResponseBody
    public String [][] getBoard(@RequestParam(value = "size",defaultValue = "8") String size){
        System.out.println("ma carte");
        int sz = Integer.parseInt(size);
        String [][] board = new String[sz][sz];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if(utils.generateRandomValues(1).equals("0")){
                    board[i][j]=" ";
                }
                else {
                    board[i][j]="X";
                }
            }
        }
        utils.displayCarteInConsole(board);
        return board;
    }

/**
 * cette méthode retourne la position du joueur aprés une suite de commandes
 *
 * @param   gameRequest GameRequest

 *
 * @return un vecteur [x][y] qui represente un la nouvelle position du joueur
 * */
    @RequestMapping("/getPosition")
    @ResponseBody
    public String getPlayerPosition(@RequestBody GameRequest gameRequest) {
        System.out.println("ma carte apres avoir clique sur joué");
        utils.displayCarteInConsole(gameRequest.getBoard());
        String directions = gameRequest.getPlayerData().getDirections();
        String[] playerPosition = gameRequest.getPlayerData().getPlayerPosition();
        String[][] board = gameRequest.getBoard();
        utils.displayCarteInConsole(gameRequest.getBoard());
        System.out.println("heeeeeeeeeeeeeeeeey");
        char[]charsDirections= directions.toLowerCase(Locale.ROOT).toCharArray();
        for(int i=0;i<charsDirections.length;i++){
            String[] newtPosplayer = utils.getNextPosition(charsDirections[i], playerPosition);
            System.out.println("newtPosplaye: "+Arrays.toString(newtPosplayer));
            if(utils.isPositionNonValid(newtPosplayer,board)){
                System.out.println("position non valide");
                return "erreur";
            }else{
                System.out.println("position valide");
                playerPosition =newtPosplayer;
            }
        }
        return Arrays.toString(playerPosition);
    }

}
