package com.example.whip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.view.MotionEvent
import android.os.SystemClock

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private var lastPlayTime: Long = 0          // 记录上次播放时间
    private val interval: Long = 1000           // 间隔 1 秒（毫秒）

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 初始化 MediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.whip)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            val currentTime = SystemClock.elapsedRealtime()
            if (currentTime - lastPlayTime >= interval) {
                mediaPlayer?.start()
                lastPlayTime = currentTime
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
