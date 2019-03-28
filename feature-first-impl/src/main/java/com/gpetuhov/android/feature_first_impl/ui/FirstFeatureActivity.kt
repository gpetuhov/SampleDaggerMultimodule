package com.gpetuhov.android.feature_first_impl.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gpetuhov.android.feature_first_impl.R

class FirstFeatureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_feature)
    }
}