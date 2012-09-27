package au.org.ststephens.camperdowncemetery;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.view.View;
import android.widget.MediaController;

public class AudioPlayer implements OnPreparedListener, MediaController.MediaPlayerControl{
	private MediaController mediaController;
	private MediaPlayer mediaPlayer;
	private View anchorView;
	private Handler handler;
	
	public AudioPlayer(MediaPlayer mediaPlayer, MediaController mediaController, View anchorView){
		//Setup audio
		this.mediaPlayer = mediaPlayer;
		this.mediaController = mediaController;
		this.anchorView = anchorView;
		this.handler=new Handler();
	    mediaPlayer.setOnPreparedListener(this);
	    mediaPlayer.start();
	}
	
	@Override
	public void onPrepared(MediaPlayer mp) {
		mediaController.setMediaPlayer(this);
		mediaController.setAnchorView(anchorView);
	    
	    handler.post(new Runnable() {
	        public void run() {
		          mediaController.setEnabled(true);
		          mediaController.show(Integer.MAX_VALUE);//TODO: Not quite infinity, but close enough
	        }
	      });
	}
	
	public void showControls(){
		mediaController.show();
	}
	
	public void finish(){
		handler.removeCallbacksAndMessages(null);
		mediaController.hide();
	    mediaPlayer.stop();
	    mediaPlayer.release();
	}
	
	@Override
	public boolean canPause() {
		return true;
	}

	@Override
	public boolean canSeekBackward() {
		return true;
	}

	@Override
	public boolean canSeekForward() {
		return true;
	}

	@Override
	public int getBufferPercentage() {
		return 0;
	}

	@Override
	public int getCurrentPosition() {
		 return mediaPlayer.getCurrentPosition();
	}

	@Override
	public int getDuration() {
		return mediaPlayer.getDuration();
	}

	@Override
	public boolean isPlaying() {
		return mediaPlayer.isPlaying();
	}

	@Override
	public void pause() {
		mediaPlayer.pause();
	}

	@Override
	public void seekTo(int i) {
		mediaPlayer.seekTo(i);
	}

	@Override
	public void start() {
		mediaPlayer.start();
	}
}