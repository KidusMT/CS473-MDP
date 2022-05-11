package edu.miu.quizapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import edu.miu.quizapp.db.Quiz
import edu.miu.quizapp.db.QuizDatabase
import edu.miu.quizapp.utils.BaseFragment
import edu.miu.quizapp.utils.toast
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment()  {

    private lateinit var tvQuestion: TextView
    private lateinit var tvScore: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var questions: List<Quiz>
    private var qstnIdx = 0
    private var score = 0
    private lateinit var selectedChoice: String
    private lateinit var currentQuiz: Quiz
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val skipBtn = view.findViewById<Button>(R.id.btn_qstn_skip)
        val nextBtn = view.findViewById<Button>(R.id.btn_qstn_next)
        tvQuestion = view.findViewById(R.id.tv_question)
        tvScore = view.findViewById(R.id.tv_score)
        launch {
            context?.let {
                questions = QuizDatabase(it).getQuizDao().getAllQuizzes()
                changeQuestion(view)
            }
        }
        skipBtn.setOnClickListener {
            changeQuestion(view)
        }
        nextBtn.setOnClickListener {
            evaluateAnswer(selectedChoice)
            changeQuestion(view)
        }
        radioGroup = view.findViewById(R.id.question_radio)
        radioGroup.setOnCheckedChangeListener(this::handler)
        return view
    }


    private fun changeQuestion(view: View) {
        currentQuiz = questions[qstnIdx]
        tvQuestion.text = currentQuiz.question
        val radioGroup = view.findViewById(R.id.question_radio) as RadioGroup
        val questionChoices = listOf(currentQuiz.a,currentQuiz.b,currentQuiz.c,currentQuiz.d)
        for (i in 0 until radioGroup.childCount) {
            (radioGroup.getChildAt(i) as RadioButton).text = questionChoices[i]
        }
        qstnIdx++
        radioGroup.clearCheck()
    }

    private fun handler(group: RadioGroup, checkedId: Int) {
        when (checkedId) {
            R.id.radio_q1_a -> selectedChoice = "a"
            R.id.radio_q1_b -> selectedChoice = "b"
            R.id.radio_q1_c -> selectedChoice = "c"
            R.id.radio_q1_d -> selectedChoice = "d"
        }
    }

    private fun evaluateAnswer(ans: String){
        if(currentQuiz.answer == ans){
            score++
        }
        tvScore.text = String.format("%d/15",score)
    }



}