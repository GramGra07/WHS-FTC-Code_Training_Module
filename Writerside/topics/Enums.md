# Enums

Enums are a way of creating a list of constants that can be used in a program. For example, you could create an Enum of fruits and have it contain apples, oranges, and bananas. Another example could be types of cars, you could have a list of cars that are sedans, trucks, and SUVs.
Enums are a variable that is defined by the user, and has a list of constants the user defines.
In this implementation, we use Enums commonly named states, or autonomousStates.
```java
enum States {
    STATE1,
    STATE2,
    STATE3,
    STATE4,
    STATE5,
    STOP,
}
```
In the case of autonomous, states could be things like drive forward, turn left, turn right, raise arm, etc.
These enums provide an advantage because they are easy to read and understand in comparison to just telling the robot exactly what to do when. It can also wait for specific input from the robot, which might be harder to implement with just hard coding autonomous.

