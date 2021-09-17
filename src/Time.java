
import java.util.Timer;
import java.util.TimerTask;

public class Time {


   public static int saniye =0;
    Timer myTimer=new Timer();
    TimerTask task=new TimerTask() {
        @Override
        public void run() {
            saniye++;
        }
    };

    public  void start(){
        myTimer.scheduleAtFixedRate(task,5,1);
    }

}
