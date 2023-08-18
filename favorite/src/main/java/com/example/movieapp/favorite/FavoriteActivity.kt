package com.example.movieapp.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapp.core.ui.MovieAdapter
import com.example.movieapp.favorite.databinding.ActivityFavoriteBinding
import com.example.movieapp.favorite.di.favoriteModule
import com.example.movieapp.ui.detail.DetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        loadKoinModules(favoriteModule)

        binding.back.setOnClickListener { finish() }

        val favAdapter = MovieAdapter()
        favAdapter.onItemClick = {
            val intent = Intent(this@FavoriteActivity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, it)
            startActivity(intent)
        }

        favoriteViewModel.favMovie.observe(this) {
            favAdapter.setData(it)
            if (it.isEmpty()) binding.fav.text = "No Favorite" else "My Favorite"
        }

        with(binding.rvFav) {
            layoutManager = GridLayoutManager(this@FavoriteActivity, 2)
            setHasFixedSize(true)
            adapter = favAdapter
        }
    }
}