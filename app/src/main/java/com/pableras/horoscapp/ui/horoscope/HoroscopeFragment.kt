package com.pableras.horoscapp.ui.horoscope

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.pableras.horoscapp.R
import com.pableras.horoscapp.databinding.FragmentHoroscopeBinding
import com.pableras.horoscapp.domain.model.HoroscopeInfo
import com.pableras.horoscapp.domain.model.HoroscopeInfo.*
import com.pableras.horoscapp.domain.model.HoroscopeModel
import com.pableras.horoscapp.ui.horoscope.HoroscopeAdapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {
    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!
    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
    private lateinit var horoscopeAdapter: HoroscopeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initList()
        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch { // <-- Sigue el ciclo de vida del Fragment
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeViewModel.horoscope.collect { // <-- Se subscribe
                    horoscopeAdapter.updateList(it)
                }
            }
        }
    }

    private fun initList() {
        horoscopeAdapter = HoroscopeAdapter(onItemSelected = {
            val tipo = when(it){
                Aquario -> HoroscopeModel.Aquario
                Aries -> HoroscopeModel.Aries
                Cancer -> HoroscopeModel.Cancer
                Capricornio -> HoroscopeModel.Capricornio
                Escorpio -> HoroscopeModel.Escorpio
                Geminis -> HoroscopeModel.Geminis
                Leo -> HoroscopeModel.Leo
                Libra -> HoroscopeModel.Libra
                Piscis -> HoroscopeModel.Piscis
                Sagitario -> HoroscopeModel.Sagitario
                Tauro -> HoroscopeModel.Tauros
                Virgo -> HoroscopeModel.Virgo
            }

            // Se sigue el grafo de navegación hacia la Activity que se indica en el main_graph
            findNavController().navigate(
                HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity(tipo)
            )
            Toast.makeText(context, getString(it.name), Toast.LENGTH_LONG).show()
        })
        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = horoscopeAdapter
        }
    }
}