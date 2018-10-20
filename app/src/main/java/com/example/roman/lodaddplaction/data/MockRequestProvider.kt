package com.example.roman.lodaddplaction.data

import com.example.roman.lodaddplaction.models.RequestModel
import com.example.roman.lodaddplaction.models.UserModel

class MockRequestProvider : RequestProvider {
    override fun getRequests(): List<RequestModel> {
        return listOf(
                RequestModel("Help me with printer",
                        listOf("IT, Принтеры"),
                        "Ничего не рОБОТОЕТ",
                        UserModel("Макаров",
                        "http://old.misis.ru/portals/0/Kaf_matem/Макаров%20П.В.jpg")),
                RequestModel("Подайте на сигареты",
                        listOf("Подать"),
                        "Просто нужно курнуть",
                        UserModel("Кирвяков",
                        "http://misis.ru/files/-/82378869657b1bee7639a3f7edb308d8/filonov.jpg"))
        )
    }
}