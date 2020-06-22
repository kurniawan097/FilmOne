package com.cuursoft.filmsubmitone

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: FilmAdapter
    private lateinit var dataNama: Array<String>
    private lateinit var dataDeskripsi: Array<String>
    private lateinit var dataFoto: TypedArray
    private var film1 = arrayListOf<Film>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.list_view)

        adapter = FilmAdapter(this)

        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            //Toast.makeText(this@MainActivity, film1[position].nama,Toast.LENGTH_SHORT).show()
            //val selectedVilm = intent.getParcelableExtra<Film>(DetailFilm.EXTRA_FILM)
            val detailMovieIntent = Intent(this@MainActivity, DetailFilm::class.java)
            val film = adapter.film[position]
            detailMovieIntent.putExtra("PARCEL", film)
            startActivity(detailMovieIntent)
            //val moveWithObjectIntent = Intent(this@MainActivity, DetailFilm::class.java)
            //moveWithObjectIntent.putExtra(DetailFilm.EXTRA_FILM, film1)
            //startActivity(moveWithObjectIntent)
            /**val panggilIntent = Intent(this@MainActivity, DetailFilm::class.java)
            val film = Film(
                dataNama[position],
                dataDeskripsi[position],
                dataFoto.getResourceId(position, -1)
            )
            film1.add(film)



            panggilIntent.putParcelableArrayListExtra(DetailFilm.EXTRA_FILM, film1)
            startActivity(panggilIntent)**/
        }
    }

    private fun prepare() {
        dataNama = resources.getStringArray(R.array.data_nama)
        dataDeskripsi = resources.getStringArray(R.array.data_deskripsi)
        dataFoto = resources.obtainTypedArray(R.array.data_foto)
    }

    private fun addItem() {
        for (position in dataNama.indices){
            val film = Film(
                dataNama[position],
                dataDeskripsi[position],
                dataFoto.getResourceId(position, -1)
            )
            film1.add(film)
        }
        adapter.film = film1
    }
}