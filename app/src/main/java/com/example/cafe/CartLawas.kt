//package com.example.cafe
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import kotlinx.android.synthetic.main.layout_table_three.view.*
//import kotlinx.android.synthetic.main.list_menu.view.*
//
//class CartAdapter
//    (var results : ArrayList<CartModel.Result>, val listener : OnAdapterListener)
//    : RecyclerView.Adapter<CartAdapter.MyViewHolder>() {
//
//    // 1. INNER CLASS MY VIEW HOLDER
//    class MyViewHolder (val view : View) : RecyclerView.ViewHolder(view)
//
//    // 2. INNER INTERFACE
//    interface OnAdapterListener {
//        fun onClick (result: MenuModel.Result)
//    }
//
//    // 3. FUNCTION SET DATA
//    fun setData(data : List <CartModel.Result>){
//        this.results.clear()
//        this.results.addAll(data)
//        notifyDataSetChanged()
//    }
//
//    // 4. OVERRIDE METHOD onCreateViewHolder
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder (
//        LayoutInflater.from(parent.context).inflate(R.layout.activity_filter,parent,false)
//    )
//
//    // 5. OVERRIDE METHOD onBindViewHolder
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val result = results[position]
//        holder.view.TVNo.text         = result.no.toString()
//        holder.view.TVMenu.text         = result.menu
//        holder.view.TVHrg.text        = "Rp. ${result.harga}"
//        holder.view.TVJml.text        = result.jml.toString()
//        holder.view.TVTotal.text      = "Rp. ${result.total}"
//
//    }
//
//    // 6. OVERRIDE METHOD onBindViewHolder
//    override fun getItemCount() = results.size
//}