1. 2D Arrays - used a 2D array of integers for the 6 by 6 grid/board, and each
  empty cell is represented with the number 0 (even though 0 itself does not appear
  on the grid). Each non-empty cell is represented by some power of 2 all the way
  to 2^13 = 8192.

  2. Collections - created a Set storing all unique tile values appearing on the
  gameboard, with the TreeSet maintaining the elements in sorted order. The class
  interacts with the Collections framework in that elements can be added to the Set
  after generating a new random tile, allowing for a nested loop to iterate over all
  board tiles. We use Collections to determine whether our method for checking if
  the player has won returns true for the value of 8192 being contained in the Set.

  3. File I/O - enabled the player to store the current game state in a plain text
  format (CSV file) after clicking a "Pause and Save Game" button. This is so that
  the player can return to the game later and try to finish it after clicking a
  "Load Previous Game" button, which would load the pre-saved game state from the
  CSV file and auto-populate the 2D array.

  4. JUnit Testable Component - If the player clicks "A" or the left arrow, all
  tiles move left; "D" or the right arrow, all tiles move right; "W" or the up
  arrow, all tiles move up; and "S" or the down arrow, all tiles move down. In
  addition to tests for making sure that the keyboard shortcuts work, no other
  keyboard shortcuts have an effect on the game, and the previously saved game
  can be reloaded from the plain text CSV file, I will test the following cases:
   - The player wins when a tile reaches 2^13 = 8192.
   - The player loses when there are no empty tiles and player is unable to move
   in any direction.


Game.java class - The Game.java class contains a main method that initializes a
Runnable object with an instance of Run8192, and then uses SwingUtilities.invokeLater
to run the game. The main method is essential and should not be deleted.

Gameboard8192.java class - The Gameboard8192.java class represents the game board
of a 6x6 grid-based game, 8192, and follows the Model-View-Controller design framework.
The class has a Game8192 object as its model, and acts as both the view (with its
paintComponent method and status JLabel) and the controller (with a KeyAdapter for
handling key presses). The class contains methods to initialize the game board, save
and load games, reset the game, update the status JLabel, draw the game board, and
get the current game state as a CSV-formatted string. It also defines game constants
for board dimensions and cell size.

Game8192.java class - The Game8192.java class represents a model for the 8192 game.
It consists of a 6x6 board and provides methods to play the game, including moving
tiles up, down, left, or right, merging them if necessary, and updating the score.
The game starts with two random tiles placed on the board, and new tiles are added
after each valid move. The game ends when no valid moves are left. The class provides
methods to check if the game is over, if the player has won, and to print the current
game state for debugging purposes. The class demonstrates modularity by allowing the
game to be played without any user interface, using only the model's methods.

Run8192.java class - The Run8192.java class sets up the top-level frame and widgets
for the 8192 game's GUI using the Model-View-Controller design framework. It creates
a JFrame containing a status panel, a game board, a control panel with reset, load,
and save buttons, and an instructions window. The reset button resets the game board,
the load button opens a file chooser to load a saved game, and the save button opens
a file chooser to save the current game state. When run, the class displays the game
window and starts a new game.

Test8192.java class - The Test8192.java class is a JUnit test suite for the Game8192
class. It contains several test cases that check the functionality of the game by
simulating different move scenarios like moving left, right, up, and down using arrow
keys and their respective alphabetic counterparts (A, D, W, S). The tests also cover
edge cases like checking if the board is full without an 8192 tile and when the board
is full with an 8192 tile. The tests use the assertArrayEquals method to verify the
correctness of the game's state after each move.
