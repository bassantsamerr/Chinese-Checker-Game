***Chinese Checkers Project***

The programming language we used is: 
Java


=======================================================

Our Heuristic is:

-It is divided into 3 sections

-Section 1: 
	Calculating the minimum distance between each marble and the index[17][12], 
	which it will be the farthest distance to make the CPU marble reach the goal, 
	and then adds those distances and store it in a variable called computer.


-Section 2: 
	Calculating the minimum distance between each marble and the index[-1][12], 
	which it will be the farthest distance to make the Player marble reach the goal, 
	and then adds those distances and store it in a variable called player.


-Section 3:
	Our heuristic value will be the difference between the variable player and the variable computer.

	If the returned value is +ve value:
	Thats mean that the player has many moves to reach goal, The computer has the bigger chance to win. 

	If the returned value is -ve value:
	Thats mean that the computer has many moves to reach goal, The player has the bigger chance to win.


=======================================================

Other Information:

-We've choosen Alpha-Beta Purning.

-Our Moves is:
	-hopDownLeft
	-hopDownRight
	-hopTopRight
	-hopTopLeft
	-hopRight
	-hopLeft


-Instructions to run the project:
	1-Choose the level of game 
		-Easy (if you want easy enter 1)
		-Medium (if you want hard enter 2) //it may take long time at computer trun.
		-Hard (if you want hard enter 3) //it may take much long time at computer trun.

	2-Enter the marble coordinate
		-You should enter 2 values which it is X and Y. This is an image which it is a guide to make you enter correct coordinates.
		-https://cdn.discordapp.com/attachments/776889057203978260/981718793334173726/unknown.png
	
	3-There will be a list of possible moves that you can make the marble move to this position. You should choose only one of thoose valid moves.
	
	4-Computer makes its turn and then you will play again and so on till one of you win.     


=======================================================


Our emails are:
bassantsamer@stud.cu.edu.eg
Reemehab9732@gmail.com
Rawanehab124@gmail.com
minasamyy3@gmail.com
sm2422000@gmail.com


=======================================================
Our IDs are:
20190133
20190571
20190213
20190211
20190243