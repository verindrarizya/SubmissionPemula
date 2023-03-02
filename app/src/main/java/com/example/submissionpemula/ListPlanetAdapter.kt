package com.example.submissionpemula

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListPlanetAdapter(private val listPlanet: ArrayList<Planet>, private val context: Context)
    : RecyclerView.Adapter<ListPlanetAdapter.ListViewHolder>() {

    inner class ListViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var imgPlanet: ImageView = view.findViewById(R.id.img_planet)
        var tvName: TextView = view.findViewById(R.id.tv_planet_name)
        var tvSummary: TextView = view.findViewById(R.id.tv_planet_summary)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_planets, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPlanet.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val planet = listPlanet[position]

        Glide.with(holder.itemView.context)
                .load(planet.imageResource)
                .apply(RequestOptions().override(125, 125))
                .into(holder.imgPlanet)

        holder.tvName.text = planet.name
        holder.tvSummary.text = planet.detail

        holder.itemView.setOnClickListener {
            val intentPlanet = Intent(context, DetailPlanetActivity::class.java)

            intentPlanet.apply {
                putExtra(DetailPlanetActivity.PLANET_IMAGE, planet.imageResource)
                putExtra(DetailPlanetActivity.PLANET_NAME, planet.name)
                putExtra(DetailPlanetActivity.PLANET_DETAIL, planet.detail)
            }

            holder.itemView.context.startActivity(intentPlanet)
        }
    }
}