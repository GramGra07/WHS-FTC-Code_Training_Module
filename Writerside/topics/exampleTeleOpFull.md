# exampleTeleOpFull

```Java
//imports
@TeleOp(name="exampleTeleOpFull",group="Pushbot")
//@Disabled
public class exampleTeleOpFull extends LinearOpMode {
    HardwarePushbot robot = new HardwarePushbot();
    private ElapsedTime   runtime = new ElapsedTime();
    public double hi=0;
    public int hello=1;
    public boolean hola=false;
    public float bonjour=0.2;
    public String hallo="This is a test!"
    @Override
    public void runOpMode(){
        runtime.reset();
        getRuntime();
        waitForStart();
        while (opModeIsActive()){
            if ( gamepad1.a){
                telemetry.addData("Test?",hallo)
            }
            getRuntime();
            telemetry.addData("Time:", String.valueOf(runtime));
        }
    }
}```