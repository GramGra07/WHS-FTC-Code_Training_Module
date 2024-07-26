# General Tips

**Tips and Tricks**

1\. PRACTICE!!

* It is known that if you practice something, you will get better at it over time, this is the same for coding and robotics

#### 2. Ask Questions

* A lot of people know what they are doing and are willing to help if you just ask

#### 3. If you don't know a concept, look it up

* There are a lot of helpful solutions and people on the internet, someone **WILL** usually know the answer to your problem

#### 4. READ

* All of the example opModes have very helpful comments to show you exactly what each part does, also if you read this whole thing you should be good to go

#### 5. Collaborate

* A lot of problems can be solved by collaboration with friends and peers

#### 6. Use prior knowledge

* Even if your prior knowledge is in a different language, it **will** help you understand this code.

**7. Trust your IDE**

* Your IDE will prevent most common problems if you trust that it knows what its doing, which it does

### Create a config.md file in your code:

This has saved me so many times with motor and servo naming and where they are supposed to be put. This allows you to have a config map of every single thing you have connected to your robot. This helps with the configuration of the Control Hub as you can just refer to this document. Create this by right clicking on the folder you want it in, add file, name = config.md, and then just copy this text in to the file.

```
Only a template, don't edit this file, copy it and make a new file
Format: # - type : name

Control Hub
Motor
0 -
1 -
2 -
3 -
Encoder (will only be different if a different encoder is in the same slot as a different motor)
0 -
1 -
2 -
3 -
Servo
0 -
1 -
2 -
3 -
4 -
5 -
Digital
0 -
1 -
2 -
3 -
4 -
5 -
6 -
7 -
I2C Bus
0 -
1 -
2 -
3 -
Analog
0 -
1 -
2 -
3 -

RS485 -
USB -

Expansion Hub
Motor
0 -
1 -
2 -
3 -
Encoder
0 -
1 -
2 -
3 -
Servo
0 -
1 -
2 -
3 -
4 -
5 -
Digital
0 -
1 -
2 -
3 -
4 -
5 -
6 -
7 -
I2C Bus
0 -
1 -
2 -
3 -
Analog
0 -
1 -
2 -
3 -

RS485 -
USB - 
```
