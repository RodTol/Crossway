# Crossway 
#### Authors: R. Tolloi, M. Corsano, and G. Bernardi
### Built with:

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
[![<DSSC>](https://circleci.com/gh/RodTol/Crossway.svg?style=shield)](https://app.circleci.com/pipelines/github/RodTol)
## About this repository
This repository contains the project for the Software Development exam, A.Y. 2021/2022.
It is an implementation of the game Crossway in Java, comprehensive of a Graphic 
User Interface.

This project was developed following the principles of AGILE software developing and
Test Driven Developing. Every part of the code was written on IntelliJ and GitHub was
used as a version control system. Gradle was used to make building and testing tasks more automated
and CircleCI for Continuous Integration.

## How to download and run the game
The only required software is OpenJdk-17, which can be installed through this page: https://jdk.java.net/archive/.
Once OpenJdk-17 is installed, the user can download the executable files from the
[distribution's directory](build/distributions), or with a single click on the button below.

<!-- BEGIN LATEST DOWNLOAD BUTTON -->
[![Download zip](https://custom-icon-badges.herokuapp.com/badge/-Download-blue?style=for-the-badge&logo=download&logoColor=white "Download zip")](https://github.com/RodTol/Crossway/raw/main/build/distributions/Crossway-DSSC.zip)
<!-- END LATEST DOWNLOAD BUTTON -->

Once the distribution is downloaded and extracted, the user can run the
program with the following commands (from the extracted directory):  
Windows:
```
bin\Crossway.bat
```  
Linux:
```
./bin/Crossway
```

## Rules of the game   
Crossway is a 2-players game played on a 19x19 board that starts
empty, as shown in the picture below.

<p align="center">
  <img height="400" src="Pictures/EmptyBoard.png" alt="">
</p>

At the beginning of the game, each player chooses a colour 
between black and white. The black will place a piece first. 
Then, the players will keep alternating placing one piece per
turn. 

When the white player begins their first turn, they will have 
two options:
* placing a white piece wherever they prefer
* calling the "Pie Rule", which means stealing the black piece
already placed on the board

If the second option is chosen, the players will effectively
switch colours, and then the game will go on normally.

Pieces are to be placed on the intersections of the lines drawn
on the board. As shown in the below image, a transparent piece
will appear in the possible piece positions as the player moves
the mouse on the board.

<p align="center">
  <img height="400" src="Pictures/BoardWithGhost.png" alt="">
</p>


To place a piece, the player needs to click on the chosen
position. The turn of the other player will then begin. 

The objective of the game is to form a contiguous sequence of 
white stones connecting the left edge of the board to the right
one for the white player, and to form a contiguous sequence of
black stones connecting the top edge of the board to the bottom
one for the black player.

When it is their turn, the player can place the piece wherever 
they prefer on the board; the only conditions are that the 
chosen position is not already occupied by another piece and that
 the below formation (or the symmetric one, with the white pieces
in place of the black ones and viceversa) does not occur.

<p align="center">
  <img height="100" src="Pictures/IllegalPosition.png" alt="">
</p>

The software does not allow this placement and the GUI will not
display the transparent guide piece on coordinates that create
this issue. In this way, the player will be helped towards a 
correct piece placement.

If no possible placements are allowed for a player, they will 
skip their turn and the opponent will continue to place their
pieces until victory.
An "I give up" button is available to the players after the second turn.  
A "Play demo" button is also present in the initial screen; if
it is clicked, a demonstration of the game will start.

## Project structure
Inside the [Structure.md](Structure.md) you can find a brief explanation of
the project structure. Before starting to work on some kind of contribution,
we suggest to have a look at it.

## How to contribute to the project
If you want to contribute to the project you can raise a [issue](https://github.com/RodTol/Crossway/issues)
or fork the project and create a pull request, we will be happy to have a look at it.  
Don't forget also to star the project! :star:


## License

Distributed under the MIT License. See [LICENSE.txt](LICENSE.txt) for more information.