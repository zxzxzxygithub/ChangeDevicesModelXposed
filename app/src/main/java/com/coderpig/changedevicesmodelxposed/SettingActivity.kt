package com.coderpig.changedevicesmodelxposed

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.orhanobut.hawk.Hawk

/**
 * 描述：机型设置页
 *
 * @author CoderPig on 2018/04/20 10:41.
 */
class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        Hawk.put(Constant.PACKAGE_NAME, "com.coderpig.changedevicesmodelxposed")
        Hawk.put(Constant.BRAND, "OPPO")
        Hawk.put(Constant.MODEL, "r11 plus")
        Hawk.put(Constant.RELEASE, "7.0")


    }
}