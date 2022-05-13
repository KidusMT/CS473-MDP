package edu.miu.quizapp.ui

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.view.*
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import edu.miu.quizapp.R
import edu.miu.quizapp.utils.BaseFragment
import edu.miu.quizapp.utils.PrefManager

class WelcomeFragment : BaseFragment() {

    private var viewPager: ViewPager? = null
    private var myViewPagerAdapter: MyViewPagerAdapter? = null
    private var dotsLayout: LinearLayout? = null
    private lateinit var dots: Array<TextView?>
    private lateinit var layouts: IntArray
    private var btnSkip: Button? = null
    private var btnNext: Button? = null
    private var prefManager: PrefManager? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)
        prefManager = PrefManager(context)

        // Making notification bar transparent
        activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        viewPager = view.findViewById(R.id.view_pager) as ViewPager
        dotsLayout = view.findViewById(R.id.layoutDots) as LinearLayout
        btnSkip = view.findViewById(R.id.btn_skip) as Button
        btnNext = view.findViewById(R.id.btn_next) as Button

        layouts = intArrayOf(
            R.layout.welcome_slide1,
            R.layout.welcome_slide2,
            R.layout.welcome_slide3,
            R.layout.welcome_slide4
        )

        addBottomDots(0)

        changeStatusBarColor()

        myViewPagerAdapter = MyViewPagerAdapter()
        viewPager?.adapter = myViewPagerAdapter
        viewPager?.addOnPageChangeListener(viewPagerPageChangeListener)

        btnSkip?.setOnClickListener { launchHomeScreen() }

        btnNext?.setOnClickListener {
            val current: Int = getItem(+1)
            if (current < layouts.size) {
                viewPager?.currentItem = current
            } else {
                launchHomeScreen()
            }
        }
        return view
    }

    private fun addBottomDots(currentPage: Int) {
        dots = arrayOfNulls(layouts.size)
        val colorsActive = resources.getIntArray(R.array.array_dot_active)
        val colorsInactive = resources.getIntArray(R.array.array_dot_inactive)
        dotsLayout!!.removeAllViews()
        for (i in dots.indices) {
            dots[i] = TextView(context)
            dots[i]?.text = Html.fromHtml("&#8226;")
            dots[i]?.textSize = 35F
            dots[i]?.setTextColor(colorsInactive[currentPage])
            dotsLayout!!.addView(dots[i])
        }
        if (dots.isNotEmpty()) dots[currentPage]?.setTextColor(colorsActive[currentPage])
    }

    private fun getItem(i: Int): Int {
        return viewPager!!.currentItem + i
    }

    private fun launchHomeScreen(view: View? = null) {
        prefManager!!.setFirstTimeLaunch(false)
        Navigation.findNavController(requireView())
            .navigate(R.id.action_welcomeFragment_to_homeFragment)
    }

    var viewPagerPageChangeListener: OnPageChangeListener = object : OnPageChangeListener {
        override fun onPageSelected(position: Int) {
            addBottomDots(position)

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.size - 1) {
                // last page. make button text to GOT IT
                btnNext?.text = getString(R.string.start)
                btnSkip!!.visibility = View.GONE
            } else {
                // still pages are left
                btnNext?.text = getString(R.string.next)
                btnSkip!!.visibility = View.VISIBLE
            }
        }

        override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
        override fun onPageScrollStateChanged(arg0: Int) {}
    }

    private fun changeStatusBarColor() {
        val window: Window? = activity?.window
        window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window?.statusBarColor = Color.TRANSPARENT
    }

    inner class MyViewPagerAdapter : PagerAdapter() {
        private var layoutInflater: LayoutInflater? = null
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            layoutInflater =
                context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
            val view: View? = layoutInflater?.inflate(layouts[position], container, false)
            container.addView(view)
            return view!!
        }

        override fun getCount(): Int {
            return layouts.size
        }

        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view === obj
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            val view = `object` as View
            container.removeView(view)
        }
    }

}