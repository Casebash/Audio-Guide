package au.org.ststephens.camperdowncemetery;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.MediaController;

class AudioController extends MediaController{
	
	public AudioController(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public AudioController(Context context) {
		super(context);
	}

	@Override
	public void hide() {
	}
	
	public void realHide() {
		super.hide();
	}
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if(event.getKeyCode()==KeyEvent.KEYCODE_BACK){
			((Activity) getContext()).finish();
		}
		return super.dispatchKeyEvent(event);
	}
}