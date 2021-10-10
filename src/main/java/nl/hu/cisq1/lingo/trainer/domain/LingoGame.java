package nl.hu.cisq1.lingo.trainer.domain;

public class LingoGame {
    private LingoRound lingoRound;
    private int points;
    private Status status;


    public LingoGame(LingoRound lingoRound){
        status = Status.PLAYING;
        this.lingoRound = lingoRound;
        points = 0;
    }

    public void newLingoGame(LingoRound lingoRound){
        status = Status.PLAYING;
        this.lingoRound = lingoRound;
        points = 0;
    }

    public void playRound(String attempt){
        if (status==Status.PLAYING){
            String hint = lingoRound.guess(attempt);
            if (lingoRound.isWordIsGuessed()){
                status = Status.WON;
                setPoints();
            }
            if (lingoRound.gameOver()){
                status = Status.LOST;
            }
        }

    }

    public void nextRound(String newToGuess){
        if (status==Status.WON){
            lingoRound = new LingoRound(newToGuess);
            status = Status.PLAYING;
        }
    }



    /*TODO Remove later, this is purely for testing purposes*/
    public int getPoints() {
        return points;
    }


    /*TODO Remove later, this is purely for testing purposes*/
    public Status getStatus() {
        return status;
    }

    /*
            na 5 kansen wordt er gecheckt of je het woord hebt geraden,
            als niet dan opnieuw beginnen en punten printen
            als je het woord hebt geraden voor 5 pogingen dan
            krijg je punten op basis van welke beurt het is
            een Quit functie toevoegen.
            een functie toevoegen dat:
                -de huidige hint geeft,
                -de poging geeft
                -de marks terug geeft
            */
    private void setPoints(){
        points += 5 * (5-lingoRound.currentTurn()) +5;
    }
}
