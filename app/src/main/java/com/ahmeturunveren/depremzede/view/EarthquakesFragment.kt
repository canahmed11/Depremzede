package com.ahmeturunveren.depremzede.view
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ahmeturunveren.depremzede.adapter.EarthquakesAdapter
import com.ahmeturunveren.depremzede.databinding.FragmentEarthquakesBinding
import com.ahmeturunveren.depremzede.model.Earthquake
import com.ahmeturunveren.depremzede.model.EarthquakeData
import com.ahmeturunveren.depremzede.service.EarthquakeAPI
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
class EarthquakesFragment : Fragment() {

    private var _binding: FragmentEarthquakesBinding? = null
    private val binding get() = _binding!!

    private val BASE_URL = "https://api.hknsoft.com/"

    private var earthquakeModels: ArrayList<Earthquake>? = null

    private var earthquakeAdapter: EarthquakesAdapter? = null

    private var compositeDisposable:CompositeDisposable?=null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEarthquakesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        compositeDisposable= CompositeDisposable()
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(requireContext())
        binding.earthquakesRecyclerView.layoutManager = layoutManager

        loadData()
    }

    private fun loadData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build().create(EarthquakeAPI::class.java)

        compositeDisposable?.add(retrofit.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse)

        )

        /*
        val service = retrofit.create(EarthquakeAPI::class.java)
        val call = service.getData()
        call.enqueue(object : Callback<EarthquakeData> {
            override fun onResponse(call: Call<EarthquakeData>, response: Response<EarthquakeData>) {
                if (response.isSuccessful) {
                    val earthquakeData = response.body()
                    earthquakeData?.let {
                        earthquakeModels = ArrayList(it.earthquakes)
                        earthquakeAdapter = EarthquakesAdapter(earthquakeModels!!)
                        binding.earthquakesRecyclerView.adapter = earthquakeAdapter
                    }
                }
            }

            override fun onFailure(call: Call<EarthquakeData>, t: Throwable) {
                t.printStackTrace()
            }
        })
        */

    }
    private fun handleResponse(earthquakeList:List<EarthquakeData>){
        val earthquakeData = ArrayList(earthquakeList)
        earthquakeData.let {
            earthquakeAdapter = EarthquakesAdapter(it)
            binding.earthquakesRecyclerView.adapter = earthquakeAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        compositeDisposable?.clear()
    }
}

