package com.example.cafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var menuAdapter: MenuAdapter
    private lateinit var cartAdapter: CartAdapter

    private fun getCart(){
        showLoading(true)
        ApiService.endpoint.getCart()
            .enqueue(object : Callback<CartModel> {
                override fun onResponse(call: Call<CartModel>, response: Response<CartModel>) {
//                    if(response.isSuccessful){
//                        showLoading(true)
//                        showResults(response.body()!!)
//                    }
                }



                override fun onFailure(call: Call<CartModel>, t: Throwable) {
                    showLoading(false)
                }

            })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.title = "My Cafe"
        setupRecylerView()
        getDataFromApi()

        val etName = findViewById(R.id.TVHrg) as TextView



    }

    private fun setupRecylerView() {
        menuAdapter = MenuAdapter(arrayListOf(), object :
            MenuAdapter.OnAdapterListener {
            override fun onClick(result: MenuModel.Result) {

               Toast.makeText(applicationContext, result.namaMenu, Toast.LENGTH_SHORT).show()

                startActivity(
                    Intent(this@MainActivity, OrderActivity::class.java)
                        .putExtra("intent_id", result.id.toString())
                        .putExtra("intent_image", result.image)
                        .putExtra("intent_nama", result.namaMenu)
                        .putExtra("intent_harga", "Rp. ${result.harga.toString()}")
                )



            }
        })
        rvMenu.apply {
            layoutManager =LinearLayoutManager(context)
            adapter = menuAdapter
        }
    }

    private fun getDataFromApi(){
        showLoading(true)
        ApiService.endpoint.getMenu()
            .enqueue(object :Callback<MenuModel>{
                override fun onResponse(call: Call<MenuModel>, response: Response<MenuModel>) {
                    if (response.isSuccessful)
                        showLoading(false)
                        showResult(response.body()!!)
                }

                override fun onFailure(call: Call<MenuModel>, t: Throwable) {
                   showLoading(false)
                }

            })
    }

    private fun showLoading (loading : Boolean){
        when (loading){
            true -> progressBar.visibility = View.VISIBLE
            else -> progressBar.visibility = View.GONE
        }
    }

    private fun showResult(results: MenuModel){
        menuAdapter.setData(results.result)
    }

    private fun showLoadings (loading : Boolean){
        when (loading){
            true -> progressBar.visibility = View.VISIBLE
            else -> progressBar.visibility = View.GONE
        }
    }
//    private fun showResults(results: CartModel){
//        cartAdapter.setData(results.result)
//    }
}