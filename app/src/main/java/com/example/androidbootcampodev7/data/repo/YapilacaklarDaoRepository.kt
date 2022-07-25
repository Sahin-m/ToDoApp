package com.example.androidbootcampodev7.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.androidbootcampodev7.data.entity.Yapilacaklar
import com.example.androidbootcampodev7.room.YapilacaklarDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class YapilacaklarDaoRepository(var ydao:YapilacaklarDao) {

    var yapilacaklarListesi : MutableLiveData<List<Yapilacaklar>>
    init {
        yapilacaklarListesi = MutableLiveData()
    }

    fun yapilacaklariGetir() : MutableLiveData<List<Yapilacaklar>>{
        return yapilacaklarListesi
    }

    fun yapilacakKayit(yapilacak_is:String){
        val job = CoroutineScope(Dispatchers.Main).launch{
            val yeniYapilacak = Yapilacaklar(0, yapilacak_is)
            ydao.yapilacakEkle(yeniYapilacak)
        }
    }

    fun yapilacakGuncelle(yapilacak_id : Int, yapilacak_is: String){
        val job = CoroutineScope(Dispatchers.Main).launch{
            val guncellenenYapilacak = Yapilacaklar(yapilacak_id, yapilacak_is)
            ydao.yapilacakGuncelle(guncellenenYapilacak)
        }
    }

    fun yapilacakAra(aramaKelimesi:String){
        val job = CoroutineScope(Dispatchers.Main).launch{
            yapilacaklarListesi.value = ydao.yapilacakAra(aramaKelimesi)
        }
    }

    fun yapilacakSil(yapilacak_id: Int){
        val job = CoroutineScope(Dispatchers.Main).launch{
            val silinenYapilacak = Yapilacaklar(yapilacak_id,"")
            ydao.yapilacakSil(silinenYapilacak)
            tumYapilacaklariAl()
        }
    }

    fun tumYapilacaklariAl(){
        val job = CoroutineScope(Dispatchers.Main).launch{
            yapilacaklarListesi.value = ydao.tumYapilacaklar()
        }
    }
}