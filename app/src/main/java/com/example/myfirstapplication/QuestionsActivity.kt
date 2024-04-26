package com.example.myfirstapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition:Int = 1
    private var mListOfQuestions: ArrayList<Questions>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUsername: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        mUsername = intent.getStringExtra(Constants.USER_NAME).toString()

        mListOfQuestions = Constants.getQuestions()
        

        val currentPosition = 1
        val question = mListOfQuestions!!.get(mCurrentPosition - 1)

        val progBar = findViewById<ProgressBar>(R.id.progressBar)
        val tvBar = findViewById<TextView>(R.id.tv_progress)
        val tvQues = findViewById<TextView>(R.id.tv_question)
        val imageView = findViewById<ImageView>(R.id.iv_image)
        val op1 = findViewById<TextView>(R.id.tv_option_one)
        val op2 = findViewById<TextView>(R.id.tv_option_two)
        val op3 = findViewById<TextView>(R.id.tv_option_three)
        val op4 = findViewById<TextView>(R.id.tv_option_four)
        val btnSubmit = findViewById<Button>(R.id.buttonSubmit)

        progBar.progress = currentPosition
        tvBar.text = "$currentPosition" + "/" + progBar.max
        tvQues.text = question!!.question
        imageView.setImageResource(question.image)

        op1.text = question.optionOne
        op2.text = question.optionTwo
        op3.text = question.optionThree
        op4.text = question.optionFour

        setQuestion()

        op1.setOnClickListener(this)
        op2.setOnClickListener(this)
        op3.setOnClickListener(this)
        op4.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)
    }

    private fun setQuestion(){
        val btnSubmit = findViewById<Button>(R.id.buttonSubmit)
         val question = mListOfQuestions!!.get(mCurrentPosition - 1)

        defaultOptionsView()
        if (mCurrentPosition == mListOfQuestions!!.size){
            btnSubmit.text = "FINISH"
        }else{
            btnSubmit.text = "SUBMIT"
        }
        val progBar = findViewById<ProgressBar>(R.id.progressBar)
        val tvBar = findViewById<TextView>(R.id.tv_progress)
        val tvQues = findViewById<TextView>(R.id.tv_question)
        val imageView = findViewById<ImageView>(R.id.iv_image)
        val op1 = findViewById<TextView>(R.id.tv_option_one)
        val op2 = findViewById<TextView>(R.id.tv_option_two)
        val op3 = findViewById<TextView>(R.id.tv_option_three)
        val op4 = findViewById<TextView>(R.id.tv_option_four)

        progBar.progress = mCurrentPosition
        tvBar.text = "$mCurrentPosition" + "/" + progBar.max
        tvQues.text = question!!.question
        imageView.setImageResource(question.image)

        op1.text = question.optionOne
        op2.text = question.optionTwo
        op3.text = question.optionThree
        op4.text = question.optionFour

    }

    private fun defaultOptionsView(){ //for the selection, kailangan everytime na mag cclick ka ng ibang options mag dedefault ulit ung ibang options
        val op1 = findViewById<TextView>(R.id.tv_option_one)
        val op2 = findViewById<TextView>(R.id.tv_option_two)
        val op3 = findViewById<TextView>(R.id.tv_option_three)
        val op4 = findViewById<TextView>(R.id.tv_option_four)
        val options = ArrayList<TextView>()
        options.add(0, op1 )
        options.add(1, op2 )
        options.add(2, op3 )
        options.add(3, op4 )

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }

    }

    override fun onClick(v: View?) {
        val op1 = findViewById<TextView>(R.id.tv_option_one)
        val op2 = findViewById<TextView>(R.id.tv_option_two)
        val op3 = findViewById<TextView>(R.id.tv_option_three)
        val op4 = findViewById<TextView>(R.id.tv_option_four)
        val btnSubmit = findViewById<Button>(R.id.buttonSubmit)

        when(v?.id){
            R.id.tv_option_one -> {
                selectedOptionsView(op1, 1)
            }

            R.id.tv_option_two -> {
                selectedOptionsView(op2, 2)
            }

            R.id.tv_option_three -> {
                selectedOptionsView(op3, 3)
            }

            R.id.tv_option_four -> {
                selectedOptionsView(op4, 4)
            }

            R.id.buttonSubmit ->{
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mListOfQuestions!!.size -> {
                            setQuestion()
                        }else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUsername)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mListOfQuestions!!.size)
                            startActivity(intent)
                        }
                    }
                }else{
                    val question = mListOfQuestions?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mListOfQuestions!!.size){
                        btnSubmit.text = "FINISH"
                    }else{
                        btnSubmit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }

        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        val op1 = findViewById<TextView>(R.id.tv_option_one)
        val op2 = findViewById<TextView>(R.id.tv_option_two)
        val op3 = findViewById<TextView>(R.id.tv_option_three)
        val op4 = findViewById<TextView>(R.id.tv_option_four)
        val btnSubmit = findViewById<Button>(R.id.buttonSubmit)
        when(answer){
            1 ->{
                op1.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 ->{
                op2.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 ->{
                op3.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 ->{
                op4.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    private fun selectedOptionsView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#7A8089"))
        tv.typeface = Typeface.DEFAULT
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }
}