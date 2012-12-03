package au.org.ststephens.camperdowncemetery;

import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class MainActivity extends FragmentActivity{
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setVolumeControlStream(AudioManager.STREAM_MUSIC);
	        setContentView(R.layout.main_activity);
	    }

	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        getMenuInflater().inflate(R.menu.activity_main, menu);
	        return true;
	    }
}
