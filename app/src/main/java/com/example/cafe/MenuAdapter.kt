package com.example.cafe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_menu.view.*

class MenuAdapter
    (var results : ArrayList<MenuModel.Result>, val listener : OnAdapterListener)
    : RecyclerView.Adapter<MenuAdapter.MyViewHolder>() {

    // 1. INNER CLASS MY VIEW HOLDER
    class MyViewHolder (val view : View) : RecyclerView.ViewHolder(view)

    // 2. INNER INTERFACE
    interface OnAdapterListener {
        fun onClick (result: MenuModel.Result)
    }

    // 3. FUNCTION SET DATA
    fun setData(data : List <MenuModel.Result>){
        this.results.clear()
        this.results.addAll(data)
        notifyDataSetChanged()
    }

    // 4. OVERRIDE METHOD onCreateViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.list_menu,parent,false)
    )

    // 5. OVERRIDE METHOD onBindViewHolder
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val result = results[position]
        holder.view.tvNama.text         = result.namaMenu
        holder.view.tvDeskripsi.text    = result.deskripsi
        holder.view.tvHarga.text        = "Rp. ${result.harga.toString()}"

        Glide.with(holder.view)
            .load(result.image)
            .placeholder(R.drawable.ic_restaurant)
            .error(R.drawable.ic_restaurant)
            .centerCrop()
            .into(holder.view.ivMenu)
        // ketika dia error gambarnya daripada silang, mending pakai template icon ic restaurant
        // center crop daripada jembluk, mending di cut

        holder.view.setOnClickListener { listener.onClick(result) }
    }

    // 6. OVERRIDE METHOD onBindViewHolder
    override fun getItemCount() = results.size
}