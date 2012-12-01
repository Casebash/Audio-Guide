package au.org.ststephens.camperdowncemetery;

import pl.polidea.coverflow.AbstractCoverFlowImageAdapter;
import pl.polidea.coverflow.CoverFlow;
import pl.polidea.coverflow.ReflectingImageAdapter;
import pl.polidea.coverflow.ResourceImageAdapter;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class SiteInfoFragment extends Fragment implements OnItemClickListener{
	private int siteId;
	private Site site = null;
	private static final String TAG = "SiteInfo";
	private int previousPosition;
	private int imageResources[];
	public AudioPlayer audioPlayer;
	
	public Site getSite() {
		return site;
	}

	public static SiteInfoFragment newInstance(int siteId) {
		SiteInfoFragment f = new SiteInfoFragment();
		f.siteId=siteId;
		Bundle args = new Bundle();
		args.putInt("siteId", siteId);
		f.setArguments(args);
		return f;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Bundle bundle=getArguments();
		previousPosition=bundle.getInt("position");
		site=MyApplication.getApp().getSiteById(bundle.getInt("siteId"));
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
		
        final CoverFlow siteImages = (CoverFlow) siteView.findViewById(R.id.siteImages);
        siteImages.setOnItemClickListener(this);
        
        imageResources=new int[]{R.drawable.sample1, R.drawable.sample2};
        AbstractCoverFlowImageAdapter imageAdapter=new ResourceImageAdapter(getActivity(), imageResources);
        BaseAdapter coverImageAdapter=new ReflectingImageAdapter(imageAdapter);
        siteImages.setAdapter(coverImageAdapter);
		
		AudioController audioController = new AudioController(getActivity());
		MediaPlayer player=MediaPlayer.create(getActivity(), R.raw.hi);
		if(previousPosition==0){
			MyApplication app=(MyApplication)getActivity().getApplication();
			previousPosition=app.getStartPosition(siteId);
		}
		player.seekTo(previousPosition);
		audioPlayer=new AudioPlayer(player, audioController, siteView);
		return siteView;
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState){
		if(audioPlayer!=null){
			int position=audioPlayer.getCurrentPosition();
			outState.putInt("position", position);
		}
	}
	
	public void finishing(){
		if(audioPlayer!=null){
			MyApplication app=(MyApplication)getActivity().getApplication();
			app.setLastAudio(siteId, audioPlayer.getCurrentPosition());
			audioPlayer.finish();
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Intent intent = new Intent();
        intent.setClass(getActivity(), ImageActivity.class);
        intent.putExtra("location", site.title);
        intent.putExtra("image_id", imageResources[arg2]);
        startActivity(intent);
	}
}

