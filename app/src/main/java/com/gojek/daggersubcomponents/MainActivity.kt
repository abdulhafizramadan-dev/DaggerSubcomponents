package com.gojek.daggersubcomponents

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import com.gojek.daggersubcomponents.data.NameDataSource
import com.gojek.daggersubcomponents.databinding.ActivityMainBinding
import com.gojek.daggersubcomponents.di.NameComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var nameComponent: NameComponent

    @Inject lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()

        nameComponent = (application as MainApplication).applicationComponent.nameComponent().create()
        nameComponent.inject(this)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initObserver()
    }

    private fun initObserver() {
        viewModel.nameState.observe(this) { name ->
            binding.tvName.text = name
        }
    }
}