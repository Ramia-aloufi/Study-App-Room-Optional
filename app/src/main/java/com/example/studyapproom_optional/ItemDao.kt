package com.example.studyapproom_optional

import android.provider.ContactsContract
import androidx.room.*
import com.example.studyapproom_optional.Item2

@Dao
interface ItemDao {

    @Query("SELECT * FROM Kotlin  ORDER BY id ASC")
    fun getAllKotlin(): List<Item>

    @Insert
    fun insertKotlinItem(item: Item)

    @Delete
    fun DeleteKotlinItem(item: Item)

    @Update
    fun UpdateKotlinItem(item: Item)

    @Query("SELECT * FROM Android  ORDER BY id ASC")
    fun getAllAndroidItem(): List<Item2>

    @Insert
    fun insertAndroidItem(item: Item2)

    @Delete
    fun DeleteAndroidItem(item: Item2)

    @Update
    fun UpdateAndroidItem(item: Item2)


}