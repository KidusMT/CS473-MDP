package com.example.tablayoutkotlinlibrary

import CVBuilderApp.R
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class ContactFragment : Fragment(R.layout.fragment_contact){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val phone = view.findViewById<LinearLayout>(R.id.phone)
        phone.setOnClickListener{onPhoneClicked()}
        val email = view.findViewById<LinearLayout>(R.id.email)
        email.setOnClickListener{onEmailClicked()}
        val linkedIn = view.findViewById<LinearLayout>(R.id.linkedIn)
        linkedIn.setOnClickListener{onLinkedInClicked()}
        val twitter = view.findViewById<LinearLayout>(R.id.twitter)
        twitter.setOnClickListener{onTwitterClicked()}
        val github = view.findViewById<LinearLayout>(R.id.github)
        github.setOnClickListener{onGithubClicked()}
    }

    private fun onPhoneClicked(){
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:3145839972")
        startActivity(intent)
    }

    private fun onEmailClicked(){
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, "ktekeste@miu.edu")
        intent.putExtra(Intent.EXTRA_SUBJECT, "Forgot Password from MDP Course")
        intent.putExtra(Intent.EXTRA_TEXT, "Could you please contact me for more information.");
        startActivity(intent)
    }

    private fun onLinkedInClicked(){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/kidus-tekeste/"))
        startActivity(intent)
    }

    private fun onTwitterClicked(){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/adukidus"))
        startActivity(intent)
    }

    private fun onGithubClicked(){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/KidusMT"))
        startActivity(intent)
    }
}