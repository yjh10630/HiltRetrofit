package com.jihunyun.hiltmvvmretrofitrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.jihunyun.hiltmvvmretrofitrecyclerview.databinding.ActivityMainBinding
import com.jihunyun.hiltmvvmretrofitrecyclerview.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * MainActivity -> MainViewModel -> MainUseCase -> MainRepository(RemoteData(Retrofit) or LocalData(Raw Folder File)) return -> MainUseCase -> MainViewModel -> MainActivity
 */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.imgList.observe(this) {
            Log.d("####", it.toString())
        }

    }
}