package au.org.ststephens.camperdowncemetery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SiteInfoFragment extends Fragment {
	private Site site = null;

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
		
		View siteView = inflater.inflate(R.layout.text, container, false);
		TextView textView = (TextView) siteView.findViewById(R.id.textView1);
		textView.setText(site.description);
		return siteView;
	}
}
