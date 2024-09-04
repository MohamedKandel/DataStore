package com.mkandeel.datastore

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.mkandeel.datastore.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val key = "Key1"

        val ds = DataStorage.getInstance(this)
        lifecycleScope.launch {
            ds.putString(this@MainActivity, key, "Great Work !")
        }
        binding.txtView.setOnClickListener {
            lifecycleScope.launch {
                Log.d("Data from ds",ds.getString(this@MainActivity, key)?:"No value found")
            }
        }
    }
}