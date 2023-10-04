package com.spaceglight.newsapp.service;

import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spaceflight.newsapp.dao.IFavoriteNewsDao;
import com.spaceflight.newsapp.model.FavoriteNews;
import com.spaceflight.newsapp.service.FavoriteNewsServiceImpl;

@ExtendWith(MockitoExtension.class)
public class NewsServiceTest {

	@Mock
	private IFavoriteNewsDao newsDao;
	
	@InjectMocks
	private FavoriteNewsServiceImpl newsService;
	
	@Test
	public void newsService_findAll_returnAllFavoriteNews() {
		List<FavoriteNews> favoriteNews = Collections.singletonList( Mockito.mock(FavoriteNews.class));
		
		when(newsDao.findAll()).thenReturn(favoriteNews);
		
		List<FavoriteNews> favorites = newsService.getFavoriteNews().getBody().getFavoritesResponse().getFavoriteList();
		
		Assertions.assertThat(favorites).isNotNull();
	}
}
