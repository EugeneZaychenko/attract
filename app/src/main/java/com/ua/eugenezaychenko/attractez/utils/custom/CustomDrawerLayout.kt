package com.ua.eugenezaychenko.attractez.utils.custom

import android.content.Context
import android.util.AttributeSet
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.ua.eugenezaychenko.attractez.R

class CustomDrawerLayout @JvmOverloads constructor(context: Context,
                                                   attrs: AttributeSet? = null) : DrawerLayout(context, attrs) {

    private var isTablet = false

    init {
        setState(attrs)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        if (isTablet) {
            openDrawer(GravityCompat.START, false)
            setDrawerLockMode(LOCK_MODE_LOCKED_OPEN)
        } else {

            setDrawerLockMode(LOCK_MODE_UNLOCKED)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val customWidthMeasureSpec = MeasureSpec.makeMeasureSpec(
                MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.EXACTLY)
        val customHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
                MeasureSpec.getSize(heightMeasureSpec), MeasureSpec.EXACTLY)
        super.onMeasure(customWidthMeasureSpec, customHeightMeasureSpec)
    }

    private fun setState(attrs: AttributeSet?) {
        attrs?.let {

            val typedArray = context.theme.obtainStyledAttributes(
                    attrs,
                    R.styleable.CustomDrawerLayout,
                    0,
                    0)

            isTablet = typedArray.getBoolean(R.styleable.CustomDrawerLayout_isTablet, false)

        }
    }

}