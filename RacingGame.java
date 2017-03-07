import javax.swing.*;
import java.awt.*;

public class RacingGame
{
	private JFrame content = new JFrame();
	private Racer player = new Racer();
	private JPanel mainPanel = new JPanel();
	private JLabel scoreLabel = new JLabel("Score");
	private int score = 0;


	public RacingGame()
	{
		
		content.setTitle("Racing Game");
		content.setSize(800, 700);
		mainPanel.add(player.getPanel());
		scoreLabel.setPreferredSize(new Dimension(50, 50));
		scoreLabel.setHorizontalAlignment(JLabel.LEFT);
		mainPanel.add(scoreLabel);
		content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content.setContentPane(mainPanel);
		content.setVisible(true);
		
		
		player.start();

		while(player.isPlaying())
		player.update();	
	}
}
	
