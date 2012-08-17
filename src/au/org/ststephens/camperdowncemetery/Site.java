package au.org.ststephens.camperdowncemetery;

import au.org.ststephens.camperdowncemetery.util.ImageInitialiser;

public class Site {
	public int id;
	public String title;
	public String description;
	public ImageInitialiser mainInitialiser;
	
	public Site(String title, String description, ImageInitialiser mainInitialiser, int id){
		this.title=title;
		this.description=description;
		this.mainInitialiser=mainInitialiser;
		this.id=id;
	}
}

