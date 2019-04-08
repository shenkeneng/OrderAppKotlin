package com.kotlin.order

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import com.ewu.core.widget.MyProgressDialog

abstract class  BaseActivity: AppCompatActivity(){

    private var progressDialog: MyProgressDialog? = null
    private var dialogCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        progressDialog = MyProgressDialog(this)
        progressDialog?.setCancelable(false)
    }

    /**
     * 初始化数据
     */
    protected abstract fun initView()

    protected abstract fun initData()

    public fun gotoActivity(clz: Class<*>){
        gotoActivity(clz, false, null)
    }

    public fun gotoActivity(clz: Class<*>, isCloseCurrentActivity: Boolean){
        gotoActivity(clz, isCloseCurrentActivity)
    }

    public fun gotoActivity(clz: Class<*>, isCloseCurrentActivity: Boolean, ex: Bundle?) {
        val intent: Intent = Intent()
        if (ex != null) {
            intent.putExtras(ex)
        }
        startActivity(intent)
        if (isCloseCurrentActivity) {
            finish()
        }
    }

    public fun gotoActivityForResult(clz: Class<*>, isCloseCurrentActivity: Boolean, ex: Bundle, requestCode: Int) {
        var intent = Intent(this, clz)
        if (ex != null) {
            intent.putExtras(ex)
        }
        startActivityForResult(intent, requestCode)
        if (isCloseCurrentActivity){
            finish()
        }
    }

    fun isShowingProgressDialog(): Boolean {
        return progressDialog!!.isShowing
    }

    fun showProgressDialog() {
        dialogCount++
        if (!progressDialog!!.isShowing){
            progressDialog?.showProgress()
        }
    }

    fun dismissProgressDialog() {
        dialogCount--
        if (dialogCount <= 0) {
            dialogCount = 0
            progressDialog?.dismissProgress()
        }
    }
}