package com.example.checkinternetconnectionkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var connectionLiveData: ConnectionLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkNetworkConnection()
    }

    private fun checkNetworkConnection() {
        connectionLiveData=ConnectionLiveData(application)
        connectionLiveData.observe(this, { isConnected ->

            if (isConnected) {
                Toast.makeText(applicationContext,"Connected",Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext,"Disconnected",Toast.LENGTH_LONG).show()
            }
        })
    }
}