package com.spaceflight.newsapp.response;

public class FavoritesResponseRest extends ResponseRest {

	private FavoritesResponse favoritesResponse= new FavoritesResponse();

	public FavoritesResponse getFavoritesResponse() {
		return favoritesResponse;
	}

	public void setFavoritesResponse(FavoritesResponse favoriteResponse) {
		favoritesResponse = favoriteResponse;
	}
	
}
