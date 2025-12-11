package com.example.launcherwhip

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 尝试启动鸡盒
        val packageNameToLaunch = "com.blazedays.perfectcoffee"
        val launchIntent = packageManager.getLaunchIntentForPackage(packageNameToLaunch)

        if (launchIntent != null) {
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(launchIntent)
        } else {
            Toast.makeText(this, "目标应用未安装", Toast.LENGTH_LONG).show()
        }

        // 关闭 Launcher 应用自身
        finish()
    }
}
