package edu.miu.walmartlogin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import edu.miu.walmartlogin.data.User
import edu.miu.walmartlogin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val users = mutableListOf(
        User("kidus", "tekeste", "ktekeste@miu.com", "kiduspass"),
        User("Bernard", "Arnault", "barnault@miu.com", "bernardpass"),
        User("Bill", "Gates", "bgates@miu.com", "billpass"),
        User("Larry", "Page", "lpage@miu.com", "larrypass"),
        User("Warren", "Buffett", "wbuffett@miu.com", "warrenpass")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onSign(view: View) {
        val email = binding.etEmail.text.toString().trim()
        val pass = binding.etPassword.text.toString().trim()
        for(user in users){
            if(user.username == email && user.password == pass){
                openShoppingCategoryActivity(user)
            }
        }
    }

    private fun openShoppingCategoryActivity(user: User){
        val intent = Intent(this, ShoppingCategoryActivity::class.java)
        intent.putExtra("user", user)
        startActivity(intent)
    }


}