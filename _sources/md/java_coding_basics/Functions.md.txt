# Functions

Functions are statements to make the code run one part when you "call" the function. It is like calling a whole new section of the code. This is useful to have the code execute specific instructions. This is useful to tell the code to update something or to set a value to a variable. You can also set parameters that are localized variables. A local variable can only be used in that function. Parameters are very useful to help us define and change local variables inside the function.

* What does a function look like?

```java
 public void imaginaryFunction(){
   //code
 }
```

* What about parameters?

```java
public void imaginaryFunction2(int hi, boolean hello){
   if (hello == true){
     //do something
     int hi2=hi+1;
   }
 }
```

* What about calling a function?

```java
  imaginaryFunction(6,false);
```

* Returning values?

```java
 public int imaginaryFunction3(int hi, boolean hello){
    if (hello == true){
      //do something
      int hi+=1;
      return hi;
    }
  }
```

You will see that this is saying public int, you use void if you are returning nothing, and the proper variable type if you are returning something. This would be called as, `telemetry.addData("Number",String(imaginaryFunction3(9,true)))`

## Why use functions?

Functions are convenient when you are running a code block multiple times, it allows you to condense it and reduce mistakes in the process of copying and pasting.

## What about Override functions?

Override functions are functions that are already defined in the code, and you are changing them to fit your needs. This is useful when you are using a library, and you want to change the way it works.

More on this [later](Classes.md)!