# WHS-FTC-GramGra07-Code_Training_Mod <a name="top"><a/>
### To help incoming freshman and everyone that needs it understand the coding process and language involved in ftc[^ftc] programming
### If you have questions, email me at graymgray07@gmail.com or start a new discussion in this repository
# Table of Contents
- [Links](#link)
- [Tips and Hints](#hint)
- [Getting Started](#gs1)
  - [Forking](#Forking)
  - [Cloning the repository](#clone)
- [Github Basics](#basics)
  - [Commits](#commit)
  - [Push](#push)
  - [Pull/merge](#pull)
  - [Managing your server](#manage)
  - [Personal Access Token](#atl)
- [Coding](#code)
  - [Code Basics](#cbasics)
    - [What is a...](#whatis)
  - [Getting Started](#gs)
  - [Setting up your files](#su)
  - [Using Variables](#var)
  - [TeleOp](#op)
  - [Autonomous](#auto)
  - [Editing your code](#edit)
  - [Functions](#func)
- [Running your code](#run)
  - [Errors and solutions](#es)
- [Updating your devices](#update)
- [Overall game](#game)
- [Feedback](#fb)
- [Agknowledgements](#agk)
- [Glossary](#gloss)
- - - - - - - - - 
## Useful Links <a name="link"><a/>
- My [user page][user] (GramGra07)
- FTC[^ftc] Official Github [user page][ftcpage]
- Team Resources [folder][team]
- [Rev Hardware Client][rhc]
- [FTC BasicOpModeLinear (21-22)][lop]
- [Game Format](#game)
- [Game Manual 0][gm0]
- [FTC Resource Library][lib]
- - - - - 
## Tips and Hints <a name="hint"><a/>
### 1. PRACTICE!!
- It is known that if you practice somthing, you will get better at it over time, this is the same for coding and robotics
### 2. Ask Questions
- The WHS team has a lot of intellegent people who would love to help you if you simply ask
### 3. If you don't know a concept, look it up
- There are a lot of helpful solutions and people on the internet, someone **WILL** usually know the answer to your problem
### 4. READ
- All of the example opModes have very helpful comments to show you exactly what each part does, also if you read this whole thing you should be good to go
### 5. Collaborate
- A lot of problems can be solved by collaboration with friends and peers
### 6. Use prior knowledge
- Even if your prior knowledge is in a different language, it **will** help you understand this code.
- - - - - - - -
## Getting started <a name="gs1"><a/>
In order to setup your repository[^repo] correctly you will do 2 things. 1. [Fork](#Forking) and 2. [Clone](#clone) this will get the repository[^repo] to your github account and then put that repository[^repo] local on your computer. Remember **only one person will need to fork the repo** then you will share it to the rest of your team. You will go through ![settingsa][step1] and to **collaborators** then add your team members using the add people button.
  
[Go to top](#top)
### Forking <a name="Forking"><a/>
Go to this [website][ftcpage] and find the latest repository[^repo] from the company. Press the ![fork button][fork] button. This will "copy" the repository onto your github account. Remember **only one person will need to fork the repo**!
  
[Go to top](#top)
### Cloning the repository <a name="clone"><a/>
To clone the repository, first find it on your github profile. You have 2 options on what to do you can do it through android studio or through github.
**Everyone will need to do this!!**

Android Studio:
Tap ![fila][file], then ![newa][new] , ![vcsa][vcs]. Go back to your repository[^repo] and copy the url, paste it into the box and make sure the destination is desktop. You might need to have an [access token](#atl) to do this.
  
Github:
Navigate to the repository you want to clone. Tap ![codea][code] then select ![zipa][zip]. This will download it to your computer. Extract the zip file (double click) and move it to desktop. Then, go back to Android Studio. Tap ![filea][file] then ![opena][open] and select the path where the folder is (desktop).
  
[Go to top](#top)
## Github basics <a name="basics"><a/>
Github is organized in a few sections. One, the code section, this is where your code and files are stored. Your repositories, where all of your code is stored and your profile, where all of your repositories are stored.
### Commits <a name="commit"><a/>
  
Commiting is an essential part in every part of coding while connected to github, it makes sure you have the latest edited version of your code local    on your computer, we got the code local to the computer in [cloning](#clone). In a github file it is a green rectangular button at the bottom of the    file that says commit changes, ![gitCommita][gitcommit] when commiting directly from github it strictly gives the code to github, you will not have the code local yet. To make your code local you will need to [pull](#pull) in your code app, most likely android studio. In android studio, the commit button is a check mark in your top right corner.![commita][commit] You are also allowed to commit and push, to be explained later in [push](#push). You will also need a commit message to be able to [push](#push) the commit.
  
[Go to top](#top)
### Push <a name="push"><a/>
  - What is a push?
    - A push will essentially do exactly as it says, push the code to github. This makes sure that you not only have the latest version of code locally, but also sent to github through the cloud. This is essential for working on code together as a team and collaborating. The push button is the arrow next to the commit button, it will be pointing out, where you want the code to go.![pusha][push] Commit and push does both at the same time to simplify the process. Also see [pull/merge](#pull)
  
[Go to top](#top)
### Pull/merge <a name="pull"><a/>
 - What is a pull?
    - A pull is the exact opposite of a [push](#push). It will take the currennt version of the code directly from github and sync it locally to your device/coding app. This is also essential as it allows you to get the teams latest version of code. This is helpful when multiple people are working on code all at once. If you are [pushing](#push) sometimes it will ask you to merge[^merge] your current code, this means you dont have the latest version, not to worry though as if you say yes github will automatically merge[^merge] and add your code to the latest code. The pull button is an arrow pointing in, or towards your computer. ![pulla][pull]
  
[Go to top](#top)
### Managing your server <a name="manage"><a/>
Managing a server is really not that hard if you do it correctly from the start. There is a settings ![settingsa][setting] button in your repository[^repo], in this tab you will find a bunch of options, it is better if you don't mess with anything that you don't know what it does. In the collaborator tab you will need to add @stcline (if you are a part of WHS). Other than that there are really no settings you need to mess with except maybe email notifications if you would like that.
  
[Go to top](#top)
### Personal Access Token <a name="atl"><a/>
In github, tap on your profile ( top right corner ), then:
  
1. ![step1a][step1]  
2. ![step2a][step2]  
3. ![step3a][step3]  
4. ![step4a][step4]  
5. ![step5a][step5]  
6. ![step6a][step6]  ( Select all, it will work better that way )
  
[Go to top](#top)
## Coding <a name="code"><a/>
The java coding language that we use is not incredibly hard to learn once you figure it all out. It follows all of the coding fundamentals you may already know.

[Go to top](#top)
# **IMPORTANT** when editing your code, only edit it in the **teamcode** section, you will have to copy and paste the files from the external samples. **DO NOT** edit the ftc robot controller sample code
### Coding Basics <a name="cbasics"><a/>
Go through this section if you have no expirence coding, if you are expirenced, [skip](#gs).
### What is a... <a name="whatis"><a/>
- Variable
- Function
- If statement

### Getting started <a name="gs"><a/>
- General Knowledge
  - ```;``` must be at the end of every line except if it ends in ```{``` or ```}```
  - ```{``` is used to begin the code for the function, ```}``` ends the function
### Setting up your files <a name="su"><a/>
Refer to the blank examples [TeleOp][beTele] and [Auto][beAuto]. These both have the proper setup and code to get started coding both of these modes. I will get into more detail into what everything means in [TeleOp](#op) and [auto](#auto).

[Go to top](#top)
### Using variables <a name="var"><a/>
Variables in java consist of:
```
boolean
int
double
float
String
```
- Boolean = True or False
- Int = Integer, a whole number
- Double = Floating point number
- Float = Decimal (up to 7 digits)
- String = Text value

Boolean is used to determine whether a value is true or not, an on/off switch
  
Int is used for a constant value like your team number, a certain value to multiple etc.
  
Double is used for your motors, this is the best method because it supports all numbers so you can use it for storing gamepad inputs.
  
Float is most commonly used to store color values
  
Strings are used to store common strings or text values like a status of initialization

- When to use public vs. private variables?
  - You generally want to always use public unless it is something that you don't want to share with other opmodes, like a runtime.
  
[Go to top](#top)
### TeleOp[^teleop] <a name="op"><a/>
Here is the [FTC BasicOpMode (21-22)][lop] it uses 2 motors.
In the [blank TeleOp Example][beTele] you will find that there are 20 lines
```
//imports
@TeleOp(name="exampleTeleOpBlank",group="Pushbot")
//@Disabled
public class exampleTeleOpBlank extends LinearOpMode {
    HardwarePushbot robot = new HardwarePushbot();
    private ElapsedTime   runtime = new ElapsedTime();
    @Override
    public void runOpMode(){
        runtime.reset();
        getRuntime();
        waitForStart();
        while (opModeIsActive()){
            getRuntime();
            telemetry.addData("Time:", String.valueOf(runtime));
        }
    }
}
  ```
First, comments are indicated by //
  
Imports are how you get the references and all the different pieces to the code.
  
Next we have ```@TeleOp(name="exampleTeleOpBlank",group="Pushbot")```, this means that this opmode is being classified under the teleop section, with the name "exampleTeleOpBlank" and it is being placed in the Pushbot group
  
Now we have the ```public class exampleTeleOpBlank extends LinearOpMode{``` this means that this opmode can now be used as a base opmode, extending an opmode means that all variables and functions are shared between the opmodes. In this case the file is extending the Linear Op Mode file which you will be able to find in your forked repository.
  
Next we have our ``` HardwarePushbot robot = new HardwarePushbot(); ``` and ```private ElapsedTime   runtime = new ElapsedTime();``` the first part declares the robot as a robot, we will be using pushbot software for the season. Elapsed time is a very important thing to consider, it times the round as it is going. You can use this for a lot of things including having an endgame timer and restricting your [auto](#auto) time to 30 seconds.
  
Next we have the function ```public void runOpMode(){``` this runs when you press Init it will run that part. Remember, when you hit Init, it is not running the whole program yet, just the small part in between runOpMode and opModeIsActive.
  
Now we will run ```runtime.reset();``` and ```getRuntime()```, these are required in order for your runtime to be correct.
  
```waitForStart();``` tells the opmode to wait until the user presses go, when this happens, everything inside this function runs.
  
```telemetry.addData("Time:", String.valueOf(runtime));```, telemetry is your equivalent of printing data in python and other languages, using this will print onto your phone, "Time: 60(or what the time is).
  
[Go to top](#top)
### Autonomous[^auto] <a name="auto"><a/>
In the [Blank Autonomous Example][beAuto] you will find 18 lines.
```
//imports
@Autonomous(name="exampleAutoBlank", group="Autonomous")
//@Disabled
public class exampleAutoBlank extends exampleTeleOpBlank {  //your doc name *extends* your main code branch
    private ElapsedTime   runtime = new ElapsedTime();
    @Override
    public void runOpMode(){
        runtime.reset();
        getRuntime();
        waitForStart();
        //actual code
        while (getRuntime()<=30) {
            getRuntime();
            telemetry.addData(String.valueOf(runtime), "Working");
        }
    }
}
```
Imports are how you get the references and all the different pieces to the code.
  
Next we have ```@TeleOp(name="exampleAutoBlank",group="Autonomous")```, this means that this opmode is being classified under the autonomous section, with the name "exampleAutoBlank" and it is being placed in the autonomous group
  
Now we have the ```public class exampleAutoBlank extends exampleTeleOpBlank{``` this means that this opmode can now be used as a secondary opmode. In this case the file is extending the exampleTeleOpBlank file.
  
Now we don`t have to use ``` HardwarePushbot robot = new HardwarePushbot(); ``` because it has been shared through extension but we have to do ```private ElapsedTime   runtime = new ElapsedTime();``` because it is private.
  
Next we have the function ```public void runOpMode(){``` this runs when you press Init it will run that part. Remember, when you hit Init, it is not running the whole program yet, just the small part in between runOpMode and opModeIsActive.
  
Now we will run ```runtime.reset();``` and ```getRuntime()```, these are required in order for your runtime to be correct.
  
```waitForStart();``` tells the opmode to wait until the user presses go, when this happens, everything inside this function runs.
  
```while (getRuntime()<=30) {
       getRuntime();
       telemetry.addData(String.valueOf(runtime), "Working");
  }
  ```
  
This gets the runtime, checks it and if it is less than or equal to 30 seconds, it keeps running. If it is over or equal to 30, it stops.

[Go to top](#top)
### Editing your code <a name="edit"><a/>
One major part is editing your code, to do this you will open your project in android studio, then tap FTC Robot Controller/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples to get to the samples, you will need to find the teamcode part to edit your code correctly.

### Functions <a name="func"><a/> [^ape]
- What is the format?
 ``` 
  public void imaginaryFunction(){
    //code
  }
  ```
- What about parameters?  
 ```
 public void imaginaryFunction2(int hi, boolean hello){
    if (hello == true){
      //do something
      int hi+=1;
    }
  }
  ```
- What about calling a function?
```
  imaginaryFunction(6,false);
```
- Returning values?
```
 public int imaginaryFunction3(int hi, boolean hello){
    if (hello == true){
      //do something
      int hi+=1;
      return hi;
    }
  }
```
You will see that this is saying public int, you use void if you are returning nothing, and the [proper variable type](#var) if you are returning something. This would be called as, ```telemetry.addData("Number",String(imaginaryFunction3(9,true)))``` [^ape]

Hint: String puts the value into string form [^ape]
  
Hint2: Int() puts the string into int form [^ape]

  
[Go to top](#top)
## Running your code <a name="run"><a/>
To put the code onto your robot, you will plug in the RC[^rc] phone or the control hub to your computer and press the ![runa][run] button. It will take a bit to load and once it finishes, you can disconnect and then go to your DS[^ds] phone and select your opmode, then select the run button once, tap it again and your code will run.
  
[Go to top](#top)  
### Common errors and solutions <a name="es"><a/>
To be filled in as problems occur.  
  
[Go to top](#top)
## Updating your devices <a name="update"><a/>
Go to this [website][rhc]. It will take you to rev hardware client. Once you download the app you will be able to connect the DS[^ds] phone[^ape2] or the Control Hub and it will show you your possible updates, take them all and you are good to go!
  
[Go to top](#top)
## Overall Game <a name="game"><a/>
The game begins with a 30 second [autonomous](#auto) period, runtime helps us achieve this, and then a 2:30 minute [TeleOp](#op) period, the goal is to score as many points as possible.
  
[Go to top](#top)
## Feedback <a name="fb"><a/>
I would love to have feedback on this repository. You can contact me at graymgray07@gmail.com. Thanks!

[Go to top](#top)
## Agknowledgements <a name="agk"><a/>
- [Google][ggl]
- [Mr Cline][clineuser]
- [Mr Mayfield][juser]
- [FTC User Page][ftcpage]
- [Rev Robotics][rev]
- [Android Studio][aslink]
#### Proofreaders
- [Sir C Timmons][cuser]
- [Sir B Sanger][buser]
  
[Go to top](#top)
## Glossary <a name="gloss"><a/>
[^ftc]: First Tech Challenge
[^repo]: A repository is a folder hosted on github that contains code and items.
[^merge]: Push and pull at the same time using github  
[^teleop]: A TeleOp is an opmode that uses your gamepad inputs to control your robot, it is on the right side of the phone when selecting an opmode.
[^auto]: A  Automonous opmode is an opmode that continuously loops for 30 seconds at the beginning of the each match, it is on the left side of the phone when selecting an opmode.
[^ape]: My apoligies if this doesn't work, some code software allows this exact code, some doesn't.
[^ape2]: Some devices accept this.
[^ds]: Driver Station
[^rc]: Robot Controller
  
  
[rhc]: https://docs.revrobotics.com/rev-hardware-client/getting-started/installation-instructions
[ftcpage]: https://github.com/FIRST-Tech-Challenge
[user]: https://github.com/GramGra07
[team]: https://github.com/WindsorHSRobotics/Team_Resources
[rev]: https://www.revrobotics.com/
[clineuser]: https://github.com/stcline
[aslink]: https://developer.android.com/studio
[ggl]: https://www.google.com/
[lop]: https://github.com/FIRST-Tech-Challenge/FtcRobotController/blob/master/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples/BasicOpMode_Linear.java
[cuser]: https://github.com/ctimmons25
[juser]: https://github.com/JohnMayfield
[buser]: https://github.com/sangerb19
[gm0]: https://gm0.org/en/latest/
[lib]: https://www.firstinspires.org/resource-library/ftc/game-and-season-info
  
[fork]: /images/fork.png
[gitcommit]: /images/gitCommit.png
[commit]: /images/commit.png
[push]: /images/push.png
[pull]: /images/pull.png
[run]: /images/run.png
[setting]: /images/settings.png
[beTele]: /examples/exampleTeleOpBlank
[feTele]: /examples/exampleTeleOpFull
[beAuto]: /examples/exampleAutoBlank.java
[feAuto]: /examples/exampleAutoFull.java
[code]: /images/code.png
[zip]: /images/zip.png
[vcs]: /images/vcs.png
[at]: /images/at.png
[step1]: /images/step1.png
[step2]: /images/step2.png
[step3]: /images/step3.png
[step4]: /images/step4.png
[step5]: /images/step5.png
[step6]: /images/step6.png  
[file]: /images/file.png
[open]: /images/open.png
[new]: /images/new.png  
