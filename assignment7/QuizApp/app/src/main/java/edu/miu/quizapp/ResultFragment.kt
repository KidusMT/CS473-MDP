package edu.miu.quizapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import edu.miu.quizapp.utils.BaseFragment

class ResultFragment : BaseFragment() {

    private lateinit var tvScore: TextView
    private lateinit var btnResult: Button
    private lateinit var btnTryAgain: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_result, container, false)
        tvScore = view.findViewById(R.id.tv_score)
        val score = ResultFragmentArgs.fromBundle(requireArguments()).score
        val wrongAnswers = 15 - score
        val finalScore = "$score/15"
        val scoreResult = String.format(
            "Total Questions: 15\n\n" +
                    "Correct Answers(Score): %d\n\n" +
                    "Wrong Answer: %d\n\n" +
                    "Your Score is: %s", score, wrongAnswers, finalScore
        )
        tvScore.text = scoreResult
        btnResult = view.findViewById(R.id.btn_result_analysis)
        btnTryAgain = view.findViewById(R.id.btn_try_again)
        btnTryAgain.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_resultFragment_to_homeFragment)
        }
        btnResult.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_resultFragment_to_answerFragment)
        }
        return view
    }


}