import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Paper;

public class RockPaperScissorGui extends JFrame implements ActionListener {
    JButton RockButton,PaperButton,ScissorButton;

    JLabel computerchoice;
    JLabel computerScoreLabel,playerScoreLabel;
    RockPaperScissor rockPaperScissor;
    public RockPaperScissorGui(){
        super("Rock Paper Scissor");
        setSize(450,574);
        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        rockPaperScissor = new RockPaperScissor();

        //adding gui components

        addGuiComponents();
    }
private void addGuiComponents(){
       computerScoreLabel = new JLabel("computer:0");
        computerScoreLabel.setBounds(0,43,450,30);
        computerScoreLabel.setFont(new Font("Dialog",Font.BOLD,26));

        //placing text in centre
    computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
    add(computerScoreLabel);

    computerchoice = new JLabel("?");
    computerchoice.setBounds(175,118,98,81);
    computerchoice.setFont(new Font("Dialog",Font.PLAIN,18));
    computerchoice.setHorizontalAlignment(SwingConstants.CENTER);

    computerchoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    add(computerchoice);

    //creating player label score

    playerScoreLabel = new JLabel("Player:0");
    playerScoreLabel.setBounds(0,317,450,30);
    playerScoreLabel.setFont(new Font("Dialog",Font.BOLD,26));
    playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
    add(playerScoreLabel);

    //player buttons
    //rock button
    RockButton = new JButton("Rock");
    RockButton.setBounds(40,387,105,81);
    RockButton.setFont(new Font("Dialog",Font.PLAIN,18));
    RockButton.addActionListener(this);
    add(RockButton);

    PaperButton = new JButton("Paper");
    PaperButton.setBounds(165,387,105,81);
    PaperButton.setFont(new Font("Dialog",Font.PLAIN,18));
    PaperButton.addActionListener(this);
    add(PaperButton);

    ScissorButton = new JButton("Scissor");
    ScissorButton.setBounds(290,387,105,81);
    ScissorButton.setFont(new Font("Dialog",Font.PLAIN,18));
    ScissorButton.addActionListener(this);
    add(ScissorButton);






    }
    private void showDialog(String message){
        JDialog resultDialog = new JDialog(this, "Result",true);
        resultDialog.setSize(227,124);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);
        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Dialog",Font.BOLD,18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel,BorderLayout.CENTER);

        JButton tryAgainButton = new JButton("Try again?");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computerchoice.setText("?");

                resultDialog.dispose();

            }
        });
        resultDialog.add(tryAgainButton,BorderLayout.SOUTH);
        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    String playerChoice = e.getActionCommand().toString();
    String result = rockPaperScissor.playRockPaperScissor(playerChoice);

    computerchoice.setText(rockPaperScissor.getComputerChoice());

    computerScoreLabel.setText("Computer"+rockPaperScissor.getComputerScore());

        playerScoreLabel.setText("Computer"+rockPaperScissor.getPlayerScore());

        showDialog(result);
    }
}
