package com.cuursoft.filmsubmitone

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.film_detail.*
import kotlinx.android.synthetic.main.list_film.view.*
import me.biubiubiu.justifytext.library.JustifyTextView

class DetailFilm : AppCompatActivity() {

    companion object {
        const val EXTRA_FILM = "extra_film"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.film_detail)

        val tvNama: TextView = findViewById(R.id.nama_kirim)
        val tvDesk: JustifyTextView = findViewById(R.id.desk_kirim)
        val tvFoto: ImageView = findViewById(R.id.foto_kirim)

        val film = intent.getParcelableExtra<Film>(EXTRA_FILM)
        val foto = film.foto
        val nama = film.nama
        val deskripsi = film.deskripsi

        tvFoto.setImageResource(foto)
        tvNama.text = nama
        tvDesk.text = deskripsi


        //showProductDetail()

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Detail Film"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    /**private fun showProductDetail() {
        nama_kirim.setText(intent.getStringExtra(EXTRA_NAMA))
        desk_kirim.setText(intent.getStringExtra(EXTRA_DESK))


        Glide.with(this)
            .load(intent.getStringExtra(EXTRA_FOTO)).into(foto_kirim)
    }**/

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}