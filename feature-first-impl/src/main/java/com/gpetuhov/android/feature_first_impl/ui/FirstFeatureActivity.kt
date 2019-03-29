package com.gpetuhov.android.feature_first_impl.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gpetuhov.android.core_utils.utils.Utils
import com.gpetuhov.android.feature_first_impl.R
import com.gpetuhov.android.feature_first_impl.di.components.FirstFeatureComponent
import com.gpetuhov.android.feature_profile_api.ProfileFeatureStarter
import kotlinx.android.synthetic.main.activity_first_feature.*
import javax.inject.Inject

class FirstFeatureActivity : AppCompatActivity() {

    @Inject lateinit var utils: Utils
    @Inject lateinit var profileFeatureStarter: ProfileFeatureStarter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_feature)

        FirstFeatureComponent.get()?.inject(this)
        app_title.text = utils.getAppTitle()
        profile_button.setOnClickListener { profileFeatureStarter.start(this) }
    }

    override fun onPause() {
        if (isFinishing) {
            // Clear component if the activity is finishing.
            // It is better to do it like this,
            // because onDestroy() is not guaranteed to be called.
            FirstFeatureComponent.resetComponent()
        }
        super.onPause()
    }
}