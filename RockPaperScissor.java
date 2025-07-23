import javax.xml.transform.Result;
import java.security.PublicKey;
import java.util.Random;


public class RockPaperScissor {
    private static final String[] computerchoices = {"Rock","Paper","Scissor"};



    private String computerChoice;

    public String getComputerChoice() {
        return computerChoice;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    private int computerScore , playerScore;

    private Random random;

    public RockPaperScissor(){
        random = new Random();

    }
    public String playRockPaperScissor(String playerChoice){
        computerChoice = computerchoices[random.nextInt(computerchoices.length)];
    String result="draw";

    if(computerChoice.equals("Rock")){
        if(playerChoice.equals("Paper")){
            result = "Player wins";
            playerScore++;
        }else if(playerChoice.equals("Scissors")){
            result = "computer wins";
            computerScore++;
        }else{
            result = "draw";
        }
    }
        else if (computerChoice.equals("Paper")){
            if(playerChoice.equals("Scissors")){
                result = "Player wins";
                playerScore++;
            }else if(playerChoice.equals("Rock")){
                result = "computer wins";
                computerScore++;
            }else{
                result = "draw";
            }
        }
        else if (computerChoice.equals("Scissors")){
            if(playerChoice.equals("Rock")){
                result = "Player wins";
                playerScore++;
            }else if(playerChoice.equals("Paper")){
                result = "computer wins";
                computerScore++;
            }else{
                result = "draw";
            }
        }
  return result;  }

}
