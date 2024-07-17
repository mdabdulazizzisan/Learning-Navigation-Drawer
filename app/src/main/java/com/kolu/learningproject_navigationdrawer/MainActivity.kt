package com.kolu.learningproject_navigationdrawer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kolu.learningproject_navigationdrawer.databinding.ActivityMainBinding
import com.kolu.learningproject_navigationdrawer.databinding.ActivityMainContentBinding

class MainActivity : AppCompatActivity() {

    lateinit var bndActivityMainContent: ActivityMainContentBinding
    lateinit var bndActivityMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bndActivityMainContent = ActivityMainContentBinding.inflate(layoutInflater)
        bndActivityMain = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(bndActivityMain.root)
        ViewCompat.setOnApplyWindowInsetsListener(bndActivityMain.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}