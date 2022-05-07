package edu.miu.quizapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class SplashFragment : Fragment() {

    private lateinit var tvWelcome: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        tvWelcome = view.findViewById(R.id.logo_welcome)
        return view
    }

    override fun onResume(){
        super.onResume()
        tvWelcome.postDelayed({
            Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_welcomeFragment)
        }, 1000)
    }

}