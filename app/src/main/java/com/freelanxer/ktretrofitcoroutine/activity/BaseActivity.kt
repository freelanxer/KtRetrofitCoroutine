package com.freelanxer.ktretrofitcoroutine.activity

import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open abstract class BaseActivity: AppCompatActivity(), OnClickListener {

    fun showToast(resId: Int) = showToast(getString(resId))
    fun showToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    override fun onClick(view: View?) {

    }

}