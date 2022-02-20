package edu.miu.dinnerdeciderapp

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var menuList = mutableListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")
    lateinit var selectedMenu: TextView
    lateinit var newMenu: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        selectedMenu = findViewById(R.id.select_value)
        newMenu = findViewById(R.id.add_menu)

    }

    fun decideMenu(v: View) {
        val randIdx = Random.nextInt(menuList.size)
        selectedMenu.text = menuList[randIdx]
    }

    fun addMenu(v: View) {
        val newMenuValue = newMenu.text.toString().trim()
        if (newMenuValue.isNotEmpty()) {
            selectedMenu.text = newMenuValue
            menuList.add(newMenuValue)
        }
    }
}