package com.kursivee.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kursivee.core.view.ext.coreComponent
import com.kursivee.login.R
import com.kursivee.login.dux.LoginViewModel
import com.kursivee.login.view.di.DaggerViewComponent
import com.kursivee.login.view.di.ViewComponent
import kotlinx.android.synthetic.main.login_fragment.*
import javax.inject.Inject

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var vm: LoginViewModel

    private val viewComponent: ViewComponent by lazy {
        DaggerViewComponent.builder()
            .coreComponent(requireActivity().application.coreComponent)
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        viewComponent.inject(this)
        super.onCreate(savedInstanceState)
        vm = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.login_fragment, container, false).also { view ->
            vm.store.state.observe(viewLifecycleOwner, Observer {
                tv_message.text = if(it.loading) { "Loading" } else {
                    if(it.success) {
                        it.token
                    } else {
                        ""
                    }
                }
            })
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_login.setOnClickListener {
            vm.auth()
        }
    }

}
