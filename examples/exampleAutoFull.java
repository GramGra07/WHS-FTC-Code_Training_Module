//imports
@Autonomous(name="exampleAuto", group="Autonomous")
//@Disabled
public class exampleAutoFull extends exampleTeleOpFull {  //your doc name *extends* your main code branch
    private ElapsedTime   runtime = new ElapsedTime();
    // every variable will be taken from exampleTeleOpFull
    // if it is public because we use extends to indicate that
    // this means we can have all variables in one file.
    @Override
    public void runOpMode(){
        runtime.reset();
        getRuntime();
        waitForStart();
        //actual code
        while (getRuntime()<=30) {
            getRuntime();
            telemetry.addData(String.valueOf(runtime), "Working");
        }
    }
}

