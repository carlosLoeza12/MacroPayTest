package com.example.macropaytest.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.macropaytest.R
import com.example.macropaytest.databinding.FragmentHomeBinding
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import java.lang.Exception

import com.auth0.android.jwt.JWT

class Home : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val args by navArgs<HomeArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        initElements()
    }

    private fun initElements(){
        decode()
        binding.txtCodeBar.text = args.token
        generateBarCode()
    }

    private fun generateBarCode() {
        try {
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.encodeBitmap(
               "123456789876",
                BarcodeFormat.ITF,
                850, 150
            )
            //set bitmap in the img
            binding.imgBarCode.setImageBitmap(bitmap)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun decode(){
        val parsedJWT = JWT(args.token ?: "")
        val subscriptionMetaData = parsedJWT.getClaim("titular")
        val parsedValue = subscriptionMetaData.asString()
        binding.txtNameUser.text =  "!Bienvenido! \n" + parsedValue

    }
}