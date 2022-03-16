package edu.miu.CVBuilderApp.ui.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import edu.miu.CVBuilderApp.ui.fragments.AboutFragment
import edu.miu.CVBuilderApp.ui.fragments.ContactFragment
import edu.miu.CVBuilderApp.ui.fragments.HomeFragment
import edu.miu.CVBuilderApp.ui.fragments.WorkFragment

class MyViewAdapter(fm:FragmentManager,lc:Lifecycle) : FragmentStateAdapter(fm,lc) {
    override fun getItemCount(): Int = 4
    override fun createFragment(position: Int): Fragment {
        return   when(position){
            0-> HomeFragment()
            1-> AboutFragment()
            2-> WorkFragment()
            3-> ContactFragment()
            else-> Fragment()
        }
    }
}

