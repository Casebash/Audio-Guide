package au.org.ststephens.camperdowncemetery;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class SiteListener implements OnItemClickListener{

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		FragmentActivity a=(FragmentActivity) adapter.getContext();
        Site s=MyApplication.getApp().getSites()[position];    
        //@TODO: Attach only if we don't already have a fragment
        //Attach fragment
        SiteInfoFragment siteInfo=(SiteInfoFragment) SiteInfoFragment.newInstance(s.id);
        a.getSupportFragmentManager()
        	.beginTransaction()
        	.add(R.id.site_info_main, siteInfo)
        	.commit();
	}
}
