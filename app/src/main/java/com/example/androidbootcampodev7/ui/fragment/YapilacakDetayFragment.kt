package com.example.androidbootcampodev7.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.androidbootcampodev7.R
import com.example.androidbootcampodev7.databinding.FragmentYapilacakDetayBinding
import com.example.androidbootcampodev7.ui.viewmodel.YapilacaklarDetayFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YapilacakDetayFragment : Fragment() {
    private lateinit var tasarim : FragmentYapilacakDetayBinding
    private lateinit var viewModel: YapilacaklarDetayFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_yapilacak_detay, container, false)

        tasarim.yapilacakDetayFragment = this
        tasarim.yapilacakDetayToolbarBaslik = "Yapılacak Detay"

        val bundle: YapilacakDetayFragmentArgs by navArgs()
        val gelenYapilacak = bundle.yapilacak
        tasarim.yapilacakNesnesi = gelenYapilacak



        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : YapilacaklarDetayFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonGuncelle(yapilacak_id : Int, yapilacak_is: String){
        viewModel.guncelle(yapilacak_id, yapilacak_is)
    }
}