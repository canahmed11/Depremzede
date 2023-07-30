package com.ahmeturunveren.depremzede.service
import com.ahmeturunveren.depremzede.model.EarthquakeData
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET

interface EarthquakeAPI {

    @GET("earthquake/v1/last24hours")
    //fun getData(): Call<EarthquakeData>
    fun getData():Observable<List<EarthquakeData>>
}