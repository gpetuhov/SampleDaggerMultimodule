package com.gpetuhov.android.feature_profile_impl.start

import android.content.Context
import android.content.Intent
import com.gpetuhov.android.feature_profile_api.ProfileFeatureStarter
import com.gpetuhov.android.feature_profile_impl.ui.ProfileActivity

class ProfileFeatureStarterImpl : ProfileFeatureStarter {

    override fun start(context: Context) {
        // All ProfileFeatureStarterImpl does is just
        // starts ProfileActivity.
        val intent = Intent(context, ProfileActivity::class.java)
        context.startActivity(intent)
    }
}