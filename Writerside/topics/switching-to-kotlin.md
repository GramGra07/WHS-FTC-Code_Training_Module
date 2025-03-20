# Switching to Kotlin

### What is it?

Kotlin is a more modern version of Java, which allows for class extensions, null safety, and good class organization.  All of these reasons are good reasons to switch, but there is a high level of Java knowledge needed to make the switch effectively.

#### Class Extensions

Class extensions are a way of adding your own code to an already existing class. You could use this to for instance, convert a double to a string, if that isn't already in the class.

You do this like the following:

```java
Class.functionName(parameters){}
```

#### Null Safety

Null Safety is a much more complex concept to handle. It allows you to make calls like `?.` , which allows it to check that a value is not null, before performing the selected operation. It also allows you to make "optional" variables. This means that the variables can be null or will be initialized later. This is done by doing `var motor: DcMotor? = null` where the ? is the optional null part that we have added. This allows you to initialize the variable later in the program. You can also do this from a `lateinit` command. Done with `lateinit var motor: DcMotor`, this allows you to have more safety in the program because it will throw an error explaining the exact problem that's happening with the robot. This is important because you might not have found that problem without the null safety. It also allows you to force variables to not be null. This is done with `name!!`, which essentially means name is forced to have a value other than null. This also allows it to be way more safe because there cannot physically be a null value without the code catching it.

### Why switch?

Switching is a fairly short process if you don't want to use some of the more advanced features, otherwise, it can take a fairly long time depending on how experienced you are. Some advantages of kotlin over Java are like I said before, class extensions and null safety. Along with that, you don't have to initialize or specify the type of each variable like in Java. This allows for more errors to come up sometime with a type mismatch, just because it isn't being verified that the value is of the correct type. This allows for a bit more freedom with your class structure and variables. Some cons of kotlin over Java are that it is a more complex language, and there won't be nearly as much support online as to how to code in kotlin. On the other hand, on the FTC Discord channel, many people do use kotlin, so I have been able to find support through there. Along with all of this, kotlin does not make you use semicolon's at the end of every line, fixing one of the most common problems with new programmers.

### Why stay?

Kotlin requires a lot of knowledge of Java and programming in general to effectively switch. If you are a rookie member with not much experience in coding, I would recommend staying for ease of use and just to get into the program. For context, I made the switch in my 3rd year of FTC and 6-7th year of programming overall.

### How to switch

FTC provides a resource to show how to switch [here](https://ftc-docs.firstinspires.org/en/latest/programming_resources/shared/installing_kotlin/Installing-Kotlin.html)

Other than that, if you have your classes already made in Java, you can right-click on it, and press the switch to kotlin button. This will automatically make Android Studio convert the code between the two making for a simple switch. There will most likely be problems with the switch, just because of the switch of language.

### Resources

A cookbook article about switching to kotlin, also explaining the pros and cons to kotlin and java [here](https://cookbook.dairy.foundation/misc/why_kotlin/why_kotlin.html)
