package com.example.timelimitapp

import android.app.Activity
import android.app.admin.DeviceAdminReceiver
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent

class KioskManager() {

    fun setKioskMode(context:Activity) {

         val devicePolicyManager = context.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
         val myDeviceAdmin = ComponentName(context,KioskDeviceAdminReceiver::class.java)

        if(devicePolicyManager.isAdminActive(myDeviceAdmin)){
            context.startLockTask()
        }else{
            context.startActivity(
                Intent().setComponent(
                    ComponentName("com.android.settings","com.android.settings.DeviceAdminSettings")
                )
            )
        }
    }

    class KioskDeviceAdminReceiver:DeviceAdminReceiver(){
        override fun onEnabled(context: Context, intent: Intent) {
            super.onEnabled(context, intent)
        }

        override fun onDisabled(context: Context, intent: Intent) {
            super.onDisabled(context, intent)
        }
    }
}