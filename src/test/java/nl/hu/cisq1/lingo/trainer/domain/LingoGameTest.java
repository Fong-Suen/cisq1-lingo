package nl.hu.cisq1.lingo.trainer.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LingoGameTest {

    @Test
    @DisplayName("Check if new LingoRound works")
    public void testPoints(){
        LingoGame lingoGame = new LingoGame(new LingoRound("woord"));
        lingoGame.playRound("woord");

        assertEquals(30,lingoGame.getPoints());
    }

    @Test
    @DisplayName("Check if new LingoRound works")
    public void multipleRoundPointTest() {
        LingoGame lingoGame = new LingoGame(new LingoRound("woord"));
        lingoGame.playRound("wdddd");
        lingoGame.playRound("woord");


        assertEquals(25,lingoGame.getPoints());

    }

    @Test
    @DisplayName("Check if new LingoRound works")
    public void Statustest() {
        LingoGame lingoGame = new LingoGame(new LingoRound("woord"));
        assertEquals(Status.PLAYING,lingoGame.getStatus());
        lingoGame.playRound("woord");
        assertEquals(Status.WON,lingoGame.getStatus());

        LingoGame lingoGame2 = new LingoGame(new LingoRound("woord"));
        lingoGame2.playRound("wdddd");
        lingoGame2.playRound("wdddd");
        lingoGame2.playRound("wdddd");
        lingoGame2.playRound("wdddd");
        lingoGame2.playRound("wdddd");

        assertEquals(Status.LOST,lingoGame2.getStatus());
    }



}