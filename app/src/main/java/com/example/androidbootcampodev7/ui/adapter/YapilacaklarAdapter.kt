package com.example.androidbootcampodev7.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.androidbootcampodev7.R
import com.example.androidbootcampodev7.data.entity.Yapilacaklar
import com.example.androidbootcampodev7.databinding.CardTasarimBinding
import com.example.androidbootcampodev7.databinding.FragmentAnasayfaBinding
import com.example.androidbootcampodev7.ui.fragment.AnasayfaFragmentDirections
import com.example.androidbootcampodev7.ui.viewmodel.AnasayfaFragmentViewModel
import com.example.androidbootcampodev7.utils.gecisYap
import com.google.android.material.snackbar.Snackbar


class YapilacaklarAdapter(var mcontext: Context,
                          var yapilacaklarListesi : List<Yapilacaklar>,
                          var viewModel: AnasayfaFragmentViewModel) : RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root) {
        var tasarim : CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mcontext)
        val tasarim : CardTasarimBinding = DataBindingUtil.inflate(layoutInflater, R.layout.card_tasarim, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yapilacak = yapilacaklarListesi.get(position)
        val t = holder.tasarim
        t.yapilacakNesnesi = yapilacak

        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.yapilacaklarDetayGecis(yapilacak = yapilacak)
            Navigation.gecisYap(it, gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${yapilacak.yapilacak_is} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                    viewModel.sil(yapilacak.yapilacak_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return yapilacaklarListesi.size
    }
}