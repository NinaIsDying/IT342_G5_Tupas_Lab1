package com.example.wildcatsden.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wildcatsden.R

data class Venue(
    val id: Int,
    val name: String,
    val location: String,
    val capacity: Int,
    val imageResId: Int
)

class VenueAdapter(
    private val venues: List<Venue>,
    private val onItemClick: (Venue) -> Unit
) : RecyclerView.Adapter<VenueAdapter.VenueViewHolder>() {

    class VenueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageVenue: ImageView = itemView.findViewById(R.id.imageVenueThumb)
        private val textName: TextView = itemView.findViewById(R.id.textVenueName)
        private val textLocation: TextView = itemView.findViewById(R.id.textVenueLocation)
        private val textCapacity: TextView = itemView.findViewById(R.id.textVenueCapacity)

        fun bind(venue: Venue, onClick: (Venue) -> Unit) {
            imageVenue.setImageResource(venue.imageResId)
            textName.text = venue.name
            textLocation.text = venue.location
            textCapacity.text = "Capacity: ${venue.capacity} people"

            itemView.setOnClickListener { onClick(venue) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_venue_card, parent, false)
        return VenueViewHolder(view)
    }

    override fun onBindViewHolder(holder: VenueViewHolder, position: Int) {
        holder.bind(venues[position], onItemClick)
    }

    override fun getItemCount(): Int = venues.size
}