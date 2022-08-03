# WHS-FTC-GramGra07-Code_Training_Mod <a name="top"><a/>
### To help incoming freshman and everyone that needs it understand the coding process and language involved in ftc[^ftc] programming
# Table of Contents
- [Links](#link)
- [Getting Started](#gs1)
  - [Forking](#Forking)
- [Cloning in terminal](#clone)
- [Github Basics](#basics)
  - [Commits](#commit)
  - [Push](#push)
  - [Pull/merge](#pull)
  - [Managing your server](#manage)
- [Coding](#code)
  - [Getting Started](#gs)
  - [Setting up your files](#su)
  - [Using Variables](#var)
  - [TeleOp](#op)
  - [Autonomous](#auto)
  - [Functions](#func)
- [Running your code](#run)
  - [Errors and solutions](#es)
- [Updating your devices](#update)
- [Feedback](#fb)
- [Agknowledgements](#agk)
- [Glossary](#gloss)
- - - - - - - - - 
## Useful Links <a name="link"><a/>
- My [user page][user] (GramGra07)
- FTC[^ftc] Official Github [user page][ftcpage]
- Team Resources [folder][team]
- [Rev Hardware Client][rhc]
- - - - - 
## Getting started <a name="gs1"><a/>
In order to setup your repository[^repo] correctly you will do 2 things. 1. [Fork](#Forking) and 2. [Clone](#clone) this will get the repository[^repo] to your github account and then put that repository[^repo] local on your computer.
  
[Go to top](#top)
### Forking <a name="Forking"><a/>
Go to this [website][ftcpage] and find the latest repository[^repo] from the company. Press the ![fork button][fork] button. This will "copy" the repository onto your github account.
  
[Go to top](#top)
## Cloning in terminal <a name="clone"><a/>
  
[Go to top](#top)
## Github basics <a name="basics"><a/>
Github is organized in a few sections. One,the code section, this is where your code and files are stored. Your repositories, where all of your code is stored and your profile, where all of your repositories are stored.
### Commits <a name="commit"><a/>
  
Commiting is an essential part in every part of coding while connected to github, it makes sure you have the latest edited version of your code local    on your computer, we got the code local to the computer in [cloning](#clone). In a github file it is a green rectangular button at the bottom of the    file that says commit changes, ![gitCommita][gitcommit] when commiting directly from github it strictly gives the code to github, you will not have the code local yet. To make your code local you will need to [pull](#pull) in your code app, most likely android studio. In android studio, the commit button is a check mark in your top right corner.![commita][commit] You are also allowed to commit and push, to be explained later in [push](#push).
  
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
## Coding <a name="code"><a/>
The java coding language that we use is not incredibly hard to learn once you figure it all out.

[Go to top](#top)
### Getting started <a name="gs"><a/>
  
[Go to top](#top)
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
Boolean = True or False
Int = Integer, a whole number
Double = Floating point number
Float = Decimal (up to 7 digits)
String = Text value

Boolean is used to determine whether a value is true or not, an on/off switch
Int is used for a constant value like your team number, a certain value to multiple etc.
Double is used for your motors, this is the best method because it supports all numbers so you can use it for storing gamepad inputs.
Float is most commonly used to store color values
Strings are used to store common strings or text values like a status of initialization

[Go to top](#top)
### TeleOp[^teleop] <a name="op"><a/>
  
[Go to top](#top)
### Autonomous[^auto] <a name="auto"><a/>
  
[Go to top](#top)
### Functions <a name="func"><a/>
  
[Go to top](#top)
## Running your code <a name="run"><a/>
  
[Go to top](#top)  
### Common errors and solutions <a name="es"><a/>
  
[Go to top](#top)
## Updating your devices <a name="update"><a/>

[Go to top](#top)
## Feedback <a name="fb"><a/>
I would love to have feedback on this repository. You can contact me at graymgray07@gmail.com. Thanks!

[Go to top](#top)
## Agknowledgements <a name="agk"><a/>

[Go to top](#top)
## Glossary <a name="gloss"><a/>
[^ftc]: First Tech Challenge
[^repo]: A repository is a folder hosted on github that contains code and items.
[^merge]: Push and pull at the same time using github  
[^teleop]: A TeleOp is an opmode that uses your gamepad inputs to control your robot, it is on the right side of the phone when selecting an opmode.
[^auto]: A  Automonous opmode is an opmode that continuously loops for 30 seconds at the beginning of the each match, it is on the left side of the phone when selecting an opmode.

  
  
[rhc]: https://docs.revrobotics.com/rev-hardware-client/getting-started/installation-instructions
[ftcpage]: https://github.com/FIRST-Tech-Challenge
[user]: https://github.com/GramGra07
[team]: https://github.com/WindsorHSRobotics/Team_Resources

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
