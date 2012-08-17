package au.org.ststephens.camperdowncemetery;

import java.util.ArrayList;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Pair;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TableLayout;

public class MainActivity extends FragmentActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyApplication app=(MyApplication)getApplication();
        
        Resources r=getResources();
        TabHost tabs = (TabHost)findViewById(R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec1 = tabs.newTabSpec("overview");
        spec1.setContent(R.id.overview);
        spec1.setIndicator(r.getString(R.string.overview_title));
        tabs.addTab(spec1);

        TabHost.TabSpec spec2 = tabs.newTabSpec("sitelist");
        spec2.setContent(R.id.sitelist);
        spec2.setIndicator(r.getString(R.string.sitelist_title));
        tabs.addTab(spec2);

        TabHost.TabSpec spec3 = tabs.newTabSpec("map");
        spec3.setContent(R.id.map);
        spec3.setIndicator(r.getString(R.string.map_title));
        tabs.addTab(spec3);
        
        //Display the list 
        ListView siteListTable=(ListView) findViewById(R.id.sitelist);       
		SiteAdapter adapter=new SiteAdapter(this, app.getSites());
        siteListTable.setAdapter(adapter);
        siteListTable.setOnItemClickListener(new SiteListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
