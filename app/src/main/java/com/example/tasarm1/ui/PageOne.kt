package com.example.tasarm1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasarm1.R
import com.example.tasarm1.adapter.CustomAdapter
import com.example.tasarm1.adapter.TransacAdapter
import com.example.tasarm1.data.Crypto
import com.example.tasarm1.data.CurrentCrypto
import com.example.tasarm1.databinding.FragmentPageOneBinding
import com.google.android.material.navigation.NavigationView


class PageOne : Fragment() {

    private var _binding: FragmentPageOneBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CustomAdapter
    private lateinit var adapterCurrent: TransacAdapter
    lateinit var toogle: ActionBarDrawerToggle

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPageOneBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val drawerLayout : DrawerLayout = binding.drawerLayout
        val navView : NavigationView = binding.navView


        toogle = ActionBarDrawerToggle(requireActivity(),drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
               // R.id.pageFive -> Toast.makeText(this,"click", Toast.LENGTH_LONG).show()
            }
            true
        }

       firstAdapterDefine()
       secondAdapterDefine()
       openNotificationFragment()
       openDrawerMenu()

    }

    private fun openDrawerMenu() {
        binding.include.imageView.setOnClickListener {
            openCloseNavigationDrawer(it)
        }
    }

    private fun openNotificationFragment() {
        binding.include.notification.setOnClickListener {
            findNavController().navigate(R.id.action_pageOne_to_notificationFragment)
        }
    }

    private fun secondAdapterDefine() {
        val valuesCurrent = defineCurrentParametres()
        binding.recyclerViewTwo.layoutManager = LinearLayoutManager(requireContext())
        adapterCurrent = TransacAdapter(valuesCurrent)
        binding.recyclerViewTwo.adapter = adapterCurrent
    }

    private fun firstAdapterDefine() {
        val values = defineCryptoParametres()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        adapter = CustomAdapter(values)
        binding.recyclerView.adapter = adapter
    }

    fun openCloseNavigationDrawer(view: View) {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    private fun defineCurrentParametres(): ArrayList<CurrentCrypto>  {
        val a = CurrentCrypto("-$124","${R.drawable.ic_baseline_arrow_drop_down_circle_24}")
        val b = CurrentCrypto("-$154","${R.drawable.ic_baseline_home_24}")
        val c = CurrentCrypto("-$194","${R.drawable.ic_abstract_user_flat_3}")
        val d = CurrentCrypto("-$172","${R.drawable.ic_baseline_arrow_drop_down_circle_24}")

        val bursa = arrayListOf<CurrentCrypto>(a,b,c,d)
        return bursa
    }

    private fun defineCryptoParametres(): ArrayList<Crypto> {
        val a = Crypto("fsda")
        val b = Crypto("fsda")
        val c = Crypto("fsda")
        val d = Crypto("fsda")

        val adana = arrayListOf<Crypto>(a,b,c,d)
        return adana
    }
}