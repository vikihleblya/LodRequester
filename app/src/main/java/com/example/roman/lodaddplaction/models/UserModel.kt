package com.example.roman.lodaddplaction.models

import java.io.Serializable

data class UserModel(
        val name: String,
        val avatarUrl: String
) : Serializable