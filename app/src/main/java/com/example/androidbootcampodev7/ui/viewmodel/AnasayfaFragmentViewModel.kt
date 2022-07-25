package com.example.androidbootcampodev7.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidbootcampodev7.data.entity.Yapilacaklar
import com.example.androidbootcampodev7.data.repo.YapilacaklarDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnasayfaFragmentViewModel @Inject constructor (var yrepo:YapilacaklarDaoRepository) : ViewModel() {

    var yapilacaklarListesi = MutableLiveData<List<Yapilacaklar>>()
    init {
        yapilacaklariYukle()
        yapilacaklarListesi = yrepo.yapilacaklariGetir()
    }

    fun ara(aramaKelimesi:String){
        yrepo.yapilacakAra(aramaKelimesi)
    }
    fun sil(yapilacak_id:Int){
        yrepo.yapilacakSil(yapilacak_id)
    }

    fun yapilacaklariYukle() {
        yrepo.tumYapilacaklariAl()
    }
}