package com.spaceflight.newsapp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Builder
@AllArgsConstructor
@Table(name="favoritenews")
public class FavoriteNews {

	@Id
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	@Column(name = "title", length = 1000)
    private String title;
	@Column(name = "url", length = 1000)
    private String url;
	@Column(name = "image_url", length = 1000)
    private String image_url;
    private String news_site;
    @Column(name = "summary", length = 1500)
    private String summary;
    private LocalDateTime published_at;
    private LocalDateTime updated_at;
    private boolean featured;
    private LocalDate addedToFav_at;
    
    FavoriteNews(){}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getNews_site() {
		return news_site;
	}
	public void setNews_site(String news_site) {
		this.news_site = news_site;
	}
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public LocalDateTime getPublished_at() {
		return published_at;
	}
	public void setPublished_at(LocalDateTime published_at) {
		this.published_at = published_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	public boolean isFeatured() {
		return featured;
	}
	public void setFeatured(boolean featured) {
		this.featured = featured;
	}

	public LocalDate getAddedToFav_at() {
		return addedToFav_at;
	}
	public void setAddedToFav_at(LocalDate addedToFav_at) {
		this.addedToFav_at = addedToFav_at;
	}
	

	
	
}
