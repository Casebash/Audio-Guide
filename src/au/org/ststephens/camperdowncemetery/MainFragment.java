package au.org.ststephens.camperdowncemetery;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TabHost;

public class MainFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View mainView = inflater.inflate(R.layout.main_fragment, container,
				false);

		MyApplication app = (MyApplication) getActivity().getApplication();

		Resources r = getResources();
		TabHost tabs = (TabHost) mainView.findViewById(R.id.tabhost);
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

		// Display the list
		ListView siteListTable = (ListView) mainView
				.findViewById(R.id.sitelist);
		SiteAdapter adapter = new SiteAdapter(getActivity(), app.getSites());
		siteListTable.setAdapter(adapter);
		siteListTable.setOnItemClickListener(new SiteListener());
		return mainView;
	}
}
