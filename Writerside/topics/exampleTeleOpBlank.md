# exampleTeleOpBlank

```Java
//imports
@TeleOp(name="exampleTeleOpBlank",group="Pushbot")
//@Disabled
public class exampleTeleOpBlank extends LinearOpMode {
    HardwarePushbot robot = new HardwarePushbot();
    private ElapsedTime   runtime = new ElapsedTime();
    @Override
    public void runOpMode(){
        runtime.reset();
        getRuntime();
        waitForStart();
        while (opModeIsActive()){
            getRuntime();
            telemetry.addData("Time:", String.valueOf(runtime));
        }
    }
}
```