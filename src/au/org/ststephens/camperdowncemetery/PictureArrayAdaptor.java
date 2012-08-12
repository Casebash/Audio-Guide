package au.org.ststephens.camperdowncemetery;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//Based off http://www.mkyong.com/android/android-listview-example/
public class PictureArrayAdaptor extends ArrayAdapter<Pair<String, ImageInitialiser>> {
	private final Context context;
	private final Pair<String, ImageInitialiser>[] values;
 
	public PictureArrayAdaptor(Context context, Pair<String, ImageInitialiser>[] values) {
		super(context, R.layout.picture_list, values);
		this.context = context;
		this.values = values;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.picture_list, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
		Pair<String, ImageInitialiser> data=this.values[position];
		textView.setText(data.first);
		data.second.initialiseImage(imageView);
		return rowView;
	}
}