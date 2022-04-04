package com.example.myapplication

import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var btnTransition : Button
    private lateinit var transitionsContainer  : ViewGroup
    private lateinit var toolBar : Toolbar
    private lateinit var navigationBar : NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        transitionsContainer = findViewById(R.id.transitions_container)
        btnTransition = findViewById(R.id.btnTransition)
        toolBar = findViewById(R.id.toolBar)
        navigationBar = findViewById(R.id.navigationBar)
       btnTransition.setOnClickListener(object : View.OnClickListener {
            var visible = false
            override fun onClick(v: View?) {
                TransitionManager.beginDelayedTransition(transitionsContainer)
                visible = !visible
                toolBar.visibility = if (visible) View.VISIBLE else View.GONE
                navigationBar.visibility = if (visible) View.VISIBLE else View.GONE
            }
        })
    }
}