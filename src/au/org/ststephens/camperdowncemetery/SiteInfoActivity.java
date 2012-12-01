package au.org.ststephens.camperdowncemetery;

import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

public class SiteInfoActivity extends FragmentActivity{
	private SiteInfoFragment frag;
	private int id;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        View dualPanel=findViewById(R.id.main_dual);
        if (dualPanel!=null) {
            //Show inline - this activity isn't required
            finish();
            return;
        }
        if (savedInstanceState == null) {
            // During initial setup, plug in the details fragment.
        	id=getIntent().getIntExtra("id", 0);
        	frag=SiteInfoFragment.newInstance(id);
        	String title=MyApplication.getApp().getSiteById(id).title;
        	setTitle(title);
        	//Can place fragment directly - don't need layout
            getSupportFragmentManager().beginTransaction().add(android.R.id.content, frag).commit();
        }
    }
    
    @Override
    public void onConfigurationChanged(Configuration newConfig){
    	super.onConfigurationChanged(newConfig);
    }
    
    @Override
    public void finish(){
    	if(frag!=null)frag.finishing();
    	super.finish();
    }
}
