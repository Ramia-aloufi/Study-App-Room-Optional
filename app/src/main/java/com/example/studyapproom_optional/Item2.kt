package com.example.studyapproom_optional


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Android")
data class Item2(
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id")  var id : Int? = null, // this is how can include id if needed
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String)



