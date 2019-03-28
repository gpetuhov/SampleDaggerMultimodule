package com.gpetuhov.android.sampledaggermultimodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gpetuhov.android.core_utils.di.components.CoreUtilsComponent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get application title from Utils class.
        // Notice, that CoreUtilsComponent does not inject anything.
        // Instead we call utils() method of CoreUtilsApi interface,
        // which CoreUtilsComponent implements.
        val appTitle = CoreUtilsComponent.get()?.utils()?.getAppTitle() ?: ""
        app_title.text = appTitle

        profile_button.setOnClickListener { startProfile() }
    }

    private fun startProfile() {
        // TODO
    }
}
