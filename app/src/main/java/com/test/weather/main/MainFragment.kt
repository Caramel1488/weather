package com.test.weather.main

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.skillbox.github.utils.autoCleared
import com.test.weather.R

class MainFragment: Fragment(R.layout.fragment_main) {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    private val viewModel : MainViewModel by viewModels()

    private var dayListAdapter: DayListAdapter by autoCleared()

    private lateinit var dayList: RecyclerView

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            locationResult ?: return
            for (location in locationResult.locations) {
                //Log.i("Location", "Lat: ${location.latitude}, Lng: ${location.longitude}")
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireContext())

        checkPermissions()
        initAdapter()
        observe()
    }

    fun observe(){
        viewModel.location.observe(viewLifecycleOwner){
            requireView().findViewById<TextView>(R.id.cityTextView).text = it
        }
        viewModel.forecast.observe(viewLifecycleOwner){
            dayListAdapter.submitList(it)
        }
    }

    fun checkPermissions(){
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(requireContext(), "Location Permission need", Toast.LENGTH_SHORT).show()
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }else{
            getLastLocation()
        }
    }

    fun initAdapter(){
        dayListAdapter = DayListAdapter {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToDetailDayFragment(
                viewModel.forecast.value?.get(it)
            )
            )
        }
        dayList = requireView().findViewById(R.id.mainList)
        with(dayList){
            adapter = dayListAdapter
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
            //setHasFixedSize(true)
        }
    }

    @SuppressLint("MissingPermission")
    private fun getLastLocation() {
        fusedLocationProviderClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                if (location != null) {
                    Log.i("Location", "Lat: ${location.latitude}, Lng: ${location.longitude}")
                    viewModel.getCurrentWeather("${location.latitude},${location.longitude}")
                } else {
                    requestNewLocationData()
                }
            }
    }

    @SuppressLint("MissingPermission")
    private fun requestNewLocationData() {
        val locationRequest = LocationRequest.create().apply {
            interval = 10000
            fastestInterval = 5000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }

        fusedLocationProviderClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            null
        )
    }
}