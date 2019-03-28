package com.gpetuhov.android.feature_first_impl.start

import android.content.Context
import android.content.Intent
import com.gpetuhov.android.feature_first_api.FirstFeatureStarter
import com.gpetuhov.android.feature_first_impl.ui.FirstFeatureActivity

class FirstFeatureStarterImpl : FirstFeatureStarter {

    override fun start(context: Context) {
        val intent = Intent(context, FirstFeatureActivity::class.java)
        context.startActivity(intent)
    }
}