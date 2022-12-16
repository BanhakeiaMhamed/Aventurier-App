package aventurier.jeu.banhakeia;

import  aventurier.jeu.banhakeia.Requests.*;
import aventurier.jeu.banhakeia.entites.PlayerData;
import aventurier.jeu.banhakeia.utils.GamePlayUtils;
import org.junit.jupiter.api.Test;
import aventurier.jeu.banhakeia.controller.controller;


import static org.assertj.core.api.Assertions.assertThat;
/**
 * @Author : Mohamed BANHAKEIA
 *
 *
 * */
public class utilsTest {

    GamePlayUtils utils = new GamePlayUtils();
    controller controller = new controller();
    GameRequest gameRequest = new GameRequest();
/**
 * @Author : Mohamed BANHAKEIA
 *
 * */
    @Test
    void generateRandomValuesShouldGenerateRandomValuesOfOAndX() {
        //given
        int size = 6;
        //when
        String randomValue = utils.generateRandomValues(size);
        //then
        assertThat(randomValue.chars().anyMatch(n-> n=='x'));
        assertThat(randomValue.chars().anyMatch(n-> n=='0'));
    }

/**
 * @Author : Mohamed BANHAKEIA
 *
 *
 * */
    @Test
    void isPositionNonValidShouldReturnTrueWhenPlayerPositionIsNotValid(){

        GamePlayUtils utils = new GamePlayUtils();
        String[][] board = {

                {"x","x","x"},
                {"0","0","x"},
                {"x","0","0"}
        };

        String [] initialPlayerPosition = {"5","5"};
        assertThat(utils.isPositionNonValid(initialPlayerPosition,board)).isTrue();

    }


/**
 * @Author : Mohamed BANHAKEIA
 *
 * */
    @Test
    void isPositionNonValidShouldReturnTrueWhenPlayerPositionIsXXX(){

        GamePlayUtils utils = new GamePlayUtils();
        String[][] board = {
                {"x","x","x"},
                {"0","0","x"},
                {"x","0","0"}
        };
        String [] initialPlayerPosition = {"0","0"};
        assertThat(utils.isPositionNonValid(initialPlayerPosition,board)).isTrue();

    }


    @Test
    void getPlayerPositionShouldReturnPlayerPositionWhenAllParamsAreOk(){

        String[][] borad = {
                {"#","#","#","0","0","0","0","#","#","#","#","#","#","0","0","0","0","#","#","#"},
                {"#","#","#","0","0","0","0","0","0","#","#","0","0","0","0","0","0","#","#","#"},
                {"#","#","0","0","0","0","0","#","#","0","0","#","#","0","0","0","0","0","#","#"},
                {"#","0","0","0","0","0","0","#","#","0","0","#","#","0","0","0","0","0","0","#"},
                {"#","#","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","#","#"},
                {"#","#","#","#","#","0","0","0","0","0","0","0","0","0","0","#","#","#","#","#"},
                {"#","#","#","#","#","#","0","#","#","0","0","#","#","0","0","#","#","#","#","#"},
                {"0","#","0","0","0","0","0","0","#","#","#","#","#","#","0","0","0","0","0","#"},
                {"0","0","0","0","0","#","#","#","#","#","#","#","#","0","0","0","0","0","0","0"},
                {"0","0","0","0","#","#","#","#","#","#","#","#","#","#","#","#","0","0","0","0"},
                {"0","0","0","0","#","#","#","#","#","#","#","#","#","#","#","#","0","0","0","0"},
                {"0","0","0","0","0","#","#","#","#","#","#","#","#","0","0","0","0","0","0","#"},
                {"0","#","0","0","0","0","0","#","#","#","#","#","#","0","0","0","0","0","#","#"},
                {"#","#","#","#","#","#","0","#","#","0","0","#","#","0","#","#","#","#","#","#"},
                {"#","#","#","#","#","0","0","0","0","0","0","0","0","0","0","#","#","#","#","#"},
                {"#","#","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","#","#"},
                {"#","0","0","0","#","#","0","#","0","0","0","0","#","0","#","#","0","0","0","#"},
                {"#","#","0","0","0","#","#","0","0","0","0","0","0","#","#","0","0","0","#","#"},
                {"#","#","#","0","0","0","0","#","0","0","0","0","#","0","0","0","0","#","#","#"},
                {"#","#","#","0","0","0","0","#","#","#","#","#","#","0","0","0","0","#","#","#"}
        };
        String[] playerPosition = {"3","0"};
        PlayerData playerData = new PlayerData(playerPosition, "sssseeeeeenn" );


        gameRequest.setBoard(borad);
        gameRequest.setPlayerData(playerData);
        String position = controller.getPlayerPosition(gameRequest);
        assertThat(position.equals("9, 2"));


    }
}
