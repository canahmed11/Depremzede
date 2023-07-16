package com.ahmeturunveren.depremzede.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ahmeturunveren.depremzede.databinding.FeedRecyclerRowBinding
import com.ahmeturunveren.depremzede.view.FeedFragmentDirections

class FeedAdapter(val feedList:ArrayList<String>):RecyclerView.Adapter<FeedAdapter.FeedHolder>() {
    class FeedHolder(val binding: FeedRecyclerRowBinding):RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedHolder {
        val binding=FeedRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FeedHolder(binding)
    }

    override fun getItemCount(): Int {
        return feedList.size
    }

    override fun onBindViewHolder(holder: FeedHolder, position: Int) {
        holder.binding.feedFragmentTextView.text=feedList.get(position)
        holder.itemView.setOnClickListener {
            if(position==0){
                val action=FeedFragmentDirections.actionFeedFragmentToEarthquakesFragment()
                Navigation.findNavController(it).navigate(action)
            }else if(position==1){
                val action=FeedFragmentDirections.actionFeedFragmentToWhistleFragment()
                Navigation.findNavController(it).navigate(action)
            }else if(position==2){
                val action=FeedFragmentDirections.actionFeedFragmentToFaultLineFragment()
                Navigation.findNavController(it).navigate(action)
            }else if(position==3){
                val action=FeedFragmentDirections.actionFeedFragmentToBagFragment()
                Navigation.findNavController(it).navigate(action)
            }else if(position==4){
                val action=FeedFragmentDirections.actionFeedFragmentToUrgentCallFragment()
                Navigation.findNavController(it).navigate(action)
            }else if(position==5){
                val action=FeedFragmentDirections.actionFeedFragmentToLocationFragment()
                Navigation.findNavController(it).navigate(action)
            }
        }

    }
}