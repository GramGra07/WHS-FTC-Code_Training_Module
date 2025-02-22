# Common Errors

You can also look up errors [here](https://gramgra07.github.io/FTC-Error-Lookup/) as well as requesting and adding errors [here](https://github.com/GramGra07/FTC-Error-Lookup/issues).

### Tentative, somewhat dangerous fix

When updating or upgrading your control hub, you may get an error saying something like, could not find a file, in some random folder that you can't find. This is caused by an error in your gradle code. If you can't find another way to fix it I would recommend this method, it is a little complicated but will solve it. First, create a new repository **DO NOT ADD ANYTHING AUTOMATICALLY** not even a read me we will call this repository our bridge. Then scroll down to the bottom and tap import from repository, grab the URL of your old repository and make sure it finished importing. Then go into the old repositories settings and delete the repository. Then go to the FTC Robot Controller and fork it. You will want to clone both the bridge repository and the new one we just forked. Now you will copy over all of your working files from the bridge repo and put them in your new repository. As soon as that is finished and committed you should be good to go, you can then delete the bridge repository.

### Cannot find hostname ...

This means that it cannot download the necessary components (typically during a gradle build). To fix this, you must get on an available Wi-Fi channel and press the make build button on Android Studio. Either this or rebuild project will download the gradle resources, and then you can easily fo the build to the robot.

### Null Pointer Exception

This basically means that the thing you are trying to call hasn't been initialized yet. This occurs most with motors and other hardware devices. This happens when you have not set the device to equal a hardware map. Get instance.

### Hardware Device Not Found

This means that whatever you have named the device in the code, is not found in the configuration of the Driver Station. To fix this, you need to make sure your configuration is correct in your DS. Click the three dots, then configuration, and then add the device where it should be with the correct name. This should fix the error completely.

### OpMode not appearing on the Driver Station

This could be a result of multiple things, you need to have the @TeleOp or @Autonomous annotations at the beginning of the class, or it won't show up at all. Other than that, if you have the @Disabled annotation at the beginning of the class, it will result in the same thing, and it won't show up at all.

