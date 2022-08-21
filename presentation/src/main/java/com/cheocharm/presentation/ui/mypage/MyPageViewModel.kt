package com.cheocharm.presentation.ui.mypage

import androidx.lifecycle.ViewModel
import com.cheocharm.domain.usecase.RequestSignOutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val requestSignOutUseCase: RequestSignOutUseCase
) : ViewModel() {

    fun requestSignOut() {
        requestSignOutUseCase.invoke()
    }
}
