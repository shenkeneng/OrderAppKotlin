package com.kotlin.order

import android.Manifest
import android.os.Bundle
import com.ewu.core.utils.EasyPermissionsEx

 open class MyBaseActivity: BaseActivity() {

    // 请求文件存储权限的标识码
    private val MY_PERMISSIONS_REQUEST_WES = 1001
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (this !is SplashActivity) {
            if ( EasyPermissionsEx.hasPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE)) {

            }

        }
    }
    override fun initView() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initData() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}