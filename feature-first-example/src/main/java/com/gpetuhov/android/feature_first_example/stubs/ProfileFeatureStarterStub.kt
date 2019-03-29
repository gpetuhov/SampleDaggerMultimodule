package com.gpetuhov.android.feature_first_example.stubs

import android.content.Context
import android.widget.Toast
import com.gpetuhov.android.feature_profile_api.ProfileFeatureStarter

// This stub is used in this application module instead of
// ProfileFeatureStarterImpl from feature-profile-impl.

class ProfileFeatureStarterStub : ProfileFeatureStarter {

    override fun start(context: Context) {
        // Instead of really starting ProfileActivity, just show toast.
        Toast.makeText(context, "Profile stub", Toast.LENGTH_SHORT).show()
    }
}