package com.example.mytravelguide.base

import androidx.lifecycle.ViewModel
import java.lang.ref.WeakReference


abstract class BaseViewModel<N> : ViewModel() {

    private var mNavigator: WeakReference<N>? = null


    fun getNavigator(): N? {
        return mNavigator?.get()
    }

    fun setNavigator(navigator: N) {
        this.mNavigator = WeakReference(navigator)
    }

}