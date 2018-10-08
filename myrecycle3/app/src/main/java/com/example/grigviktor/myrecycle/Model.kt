package com.example.grigviktor.myrecycle

data class PersonNeed (var title: String, var Tag: String)

object Supplier {
    val titles = listOf<PersonNeed>(
            PersonNeed("Help with router", "Router"),
            PersonNeed("Cook the dish", "Cooking"),
            PersonNeed("Go to PY", "GYM"),
            PersonNeed("Eating Toast", "Pls halp"),
            PersonNeed("Fuck you Debbie", "Explicit Content"),
            PersonNeed("Now this looks like", "Is Job for me"),
            PersonNeed("Common User Interface", "NEnene"),
            PersonNeed("Help with router", "Router"),
            PersonNeed("Cook the dish", "Cooking"),
            PersonNeed("Go to PY", "GYM"),
            PersonNeed("Eating Toast", "Pls halp"),
            PersonNeed("Fuck you Debbie", "Explicit Content"),
            PersonNeed("Now this looks like", "Is Job for me"),
            PersonNeed("Common User Interface", "Nenene")
            )
}