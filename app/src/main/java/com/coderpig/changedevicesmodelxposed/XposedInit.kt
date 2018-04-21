package com.coderpig.changedevicesmodelxposed

import android.annotation.SuppressLint
import android.os.Build
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers.setStaticObjectField
import de.robv.android.xposed.callbacks.XC_LoadPackage


/**
 * 描述：修改手机机型的核心类
 *
 * @author CoderPig on 2018/04/20 10:40.
 */
class XposedInit : IXposedHookLoadPackage {
    @SuppressLint("PrivateApi")
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        when(lpparam.packageName) {
            "com.tencent.tmgp.sgame","com.coolapk.market" -> {
                //兼容低版本
                setStaticObjectField(Build::class.java, Constant.MANUFACTURER, "OPPO")
                setStaticObjectField(Build::class.java, Constant.BRAND, "OPPO")
                setStaticObjectField(Build::class.java, Constant.PRODUCT, "R11 Plus")
                setStaticObjectField(Build::class.java, Constant.DEVICE, "R11 Plus")
                setStaticObjectField(Build::class.java, Constant.MODEL, "OPPO R11 Plus")
                //应对反射获取机型的情况
                val c = Class.forName("android.os.SystemProperties")
                val m = c.getDeclaredMethod("native_get", String::class.java, String::class.java)
                m.isAccessible = true
                XposedBridge.hookMethod(m, object : XC_MethodHook() {
                    override fun afterHookedMethod(param: MethodHookParam) {
                        when (param.args[0].toString()) {
                            "ro.product.manufacturer", "ro.product.brand" -> param.result = "OPPO"
                            "ro.product.name", "ro.product.device" -> param.result = "R11 Plus"
                            "ro.product.model" -> param.result = "OPPO R11 Plus"
                        }
                    }
                })
            }
        }
    }
}