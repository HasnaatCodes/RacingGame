import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
* When this class is called, the Scoreboard is set up.
* Swing libraries are used to import Swing labels, panels, buttons and frames.
* The class is also responsible for taking the score and takes the users name
* and appends the scores on the scoreboard.  
* 
* Class also utilises listeners which listen for state changing events and
* execute methods accordingly.
*
* @author: Hasnaat Akhtar 
*/

	/**
	* 
	* Class makes instances of frames, panels which construct the scoreboard.
	* 
	*/
 
public class Scoreboard implements KeyListener
{
	private JFrame scoreTable = new JFrame();
	private JPanel mainPanel = new JPanel();
	private JPanel namePanel = new JPanel();
	private JPanel scorePanel = new JPanel();	
	private JTextField playerName = new JTextField();
	
	private int finalScore; //variable stores users final score
	private int comparisonOfScore; //variable stores value of score and is used for comparison with other scores.
	private boolean enteredName;
	private boolean savedScore;
	
	private JLabel[] playersLabel = new JLabel[11];
	private JLabel[] scoreLabel = new JLabel[11];
	private JLabel titleName = new JLabel("<html><font color='red'>NAME:</font></html>");
	private JLabel titleScore = new JLabel("<html><font color='red'>SCORE:</font></html>");
	private JLabel enterNameText = new JLabel("<html><font color='red'>Enter your name and press enter: </font></html>");
	
	/**
	* The panels are added for the scoreboard; the name labels, score labels etc.
	* The for loops are used to add required number of labels for the names and score.
	* A for loop is used to fill these labels with "NONE" and 0
	* The textfield has a KeyListener attached to it, so when the button assigned(ENTER) is pressed, it calls the appropriate method.
	*
	*/
	public Scoreboard()
	{
		//The main frame is added and the mainPanel is added on top. 
		scoreTable.setContentPane(mainPanel);
		scoreTable.setSize(350,300);
		scoreTable.setTitle("High Scoreboard");
		mainPanel.setLayout(new BorderLayout());
		
		//Two separate panels (Score Panel and Name Panel) are added on to the main Panel
		namePanel.setLayout(new GridLayout(13,1));
		scorePanel.setLayout(new GridLayout(13,1));
		mainPanel.add("West", namePanel);
		mainPanel.add("East", scorePanel);

		for(int i=0; i<11;i++)
		{
			playersLabel[i] = new JLabel();
			scoreLabel[i] = new JLabel();
		}
		
		namePanel.add(titleName);
		scorePanel.add(titleScore);
		
		for(int i=0; i<10;i++)
		{
			playersLabel[i].setText("NONE");
			namePanel.add(playersLabel[i]);
			scoreLabel[i].setText((String.valueOf(0)));
			scorePanel.add(scoreLabel[i]);
		}
		namePanel.add(enterNameText);
		mainPanel.add("South", playerName);
		playerName.addKeyListener(this);
		
		scoreTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scoreTable.setLocation(900,200);
		scoreTable.setVisible(true);
	}
	
	/**
	* When enter is pressed, run updateScoreboard();
	*/
	public void keyPressed(KeyEvent a)
	{
		if (a.getKeyCode() == KeyEvent.VK_ENTER)
		{
			playersLabel[10].setText(playerName.getText());
			updateScoreboard();
		}
	}
	
	public void keyTyped(KeyEvent a){}
	
	public void keyReleased(KeyEvent a){}
	
	public void saveScore(int scoreValue)
	{
		scoreLabel[10].setText((String.valueOf(scoreValue))); 
		finalScore = scoreValue;
		enteredName = true;
		savedScore = true;
	}
	
	/**
	* This is where the score is added to the scoreboard along with the name and score.
	*/
	public void updateScoreboard()
	{
		if (savedScore == true)
		{
			for (int i = 0; i < 10; i++)
			{
				int y = 8;
				comparisonOfScore = Integer.parseInt(scoreLabel[i].getText());
				if (finalScore > comparisonOfScore)
				{
					for (int x = 9; x > i; x--)
					{
						playersLabel[x].setText(playersLabel[y].getText());
						scoreLabel[x].setText(String.valueOf(Integer.parseInt(scoreLabel[y].getText())));
						y--;
					}
					playersLabel[i].setText(playersLabel[10].getText());
					scoreLabel[i].setText(String.valueOf(Integer.parseInt(scoreLabel[10].getText())));
					break;
				}
			}
		}
	}
	
	
	
}