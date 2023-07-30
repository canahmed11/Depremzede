package com.ahmeturunveren.depremzede.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmeturunveren.depremzede.databinding.EarthquakesRecyclerRowBinding
import com.ahmeturunveren.depremzede.model.Earthquake
import com.ahmeturunveren.depremzede.model.EarthquakeData

class EarthquakesAdapter(val earthquakeList:ArrayList<EarthquakeData>):RecyclerView.Adapter<EarthquakesAdapter.EarthquakesHolder>() {

    class EarthquakesHolder(val binding:EarthquakesRecyclerRowBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EarthquakesHolder {
        val binding=EarthquakesRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EarthquakesHolder(binding)
    }

    override fun getItemCount(): Int {
        return earthquakeList.size
    }

    override fun onBindViewHolder(holder: EarthquakesHolder, position: Int) {

        holder.binding.textViewDate.text=earthquakeList[position].earthquakes[position].date
        holder.binding.textViewTime.text=earthquakeList[position].earthquakes[position].time
        holder.binding.textViewLocation.text=earthquakeList[position].earthquakes[position].location
        holder.binding.textViewCity.text=earthquakeList[position].earthquakes[position].city
        holder.binding.textViewLat.text=earthquakeList[position].earthquakes[position].lat
        holder.binding.textViewLng.text=earthquakeList[position].earthquakes[position].lng
        holder.binding.textViewMag.text=earthquakeList[position].earthquakes[position].mag
        holder.binding.textViewDepth.text=earthquakeList[position].earthquakes[position].depth
    }
}