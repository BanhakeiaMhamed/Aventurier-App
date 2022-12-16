package aventurier.jeu.banhakeia.entites;

public class PlayerData {
    private String[] playerPosition;
    private String directions;

    public PlayerData() {
    }

    public PlayerData(String[] position, String directions) {

        this.playerPosition = position;
        this.directions = directions;
    }


    public String[] getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String[] playerPosition) {
        this.playerPosition = playerPosition;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }
}
