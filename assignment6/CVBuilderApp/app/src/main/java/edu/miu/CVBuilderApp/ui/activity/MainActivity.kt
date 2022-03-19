package edu.miu.CVBuilderApp.ui.activity

import CVBuilderApp.R
import CVBuilderApp.databinding.ActivityMainBinding
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import edu.miu.CVBuilderApp.adapter.MyViewAdapter
import edu.miu.CVBuilderApp.data.Work
import edu.miu.CVBuilderApp.ui.dialog.DialogCommunicator
import edu.miu.CVBuilderApp.ui.dialog.SettingsDialog
import edu.miu.CVBuilderApp.ui.dialog.WorkDialogCommunicator
import edu.miu.CVBuilderApp.utils.AppUtils


class MainActivity : AppCompatActivity(), DialogCommunicator, WorkDialogCommunicator {

    private lateinit var binding: ActivityMainBinding
    private var sharedPref: SharedPreferences = AppUtils.getSharedPref()
    private lateinit var adapter: MyViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val theme = AppUtils.getPref(getString(R.string.saved_theme))
        val user = AppUtils.getPref(getString(R.string.login_user_key))
        if (theme != null) AppUtils.decideTheme(theme)

        showWorkDialog()
        binding.tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.home_menu)
                1 -> tab.text = getString(R.string.about_me_menu)
                2 -> tab.text = getString(R.string.work_menu)
                3 -> tab.text = getString(R.string.contact_menu)
            }
        }.attach()


        user?.apply { binding.toolbar.title = "$user's CV" }
        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_main_setting -> {
                    showNoticeDialog()
                    return@setOnMenuItemClickListener true
                }
                R.id.menu_main_logout -> {
                    finish()
                    return@setOnMenuItemClickListener true
                }
                else -> false
            }
        }
    }

    private fun showNoticeDialog() {
        val dialog = SettingsDialog()
        dialog.show(supportFragmentManager, SettingsDialog::class.java.name)
    }

    override fun onChangeTheme(theme: String) {
        with(sharedPref.edit()) {
            putString(getString(R.string.saved_theme), theme)
            apply()
        }
        AppUtils.decideTheme(theme)
    }

    private fun showWorkDialog() {
        adapter = MyViewAdapter(supportFragmentManager, lifecycle)
        binding.pager.adapter = adapter
    }

    override fun onAddWOrk(work: Work) {
        if (::adapter.isInitialized) {
            adapter.addWork(work)
        } else {
            showWorkDialog()
            adapter.addWork(work)
        }
    }

}