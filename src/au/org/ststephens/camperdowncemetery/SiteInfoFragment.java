package au.org.ststephens.camperdowncemetery;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.MediaController;
import android.widget.TextView;

public class SiteInfoFragment extends Fragment{
	private Site site = null;
	private static final String TAG = "SiteInfo";
	private AudioPlayer audioPlayer;
	
	public Site getSite() {
		return site;
	}

	public static SiteInfoFragment newInstance(int siteId) {
		SiteInfoFragment f = new SiteInfoFragment();
		Bundle args = new Bundle();
		args.putInt("siteId", siteId);
		f.setArguments(args);
		return f;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int siteId=getArguments().getInt("siteId");
		site=MyApplication.getApp().getSiteById(siteId);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
            //No containing frame
            return null;
        }
		
		final View siteView = inflater.inflate(R.layout.site_info, container, false);
		final TextView textView = (TextView) siteView.findViewById(R.id.textView1);
		textView.setText(site.description);
		textView.setMovementMethod(new ScrollingMovementMethod());
		
		MediaController mediaController = new MediaController(getActivity()){
			@Override
			public boolean dispatchKeyEvent(KeyEvent event) {
				if(event.getKeyCode()==KeyEvent.KEYCODE_BACK){
					((Activity) getActivity()).finish();
				}
				return super.dispatchKeyEvent(event);
			}
		};
		MediaPlayer player=MediaPlayer.create(getActivity(), R.raw.hi);
		audioPlayer=new AudioPlayer(player, mediaController, siteView);
		return siteView;
	}
	
	@Override
	public void onStop() {
		if(audioPlayer!=null) audioPlayer.finish();
		super.onStop();
	}

}
