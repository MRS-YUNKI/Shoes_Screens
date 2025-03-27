package com.example.shoes.di

import com.example.shoes.data.Auth
import com.example.shoes.data.RetrofitClient
import com.example.shoes.data.domain.usecase.AuthUseCase
import com.example.shoes.data.local.localStorage
import com.example.shoes.data.repository.AuthRepository
import com.example.shoes.ui.screen.signUp.SignUpViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    single<localStorage> { localStorage(androidContext()) }
    single<Auth> { RetrofitClient.retrofit }
    single<AuthRepository> { AuthRepository(get()) }
    single<AuthUseCase> { AuthUseCase(get(), get()) }
    viewModel<SignUpViewModel> { SignUpViewModel(get()) }

}