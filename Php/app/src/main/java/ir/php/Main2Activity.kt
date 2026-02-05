package ir.php

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.NotificationCompat
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


    }

    fun save(view : View)
    {
        val username = findViewById(R.id.user) as EditText;
        val password = findViewById(R.id.pass) as EditText;

        val sharePreferences = getSharedPreferences("userInfo",Context.MODE_PRIVATE)
        val editor = sharePreferences.edit()
        editor.putString("username",username.text.toString())
        editor.putString("password",password.text.toString())
        editor.apply()

        Toast.makeText(this,"Saved",Toast.LENGTH_SHORT)

    }

    fun retrieve (view : View)
    {
        val sharePreferences = getSharedPreferences("userInfo",Context.MODE_PRIVATE)
        val name =sharePreferences.getString("username",null)
        val pass = sharePreferences.getString("password",null)

        Toast.makeText(this,name+","+pass,Toast.LENGTH_SHORT)


    }


}
