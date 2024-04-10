# Coding Basics

#### Coding Basics <a href="#cbasics" id="cbasics"></a>

Go through this section if you have no experience coding, if you are experienced, skip this.

#### What is a... <a href="#wia" id="wia"></a>

* Operation

`==` is equals

`!=` is not equals

`<=` less than or equal to

`>=` greater than or equal to

`>` greater than

`<` less than

Math:

`++` increments by one

`--` decreases by one

`variable += 1` equivalent of variable + 1 = variable

`variable /= 1` equivalent of variable / 1 = variable

`variable -= 1` equivalent of variable - 1 = variable

`variable *= 1` equivalent of variable \* 1 = variable

*   Variable

    A variable is a holder of a value, these values can be anything, as explained in Using Variables. You can use these to store values such as an on off switch, or a progress update, you can also use this as a place to store the power for motors. You will also declare your motors and servos as variables. A local variable can only be used where it was defined or set. A global variable can be used wherever. FTC documentation also lets us use some of their universal variables such as DcMotors and Servos, these are all imported by import statements at the beginning of your code.
*   Function

    Functions are statements to make the code run one part when you "call" the function. It is like calling a whole new section of the code. This is useful to have the code execute specific instructions. This is useful to tell the code to update something or to set a value to a variable. You can also set parameters that are localized variables. A local variable can only be used in that function. Parameters are very useful to help us define and change local variables inside of of the function.

    These can return specific values like a boolean or if they are not meant to return anything, a void function. This is done by `void name(){}`
* If statementAn if statement is simply `if (condition) { (do something) }`. Conditions can be found in [operations](codingbasics.md#oper).
*   Print/telemetry statement

    Print statements are very useful in debugging your code, essentially what they do is show you a value that you tell it to. `telemetry.addData("caption"," info")` This will give you values on the Driver Station phone and you can use this to see values like if a certain variable is on or off. In other languages you would use `print('',value)` to get the same information.
*   Loops

    While loops are very helpful in robot code. They can help you to make the robot do something until a condition is met. These are used by the ftc company in their own opModes to have the robot be on when you tell it to. These are very useful for distance or color sensors. For loops run the event a certain amount of times. In Java: `for (int i = 0; i < 100; i++){` this is the same as you would use in python: `for i in range(100){`, this would have the stuff in the loop run 10 times.
*   Imports

    Imports are very useful and can give you many more abilities in your code, one of the biggest known things to import is time. Other than that, every different sensor and motor you use will need to be imported.
* Enums - more info found [here](https://gentrified-apps.gitbook.io/statemachineftc)
