package work.nbcc.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true)
    )

    private var questionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = CheatFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.btn_cheat, fragment)
        transaction.commit()

        findViewById<Button>(R.id.next_button).setOnClickListener {
            questionIndex =
                (questionIndex + 1) % 20 //Doing it so the last question go backs to the first one
            findViewById<TextView>(R.id.question_text).setText(questionBank[questionIndex].resourceId)
        }

        findViewById<Button>(R.id.button_previous).setOnClickListener {
            if(questionIndex == 0){
                questionIndex = questionBank.size - 1
            } else {
                questionIndex = (questionIndex - 1)
                findViewById<TextView>(R.id.question_text).setText(questionBank[questionIndex].resourceId)
            }
        }

        findViewById<Button>(R.id.button_true).setOnClickListener {
            checkAnswer(true)
        }

        findViewById<Button>(R.id.button_false).setOnClickListener {
            checkAnswer(false)
        }
    }

    private fun checkAnswer(answer: Boolean) {
        if(answer == questionBank[questionIndex].answer){
            Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show()
        }
    }
}
