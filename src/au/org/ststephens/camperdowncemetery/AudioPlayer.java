package au.org.ststephens.camperdowncemetery;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;

public class AudioPlayer implements OnPreparedListener, MediaController.MediaPlayerControl{
	public AudioController audioController;
	private MediaPlayer mediaPlayer;
	private View anchorView;
	private Handler handler;
	private boolean finishedWithMediaPlayer;
	
	public AudioPlayer(MediaPlayer mediaPlayer, AudioController audioController, View anchorView){
		//Setup audio
		this.mediaPlayer = mediaPlayer;
		this.audioController = audioController;
		this.anchorView = anchorView;
		this.handler=new Handler();
	    mediaPlayer.setOnPreparedListener(this);
	    mediaPlayer.start();
	}
	
	@Override
	public void onPrepared(MediaPlayer mp) {
		audioController.setMediaPlayer(this);
		audioController.setAnchorView(anchorView);
	    
	    handler.post(new Runnable() {
	        public void run() {
	        	audioController.setEnabled(true);
	        	audioController.show(Integer.MAX_VALUE);//TODO: Not quite infinity, but close enough
	        }
	    });
	}
	
	public void showControls(){
		audioController.show();
	}
	
	public void finish(){
		handler.removeCallbacksAndMessages(null);
		if(audioController.isShown()){
			audioController.realHide();
		}
		if(!finishedWithMediaPlayer){
			mediaPlayer.reset();
		    mediaPlayer.release();
		    finishedWithMediaPlayer=true;
		}
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