package com.example.tbcexercises.presentation.launcher_screen

import androidx.lifecycle.ViewModel
import com.example.tbcexercises.domain.repository.user.UserPreferencesRepository
import com.example.tbcexercises.domain.repository.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    userPreferencesRepository: UserPreferencesRepository,
    userRepository: UserRepository
) : ViewModel() {

    val rememberMeFlow = userPreferencesRepository.getRememberMe()
    val user = userRepository.getUser()
}