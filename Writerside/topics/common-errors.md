# Common Errors

You should look up errors [here](https://gramgra07.github.io/FTC-Error-Lookup/) as well as requesting and adding errors [here](https://github.com/GramGra07/FTC-Error-Lookup/issues).

### OpMode not appearing on the Driver Station

This could be a result of multiple things, you need to have the @TeleOp or @Autonomous annotations at the beginning of the class, or it won't show up at all. Other than that, if you have the @Disabled annotation at the beginning of the class, it will result in the same thing, and it won't show up at all.

