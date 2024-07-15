package com.example.encoretestgaura

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.encoretestgaura.data.local.table.Song

class SongAdapter(
    private var songList: List<Song>,
    private val onItemClickListener: (Song) -> Unit
) : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.song_item_layout, parent, false) // Use your item song_item_layout.xml here
        return SongViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songList[position]
        holder.bind(song)
        holder.itemView.setOnClickListener { onItemClickListener(song) }
    }

    override fun getItemCount(): Int = songList.size

    fun updateSongs(newSongs: List<Song>) {
        songList = newSongs
        notifyDataSetChanged()
    }

    class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Get references to your views within the item song_item_layout.xml here
        private val titleTextView: TextView = itemView.findViewById(R.id.txtTitle)
        private val artistTextView: TextView = itemView.findViewById(R.id.txtArtist)
        private val realeaseDateTextView: TextView = itemView.findViewById(R.id.txtDate)
        private val priceTextView: TextView = itemView.findViewById(R.id.txtPrice)
        private val albumImage: ImageView = itemView.findViewById(R.id.imageView)
        // ... other views

        fun bind(song: Song) {
            titleTextView.text = song.name
            artistTextView.text = song.artist
            realeaseDateTextView.text = song.date
            priceTextView.text = song.price
            // Load image using Coil
            albumImage.load(song.imageUrl) {
                crossfade(true) // Optional: Add a crossfade effect
                placeholder(R.drawable.outline_image_24) // Optional: Set a placeholder image
                error(R.drawable.outline_image_24) // Optional: Set an error image
            }

        }
    }
}