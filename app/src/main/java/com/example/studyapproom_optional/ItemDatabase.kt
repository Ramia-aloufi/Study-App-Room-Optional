package com.example.studyapproom_optional

import android.content.Context
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.studyapproom_optional.Item2
import com.example.studyapproom_optional.ItemDao


@Database(entities = [Item::class,Item2::class],version = 1,exportSchema = false)
abstract class ItemDatabase:RoomDatabase() {

    companion object{
        var instance:ItemDatabase?=null;
        fun getInstance(ctx: Context):ItemDatabase
        {
            if(instance!=null)
            {
                return  instance as ItemDatabase;
            }
            instance= Room.databaseBuilder(ctx,ItemDatabase::class.java,"raam11").run { allowMainThreadQueries() }.build();
            return instance as ItemDatabase;
        }
    }
    abstract fun ItemDao(): ItemDao;
}