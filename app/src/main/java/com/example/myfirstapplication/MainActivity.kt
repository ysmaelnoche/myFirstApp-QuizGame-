package com.example.myfirstapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myfirstapplication.ui.theme.MyFirstApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN //fullscreen view
        val btnStart = findViewById<Button>(R.id.buttonStart)
        val text1 = findViewById<TextView>(R.id.et_name)

        btnStart.setOnClickListener {
            if (text1.text.toString().isEmpty()) //if the user doesn't enter the name
            {
                Toast.makeText(this, "Sabing i-enter pangalan eh!", Toast.LENGTH_SHORT)
            }
            else{
                val intent = Intent(this, QuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, text1.text.toString()) //get mo lang yung value nung text 1 sa if which is ayan ung input and ayan na ung username sa result
                startActivity(intent)
                finish()
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstApplicationTheme {
        Greeting("Android")
    }
}