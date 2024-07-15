package com.example.encoretestgaura.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.encoretestgaura.R
import com.example.encoretestgaura.SongAdapter
import com.example.encoretestgaura.databinding.ActivityMainBinding
import com.example.encoretestgaura.viewmodel.MyViewModelFactory
import com.example.encoretestgaura.viewmodel.SongViewModel
import com.example.rangtechnologygauravassignment.repositories.SongRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewModel: SongViewModel by viewModels { MyViewModelFactory(application) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvSongs.layoutManager = LinearLayoutManager(this)

        val recyclerView: RecyclerView = findViewById(R.id.rvSongs)
        val songAdapter = SongAdapter(emptyList()) { song ->
            // Handle item click here, e.g., open a details screen
        }
        recyclerView.adapter = songAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        binding.progressCircular.visibility = View.VISIBLE
        viewModel.getSongsFromDb()
        viewModel.allSongs.observe(this){
            binding.progressCircular.visibility = View.GONE
            if(it.isNotEmpty()){
                songAdapter.updateSongs(it)
            }else{
                viewModel.getSongs(20)
            }
        }

    }
}