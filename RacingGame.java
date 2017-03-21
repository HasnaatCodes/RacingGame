import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
* On runtime, this class sets up the playing environment.
* It uses Swing libraries to import various panels, frames, labels and buttons.
* These are then used to construct the actual gameplay.
* It also creates an instance of the Scoreboard class I created
*
*
* *@author: Hasnaat Akhtar 
*/

public class RacingGame implements ActionListener
{
	private JFrame content = new JFrame();
	private Racer player = new Racer();
	private JPanel mainPanel = new JPanel();
	private JLabel scoreLabel = new JLabel("Score: 0");
	private JButton playButton = new JButton("PLAY");
	private JButton stopButton = new JButton("STOP");
	private JPanel buttonPanel = new JPanel();
	private boolean checkPlaying;
	
	/**
	* The whole game is put together.
	* All the windows show up and panels are added on top.
	*/
	public RacingGame()
	{
		//The Main panel where the scoreLabel and buttonPanel are added
		mainPanel.setLayout(new BorderLayout());		
		mainPanel.add(player.getPanel()); //runs the getPanel method in Racer file
		mainPanel.add("North", scoreLabel);
		mainPanel.add("South", buttonPanel);
		
		//The button panel is set up and buttons are added
		buttonPanel.setLayout(new GridLayout(1,2));
		playButton.setPreferredSize(new Dimension(25, 25));
		stopButton.setPreferredSize(new Dimension(25, 25));		
		buttonPanel.add("South", playButton);		
		buttonPanel.add("South", stopButton);
		playButton.addActionListener(this);
		stopButton.addActionListener(this);
		
		//A label where score is shown 
		scoreLabel.setPreferredSize(new Dimension(40, 40));		
		scoreLabel.setHorizontalAlignment(JLabel.LEFT);
		
		//Code for the main Frame Window
		content.setTitle("Racing Game");
		content.setSize(800, 700);			
		content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		content.setContentPane(mainPanel);

		//Creates an instance of the Scoreboard class
		Scoreboard score = new Scoreboard();		
		
		//Displays the main frame
		content.setVisible(true);
		
		//Starts the game
		player.start();

		while (true) //makes sure that the both if statement run
		{
			player.update();
			if(player.isPlaying())
			{
				scoreLabel.setText("Score: " + player.getScore());
				playButton.setEnabled(false);
				stopButton.setEnabled(true);
				checkPlaying = false;
			}
			
			if (player.isPlaying() == false && checkPlaying == false)
			{
				playButton.setEnabled(true);
				stopButton.setEnabled(false);
				score.saveScore(player.getScore());
				checkPlaying = true;
			}
		}
	}
		/**
		* This method is run when the play button or stop button is pressed. 
		* Stop button will stop the game.
		* Play button will restart the game once stopped.
		*
		*/
		public void actionPerformed(ActionEvent a)
		{
			if(a.getSource() == playButton)
			{
				player.start();
				player.getPanel().requestFocus();
			}
			if(a.getSource() == stopButton)
			{
				player.stop();
			}
		}
}
	
