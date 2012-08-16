package au.org.ststephens.camperdowncemetery;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//Based off http://www.mkyong.com/android/android-listview-example/
public class PictureArrayAdapter extends ArrayAdapter<Site>{
	private final Context context;
 
	public PictureArrayAdapter(Context context, Site values[]) {
		super(context, R.layout.picture_list, values);
		this.context = context;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.picture_list, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
		Site site=getItem(position);
		textView.setText(site.title);
		site.mainInitialiser.initialiseImage(imageView);
		return rowView;
	}
}