package com.bilalqwatly.kroma.presentation.ui.base.view.activity

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bilalqwatly.kroma.R
import com.bilalqwatly.kroma.presentation.ui.base.IBaseView
import com.bilalqwatly.kroma.presentation.ui.base.adpter.BaseListAdapter


abstract class BaseActivity : AppCompatActivity(), IBaseView {


    var adapter: BaseListAdapter<*, *>? = null

    protected lateinit var context: Context
    protected abstract val layoutId: Int
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this

        setView()
    }


    override fun onBackPressed() {
        super.onBackPressed()
    }

    protected open fun setView() {
        setContentView(layoutId)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor =
                ContextCompat.getColor(this, R.color.color_grayF0F0F0)

        }
    }

    fun setLayoutManger(recyclerView: RecyclerView) {
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }

    // base methods
    override fun showMessage(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(stringId: Int) {
        showMessage(getString(stringId))
    }


}