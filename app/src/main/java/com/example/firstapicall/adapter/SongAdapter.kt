package com.example.firstapicall.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapicall.R
import com.example.firstapicall.data.Repository
import com.example.firstapicall.data.model.Song
import com.example.firstapicall.ui.main.MainFragmentDirections
import com.squareup.picasso.Picasso

class SongAdapter() : RecyclerView.Adapter<SongAdapter.ItemViewHolder>() {

    private var dataset = listOf<Song>()


    inner class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById(R.id.song_name)
        val artist: TextView = view.findViewById(R.id.song_artist)
        val songCard: CardView = view.findViewById(R.id.song_card)
        val image: ImageView = view.findViewById(R.id.song_img)

    }

    fun submitList(list: List<Song>){
        dataset = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
       val itemLayout = LayoutInflater.from(parent.context).inflate(R.layout.song_item,parent,false)
        return ItemViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: Song = dataset[position]

        holder.name.text = item.track
        holder.artist.text = item.artist
        Picasso.get().load(item.artResource).into(holder.image)

        holder.songCard.setOnClickListener {
            holder.itemView.findNavController().navigate(MainFragmentDirections.actionMainFragmentToSongDetailFragment(item.track,item.artist,item.artResource))
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}