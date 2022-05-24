package com.example.cafe


import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.LinearLayout
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_filter.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartView : AppCompatActivity() {
    lateinit var apiInterface: ApiEndPoint
    lateinit var mAdapter : CartAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        val order = CartModel(this);
        val data = ArrayList<CartModel>();

        data.clear();
        data.add(order.addHeader("No Meja", "Menu", "Harga","Jml","Total"));
//        viewPenerbit()
//        data.add((order.addData()))
//getDataFromApiCart()
        data.add(order.addData(1, "Nasi Goreng", 7000,10,70000));
//        data.add(order.addData(1, "Nasi Goreng", 9500,8,76000));

//        data.add(pertamina.addData(2, "Pertamax", 9000.0));
//        data.add(pertamina.addData(3, "Pertalite", 7650.0));
//        data.add(pertamina.addData(4, "Premium", 6450.0));
//        data.add(pertamina.addData(5, "Pertamina Dex", 10200.0));
//        data.add(pertamina.addData(6, "Dexlite", 9500.0));
//        data.add(pertamina.addData(7, "Bio Solar", 9400.0));

        mAdapter = CartAdapter(this, data ).also{ adapter -> listviewFilter.adapter = adapter }
    }

//    private fun viewPenerbit(){
//        val rvBuku = findViewById<LinearLayout>(R.id.list_cart)
//
//
//        apiInterface.getCart().enqueue(object  : Callback<CartModel>{
//            override fun onResponse(call: Call<CartModel>, response: Response<CartModel>) {
//                var penerbitData = response?.body()!!
//
//
//            }
//
//            override fun onFailure(call: Call<CartModel>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//        })
//            override fun onResponse(
//                call: Call<ArrayList<PenerbitModel>>,
//                response: Response<ArrayList<PenerbitModel>>
//            ) {
//                var penerbitData = response?.body()!!
//                if (penerbitData.size>0){
//                    rvBuku.adapter= PenerbitAdapter(penerbitData)
//                }
//            }
//
//            override fun onFailure(call: Call<ArrayList<PenerbitModel>>, t: Throwable) {
//                Log.e("error", "error ${t.message}")
//            }
//
//        })
//    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu);
        val searchManager : SearchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager;
        val searchView : SearchView = menu?.findItem(R.id.action_search)?.actionView as SearchView;
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName));
        searchView.maxWidth = Int.MAX_VALUE;
        searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    mAdapter.filter.filter(query);
                    return false;
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    mAdapter.filter.filter(newText);
                    return false;
                }
            });

        return super.onCreateOptionsMenu(menu)
    }

//private fun getDataFromApiCart(){
//    //        data.add(order.addData(1, "Nasi Goreng", 7000,10,70000));
////    showLoading(true)
//    ApiService.endpoint.getCart()
//        .enqueue(object : Callback<CartModel>{
//            override fun onResponse(call: Call<CartModel>, response: Response<CartModel>) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onFailure(call: Call<CartModel>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//
//        })
//}

//    private fun showLoading(loading : Boolean){
//
//
//        }
    }


//    private fun showLoading (loading : Boolean){
//        when(loading){
//            true -> progressBar.visibility = View.GONE
//            true -> progressBar.visibility = View.VISIBLE
//        }
//    }


//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        when(item?.itemId){
//            android.R.id.home ->{
//                super.onBackPressed();
//                return true;
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }

