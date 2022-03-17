package edu.miu.CVBuilderApp.ui.activity

import CVBuilderApp.R
import CVBuilderApp.databinding.ActivityWebBinding
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class WebActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url: String = intent.getSerializableExtra(getString(R.string.intent_key)) as String
        val title: String = when (url) {
            getString(R.string.my_linkedin) -> getString(R.string.linked_in_title)
            getString(R.string.my_twitter) -> getString(R.string.twitter_in_title)
            getString(R.string.my_github) -> getString(R.string.github_in_title)
            else -> getString(R.string.app_name)
        }

        binding.toolbar.title = title

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        binding.webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                return false
            }
        }
        binding.webview.settings.javaScriptEnabled = true
        binding.webview.loadUrl(url)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}