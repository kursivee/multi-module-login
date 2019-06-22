package com.kursivee.login.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kursivee.login.R
import com.kursivee.login.app.ext.coreComponent
import com.kursivee.login.view.di.DaggerViewComponent
import com.kursivee.login.view.di.ViewComponent
import com.kursivee.login.view.viewmodel.LoginViewModel
import javax.inject.Inject

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: LoginViewModel

    private val viewComponent: ViewComponent by lazy {
        DaggerViewComponent.builder()
            .coreComponent(requireActivity().application.coreComponent)
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        viewComponent.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.login_fragment, container, false).also {
            it.findViewById<TextView>(R.id.tv_message).text = viewModel.authenticate("", "").toString()
        }
    }

}
