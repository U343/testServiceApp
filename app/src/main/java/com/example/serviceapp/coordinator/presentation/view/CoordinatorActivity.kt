package com.example.serviceapp.coordinator.presentation.view

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.MutableLiveData
import com.example.serviceapp.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlinx.android.synthetic.main.coordinator_activity.*

class CoordinatorActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var appBar: AppBarLayout
    private lateinit var collapsingToolbarLayout: CollapsingToolbarLayout
    private val offsetChangedListener: MutableList<AppBarLayout.OnOffsetChangedListener> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coordinator_activity)

        initViews()
        setupToolbar()
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    override fun onDestroy() {
        super.onDestroy()

        for (onOffsetChangedListener in offsetChangedListener) {
            appBar.removeOnOffsetChangedListener(onOffsetChangedListener)
        }
        offsetChangedListener.clear()
    }

    private fun initViews() {
        toolbar = findViewById(R.id.toolbar)
        appBar = findViewById(R.id.appbar)
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar)
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        supportActionBar?.title = null
        initAppbarOffsetListener()
        //collapsingToolbarLayout.statusBarScrim = null
        //collapsingToolbarLayout.title = null

    }

    private fun initAppbarOffsetListener() {
        val onOffsetChangedListener = object : AppBarLayout.OnOffsetChangedListener {
            var scrollRange = -1
            var toolbarHeight = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (toolbarHeight == -1) {
                    toolbarHeight = appBarLayout.height
                }

                if (scrollRange + verticalOffset == 0) {
                    supportActionBar?.title = "Озвученные операции"
                } else {
                    supportActionBar?.title = null
                    collapsing_toolbar.title = null
                }
            }

        }
        offsetChangedListener.add(onOffsetChangedListener)
        appBar.addOnOffsetChangedListener(onOffsetChangedListener)
    }
}