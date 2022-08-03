//imports
@Autonomous(name="exampleAuto", group="Autonomous")
//@Disabled
public class exampleAuto extends SAMPLEptpov {  //your doc name *extends* your main code branch
    private ElapsedTime   runtime = new ElapsedTime();
    @Override
    public void runOpMode(){
        runtime();
        waitForStart();
        //actual code
        while (getRuntime()<=30) {
            getRuntime();
            telemetry.addData(String.valueOf(runtime), "Working");
        }
    }
    public void run_time(){
        runtime.reset();
        getRuntime();
    }
}

