package com.kursivee.login.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kursivee.login.R
import com.kursivee.login.view.LoginFragment

class AppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.core_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment.newInstance())
                .commitNow()
        }
    }

}
