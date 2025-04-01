package News.Backend.Api.Model;

import java.util.Date;

public class News {
	private String title; 
	
	private String description;
	
	private String imageUrl;
	
	private String Url;
	
	private Date date;
	
	private String source;
	
	private String author;
	
	public News(String title, String description, String imageUrl, String url, Date date, String source,
			String author) {
		super();
		this.title = title;
		this.description = description;
		this.imageUrl = imageUrl;
		Url = url;
		this.date = date;
		this.source = source;
		this.author = author;
	}
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
