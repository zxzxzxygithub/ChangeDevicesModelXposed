package com.coderpig.changedevicesmodelxposed

import android.os.Build
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.XposedHelpers.setStaticObjectField
import de.robv.android.xposed.callbacks.XC_LoadPackage

/**
 * 描述：修改手机机型的核心类
 *
 * @author CoderPig on 2018/04/20 10:40.
 */
class XposedInit : IXposedHookLoadPackage {
    @Throws(Throwable::class)
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        setStaticObjectField(Build::class.java, Constant.BRAND, "OPPO")
        setStaticObjectField(Build::class.java, Constant.PRODUCT, "OPPO")
        setStaticObjectField(Build::class.java, Constant.MANUFACTURER, "OPPO")
        setStaticObjectField(Build::class.java, Constant.MODEL, "亮瞎合金狗眼的 OPPO R11 Plus")
        setStaticObjectField(Build::class.java, Constant.DEVICES, "OPPO R11 Plus")
        setStaticObjectField(Build::class.java, Constant.RELEASE, "7.1")
        XposedHelpers.findAndHookMethod(XposedHelpers.findClass("android.os.SystemProperties", lpparam.classLoader), "native_get", object : XC_MethodHook() {
            override fun afterHookedMethod(param: MethodHookParam) {
                when (param.args[0].toString()) {
                    "ro.product.manufacturer", "ro.product.brand", "ro.product.name" -> param.result = "OPPO"
                    "ro.product.model", "ro.product.device" -> param.result = "OPPO R9s Plus"
                    "ro.product.version.release" -> param.result = "7.1"
                }
            }
        })
    }
}