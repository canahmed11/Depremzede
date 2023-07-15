package com.ahmeturunveren.depremzede.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ahmeturunveren.depremzede.R
import com.ahmeturunveren.depremzede.databinding.FragmentWhistleBinding


class WhistleFragment : Fragment() {
    private var _binding:FragmentWhistleBinding?=null
    private val binding get()=_binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=FragmentWhistleBinding.inflate(inflater,container,false)
        val view=binding.root
        return view
    }


}