package com.anshuman.andriodcse225allcode.Unit1

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.anshuman.andriodcse225allcode.R

class TollBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_toll_bar)
        val tollBar = findViewById<Toolbar>(R.id.toolbar)
        tollBar.title = "My Toolbar"
        tollBar.setLogo(R.drawable.game)
        setSupportActionBar(tollBar)

    }
    // How to link the menue file to the toll bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tollbar , menu)
        return true
    }
    // now we need to set after click the each item we need to peroform some action
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id:Int = item.itemId
        if (id == R.id.action_search){
            Toast.makeText(this , "Search " , Toast.LENGTH_LONG).show()
            return true
        }
        else if(id == R.id.action_about){
            Toast.makeText(this , "about " , Toast.LENGTH_LONG).show()
            return  true
        }
        else if (id == R.id.action_like){
            Toast.makeText(this , "like " , Toast.LENGTH_LONG).show()
            return true
        }
        else if(id == R.id.action_seating){
            Toast.makeText(this , "seeting" , Toast.LENGTH_LONG).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}