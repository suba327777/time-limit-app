package com.example.timelimitapp

import android.app.Activity
import android.app.AlertDialog
import android.app.admin.DeviceAdminReceiver
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent

class KioskManager() {
    companion object {

        fun startKioskMode(context: Activity) {

            val devicePolicyManager =
                context.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
            val myDeviceAdmin = ComponentName(context, KioskDeviceAdminReceiver::class.java)

            if (devicePolicyManager.isAdminActive(myDeviceAdmin)) {
                context.startLockTask()
            }
        }

        fun stopKioskMode(context:Activity){
             val devicePolicyManager =
                context.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
            val myDeviceAdmin = ComponentName(context, KioskDeviceAdminReceiver::class.java)

            if(devicePolicyManager.isAdminActive(myDeviceAdmin)){
                context.stopLockTask()
            }
        }

        fun isAdmin(context: Activity) {
            val devicePolicyManager =
                context.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
            val myDeviceAdmin = ComponentName(context, KioskDeviceAdminReceiver::class.java)
            if (!devicePolicyManager.isAdminActive(myDeviceAdmin)) {
                val dialog = AlertDialog.Builder(context)
                    .setTitle("権限を追加してください")
                    .setMessage("この機能を使用するためには特定の権限が必要です。設定画面を開き、アプリをデバイス管理者に設定してください。")
                    .setPositiveButton("設定画面に移動") { dialog, _ ->
                        context.startActivity(
                            Intent().setComponent(
                                ComponentName(
                                    "com.android.settings",
                                    "com.android.settings.DeviceAdminSettings"
                                )
                            )
                        )

                        dialog.dismiss()
                    }
                    .create()
                dialog.show()
            }
        }
    }

    class KioskDeviceAdminReceiver : DeviceAdminReceiver() {
        override fun onEnabled(context: Context, intent: Intent) {
            super.onEnabled(context, intent)
        }

        override fun onDisabled(context: Context, intent: Intent) {
            super.onDisabled(context, intent)
        }
    }
}