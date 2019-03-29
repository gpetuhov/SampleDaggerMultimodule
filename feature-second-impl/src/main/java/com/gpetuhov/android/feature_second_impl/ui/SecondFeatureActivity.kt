package com.gpetuhov.android.feature_second_impl.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gpetuhov.android.core_utils.utils.Utils
import com.gpetuhov.android.feature_profile_api.ProfileFeatureStarter
import com.gpetuhov.android.feature_second_impl.R
import com.gpetuhov.android.feature_second_impl.di.components.SecondFeatureComponent
import kotlinx.android.synthetic.main.activity_second_feature.*
import javax.inject.Inject

class SecondFeatureActivity : AppCompatActivity() {

    @Inject lateinit var utils: Utils
    @Inject lateinit var profileFeatureStarter: ProfileFeatureStarter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_feature)

        SecondFeatureComponent.get()?.inject(this)
        app_title.text = utils.getAppTitle()
        profile_button.setOnClickListener { profileFeatureStarter.start(this) }
    }

    override fun onPause() {
        if (isFinishing) {
            SecondFeatureComponent.resetComponent()
        }
        super.onPause()
    }
}