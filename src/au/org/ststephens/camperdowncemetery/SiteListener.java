package au.org.ststephens.camperdowncemetery;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class SiteListener implements OnItemClickListener{

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
		Intent intent = new Intent(view.getContext(), SiteActivity.class);
		intent.putExtra("id", position);
		view.getContext().startActivity(intent);
	}
}
