/* Name =  Fatima Dembele
 * NetId = fdembele /  32107296
 * Lab times =  M/W 14:00 - 15:15
 * Lab section = 13 */

package Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.swing.Timer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SnakePanel extends JPanel {
		
	private static final long serialVersionUID = 1L;
	
	int Snake = 2;
	int score;
	int xAxis;
	int yAxis;
	String Direction = "down";
	boolean isRunning = false;
	
	Timer timer;
	Random random;
	Random random1;
	
	SnakePanel snake;
	JButton ResetButton;
	JLabel background;
	
	int R;
	int G;
	int B;
	
	FontMetrics one;
	FontMetrics two;
	FontMetrics three;
	FontMetrics four;
	FontMetrics five;
	
	public static final int width = 770;
	public static final int height = 750;
	public static final int objectDimensions = 25;
	
	static final int speed = 92;
	
	public final int finishProduct = (width * height) / objectDimensions; //this would probably give non int number
	final int x[] = new int[finishProduct];
	final int y[] = new int[finishProduct];
	

	File file = new File("joji.wav");
	AudioInputStream audio = AudioSystem.getAudioInputStream(file);
	
	Clip clip = AudioSystem.getClip();
	
	File file1 = new File("OhBrother.wav");
	AudioInputStream audio1 = AudioSystem.getAudioInputStream(file1);
	
	Clip clip1 = AudioSystem.getClip();
	
		
	public SnakePanel() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
		random = new Random();
		
		this.setPreferredSize(new Dimension(width, height));
		
		random1 = new Random();
		R = random.nextInt(256);
		G = random.nextInt(256);
		B = random.nextInt(256);
			
		this.setBackground(new Color(R, G, B));	
		

//		this.setContentPane(new JLabel(new ImageIcon("Image/grassGif.gif")));
		
		
		setSize(width, height);
		setLayout(null);
		
		start();
		keyOutPut();
		
		clip.open(audio);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
		clip1.open(audio1);
		
		clip.start();
		
	}
	
	public class Keys extends KeyAdapter{
		KeyListener Keys;
	}
		
	public void keyOutPut() { 
		this.setFocusable(true);
		this.addKeyListener(new Keys() {
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				
				case KeyEvent.VK_LEFT:
					if(Direction != "right") {
						Direction = "left";
						
					}
					
					break;
				
				case KeyEvent.VK_RIGHT:
					if(Direction != "left") {
						Direction = "right";
					}
					
					break;
				
				case KeyEvent.VK_UP:
					if(Direction != "down") {
						Direction = "up";
					}
					
					break;
				
				case KeyEvent.VK_DOWN:
					if(Direction != "up") {
						Direction = "down";
					}
					
					break;
				
				case KeyEvent.VK_W:
					if(Direction != "down") {
						Direction = "up";
					}
					
					break;
				
				case KeyEvent.VK_A:
					if(Direction != "right") {
						Direction = "left";
						
					}
					
					break;
				
				case KeyEvent.VK_S:
					if(Direction != "up") {
						Direction = "down";
					}
					
					break;
					
				case KeyEvent.VK_D:
					if(Direction != "left") {
						Direction = "right";
					}
				}

			}
		});
	}
	
	public void start() {
		newApples();
		
		isRunning = true;
		timer = new Timer(speed, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(isRunning) {
					Move();
					checkApples();
					Collisions();

				}
				repaint();
				
			}
		});
		timer.restart();
	}
	
	Image img = Toolkit.getDefaultToolkit().getImage("Image/grassGif.gif");
	Image imge = Toolkit.getDefaultToolkit().getImage("Image/ballerina.gif");

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(isRunning) {
			
		g.drawImage(img, 120, 220, null); 
		g.drawImage(imge, 5, 500, 120, 220, null);
		g.drawImage(imge, 595, 500, 120, 220, null);

		}
		

		try {
			
			Draw(g);
			
		} 
		catch (LineUnavailableException e) {
			
			e.printStackTrace();
			
		} 
		catch (IOException e) {
			
			e.printStackTrace();
			
		}
		

	}
	
	
	public void Draw(Graphics g) throws LineUnavailableException, IOException {
		
		if(isRunning) {
			g.setColor(Color.red);
			g.fillOval(xAxis, yAxis, objectDimensions, objectDimensions);
			
			for(int i = 0; i < Snake; i++) {
				if(i == 0) {
					g.setColor(new Color(60,179,113));
					g.fillRect(x[i], y[i], objectDimensions, objectDimensions);
				}
				else {
					
					R = random.nextInt(256);
					G = random.nextInt(256);
					B = random.nextInt(256);
					
					g.setColor(new Color(R, G, B));
					g.fillRect(x[i], y[i], objectDimensions, objectDimensions);
			
				}
			}
			
			R = random.nextInt(256);
			G = random.nextInt(256);
			B = random.nextInt(256);
			
			g.setColor(new Color(R, G, B));
			g.setFont(new Font("sans serif", Font.BOLD, 40));
			one = getFontMetrics(g.getFont());
			g.drawString("Score: "+score, (width - one.stringWidth("Score: "+ score))/2,g.getFont().getSize());
			
			g.setColor(Color.black);
			g.setFont(new Font("sans serif", Font.PLAIN, 20));
			five = getFontMetrics(g.getFont());
			g.drawString("Turn your Volume up \uD83D\uDD0A", (width - five.stringWidth("Turn your Volume up"))/2, height/8);
						
		} 
		else {
			gameOver(g);
		}
	}
	
	public void newApples() {
		xAxis = random.nextInt((width/objectDimensions))*objectDimensions;
		yAxis = random.nextInt((height/objectDimensions))*objectDimensions;
	}
	
	public void Move() {
		for(int i = Snake; i > 0; i--) {
			x[i] = x[i - 1];
			y[i] = y[i - 1];
		}
		
		switch(Direction) {
		
		case "down":
			y[0] = y[0] + objectDimensions;
			break;
			
		case "right":
			x[0] = x[0] + objectDimensions;
			break;
		
		case "up":
			y[0] = y[0] - objectDimensions;
			break;
			
		case "left":
			x[0] = x[0] - objectDimensions;
			break;
		
		}
		
		
	}
	
	public void checkApples() {
		if((x[0] == xAxis) && (y[0] == yAxis)) {
			Snake++;
			score++;
			newApples();
		}
	}
	
	public void Collisions() {
		for(int i = Snake; i >0; i--) {
			if((x[0] == x[i]) && (y[0] == y[i])){
				isRunning = false;
			}
		}
		
		if(y[0] > height || y[0] < 0) { //first part of snake body touches top of screen
			isRunning = false;
		}
		if(x[0] > width || x[0] < 0) { //first part of snake body touches right of screen
			isRunning = false;
		}

	}
	
	public void clipStop() {
		
		clip.stop();
		clip1.start();
		clip1.loop(Clip.LOOP_CONTINUOUSLY);
				
	}
		
	Image imag = Toolkit.getDefaultToolkit().getImage("Image/tongue.gif");
	
	public void gameOver(Graphics g) {
		R = random.nextInt(256);
		G = random.nextInt(256);
		B= random.nextInt(256);
		
		g.setColor(new Color(R, G, B));
		g.setFont(new Font("sans serif", Font.BOLD, 40));
		two = getFontMetrics(g.getFont());
		g.drawString("Score: "+score, (width - two.stringWidth("Score: "+ score))/2,g.getFont().getSize());
		
		g.setColor(new Color(48, 25, 52));
		g.setFont(new Font("Ink Free", Font.BOLD, 25));
		three = getFontMetrics(g.getFont());
		g.drawString("Better Luck Next Time :P", (width - three.stringWidth("Better Luck Next Time :P"))/2, height/8);
		
		g.setColor(new Color(196, 30, 58));
		g.setFont(new Font("Rock Salt", Font.BOLD, 90));
		four = getFontMetrics(g.getFont());
		g.drawString("Loser!", (width - four.stringWidth("Loser!"))/2, height/4);
		
		clipStop();
		g.drawImage(imag, 80, 170, null); 
		
	}
		
}
