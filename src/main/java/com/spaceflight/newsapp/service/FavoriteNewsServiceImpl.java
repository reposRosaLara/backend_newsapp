package com.spaceflight.newsapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.spaceflight.newsapp.model.FavoriteNews;
import com.spaceflight.newsapp.response.FavoritesResponseRest;
import com.spaceflight.newsapp.dao.IFavoriteNewsDao;

@Service
public class FavoriteNewsServiceImpl implements IFavoriteNewsService{

	private static final Logger LOGGER = LoggerFactory.getLogger(FavoriteNews.class);

	
	private IFavoriteNewsDao favoriteNewsDao;
	
	FavoriteNewsServiceImpl(IFavoriteNewsDao newsDao){
		this.favoriteNewsDao = newsDao;
	}
	
	List<FavoriteNews> favorites;
	
	@Override
	public ResponseEntity<FavoritesResponseRest> getFavoriteNews() {
		LOGGER.info("Inicio método obtener noticias favoritas");
		FavoritesResponseRest responseRest = new FavoritesResponseRest();
		
		try {
			favorites = (List<FavoriteNews>)favoriteNewsDao.findAll();
			responseRest.getFavoritesResponse().setFavoriteList(favorites);
			responseRest.setMetadata("Respuesta ok", "200", "Respuesta exitosa");
			if(!favorites.isEmpty()) {
				LOGGER.info("Exito al obtener lista de favoritos");
			}
			else {
				LOGGER.info("Lista favoritos vacia");
			}
		} catch (Exception e) {
			LOGGER.error("No se pudo encontrar lista . Causa: " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>(responseRest, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(responseRest, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<FavoritesResponseRest> addFavoriteNew(FavoriteNews favoriteNew) {
		
		LOGGER.info("Inicio método agregar a favoritos");
		FavoritesResponseRest response = new FavoritesResponseRest();

		
		try {
			Optional<FavoriteNews> news = favoriteNewsDao.findById(favoriteNew.getId()); 
			if (favoriteNew != null && !news.isPresent()) {
				favoriteNew.setAddedToFav_at(LocalDate.now());
				favoriteNewsDao.save(favoriteNew);
				response.getFavoritesResponse().setFavoriteList((List<FavoriteNews>)(favoriteNewsDao.findAll()));
				response.setMetadata("Respuesta ok", "200", "Noticia agregada a favoritos");
				return new ResponseEntity<FavoritesResponseRest>(response, HttpStatus.CREATED);
			}else {
				LOGGER.error("noticia no agregada a favoritos. Noticia ya existe");
				response.setMetadata("Respuesta no OK", "-1", "No se pudo agregar a favoritos. Noticia ya existe");
				return new ResponseEntity<FavoritesResponseRest>(response, HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			LOGGER.error("Error al agregar a favoritos");
			response.setMetadata("respuesta no OK", "-1", "Error al agregar noticia a favoritos.");
			return new ResponseEntity<FavoritesResponseRest>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<FavoritesResponseRest> deleteFavoriteNew(Integer id) {
		LOGGER.info("Inicio método eliminar de favoritos");
		FavoritesResponseRest response = new FavoritesResponseRest();
		try {
			if(id!= null && id>0) {
				Optional<FavoriteNews> news = favoriteNewsDao.findById(id);
				if (news.isPresent()) {
					favoriteNewsDao.deleteById(id);
					LOGGER.info("Noticia eliminada de favoritos");
					response.setMetadata("Respuesta ok", "200", "Noticia eliminada de favoritos");
					response.getFavoritesResponse().setFavoriteList((List<FavoriteNews>)(favoriteNewsDao.findAll()));
					return new ResponseEntity<FavoritesResponseRest>(response, HttpStatus.OK);
				}
					LOGGER.error("Noticia no existe en favoritos");
					response.setMetadata("Respuesta no OK", "-1", "Noticia no existe en favoritos.");
					response.getFavoritesResponse().setFavoriteList((List<FavoriteNews>)(favoriteNewsDao.findAll()));
					return new ResponseEntity<FavoritesResponseRest>(response, HttpStatus.BAD_REQUEST);
			}
			LOGGER.error("Id ingresado inválido");
			response.setMetadata("Respuesta no OK", "-1", "Id ingresado invalido.");
			response.getFavoritesResponse().setFavoriteList((List<FavoriteNews>)(favoriteNewsDao.findAll()));
			return new ResponseEntity<FavoritesResponseRest>(response, HttpStatus.BAD_REQUEST);
			
		} catch (Exception e) {
			LOGGER.error("Error al eliminar a favoritos");
			response.setMetadata("respuesta no OK", "-1", "Error al eliminar noticia a favoritos.");
			return new ResponseEntity<FavoritesResponseRest>(response, HttpStatus.BAD_REQUEST);
		}
		

	}

	

	
	
    
}
