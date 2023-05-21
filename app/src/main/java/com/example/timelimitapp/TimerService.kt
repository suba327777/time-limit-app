//package com.example.timelimitapp
//
//import android.app.Service
//import android.content.ComponentName
//import android.content.Intent
//
//class TimerService:Service() {
//
//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        if(intent?.action == ACTION_TIMER){
//            // 他のアプリ（timelimitapp）に遷移するためのIntentを作成
//            val targetPackage = "com.example.timelimitapp"
//            val targetActivity = "com.example.timelimitapp.MainActivity"
//            val targetIntent = Intent(Intent.ACTION_MAIN)
//                .setComponent(ComponentName(targetPackage, targetActivity))
//                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            // アプリのコンテキストを使用してアプリを起動
//            applicationContext.startActivity(targetIntent)
//
//        }
//        return START_NOT_STICKY
//    }
//
//    companion object{
//        private const val ACTION_TIMER = "com.example.timelimitapp.ACTION_TIMER"
//    }
//}