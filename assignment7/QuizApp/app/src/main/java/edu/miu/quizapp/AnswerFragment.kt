package edu.miu.quizapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import edu.miu.quizapp.db.Quiz
import edu.miu.quizapp.db.QuizDatabase
import edu.miu.quizapp.utils.BaseFragment
import kotlinx.coroutines.launch


class AnswerFragment : BaseFragment() {

    private lateinit var questions: List<Quiz>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_answer, container, false)
        val listView = view.findViewById<ListView>(R.id.list_view)
        launch {
            context?.let {
                questions = QuizDatabase(it).getQuizDao().getAllQuizzes()
                listView.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1,
                    prepResultAnalysis(questions))
            }
        }

        return view
    }

    private fun prepResultAnalysis(questions: List<Quiz>): List<String> {
        val items = mutableListOf<String>()
        for (quiz in questions){
            val listItem = String.format("%s\nYour answer: %s\nCorrect answer: %s",quiz.question,quiz.answer,quiz.explanation)
            items.add(listItem)
        }
        return items
    }

}