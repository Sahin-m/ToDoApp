package com.example.androidbootcampodev7.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.androidbootcampodev7.R
import com.example.androidbootcampodev7.databinding.FragmentYapilacakKayitBinding
import com.example.androidbootcampodev7.ui.viewmodel.YapilacaklarKayitFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YapilacakKayitFragment : Fragment() {
    private lateinit var tasarim : FragmentYapilacakKayitBinding
    private lateinit var viewModel: YapilacaklarKayitFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_yapilacak_kayit, container, false)
        tasarim.yapilacakKayitFragment = this
        tasarim.yapilacakKayitToolbarBaslik = "Yapılacak Kayıt"

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : YapilacaklarKayitFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonKaydet(yapilacak_is: String){
        viewModel.kayit(yapilacak_is)
    }
}