package au.org.ststephens.camperdowncemetery;

public class Site {
	public String title;
	public String description;
	public ImageInitialiser mainInitialiser;
	
	public Site(String title, String description, ImageInitialiser mainInitialiser){
		this.title=title;
		this.description=description;
		this.mainInitialiser=mainInitialiser;
	}
}

