package edu.miu.CVBuilderApp.ui.activity

import CVBuilderApp.R
import CVBuilderApp.databinding.ActivityLoginBinding
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.miu.CVBuilderApp.utils.AppUtils

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPref : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref = AppUtils.setPref(this)
        val prefUser = AppUtils.getPref(getString(R.string.login_user_key))
        val prefPass = AppUtils.getPref(getString(R.string.login_pass_key))
        prefUser?.let { binding.etEmail.setText(it) }
        prefPass?.let { binding.etPassword.setText(it) }
        val theme = AppUtils.getPref(getString(R.string.saved_theme))
        if (theme != null) AppUtils.decideTheme(theme)
    }

    fun onLogin(view: View) {
        val user = binding.etEmail.text.toString().trim()
        val pass = binding.etPassword.text.toString().trim()

        if(user.isEmpty()){
            Toast.makeText(applicationContext,"Please enter your username", Toast.LENGTH_LONG).show()
            return
        }
        if(pass.isEmpty()){
            Toast.makeText(applicationContext,"Please enter your password", Toast.LENGTH_LONG).show()
            return
        }
        openMainActivity(user, pass)
    }

    private fun openMainActivity(user: String, pass: String){
        with(sharedPref.edit()) {
            putString(getString(R.string.login_user_key), user)
            putString(getString(R.string.login_pass_key), pass)
            apply()
        }

        startActivity(Intent(this, MainActivity::class.java))
    }

}