package com.spaceflight.newsapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spaceflight.newsapp.model.FavoriteNews;
import com.spaceflight.newsapp.response.FavoritesResponseRest;
import com.spaceflight.newsapp.service.IFavoriteNewsService;


@RestController
@CrossOrigin
@RequestMapping("/newsapp")
public class NewsRestController {

    private final IFavoriteNewsService favoriteNewsService;
	
	NewsRestController(IFavoriteNewsService service){
		this.favoriteNewsService = service;
	}
	
	@GetMapping("/favorites")
    public ResponseEntity<FavoritesResponseRest> getFavorites() {
        return favoriteNewsService.getFavoriteNews();
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<FavoritesResponseRest> deleteFromFavorites(@PathVariable Integer id ) {
		return favoriteNewsService.deleteFavoriteNew(id);
    }
	
	@PostMapping("/add")
    public ResponseEntity<FavoritesResponseRest> addFavoriteNews(@RequestBody FavoriteNews request ) {
		return favoriteNewsService.addFavoriteNew(request);
    }
}
