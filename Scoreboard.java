import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Scoreboard implements KeyListener
{

//score for the high score table
	private JFrame scoreTable = new JFrame();
	private JPanel mainPanel = new JPanel();
	private JPanel namePanel = new JPanel();
	private JPanel scorePanel = new JPanel();	
	private JTextField playerName = new JTextField();
	private int finalScore;
	private int comparisonOfScore;
	private boolean enteredName;
	private boolean savedScore;
	
	private JLabel[] playersLabel = new JLabel[11];
	private JLabel[] scoreLabel = new JLabel[11];
	private JLabel titleName = new JLabel("<html><font color='red'>NAME:</font></html>");
	private JLabel titleScore = new JLabel("<html><font color='red'>SCORE:</font></html>");
	private JLabel enterNameText = new JLabel("<html><font color='red'>Enter your name and press enter: </font></html>");
	
	public Scoreboard()
	{
		scoreTable.setContentPane(mainPanel);
		scoreTable.setSize(350,300);
		scoreTable.setTitle("High Scoreboard");
		mainPanel.setLayout(new BorderLayout());
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
	
	public void updateScoreboard()
	{
		if (savedScore == true)
		{
			for (int i = 0; i < 10; i++)
			{
				comparisonOfScore = Integer.parseInt(scoreLabel[i].getText());
				if (finalScore > comparisonOfScore)
				{
					playersLabel[i].setText(playersLabel[10].getText());
					scoreLabel[i].setText(String.valueOf(Integer.parseInt(scoreLabel[10].getText())));
					break;
				}
			}
		}
	}
	
	
	
}