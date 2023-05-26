 # 🐍 Snake-Confetti.io-Game
Remake of the notable Snake Game

# 🎮 Brief Overview of Game: 

I decided to recreate the notable Snake Game which I named Snake Confetti.io. The main
objective of the game is for the user to control the snake using their computer keys to guide the
snake to the apples that appear. Each apple that they manage the snake to ‘eat’, the user gets
one point. However, if the snake touches a part of their body, like the head or tail, or bumps into
the top/left/right/border of the screen, the user loses the game.
To create the game, I created a project folder, and created three classes within it (Snake,
SnakeFrame, and SnakePanel). Within the Snake class, I created an instance of the
SnakeFrame class in its main method. And I also created constructors within the SnakeFrame
and Snake Panel class.
Note: SnakeFrame class was extended by JFrame, so I can have the SnakeFrame class act as
a JFrame, and the SnakePanel class was also extended by JPanel.

# 🏃‍♂️How to run the game:

It’ll be ideal to run the game using the Snake Class, but I don’t think that will be necessary. A
couple things to note is that you might want to run the game 2 or more times because the
background color of the panel changes color every time you enter the game. Also, turn up your
volume when you run the program because I added sound to the program. You can also use
your arrow keys or the W A S B keys on your keyboard to play the game.

# 🖼️ SnakeFrame Class:

Within the SnakeFrame class, I added the SnakePanel class in the Snake Frame constructor. I
utilized the pack() method, so that the components I add to the JFrame can fit around all the
components I add. setLocationRelative was set to null to make the frame appear on the middle
of the users screen.

# 🎛️ SnakePanel Class:

The bulk of our code was written within the SnakePanel class; I declared a bunch of variables
that were necessary to the creation of the game.

# 🌎 Global Variables: [ Not all variables are listed below; some are explained in methods. ]

int Snake = symbolizes the size of the snake prior to it eating the apples

int score = total score of the user

int yAxis = x - coordinate of where the apple is located in random locations of the screen

int xAxis = y - coordinate of where the apple is located in random locations of the screen

char Direction = the direction the snake would appear when the game starts

Boolean isRunning = this was set to false, when the game starts, isRunning is set to True

Timer timer = utilized to have the game run after a certain moment of time

Random random, random1 = utilized to have random numbers as RGB codes

Width = width of our screen

Height = height out screen

ObjectDimensions = how big the objects in the game would big (i.e. snake, apple)

JLabel Background = used to place gif that’s located at the center of the game screen

int R, G, B = variables used to create the random values used to create numerous colors

FontMetrics one, two, three, four, five = used to place string in a certain location of the screen

int speed = (for the timer) sets the motion of the game. The higher the number, the slower that
snake moves.

new int x[ObjectDimensions ] , int y[ObjectDimensions ] = these hold the x and y coordinates for
the body of the snake

int finishProduct = this calculates how many objects can fit on the screen (I think this would
return a decimal value if you don't encapsulate with an int).

# 🎛️ SnakePanel Methods:

1. Draw() Method
In the Draw() method, I created the apples, the head of the snake, as well as the rest of its body.
While If the game is running, then the program would draw an apple on the screen. The color of
the apple is red, and the size of the apple that was set was done in the fillOval method.

If the game is running, then the program would draw the head and body of the snake. A for loop
was utilized to iterate through all the body parts of the snake. If i == 0, then I am dealing with the
head of the snake. Else, the color of the body was set to randomized int values (R, G, B).

Also in the Draw( ) method, I utilized the font metrics variable to draw the current score of the
player. I used the drawString() method which contained the total number of apples eaten which
represents the users total score.

If the game is not running, then in the draw method I call the game over method.

2. newApples( ) method
The main objective of the new Apples method was to generate x, y coordinates of where the
apple will be located on the screen. Each coordinate will be randomized with the help of the
Random class in JAVA. And each coordinate will then be multiplied by the ObjectDimensions
because I want the apple to be placed on the screen in an even fashion.

3. Move( ) method
This method is for the purpose of moving the snake. I created a loop to iterate through all the
body parts of the snake. In the loop, I shifted the body parts of our snake around by a unit of 1 in
the array.

I needed something that would change the direction of the snake because it would not make
sense if the snake was going only in one direction. That’s where I utilized a switch statement to
change the direction of the snake. In the switch statement, if the snake, for instance, was going
up,when the array y was at the index 0, I set that equal to the index of y at 0 minus the Object Dimensions variable to prompt the snake to go in the up position. I replicated this thrice in the
code to change the snake's position when it was going down, left, and right.

4. Collisions( ) method
In the collision method, I first checked to see if the head of the snake would collide with its own
body. To do that, I iterated through the snake's body parts in an if statement. For instance, if the
snake’s head ( index 0 ) is at x[i] -x and y[0] = y[i], then the head of the snake collides with its
body, and I set the isRunning variable to false and call the game over method.

To check to see if the head of the snake touches any of the borders of the screen, I used 2 if
statements. For example if x at index 0 is greater than the width variable, then isRunning
variable is set to equal false and the game over method is called.

5. checkApples( ) method
Within the check Apples method, I would be allowing the snake to ‘“grab” the apple to eat so the
user scores a point.

If x at index 0 (the x position of the snake’s head) is equal to the x position of apple and y at
index 0 ( the y position of the snake’s head) is equal to the y position of the apple, then I
increase the size of the snake by a unit of 1, and the score would increase by 1 as well.
The new Apple method would be called in this method to generate a new apple in a random
location on the screen.

6. GameOver( ) method
In this method, I utilized the font metrics variable to have the user see “Loser!” and “Better luck
next time :p” text once they lose. I also assigned a color to these texts, and placed the text at
the center of the screen.

The final score also was shown with the help of the font metrics variable when the user lost.
I also called the clipStop method that’s responsible for stopping the first sound to play the
second sound, and looping the second audio continuously,

7. start( ) method
In the start method, I call the newApples method to get an apple to appear on the screen. The
boolean variable isRunning was set to be true, and timer was set to equal (speed, new
ActionListener). This was done to the timer variable because this would dictate how fast/slow
the game would go, and also pass the Action Listener because I would be implementing that to
move the snake. 

Within the start method I had the actionPerformed method within it. If the game is running, then
the program would run the move method, Collisions method, and check Apples method. After it
does all that, it then the repaint method is called to redraw the program on the screen. When the
program redraws on the screen, the timer restarts.

8. keyOutPut( ) Method + Keys class
In the Keys class, a KeyListener variable was declared in it. In the keyOutput Method, the keys
that I use to navigate the Snake in the game are programmed in this method. This was done by
placing the keyPressed method inside the keyOutput Method whilst using the KeyListener
variable that was previously declared in the Keys class. Because of this, the user can use the
arrow keys or W/A/S/B to direct the snake towards the apple.

9. clipStop( ) Method
This method is responsible for stopping the first audio that plays when the user is playing the
game, and starting/looping the second audio once the user loses.

10. paintComponent( ) Method
In the paintComponent Method, if the game is running ,then the gif with the grass and the two
ballerinas would appear on the user's screen. When the game is not running those images
would not appear.

# 🔊 Sounds

I wanted there to be sound in the game, so I created a File variable for the sound file as Ill as for
AudioInputStream. To get the audio to play, I utilized the Clip interface to have the sound play in
the background while the user plays and loses. To make the sound file operational, I had to
include clip.open() within my code, and clip.loop() to have the sound continuously loop as the
user plays the snake game. Two sounds played within the program, one sound for when the
user is playing the game, another when the user loses. To stop the first sound and play the
second sound when the user loses, I created a method called clipStop( ).

# 📸 Images

I utilized 3 gif images within my code to make my code a bit decorative and have the aesthetic
of the game match with the male singers voice. For the 2 gif images that appear when the user
first enters the game, I utilized the paintComponent method in my program to place them in their
appropriate locations. I didn’t add any collision detection to the image. When the user loses the
game, I had another gif that would appear with a different sound playing in the background
continuously.

# 🖼 Game's UI
![Game begins]([http://url/to/img.png](https://pasteboard.co/uPs4U6hQGIPM.png))
![User loses game]([http://url/to/img.png](https://i.ibb.co/k6vTdqr/Screen-Shot-2023-05-22-at-05-22-52.png))
