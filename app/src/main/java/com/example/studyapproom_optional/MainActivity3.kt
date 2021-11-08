package com.example.studyapproom_optional

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity3 : AppCompatActivity() {
    lateinit var al:ArrayList<Item>
    lateinit var rv: RecyclerView
    lateinit var btnadd:FloatingActionButton
    lateinit var dialog:Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        btnadd = findViewById(R.id.floatingActionButton11)

        dialog = Dialog()
//        al = arrayListOf(
//            Item(null,"RecyclerView","using with array list or list"),
//            Item(null,"SharedPrefrences","to save item locally"),
//            Item(null,"Toast","to show amassege in some cases"),
//            Item(null,"Alert Dialog","to show alert"),
//            Item(null,"Intent","To go to another mainactivity")
//        )
        rv = findViewById(R.id.rv)
        al = arrayListOf()

        rvUp()

        btnadd.setOnClickListener {
            preSave()
        }

    }

    fun add(na:String,n4:String){
        var items = Item2(null,na,n4)
        ItemDatabase.getInstance(this).ItemDao().insertAndroidItem(items)
            Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show()

        }



    fun preSave(){
        var txt1 = EditText(this)
        var txt2 = EditText(this)
        val layout = LinearLayout(this)
        layout.addView(txt1)
        layout.addView(txt2)
        layout.orientation = LinearLayout.VERTICAL
        txt1.hint = "titel"
        txt2.hint = "description"
        AlertDialog.Builder(this)
            .setPositiveButton("Add", DialogInterface.OnClickListener { _, _ ->
                add(txt1.text.toString(),txt2.text.toString())
            })
            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, _ ->
                dialog.cancel()
            })
            .setTitle("Add New Item")

            .setView(layout)
            .create()
            .show()
    }

    fun UpdatOrDelete(a1:Item2){
        dialog.createDealog2(a1,this)

    }
    fun updateAndroid(a1:Item2){
        ItemDatabase.getInstance(this).ItemDao().UpdateAndroidItem(a1)
        Toast.makeText(this,"Updated successfully..!",Toast.LENGTH_SHORT).show()
        rvUp()
    }

    fun deleteAndroid(a1:Item2){
        ItemDatabase.getInstance(this).ItemDao().DeleteAndroidItem(a1)
        Toast.makeText(this,"deleteed successfully..!",Toast.LENGTH_SHORT).show()
        rvUp()
    }

    fun rvUp(){
        rv.adapter?.notifyDataSetChanged()
//        var rr = ItemDatabase.getInstance(this).ItemDao().getAllAndroidItem()
////        for(i in rr){
////            al.add(Item(i.id,i.title,i.description))
////        }

        rv.adapter = RVAdapter2(ItemDatabase.getInstance(this).ItemDao().getAllAndroidItem() as ArrayList<Item2>,this)
        rv.layoutManager = LinearLayoutManager(this)
    }
}