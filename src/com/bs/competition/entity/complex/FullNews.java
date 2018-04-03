package com.bs.competition.entity.complex;

import com.bs.competition.entity.simple.Admin;
import com.bs.competition.entity.simple.Image;
import com.bs.competition.entity.simple.News;

public class FullNews {
	private News news;
	private Image image;
	private Admin admin;
	
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
}
