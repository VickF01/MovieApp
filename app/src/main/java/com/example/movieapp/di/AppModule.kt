package com.example.movieapp.di

import com.example.movieapp.core.domain.usecase.MovieInteractor
import com.example.movieapp.core.domain.usecase.MovieUseCase
import com.example.movieapp.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get())}
}