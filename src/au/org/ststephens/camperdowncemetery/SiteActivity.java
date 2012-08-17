package au.org.ststephens.camperdowncemetery;

import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

public class SiteActivity extends FragmentActivity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication app=(MyApplication) getApplication();
        Site s=app.getSiteById(getIntent().getIntExtra("id", -1));
        setTitle(s.title);    
        setContentView(R.layout.site_activity);
        //Attach fragment
        SiteInfoFragment siteInfo=(SiteInfoFragment) SiteInfoFragment.newInstance(s.description);
        getSupportFragmentManager()
        	.beginTransaction()
        	.add(R.id.site_info, siteInfo)
        	.commit();
    }
}
