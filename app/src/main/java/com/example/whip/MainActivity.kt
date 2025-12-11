package com.example.launcherwhip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val targetPackage = "com.blazedays.perfectcoffee"  // 鸡盒包名

        val intent = packageManager.getLaunchIntentForPackage(targetPackage)
        if (intent != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "目标应用未安装", Toast.LENGTH_SHORT).show()
        }

        finish()  // 启动目标应用后关闭自己
    }
}
