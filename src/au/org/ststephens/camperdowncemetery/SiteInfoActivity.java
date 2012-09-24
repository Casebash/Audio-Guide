package au.org.ststephens.camperdowncemetery;

import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class SiteInfoActivity extends FragmentActivity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //Show inline - this activity isn't required
            finish();
            return;
        }
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        if (savedInstanceState == null) {
            // During initial setup, plug in the details fragment.
        	SiteInfoFragment frag=SiteInfoFragment.newInstance(getIntent().getIntExtra("id", 0));
        	//Can place fragment directly - don't need layout
            getSupportFragmentManager().beginTransaction().add(android.R.id.content, frag).commit();
        }
    }
}
