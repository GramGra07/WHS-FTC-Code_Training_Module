# Classes

### Object Oriented Programming

Object-Oriented Programming (OOP) is a programming paradigm based on the concept of classes and objects. It provides a structured way to organize code, making it more modular, reusable, and easier to manage. OOP helps reduce errors by encapsulating data and behavior within classes, reusing code, and minimizing duplication.

In the context of FTC, you might use OOP to create a custom DcMotor class that extends or enhances the built-in DcMotor functionality, allowing for additional features such as preset motor speeds, automated braking, or advanced control algorithms.

For a generic example, if you had a Person class with two parameters and variables, name and age. If you wanted to do this exact thing, you would create the Person class, and then access that property later in the program. Example below

```java
class Person {
    String name;
    int age;

    // constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// initialize the class
Person bob = new Person("bob", 29);
// access bob's name
bob.name;
// access his age
bob.age;
```

### State Based Class

See [this](subsystem-control.md)

State based classes and subsystems are a little different from the base level subsystem like above. These are commonly used for servos or other simple classes that have foreseeable states. For instance, my claw subsystem class, included completely below, uses states for the claws and for the flip servo. Then, when it calls the update function, it will move the servos to the correct position based on the state it is in.

Unfortunately, you will not be able to use this code but use it as an **example**

The parts of this code include:

The enums, which control and operate the states

Variables that contain the states

The constructor (including my own initialize function)

Functions that set the variables correctly (these are needed because it could be confusing to just set the variable differently in the program)

The update function which will use a switch statement to control the claw and flip servo using my own commands

### Private Variables/Functions

Private variables are variables that can only be used inside the class they are defined within. This allows for more code security so you don't accidentally mess something up. For instance, if you have a class that is for calculating ticks per inch, you don't want to accidentally change the ticks per inch variable in the main program and instead make that var private.

As for public variables, these are variables that can be used outside the class they are defined within. This allows for more flexibility in the code, but also makes it easier to mess up. For instance, if you have a class that is for calculating ticks per inch, you want to be able to access the variables used for calculating ticks per inch in the main program.

### Static Variables/Functions

Static variables are variables that can be shared and used in different classes at any time. A very good example of when you would use this is if you are using a class to store positions for a servo, you would want `static` variables for the positions so you can access them in the main program. This is also true for functions, if you have a function that is used in multiple classes, you would want to make it static so you can access it in any other program you want to.

When using FTC Dash, the variables must be static, or they will not be able to be accessed in the dashboard.

### Class Functions

Functions inside classes are one of the most important parts of the class. These control the overall function of the class and allow you to call methods using the class.

Example:

```java
class Person {
    String name;
    int age;

    // constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // function to get the name
    public String getName() {
        return name;
    }

    // function to get the age
    public int getAge() {
        return age;
    }
}
```

In this example, getName() returns a String of name, and getAge() returns an int of age. In this way, you could also have `void` functions that do not return anything, but instead do something behind the scenes.

### Class Inheritance

Inheritance is a way to create a new class based on an existing class. The new class inherits the properties and methods of the existing class, allowing for code reuse and organization. Inheritance is a key feature of object-oriented programming (OOP) and helps create a hierarchical structure of classes.

In the context of FTC, you might create a base class for a robot, and an inherited class for the autonomous part of it.

For example, you could create a base class called `Robot` that contains common properties and methods for all robots, such as `drive()`, `turn()`, and `stop()`. Then, you could create a subclass called `AutonomousRobot` that inherits from the `Robot` class and adds specific functionality for autonomous operations, such as `followLine()` or `avoidObstacle()`. Inheritance is denoted by the `extends` keyword.

### Class Extension

Class extension is a way to use all functions of one class in another class. This is useful when you are creating complex system architectures and want to use similar functions in multiple classes. This is approximately the same as class inheritance, but is more commonly used in FTC.

Specifically in FTC, every OpMode must `extends OpMode or LinearOpMode` (preference to LinearOpMode). This allows you to use all the functions of the OpMode class in your own OpMode. This is required because the OpMode class contains all the functions needed to run the robot.

### Class Initialization

Class initialization allows you to create a new instance of the class. This is done using the `new` keyword. For example, if you have a class called `Person`, you can create a new instance of the class using `Person bob = new Person("bob", 29);`. This creates a new instance of the `Person` class and assigns it to the variable `bob`.

You need to make sure that the class is initialized before you use it and that you are using the correct class instance when using multiple class instances.

### Class Variables

Class variables are variables that are shared in the instance of the class. This is most useful when you are using classes that contain HardwareDevices. It allows you to call specific motors or servos inside the class without having to create a new instance of the class.

### Abstract Classes

Abstract classes are classes that cannot be instantiated. This means that you cannot create a new instance of the class. This is useful when you want to create a base class that contains common properties and methods, but you do not want to create an instance of the class. Instead, you create a subclass that inherits from the abstract class and implements the abstract methods.

For instance, if you have a class called `Person`, you could create an abstract class called `AbstractPerson` that contains common properties and methods, but cannot be instantiated. Then, you could create a subclass called `Student` that inherits from the `AbstractPerson` class and implements the abstract methods such as `eat` or `sleep`.

#### Overriding Classes/Functions

When you create an abstract class, the functions must be overridden in the subclass. This means that you must create a new implementation of the function in the subclass. This is useful when you want to create a base class that contains common properties and methods, but you want to create a new implementation of the function in the subclass. 

For instance, if you had a robot class, you could create a subclass called `AutonomousRobot` that overrides the `drive()` function to create a new (autonomous) implementation of the same function.

### Class Example

```java
abstract class Person{
    String name;
    int age;

    // constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // abstract function
    public abstract void eat();
    public abstract void sleep();
    public abstract void calculateAge();
}

class Student extends Person {
    String school;

    // Constructor
    public Student(String name, int age, String school) {
        super(name, age); // Calls the superclass (Person) constructor
        this.school = school;
    }

    // Implementing abstract methods
    @Override
    public void eat() {
        System.out.println(name + " is eating in the cafeteria.");
    }

    @Override
    public void sleep() {
        System.out.println(name + " is sleeping after studying.");
    }

    @Override
    public void calculateAge() {
        System.out.println(name + " is " + age + " years old.");
    }
}
```

FTC example [here](external-hardware-classes.md)