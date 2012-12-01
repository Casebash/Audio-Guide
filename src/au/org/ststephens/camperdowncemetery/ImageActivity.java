package au.org.ststephens.camperdowncemetery;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageActivity extends Activity{
	   public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.image_activity);
	        Intent intent=getIntent();
	        setTitle(intent.getStringExtra("location"));
	        ImageView image=(ImageView)findViewById(R.id.image);
	        image.setImageResource(intent.getIntExtra("image_id", 0));
	    }
}
