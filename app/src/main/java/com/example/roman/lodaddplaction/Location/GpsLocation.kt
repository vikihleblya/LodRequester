package com.example.roman.lodaddplaction.Location

import kotlin.math.asin

fun getDistanceBetweenTwoMembers(latitude: Double, longitude: Double, latitude1: Double, longitude1: Double)
        : Double {
    val llatitude = latitude * kotlin.math.PI / 180
    val llatitude1 = latitude1 * kotlin.math.PI / 180
    val llongitude = longitude * kotlin.math.PI / 180
    val llongitude1 = longitude1 * kotlin.math.PI / 180
    val firstTerm = kotlin.math.sin((llatitude - llatitude1) / 2) * kotlin.math.sin((llatitude - llatitude1) / 2)
    val secondTerm = kotlin.math.cos(llatitude) *
            kotlin.math.cos(llatitude1) *
            kotlin.math.sin((llongitude - llongitude1) / 2) *
            kotlin.math.sin((llongitude - llongitude1) / 2)
    val sqrt = kotlin.math.sqrt(firstTerm + secondTerm)
    return kotlin.math.round(2 * asin(sqrt) * 6367.444)
}