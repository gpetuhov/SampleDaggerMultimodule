package com.gpetuhov.android.feature_second_impl.start

import android.content.Context
import android.content.Intent
import com.gpetuhov.android.feature_second_api.SecondFeatureStarter
import com.gpetuhov.android.feature_second_impl.ui.SecondFeatureActivity

class SecondFeatureStarterImpl : SecondFeatureStarter {

    override fun start(context: Context) {
        val intent = Intent(context, SecondFeatureActivity::class.java)
        context.startActivity(intent)
    }
}