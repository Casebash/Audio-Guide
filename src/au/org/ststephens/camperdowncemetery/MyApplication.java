package au.org.ststephens.camperdowncemetery;

import android.app.Application;
import au.org.ststephens.camperdowncemetery.util.ResourceImageInitialiser;

public class MyApplication extends Application{
	private static MyApplication app;
	public static final String TAG = "AudioGuide";
	
	private Site siteList[] = {
    	new Site("A", "a is here\nne\nne\nne\nne\nne\nne\nne\nne\nne\nne\nne\nne\nne\nne\nnaa\nnnnaa\nnnnaa\nnnnaa\nnnnaa\nnnnaa\nnnnaa\nzzzzzz", new ResourceImageInitialiser(R.drawable.sample1), 0),
    	new Site("B", "b is here", new ResourceImageInitialiser(R.drawable.sample2), 1)
    };
	
	public Site[] getSites(){
		return siteList;
	}
	
	public Site getSiteById(int id){
		//At the moment, id corresponds with index number in table
		return siteList[id];
	}	    

    public void onCreate(){
        super.onCreate();
        MyApplication.app = (MyApplication) getApplicationContext();
    }
    
    //Only call after onCreate
    public static MyApplication getApp() {
        return MyApplication.app;
    }
}
