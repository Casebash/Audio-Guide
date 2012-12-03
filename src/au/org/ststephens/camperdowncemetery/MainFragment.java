package au.org.ststephens.camperdowncemetery;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TabHost;

//Based off example towards end of fragments - http://developer.android.com/guide/components/fragments.html
public class MainFragment extends Fragment implements OnItemClickListener{
	boolean mDualPane;
    int mCurCheckPosition = 0;
	
    private ListView findListView(){
    	return (ListView) getActivity().findViewById(R.id.site_list);
    }
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View mainView = inflater.inflate(R.layout.main_tabs, container);

		Resources r = getResources();
		//Create tabs
		TabHost tabs = (TabHost) mainView.findViewById(R.id.tabhost);
		tabs.setup();

		TabHost.TabSpec spec1 = tabs.newTabSpec("overview");
		spec1.setContent(R.id.overview);
		spec1.setIndicator(r.getString(R.string.overview_title));
		tabs.addTab(spec1);

		TabHost.TabSpec spec2 = tabs.newTabSpec("sitelist");
		spec2.setContent(R.id.site_list);
		spec2.setIndicator(r.getString(R.string.site_list_title));
		tabs.addTab(spec2);

		TabHost.TabSpec spec3 = tabs.newTabSpec("map");
		spec3.setContent(R.id.map);
		spec3.setIndicator(r.getString(R.string.map_title));
		tabs.addTab(spec3);
		
		//Set current tab
		if(savedInstanceState!=null){
			int startTab=savedInstanceState.getInt("currentTab");
			tabs.setCurrentTab(startTab);
		}

		//Prepare the site list
		ListView siteListTable = (ListView) mainView.findViewById(R.id.site_list);
		SiteAdapter adapter = new SiteAdapter(getActivity(), 0, MyApplication.getApp().getSites());
		siteListTable.setAdapter(adapter);
		siteListTable.setOnItemClickListener(this);
		
		//Prepare the map
        TouchImageView img = (TouchImageView) mainView.findViewById(R.id.map);
        img.setImageResource(R.drawable.cemetery);
        img.setMaxZoom(4f);
		
		return mainView;
	}
	
	//Instantiate other view if we need to
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		View detailsFrame = getActivity().findViewById(R.id.site_info_main);
        mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        if (savedInstanceState != null) {
            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
        }

        if (mDualPane) {
            findListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showSite(mCurCheckPosition);
        }
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		
		TabHost tabs = (TabHost) getView().findViewById(R.id.tabhost);
		outState.putInt("currentTab", tabs.getCurrentTab());
	}
	
	public void showSite(int siteIndex){
    	Site s=MyApplication.getApp().getSites()[siteIndex];
        mCurCheckPosition = siteIndex;
        /*if (mDualPane) {
            findListView().setItemChecked(siteIndex, true);
            SiteInfoFragment details = (SiteInfoFragment)
                    getFragmentManager().findFragmentById(R.id.site_info_main);
            if (details == null || details.getSite().id != s.id) {
                // Make new fragment to show this selection.
                details = SiteInfoFragment.newInstance(s.id);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.site_info_main, details);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }

        } else {*/
            // Otherwise we need to launch a new activity to display
            // the dialog fragment with selected text.
            Intent intent = new Intent();
            intent.setClass(getActivity(), SiteInfoActivity.class);
            intent.putExtra("id", s.id);
            startActivity(intent);
        /*}*/
	}

	@Override
	public void onItemClick(AdapterView<?> l, View v, int position, long id) {
		showSite(position);
	}
}
