package edu.miu.quizapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import edu.miu.quizapp.R
import edu.miu.quizapp.db.Quiz
import edu.miu.quizapp.db.QuizDatabase
import edu.miu.quizapp.utils.BaseFragment
import edu.miu.quizapp.utils.PrefManager
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment() {

    private lateinit var tvWelcome: TextView
    private var prefManager: PrefManager? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        prefManager = PrefManager(context)
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        tvWelcome = view.findViewById(R.id.logo_welcome)
        addQuestionsToDB()
        return view
    }

    override fun onResume(){
        super.onResume()
        tvWelcome.postDelayed({
            if (!prefManager?.isFirstTimeLaunch()!!) {
                Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_homeFragment)
            }else{
                Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_welcomeFragment)
            }
        }, 1000)
    }

    fun addQuestionsToDB(){
        val quiz1 = Quiz(1L,"1) Android is","A. an operating system", "B. a web browser","C. a web server","D. None of the above","a","Answer: (a) an operating system\n" +
                "\n" +
                "Android is a software package and linux based operating system for mobile devices such as tablet computers and smartphones.")
        val quiz2 = Quiz(2L,"2) Under which of the following Android is licensed?", "A. OSS","B. Sourceforge","C. Apache/MIT","D. None of the above","c","Answer: (c) Apache/MIT\n" +
                "\n" +
                "Explanation: The Android platform was released under the Apache 2.0 license, and it is responsible for the copyright of the Android Open Source project. The Apache Foundation permits and grants licenses for software uses and distribution by the copyright under the Android Open Source Project.")
        val quiz3 = Quiz(3L,"3) For which of the following Android is mainly developed?","A. Servers", "B. Desktops","C. Laptops","D. Mobile devices","d","Answer: (d) Mobile devices\n" +
                "\n" +
                "Explanation: Android is a software package and a Linux-based operating system specially designed for touch-screen mobile devices like smartphones and tablets.")
        val quiz4 = Quiz(4L,"4) Which of the following is the first mobile phone released that ran the Android OS?","A. HTC Hero", "B. Google gPhone","C. T - Mobile G1","D. None of the above","c","Answer: (c) T - Mobile G1\n" +
                "\n" +
                "Explanation: The first Android mobile was publicly released with Android 1.0 of the T-Mobile G1 (aka HTC Dream) in October 2008.")
        val quiz5 = Quiz(5L,"5) Which of the following virtual machine is used by the Android operating system?","A. JVM", "B. Dalvik virtual machine","C. Simple virtual machine","D. None of the above","b","Answer: (b) Dalvik virtual machine\n" +
                "\n" +
                "Explanation: The Dalvik Virtual Machine (DVM) is an android virtual machine optimized for mobile devices. It optimizes the virtual machine for memory, battery life, and performance. Dalvik is a name of a town in Iceland. The Dalvik VM was written by Dan Bornstein.")
        val quiz6 = Quiz(6L,"6) Android is based on which of the following language?","A. Java", "B. C++","C. C","D. None of the above","a","Answer: (a) Java\n" +
                "\n" +
                "Explanation: Java language is mainly used to write the android code even though other languages can be used.")
        val quiz7 = Quiz(7L,"7) APK stands for -","A. Android Phone Kit", "B. Android Page Kit","C. Android Package Kit","D. None of the above","c","Answer: (c) Android Package Kit\n" +
                "\n" +
                "Explanation: An APK is a short form of the Android Package Kit. An APK file is the file format used to install the applications on the android operating system.")
        val quiz8 = Quiz(8L,"8) What does API stand for?","A. Application Programming Interface", "B. Android Programming Interface","C. Android Page Interface","D. Application Page Interface","a","Answer: (a) Application Programming Interface\n" +
                "\n" +
                "Explanation: API stands for application program interface. It is a set of routines, protocols, and tools for building software and applications. It may be any type of system like a web-based system, operating system, or database system.")
        val quiz9 = Quiz(9L,"9) Which of the following converts Java byte code into Dalvik byte code?","A. Dalvik converter", "B. Dex compiler","C. Mobile interpretive compiler (MIC)","D. None of the above","b","Answer: (b) Dex compiler\n" +
                "\n" +
                "Explanation: The Dex compiler converts the class files into a .dex file that runs on the Dalvik VM. Multiple class files are converted into one dex file.")
        val quiz10 = Quiz(10L,"10) How can we stop the services in android?","A. By using the stopSelf() and stopService() method", "B. By using the finish() method","C. By using system.exit() method","D. None of the above","a","Answer: (a) By using the stopSelf() and stopService() method\n" +
                "\n" +
                "Explanation: A service is started when a component (like activity) calls the startService() method; now, it runs in the background indefinitely. It is stopped by the stopService() method. The service can stop itself by calling the stopSelf() method.")
        val quiz11 = Quiz(11L,"11) What is an activity in android?","A. android class", "B. android package","C. A single screen in an application with supporting java code","D. None of the above","c","Answer: (c) A single screen in an application with supporting java code\n" +
                "\n" +
                "Explanation: An activity is a single screen in android. It is like a window or frame of Java. By the help of activity, you can place all your UI components or widgets in a single screen. Activity is like a frame or window in java that represents GUI. It represents one screen of android.")
        val quiz12 = Quiz(12L,"12) How can we kill an activity in android?","A. Using finish() method", "B. Using finishActivity(int requestCode)","C. Both (a) and (b)","D. Neither (a) nor (b)","c","Answer: (c) Both (a) and (b)\n" +
                "\n" +
                "Explanation: The finish() method is used to close the activity. Whereas the finishActivity(int requestCode) also closes the activity with requestCode.")
        val quiz13 = Quiz(13L,"13) ADB stands for -","A. Android debug bridge", "B. Android delete bridge","C. Android destroy bridge","D. None of the above","a","Answer: (a) Android debug bridge\n" +
                "\n" +
                "Explanation: ADB stands for Android Debug Bridge. It is a command-line tool that is used to communicate with the emulator instance.")
        val quiz14 = Quiz(14L,"14) On which of the following, developers can test the application, during developing the android applications?",
            "A. Third-party emulators", "B. Emulator included in Android SDK","C. Physical android phone","D. All of the above","d","Answer: (d) All of the above\n" +
                    "\n" +
                    "Explanation: We can use the Android emulator, physical android phone, or third-party emulator as a target device to execute and test our Android application.")
        val quiz15 = Quiz(15L,"15) Which of the following kernel is used in Android?","A. MAC", "B. Windows","C. Linux","D. Redhat","c","Answer: (c) Linux\n" +
                "\n" +
                "Explanation: Android is a customized Linux 3.6 kernel. It is the heart of android architecture that exists at the root of android architecture. Linux kernel is responsible for device drivers, power management, memory management, device management, and resource access.")

        launch {
            context?.let {
                QuizDatabase(it)
                    .getQuizDao().deleteAllQuiz()
                QuizDatabase(it)
                    .getQuizDao().addQuizzes(quiz1,quiz2,quiz3,quiz4,quiz5,quiz6,quiz7,quiz8,
                    quiz9,quiz10,quiz11,quiz12,quiz13,quiz14,quiz15)
            }
        }
    }

}