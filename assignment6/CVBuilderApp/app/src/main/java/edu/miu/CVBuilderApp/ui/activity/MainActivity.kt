package edu.miu.CVBuilderApp.ui.activity

import CVBuilderApp.R
import CVBuilderApp.databinding.ActivityMainBinding
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import edu.miu.CVBuilderApp.data.Work
import edu.miu.CVBuilderApp.ui.dialog.DialogCommunicator
import edu.miu.CVBuilderApp.ui.dialog.SettingsDialog
import edu.miu.CVBuilderApp.ui.dialog.WorkDialogCommunicator
import edu.miu.CVBuilderApp.utils.AppUtils
import edu.miu.CVBuilderApp.utils.Utils


class MainActivity : AppCompatActivity(), DialogCommunicator, WorkDialogCommunicator {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref: SharedPreferences
    private lateinit var adapter: MyViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref = AppUtils.setPref(this)

        val theme = sharedPref.getString(getString(R.string.saved_theme), "")
        if(theme!=null) decideTheme(theme)

        adapter = MyViewAdapter(supportFragmentManager,lifecycle)
        binding.pager.adapter = adapter
        binding.tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        TabLayoutMediator(binding.tabLayout,binding.pager){tab,position->
            when(position){
                0-> tab.text = getString(R.string.home_menu)
                1-> tab.text = getString(R.string.about_me_menu)
                2-> tab.text = getString(R.string.work_menu)
                3-> tab.text = getString(R.string.contact_menu)
            }
        }.attach()

        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            if (menuItem.itemId == R.id.menu_main_setting) {
                showNoticeDialog()
                return@setOnMenuItemClickListener true
            } else false
        }
    }

    private fun showNoticeDialog() {
        val dialog = SettingsDialog()
        dialog.show(supportFragmentManager, SettingsDialog::class.java.name)
    }

    override fun onChangeTheme(theme: String) {
        with (sharedPref.edit()) {
            this?.putString(getString(R.string.saved_theme), theme)
            this?.apply()
        }
        decideTheme(theme)
    }

    private fun decideTheme(theme: String){
        if(theme== Utils.DARK) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    override fun onAddWOrk(work: Work) {
        adapter.addWork(work)
    }

}