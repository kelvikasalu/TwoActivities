package com.example.twoactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val message = intent.getStringExtra("SEND_KEY_VALUE")
        val textView: TextView = findViewById(R.id.text_message)

        // Handle the EditText and Send button for the second activity
        val editTextSendSecond: EditText = findViewById(R.id.editText_send_second)
        val buttonSendReplySecond: Button = findViewById(R.id.button_send_reply_second)

        textView.text = message

        buttonSendReplySecond.setOnClickListener {
            val reply = editTextSendSecond.text.toString().trim()

            val replyIntent = Intent()
            replyIntent.putExtra("REPLY_KEY_VALUE", reply)
            setResult(RESULT_OK, replyIntent)
            finish()
        }
    }
}
