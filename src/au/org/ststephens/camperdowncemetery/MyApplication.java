package au.org.ststephens.camperdowncemetery;

import android.app.Application;

public class MyApplication extends Application{
	private Site siteList[] = {
    	new Site("A", "a is here", new ResourceImageInitialiser(R.drawable.sample1), 0),
    	new Site("B", "b is here", new ResourceImageInitialiser(R.drawable.sample2), 1)
    };
	
	public Site[] getSites(){
		return siteList;
	}
	
	public Site getSiteById(int id){
		//At the moment, id corresponds with index number in table
		return siteList[id];
	}
}
