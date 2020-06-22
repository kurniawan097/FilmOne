package com.cuursoft.filmsubmitone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class FilmAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var film = arrayListOf<Film>()

    override fun getCount(): Int = film.size

    override fun getItem(i: Int): Any = film[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.list_film, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val film = getItem(position) as Film
        viewHolder.bind(film)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val txtNama: TextView = view.findViewById(R.id.txt_nama)
        private val txtDeskripsi: TextView = view.findViewById(R.id.txt_deskripsi)
        private val imgFoto: ImageView = view.findViewById(R.id.img_foto)

        internal fun bind(film: Film) {
            txtNama.text = film.nama
            txtDeskripsi.text = film.deskripsi
            imgFoto.setImageResource(film.foto)
        }
    }
}