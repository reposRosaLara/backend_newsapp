package com.spaceflight.newsapp.service;

import org.springframework.http.ResponseEntity;
import com.spaceflight.newsapp.model.FavoriteNews;
import com.spaceflight.newsapp.response.FavoritesResponseRest;

public interface IFavoriteNewsService{
	
	public ResponseEntity<FavoritesResponseRest> getFavoriteNews();

	public ResponseEntity<FavoritesResponseRest> addFavoriteNew(FavoriteNews favoriteNew);

	public ResponseEntity<FavoritesResponseRest> deleteFavoriteNew(Integer id);



}
