package com.gpetuhov.android.feature_profile_impl.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gpetuhov.android.core_db_api.data.DbClientApi
import com.gpetuhov.android.core_utils.utils.Utils
import com.gpetuhov.android.feature_profile_impl.R
import com.gpetuhov.android.feature_profile_impl.di.components.ProfileFeatureComponent
import kotlinx.android.synthetic.main.activity_profile.*
import javax.inject.Inject

class ProfileActivity : AppCompatActivity() {

    // ProfileActivity and ProfileFeatureComponent are inside the same module,
    // so they know of each other, and we can inject dependencies as usual.
    @Inject lateinit var utils: Utils
    @Inject lateinit var dbClientApi: DbClientApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Inject dependencies and use them
        ProfileFeatureComponent.get()?.inject(this)
        app_title.text = utils.getAppTitle()
        user_name.text = dbClientApi.getUser().name
    }
}