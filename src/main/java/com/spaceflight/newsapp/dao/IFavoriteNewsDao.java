package com.spaceflight.newsapp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.spaceflight.newsapp.model.FavoriteNews;

@Repository
public interface IFavoriteNewsDao extends CrudRepository<FavoriteNews, Integer>{
    
    
}
