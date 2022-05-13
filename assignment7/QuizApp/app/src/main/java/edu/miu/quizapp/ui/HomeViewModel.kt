package edu.miu.quizapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private  var score = 0
    private var scoreLiveData= MutableLiveData<Int>()
    fun getInitialScore(): MutableLiveData<Int> {
        scoreLiveData.value = score
        return  scoreLiveData
    }
    fun getCurrentScore(){
        score+=1
        scoreLiveData.value= score
    }
    fun getFinalScore(): MutableLiveData<Int>{
        return scoreLiveData
    }
}
