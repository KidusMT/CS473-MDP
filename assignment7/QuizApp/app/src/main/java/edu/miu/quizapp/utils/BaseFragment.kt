package edu.miu.quizapp.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseFragment : Fragment(),CoroutineScope{
    // Instance in the Co routine Context
    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        // To perform the Job, Displatchers.Main is used for CoroutineContext
        get() = job + Dispatchers.Main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Create an Instance for the Job()
        job = Job()
    }
    override fun onDestroy() {
        super.onDestroy()
        // Cancel the Job
        job.cancel()
    }
}