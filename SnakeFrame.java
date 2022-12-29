/* Name =  Fatima Dembele
 * NetId = fdembele /  32107296
 * Lab times =  M/W 14:00 - 15:15
 * Lab section = 13 */

package BluePrint;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import Snake.SnakePanel;

public class SnakeFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public SnakeFrame() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
		
		this.add(new SnakePanel());
		this.setTitle("Snake Confetti.io");
		this.setSize(750,770);
		this.setResizable(true);
		this.setLayout(null);		
		this.setLocationRelativeTo(null);	
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

}
