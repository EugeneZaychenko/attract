package com.ua.eugenezaychenko.attractez.utils.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ua.eugenezaychenko.attractez.utils.CustomProgressDialog

abstract class BaseFragment : Fragment() {

    protected abstract val viewResource: Int

    protected abstract fun injectDependencies(): Unit?

    private var isInstanceStateSaved = false

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectDependencies()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(viewResource, container, false)
    }

    override fun onResume() {
        super.onResume()
        isInstanceStateSaved = false
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        isInstanceStateSaved = true
    }

    protected fun showProgressbarDialog() {
        if (isInstanceStateSaved) return

        val fragment = childFragmentManager.findFragmentByTag(PROGRESS_TAG)

        if (fragment == null) {
            CustomProgressDialog().show(childFragmentManager, PROGRESS_TAG)
            childFragmentManager.executePendingTransactions()
        }
    }

    protected fun hideProgressbarDialog() {
        if (isInstanceStateSaved) return

        val fragment = childFragmentManager.findFragmentByTag(PROGRESS_TAG)

        fragment?.let {
            (it as CustomProgressDialog).dismissAllowingStateLoss()
            childFragmentManager.executePendingTransactions()
        }
    }

    protected fun showToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        private const val PROGRESS_TAG = "com.ua.eugenezaychenko.attractez.progress"
    }
}