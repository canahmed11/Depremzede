package com.ahmeturunveren.depremzede.model

data class EarthquakeData(
    val github: String,
    val warning: String,
    val reference: String,
    val earthquakes: List<Earthquake>
)

data class Earthquake(
    val date: String,
    val time: String,
    val location: String,
    val city: String,
    val lat: String,
    val lng: String,
    val mag: String,
    val depth: String
)
