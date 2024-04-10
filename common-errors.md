# Common Errors

### Null Pointer Exception

This basically means that the thing you are trying to call hasn't been initialized yet. This occurs most with motors and other hardware devices. This happens when you have not set the device to equal a hardware map.get instance. To fix this, read through [#code](coding.md#code "mention")

### Hardware Device Not Found

This means that whatever you have named the device in the code, is not found in the configuration of the Driver Station. To fix this, you need to make sure your configuration is correct in your DS. Click the three dots, then configuration, and then add the device where it should be with the correct name. This should fix the error completely.

### OpMode not appearing on the Driver Station

This could be a result of multiple things, you need to have the @TeleOp or @Autonomous annotations at the beginning of the class or it won't show up at all. Other than that, if you have the @Disabled annotation at the beginning of the class, it will result in the same thing and it won't show up at all.

