package com.ahmeturunveren.depremzede.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmeturunveren.depremzede.R
import com.ahmeturunveren.depremzede.adapter.FeedAdapter
import com.ahmeturunveren.depremzede.databinding.FragmentFeedBinding


class FeedFragment : Fragment() {
    private lateinit var feedList:ArrayList<String>
    private var _binding:FragmentFeedBinding?=null
    private val binding get()=_binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        feedList= ArrayList<String>()
        feedList.add("Gerçekleşen Depremler")
        feedList.add("Deprem Düdüğü")
        feedList.add("Güncel Fay Hatları")
        feedList.add("Deprem Çantası")
        feedList.add("Acil Aranacaklar")
        feedList.add("Konumu Kaydet")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=FragmentFeedBinding.inflate(inflater,container,false)
        val view=binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.feedRecyclerView.layoutManager=LinearLayoutManager(view.context)
        val feedAdapter=FeedAdapter(feedList)
        binding.feedRecyclerView.adapter=feedAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}