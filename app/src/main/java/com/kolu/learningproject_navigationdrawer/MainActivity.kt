package com.kolu.learningproject_navigationdrawer

import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kolu.learningproject_navigationdrawer.databinding.ActivityMainBinding
import com.kolu.learningproject_navigationdrawer.databinding.ActivityMainContentBinding

class MainActivity : AppCompatActivity() {

    lateinit var bndActivityMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bndActivityMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bndActivityMain.root)

        ViewCompat.setOnApplyWindowInsetsListener(bndActivityMain.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<ImageView>(R.id.icon_menu).setOnClickListener {
            bndActivityMain.contentInclude.iconMenu.setOnClickListener {
                bndActivityMain.main.open()
            }
        }

        bndActivityMain.navView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.mProfile -> {
                    Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show()
                    bndActivityMain.main.close()
                    true
                }
                R.id.mCart -> {
                    Toast.makeText(this, "Cart clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.mHistory -> {
                    Toast.makeText(this, "History clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.mSettings -> {
                    Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    Toast.makeText(this, "Other item clicked", Toast.LENGTH_LONG).show()
                    true
                }
            }
        }
    }
}
