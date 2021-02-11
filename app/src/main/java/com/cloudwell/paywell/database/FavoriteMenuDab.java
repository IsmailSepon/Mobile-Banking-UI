package com.cloudwell.paywell.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cloudwell.paywell.services.activity.myFavorite.model.FavoriteMenu;
import com.cloudwell.paywell.recentList.model.RecentUsedMenu;

import java.util.List;

import io.reactivex.Maybe;


/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2/1/19.
 */
@Dao
public interface FavoriteMenuDab {

    @Query("SELECT * FROM favoritemenu ")
    List<FavoriteMenu> getAll();

    @Query("SELECT * FROM favoritemenu WHERE status ='unFavourite'")
    Maybe<List<FavoriteMenu>> getAllUnFavoriteMenu();


    @Query("SELECT * FROM favoritemenu WHERE status ='Favourite'")
    Maybe<List<FavoriteMenu>> getAllFavoriteMenu();


    @Query("SELECT * FROM RecentUsedMenu")
    Maybe<List<RecentUsedMenu>> getAllRecentUsedMenu();

    @Query("SELECT * FROM favoritemenu WHERE status ='Favourite'")
    List<FavoriteMenu> getAppShortcut();

    @Query("SELECT * FROM favoritemenu WHERE status !='Favourite'")
    List<FavoriteMenu> getDislikedMenu();

    @Insert
    void insert(FavoriteMenu task);

    @Insert
    void insert(List<FavoriteMenu> task);


    @Insert
    void insertRecentUsedMenu(List<RecentUsedMenu> task);

    @Delete
    void delete(FavoriteMenu task);

    @Delete
    void delete(List<FavoriteMenu> task);

    @Query("DELETE FROM  favoritemenu WHERE alias_key = :aliasKey")
    void delete( int aliasKey);

    @Update
    int update(FavoriteMenu task);

    @Query("DELETE FROM favoritemenu")
    public void deletedALl();


    @Query("DELETE FROM RecentUsedMenu")
    public void deletedALlRecentUsedMenu();







}
