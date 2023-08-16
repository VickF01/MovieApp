package com.example.movieapp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.core.domain.model.Movie
import com.example.movieapp.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val detail = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        showDetail(detail)

        binding.back.setOnClickListener {
            finish()
        }
    }

    private fun showDetail(detail: Movie?) {
        detail?.let {
            binding.tvTitle.text = detail.title
            binding.tvDescDetail.text = detail.overview
            binding.rating.text = "${it.vote_average} / 10"
            Glide.with(this@DetailActivity).load(detail.poster_path).into(binding.ivDetail)

            var fav = detail.isFavorite
            setStatus(fav)

            binding.favBtn.setOnClickListener {
                fav = !fav
                detailViewModel.setFavMovie(detail, fav)
                setStatus(fav)
            }
        }
    }

    private fun setStatus(fav: Boolean) {
        if (fav) {
            binding.favBtn.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.baseline_favorite_24))
        } else {
            binding.favBtn.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.baseline_favorite_border_24))
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}