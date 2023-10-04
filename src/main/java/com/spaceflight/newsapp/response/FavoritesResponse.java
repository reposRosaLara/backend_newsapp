package com.spaceflight.newsapp.response;

import java.util.List;

import com.spaceflight.newsapp.model.FavoriteNews;

public class FavoritesResponse {

	private List<FavoriteNews> favoriteList;

	public List<FavoriteNews> getFavoriteList() {
		return favoriteList;
	}
	
	public void setFavoriteList(List<FavoriteNews> favoriteList) {
		this.favoriteList = favoriteList;
	}



}
