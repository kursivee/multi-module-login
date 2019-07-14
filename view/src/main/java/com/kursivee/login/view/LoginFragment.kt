package com.kursivee.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kursivee.core.view.ext.coreComponent
import com.kursivee.login.R
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
        return inflater.inflate(R.layout.login_fragment, container, false).also { view ->
            viewModel.success.observe(this, Observer {
                view.findViewById<TextView>(R.id.tv_message).text = it.toString()
            })
            // Double calling to check if caching is called
            viewModel.authenticate("", "").toString()
            viewModel.authenticate("", "").toString()
        }
    }

}
