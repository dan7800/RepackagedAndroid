package spawn;

import java.lang.RuntimeException;
import com.octo.android.robodemo.DemoActivity;
import com.octo.android.robodemo.sample.MainActivityDemoActivity;
import com.octo.android.robodemo.sample.MainActivity;


public class Wrapper99 {

	public static void main(String[] args){
		System.out.println("Starting function calls");
		try{
			MainActivityDemoActivity MainActivityDemoActivityVar = new MainActivityDemoActivity();
			MainActivityDemoActivityVar.onCreate(null);
		}catch(RuntimeException ex){
			System.out.println("Hit Runtime!");
		}
		try{
			MainActivity MainActivityVar = new MainActivity();
			MainActivityVar.onCreate(null);
		}catch(RuntimeException ex){
			System.out.println("Hit Runtime!");
		}

        System.out.println("Finished with function calls");
	}
}

