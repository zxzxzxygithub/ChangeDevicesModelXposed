package com.coderpig.changedevicesmodelxposed

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * 描述：机型设置页
 *
 * @author CoderPig on 2018/04/20 10:41.
 */
class SettingActivity : AppCompatActivity() {

    @SuppressLint("PrivateApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        //获取设备信息
//        val devicesInfo = StringBuffer()
//        devicesInfo.append("ID：").append(Build.ID).append("\n")
//        devicesInfo.append("DISPLAY：").append(Build.DISPLAY).append("\n")
//        devicesInfo.append("PRODUCT：").append(Build.PRODUCT).append("\n")
//        devicesInfo.append("DEVICE：").append(Build.DEVICE).append("\n")
//        devicesInfo.append("BOARD：").append(Build.BOARD).append("\n")
//        devicesInfo.append("CPU_ABI：").append(Build.CPU_ABI).append("\n")
//        devicesInfo.append("CPU_ABI2：").append(Build.CPU_ABI2).append("\n")
//        devicesInfo.append("MANUFACTURER：").append(Build.MANUFACTURER).append("\n")
//        devicesInfo.append("BRAND：").append(Build.BRAND).append("\n")
//        devicesInfo.append("MODEL：").append(Build.MODEL).append("\n")
//        devicesInfo.append("BOOTLOADER：").append(Build.BOOTLOADER).append("\n")
//        devicesInfo.append("RADIO：").append(Build.RADIO).append("\n")
//        devicesInfo.append("HARDWARE：").append(Build.HARDWARE).append("\n")
//        devicesInfo.append("BOOTLOADER：").append(Build.BOOTLOADER).append("\n")
//        devicesInfo.append("INCREMENTAL：").append(Build.VERSION.INCREMENTAL).append("\n")
//        devicesInfo.append("RELEASE：").append(Build.VERSION.RELEASE).append("\n")
//        devicesInfo.append("SDK：").append(Build.VERSION.SDK).append("\n")
//        devicesInfo.append("SDK_INT：").append(Build.VERSION.SDK_INT).append("\n")
        //测试反射
        val c = Class.forName("android.os.Build")
        val m = c.getDeclaredMethod("getString",String::class.java)
        m.isAccessible = true
        Log.e("HEHE", (m.invoke(c.newInstance(), "ro.product.model")).toString())
    }
}