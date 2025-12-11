package com.example.launcherwhip

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            val intent = Intent()
            intent.setClassName(
                "com.blazedays.perfectcoffee",
                "cn.mbrowser.activity.BrowserActivity"
            )
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "目标应用未安装或无法启动", Toast.LENGTH_LONG).show()
        }

        finish()
    }
}
