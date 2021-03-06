package com.moon.nugasam

import android.app.ProgressDialog
import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager


open class BaseActivity : AppCompatActivity() {

    @VisibleForTesting
    val mProgressDialog by lazy {
        ProgressDialog(this)
    }

    fun showProgressDialog() {
        mProgressDialog.setMessage(getString(R.string.loading))
        mProgressDialog.isIndeterminate = true
        mProgressDialog.show()
    }

    fun hideProgressDialog() {
        if (mProgressDialog.isShowing) {
            mProgressDialog.dismiss()
        }
    }

    fun hideKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    public override fun onStop() {
        super.onStop()
        hideProgressDialog()
    }

}