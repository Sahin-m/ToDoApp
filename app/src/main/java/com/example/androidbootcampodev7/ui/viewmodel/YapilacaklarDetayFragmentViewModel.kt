package com.example.androidbootcampodev7.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.androidbootcampodev7.data.repo.YapilacaklarDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class YapilacaklarDetayFragmentViewModel @Inject constructor (var yrepo:YapilacaklarDaoRepository)  : ViewModel() {

    fun guncelle(yapilacak_id : Int ,yapilacak_is:String){
        yrepo.yapilacakGuncelle(yapilacak_id, yapilacak_is)
    }
}