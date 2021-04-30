package reports_modelo;

public class WebCorporativa {
	
	String precio;
	String weburl;
	
	public WebCorporativa (String precio, String weburl) {
		this.precio = precio;
		this.weburl = weburl;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getWeburl() {
		return weburl;
	}

	public void setWeburl(String weburl) {
		this.weburl = weburl;
	}
	
	
	
}