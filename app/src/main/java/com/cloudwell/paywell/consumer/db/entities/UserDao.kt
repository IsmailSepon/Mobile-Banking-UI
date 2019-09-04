package com.cloudwell.paywell.consumer.db.entities

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-09-03.
 */
@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(user: User) : Long

//    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
//    suspend fun getuser() : LiveData<User>

}