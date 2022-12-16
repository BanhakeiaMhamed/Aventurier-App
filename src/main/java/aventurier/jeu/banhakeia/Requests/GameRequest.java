package aventurier.jeu.banhakeia.Requests;

import aventurier.jeu.banhakeia.entites.PlayerData;
import aventurier.jeu.banhakeia.entites.PlayerData;

/**
 * @Author: Mohamed BANHAKEIA
 *
 * Cette classe est conçue pour rassemble le body de La requette venant du Front
 *
 * @param : playerPosition représente la postion du Joueur
 * @param : board represente la carte surlaquelle deplace le joueur
 * @param : directions c'est la suite de commande comme "sseenn"
 * */
public class GameRequest {

    private String[][] board;
    private PlayerData playerData;

    public GameRequest(String[][] board, PlayerData playerData) {
        this.board = board;
        this.playerData = playerData;
    }

    public GameRequest() {
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public PlayerData getPlayerData() {
        return playerData;
    }

    public void setPlayerData(PlayerData playerData) {
        this.playerData = playerData;
    }
}
