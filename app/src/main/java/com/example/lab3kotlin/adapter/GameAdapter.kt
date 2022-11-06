package com.example.lab3kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3kotlin.R
import com.example.lab3kotlin.model.Game
import com.bumptech.glide.Glide


class GameAdapter(val items: List<Game>): RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    inner class GameViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.gameName)
        private val onlineStatusTextView: TextView = itemView.findViewById(R.id.price)
        private val gameImageView: ImageView = itemView.findViewById(R.id.gameImage)

        fun bind(item : Game, context : Context) {
            nameTextView.text = item.name
            onlineStatusTextView.text = item.cost.toString()
            Glide.with(context)
                .load(item.photo)
                .error(R.drawable.ic_gen_image)
                .into(gameImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.game_info, parent, false)
        return GameViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(items[position], holder.itemView.context)
    }

    override fun getItemCount(): Int = items.size
}