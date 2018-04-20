package com.coderpig.changedevicesmodelxposed

import android.app.Application
import com.orhanobut.hawk.Hawk
import kotlin.properties.Delegates

/**
 * 描述：
 *
 * @author CoderPig on 2018/04/20 17:22.
 */
class App: Application() {
    companion object {
        var instance by Delegates.notNull<App>()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Hawk.init(this).build()
    }
}