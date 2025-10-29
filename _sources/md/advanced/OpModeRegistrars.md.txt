# OpModeRegistrars

OpModeRegistrars are a great way to remove the ```@Autonomous``` or ```@TeleOp``` tags from your OpModes.
This works by sending in the OpMode to the registrar, which then builds and registers your opMode for you.

## Code

```java
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpModeManager;
import com.qualcomm.robotcore.eventloop.opmode.OpModeRegistrar;
        
import org.firstinspires.ftc.robotcore.internal.opmode.OpModeMeta;
        
public final class AutonomousRegistrar {
     private AutonomousRegistrar() {}
        
     private static OpModeMeta metaForClass(Class<? extends OpMode> cls) {
           return new OpModeMeta.Builder()
               .setName(cls.getSimpleName())
               .setGroup("Autonomous")
               .setFlavor(OpModeMeta.Flavor.AUTONOMOUS) // can be changed to TELEOP
               .build();
     }
        
    @OpModeRegistrar
    public static void register(OpModeManager manager) {
        manager.register(metaForClass(Auto1.class), new Auto1());
        manager.register(metaForClass(Auto2.class), new Auto2());
    }
}
```

Essentially, it just allows you to remove the ```@Autonomous``` or ```@TeleOp``` tags from your OpModes and instead use a registrar to register them, providing one central spot all of them are registered and stored.
As well as this, if you start using constructors for your teleOp, ex getting Alliance color, this is an easy way because you can change it to include Alliance color as a param. While this is possible, it is not recommended as if you have to change back, it will not allow initialization.

You can use this [website](https://gramgra07.github.io/gg-web/content/ftcUtils/opmode_registrar_creator/index.html) that I made to generate code for you.