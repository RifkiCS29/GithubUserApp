package com.rifki.kotlin.mygithubuserapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rifki.kotlin.mygithubuserapp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView
import com.rifki.kotlin.mygithubuserapp.model.GithubUser
import kotlinx.android.synthetic.main.item_row_github_user.view.*

class GithubUserAdapter (private val listGithubUser : ArrayList<GithubUser>) : RecyclerView.Adapter<GithubUserAdapter.GithubViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GithubViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_github_user, viewGroup, false)
        return GithubViewHolder(view)
    }

    override fun getItemCount(): Int = listGithubUser.size

    inner class GithubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var avatar: CircleImageView = itemView.image_avatar
        var name: TextView = itemView.tv_name
        var username: TextView = itemView.tv_username
        var company: TextView = itemView.tv_company
    }

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        val data = listGithubUser[position]
        Glide.with(holder.itemView.context)
            .load(data.avatar)
            .apply(RequestOptions().override(250, 250))
            .into(holder.avatar)
        holder.name.text = data.name
        holder.username.text = data.username
        holder.company.text = data.company
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listGithubUser[holder.adapterPosition])
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: GithubUser)
    }
}