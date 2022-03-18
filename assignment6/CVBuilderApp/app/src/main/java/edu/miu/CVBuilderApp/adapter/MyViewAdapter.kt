package edu.miu.CVBuilderApp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import edu.miu.CVBuilderApp.data.Work
import edu.miu.CVBuilderApp.ui.fragments.AboutFragment
import edu.miu.CVBuilderApp.ui.fragments.ContactFragment
import edu.miu.CVBuilderApp.ui.fragments.HomeFragment
import edu.miu.CVBuilderApp.ui.fragments.WorkFragment

class MyViewAdapter(fm:FragmentManager,lc:Lifecycle) : FragmentStateAdapter(fm,lc) {
    override fun getItemCount(): Int = 4
    val workFragment = WorkFragment()
    override fun createFragment(position: Int): Fragment {
        return   when(position){
            0-> HomeFragment()
            1-> AboutFragment()
            2-> workFragment
            3-> ContactFragment()
            else-> Fragment()
        }
    }

    fun addWork(work: Work){
        workFragment.onAddWOrk(work)
    }
}

