package com.example.mytravelguide.base

import android.os.Bundle
import android.util.SparseIntArray
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar


abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel<*>> : AppCompatActivity(){

    private var mViewDataBinding: T? = null
    private var viewModel: V? = null
    private var mErrorString: SparseIntArray? = null
    private var snackBar : Snackbar? = null


    abstract fun getBindingVariable(): Int

    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): V

    fun getViewDataBinding(): T {
        return mViewDataBinding!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()

    }


    private fun performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        this.viewModel = if (viewModel == null)
            getViewModel() else viewModel
        mViewDataBinding?.setVariable(getBindingVariable(), viewModel)
        mViewDataBinding?.executePendingBindings()
    }

}
