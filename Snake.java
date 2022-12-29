/* Name =  Fatima Dembele
 * NetId = fdembele /  32107296
 * Lab times =  M/W 14:00 - 15:15
 * Lab section = 13 */

package BluePrint;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Snake { 		

	public static void main(String[] args) {
		
		try {
			
			new SnakeFrame();
			
		} 
		catch (UnsupportedAudioFileException e) {
			
			e.printStackTrace();
			
		}
		catch (IOException e) { //snakeFrame
			
			e.printStackTrace();
			
		} 
		catch (LineUnavailableException e) {

			e.printStackTrace();
		} 
		catch (InterruptedException e) {  //snakeFrame
			
			e.printStackTrace();
			
		}


	}
}

