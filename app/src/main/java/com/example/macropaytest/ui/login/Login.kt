package com.example.macropaytest.ui.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.macropaytest.R
import com.example.macropaytest.databinding.FragmentLoginBinding
import com.example.macropaytest.presentation.ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Login : Fragment(R.layout.fragment_login) {

    private lateinit var  binding: FragmentLoginBinding
    private val viewModel by viewModels<ViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        initElements()
    }

    private fun initElements(){
        viewModel._loginResponse.observe(viewLifecycleOwner, Observer {
            if (it.success){
                val action = LoginDirections.actionLoginToHome2(it.token, binding.edtEmail.text.toString())
                findNavController().navigate(action)
            }else{
                Toast.makeText(context, "Datos incorrectos", Toast.LENGTH_SHORT).show()
            }

        })

        viewModel._responseMsg
        binding.btnAccept.setOnClickListener {
            if(validateFields()) {
                val email: String = binding.edtEmail.text.trim().toString()
                val password = binding.edtPassword.text.trim().toString()
                viewModel.makeLogin(email, password)
            }
        }
    }

    private fun validateFields(): Boolean{
        var isComplete = true

        if(binding.edtEmail.text.trim().toString().isEmpty() || binding.edtPassword.text.trim().toString().isEmpty()){
            Toast.makeText(context, "Revise los campos por favor", Toast.LENGTH_SHORT).show()
            isComplete = false;
        }
        return isComplete
    }

}