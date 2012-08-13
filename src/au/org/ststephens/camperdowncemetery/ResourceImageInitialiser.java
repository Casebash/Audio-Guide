package au.org.ststephens.camperdowncemetery;

import android.widget.ImageView;

public class ResourceImageInitialiser extends ImageInitialiser{
	private int imageResource;
	
	public ResourceImageInitialiser(int imageResource){
		this.imageResource=imageResource;
	}
	
	public void initialiseImage(ImageView v){
		v.setImageResource(this.imageResource);
	}
}
