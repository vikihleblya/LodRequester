package com.example.roman.lodaddplaction.network

import com.example.roman.lodaddplaction.models.dto.LoginRequestDto
import com.example.roman.lodaddplaction.models.dto.LoginResponseDto
import io.reactivex.Single

interface LoginNetworkInteractorContract {
    fun login(body: LoginRequestDto) : Single<LoginResponseDto>
                                       // Completable -- no return values, but can return HTTP code
                                       // Observable -- множественные значения
                                       // Flowable -- множественные значения (если много)

                                       // SingleSubject : Single -- позволяет отправлять
                                                        // асинхронные события
}