package com.noblemajesty.brt.views.authentication

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.noblemajesty.brt.R
import com.noblemajesty.brt.Utils
import com.noblemajesty.brt.Utils.PREFERENCE
import android.view.WindowManager
import com.noblemajesty.brt.BuildConfig


class RegistrationActivity : AppCompatActivity() {

    private lateinit var viewModel: AuthenticationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                    or WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED)
        }
        setContentView(R.layout.registration_activity)

        viewModel = ViewModelProviders.of(this).get(AuthenticationViewModel::class.java)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, LoginFragment.newInstance())
                    .commitNow()
        }
    }

    fun saveDetailsToSharedPreference(firstName: String, lastName: String, email:String, userId: Int) {
        getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE)
                .edit()
                .putString(Utils.email, email)
                .putString(Utils.firstName, firstName)
                .putString(Utils.lastName, lastName)
                .putInt(Utils.userID, userId)
                .apply()
    }

}
