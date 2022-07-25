package com.example.androidbootcampodev7.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.androidbootcampodev7.data.repo.YapilacaklarDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class YapilacaklarKayitFragmentViewModel @Inject constructor (var yrepo:YapilacaklarDaoRepository)  : ViewModel() {

    fun kayit(yapilacak_is:String){
        yrepo.yapilacakKayit(yapilacak_is)
    }

}