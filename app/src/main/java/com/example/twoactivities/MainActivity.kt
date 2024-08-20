package com.example.twoactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val SECOND_ACTIVITY_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mMessageEditText: EditText = findViewById(R.id.editText_send)
        val buttonSend: Button = findViewById(R.id.button_send)
        val textReplyHeader: TextView = findViewById(R.id.text_header_reply)
        val textReply: TextView = findViewById(R.id.text_reply)

        textReplyHeader.visibility = View.GONE
        textReply.visibility = View.GONE

        buttonSend.setOnClickListener {
            val secondActivityIntent = Intent(this, SecondActivity::class.java)
            val message = mMessageEditText.text.toString().trim()
            secondActivityIntent.putExtra("SEND_KEY_VALUE", message)
            startActivityForResult(secondActivityIntent, SECOND_ACTIVITY_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                val reply = data?.getStringExtra("REPLY_KEY_VALUE")
                val textReplyHeader: TextView = findViewById(R.id.text_header_reply)
                val textReply: TextView = findViewById(R.id.text_reply)

                if (reply != null) {
                    textReplyHeader.visibility = View.VISIBLE
                    textReply.text = reply
                    textReply.visibility = View.VISIBLE
                }
            }
        }
    }
}
