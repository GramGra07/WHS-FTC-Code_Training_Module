# Variables

A variable is simply a placeholder for a value.

In Java, you can declare a variable by using the following syntax:

```java
type name = value;
```

Where type:

```java
boolean  True or False
int  Integer, a whole number
double  Floating point number
float  Decimal (up to 7 digits)
String  Text value
// or type can be a class of your own or a HardwareDevice, as explained later
```

Boolean is used to determine whether a value is true or not, an on/off switch

Int is used for a constant value like your team number, a certain value to multiple etc.

Double is used for your motors, this is the best method because it supports all numbers so you can use it for storing game-pad inputs.

Float is most commonly used to store color values

Strings are used to store common strings or text values like a status of initialization

* When to use public vs. private variables?
    * You generally want to always use public unless it is something that you don't want to share with other opModes, like a runtime.

* When to use static vs. non-static variables?
  * You generally want to use static variables when you want to use the same variable across multiple classes, like a motor or a sensor. More on this [later](Classes.md)!