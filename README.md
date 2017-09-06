# Furhat Packing Game
This system was created as part of the submission of my masters thesis which has the title **An Evaluation of the Ethnic Appearance of Virtual Agents and Social Robots**. To evaluate the field of interest, several experiments were conducted, in which participants were asked to interact with a virtual embodied agent. This system, the Furhat Packing Game, was the one used for the interaction. It is based on the IrisTK template *situated-dialog* by Gabriel Skantze. The system was tried and tested on a Furhat robot before. To make sure that Furhat's speech recogniser works seamlessly, check if you have unrestricted access to the internet.

## Rules of the Game
The packing game is based on the German children's game 'Ich packe meinen Koffer'. It is a dialogue-based memory game in which the goal is to remember as many items as possible. Its rules are as follows:
  - Player 1 starts by saying “I pack my bag and I take with me: ” and adds an item to the packing list
  - Player 2 then repeats the exact sentence word for word and adds a second item to the packing list
  - Player 1 then repeats the above sentence and, again, adds another item to the packing list
  - This continues until either player, ceases to remember all the items or their exact order in the packing list 

The game dialogue might look something like this:

**Player 1:** *I pack my bags and I take with me a toothbrush*
**Player 2:** *I pack my bags and I take with me a toothbrush and a shaver*
**Player 1:** *I pack my bags and I take with me a toothbrush, a shaver and a bottle of sunscreen*
**Player 2:** *I pack my bags and I take with me a toothbrush, a shaver and... I forgot which item comes next. You win.*

## Running the System
The system was built with the [IrisTK](http://www.iristk.net/) dialogue system framework. It offers an integration of microphones, speech recognisers and cameras to allow for social robotics applications. IrisTK can be downloaded [here](http://www.iristk.net/download.html). Note that IrisTK can only work on Windows machines.
For most of the speech recognisers, internet access is required. Furthermore, you need a microphone. Though it is not needed for the system to work, you can connect and enable a Microsoft Kinect (in *PackingGameSystem.java*), which will provide a more engaging interaction.
Once IrisTK is set up, as well as the relevant modules are connected, you can simply run the app via the command

    irisTK Furhat-Packing-Game
    
Depending on which speech recogniser you choose (you can do so that in the main object *PackingGameSystem.java*), make sure you read the relevant [documentation](https://docs.myfurhat.com/recognizers/) on how to set up the needed cloud service accounts.

## Description of the Relevant Package Files
The following table summarises which files are revelant for editing the stystem
|Package File|Description|
|--|--|
|PackingGameSystem.java|This is the Java file that contains the main method. Here, you can set up the relevant modules, such as the speech recogniser, Kinect, etc.|
|||

## Known Faults
- When conntected to a Kinect, the system fails to recognise a person who is alreeady present in the interaction space. Instead of automatically starting the interaction, it remains idle. You will need to exit and reenter the interaction space to start the interaction.
- The speech recognition was proven to be unreliable when handling accents which are not Standard American English. As the speech recognition is outsourced, there is not much one can do about this, except for maybe trying to change the language setting of the speech recogniser (in *skill.properties*). For Google Speech, the list of supported languages, which includes several variants English can be found [here](https://cloud.google.com/speech/docs/languages).

## Contact
Want to ask me something? Write an email to [cynthia.htlee@gmail.com](mailto:cynthia.htlee@gmail.com).

---------------------------------------------
Cynthia Lee, 2017


