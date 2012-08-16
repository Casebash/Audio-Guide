package au.org.ststephens.camperdowncemetery;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class SiteListener implements OnItemClickListener{
	private Site[] sites;
	
	public SiteListener(Site[] sites){
		this.sites=sites;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
		Intent intent = new Intent(view.getContext(), SiteActivity.class);
		intent.putExtra("test", sites[position].description);
		view.getContext().startActivity(intent);
	}
}
