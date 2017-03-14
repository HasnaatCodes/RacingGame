import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RacingGame implements ActionListener
{
	private JFrame content = new JFrame();
	private Racer player = new Racer();
	private JPanel mainPanel = new JPanel();
	private JLabel scoreLabel = new JLabel("Score: 0");
	private JButton playButton = new JButton("PLAY");
	private JButton stopButton = new JButton("STOP");
	private JPanel buttonPanel = new JPanel();


	public RacingGame()
	{
		mainPanel.setLayout(new BorderLayout());
		buttonPanel.setLayout(new GridLayout(1,2));
		
		mainPanel.add(player.getPanel());
		mainPanel.add("North", scoreLabel);
		
		mainPanel.add("South", buttonPanel);
		buttonPanel.add("South", playButton);
		
		
		buttonPanel.add("South", stopButton);
		scoreLabel.setPreferredSize(new Dimension(20, 20));		
		scoreLabel.setHorizontalAlignment(JLabel.LEFT);
		
		content.setTitle("Racing Game");
		content.setSize(800, 700);		
		
		content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		content.setContentPane(mainPanel);
		playButton.addActionListener(this);
		stopButton.addActionListener(this);
		
		content.setVisible(true);		
		player.start();

		while (true) // makes sure that the if statement can be run once the "while(player.isPlaying())" is done
		{
			while(player.isPlaying())
			{
				player.update();
				scoreLabel.setText("Score: " + player.getScore());
				playButton.setEnabled(false);
				stopButton.setEnabled(true);
			}
			
			if (player.isPlaying() == false)
			{
				playButton.setEnabled(true);
				stopButton.setEnabled(false);
			}
		}
		
		

	}
	
	
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
	
