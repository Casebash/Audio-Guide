package au.org.ststephens.camperdowncemetery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SiteInfoFragment extends Fragment{
	public static Fragment newInstance(String description){
		SiteInfoFragment f = new SiteInfoFragment();
        Bundle args = new Bundle();
        args.putString("description", description);
        f.setArguments(args);
        return f;
	}
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
        View siteView=inflater.inflate(R.layout.text, container, false);
        TextView textView=(TextView) siteView.findViewById(R.id.textView1);
        textView.setText(getArguments().getString("description"));
        return siteView;
	}
}
