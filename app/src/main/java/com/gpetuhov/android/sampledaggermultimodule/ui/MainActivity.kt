package com.gpetuhov.android.sampledaggermultimodule.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gpetuhov.android.core_utils.di.components.CoreUtilsComponent
import com.gpetuhov.android.sampledaggermultimodule.R
import com.gpetuhov.android.sampledaggermultimodule.di.FeatureProxyInjector
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
        first_feature_button.setOnClickListener { startFirstFeature() }
    }

    private fun startProfile() {
        // Get ProfileFeatureStarter and use it to start ProfileActivity
        FeatureProxyInjector.getFeatureProfile()?.profileFeatureStarter()?.start(this)
    }

    private fun startFirstFeature() {
        FeatureProxyInjector.getFeatureFirst()?.firstFeatureStarter()?.start(this)
    }
}
