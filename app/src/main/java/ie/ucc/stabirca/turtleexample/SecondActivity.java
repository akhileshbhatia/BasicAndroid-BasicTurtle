package ie.ucc.stabirca.turtleexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle b = getIntent().getExtras();
		int order = b.getInt("order");
		float length = b.getFloat("length");
		int type = b.getInt("type");

		TurtleView view = new TurtleView(this,order,type,length);

		setContentView(view);
		view.invalidate();

	}


}
