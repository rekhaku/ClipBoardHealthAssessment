package amazon.pages;

public class BaseTestPage {
	
	protected String id ;
	protected String address;
	protected String webPageTitle;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebPageTitle() {
		return webPageTitle;
	}
	public void setWebPageTitle(String webPageTitle) {
		this.webPageTitle = webPageTitle;
	}

	public BaseTestPage(String webPageTitle , String address) {
		this.webPageTitle = webPageTitle;
		this.address = address;// 
	}
	
	public BaseTestPage() {
	
	}
	

}
