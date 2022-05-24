//package com.example.cafe
//
//import CartAdapter
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.view.View
//import com.example.cafe.ApiEndPoint
//import com.example.cafe.*
//import com.nuslab.tablelayout.model.CartBinding
//import com.nuslab.tablelayout.model.CartView
//import com.nuslab.tablelayout.model.CartModel
//import kotlinx.android.synthetic.main.activity_main.*
//import kotlinx.android.synthetic.main.activity_order.*
//import retrofit2.Call
//import retrofit2.Response
//
//class MainActivitys : AppCompatActivity() {
//
//    lateinit var apiInterface: ApiEndPoint
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        val pertamina = CartModel(this);
//        val data = ArrayList<CartModel>();
//        val cart = CartBinding()
//        val binding : ArrayList<CartBinding>;
//        data.clear();
//        data.add(pertamina.addHeader("No", "Menu", "Harga", "Jml", "Total"));
//
//        data.add(pertamina.addData(1, "Pertamax Turbo", 9850,10,98500));
//        apiInterface.getCart()
////        data.add(pertamina.addData(2, "Pertamax", 9000.0));
////        data.add(pertamina.addData(3, "Pertalite", 7650.0));
////        data.add(pertamina.addData(4, "Premium", 6450.0));
////        data.add(pertamina.addData(5, "Pertamina Dex", 10200.0));
////        data.add(pertamina.addData(6, "Dexlite", 9500.0));
////        data.add(pertamina.addData(7, "Bio Solar", 9400.0));
//
//        CartAdapter(this, data).also{ adapter -> listPertamina.adapter = adapter }
//
////        val shell = ViewModel(this);
////        val data2 = ArrayList<ViewModel>();
////        data2.clear();
////        data2.add(shell.addHeader("No", "Description", "Price"));
////        data2.add(shell.addData(1, "Shell Super", 9125.0));
//////        data2.add(shell.addData(2, "Shell V-Power", 9650.0));
//////        data2.add(shell.addData(3, "Shell Diesel", 9850.0));
//////        data2.add(shell.addData(4, "Shell Regular", 9075.0));
////
////        ViewAdapter(this, data2).also{ adapter -> listShell.adapter = adapter }
//
//        btnCart.setOnClickListener(object : View.OnClickListener{
//                override fun onClick(v: View?) {
//                    val intent = Intent(v?.context, CartView::class.java);
//                    startActivity(intent);
//                }
//
//            }
//        )
//    }
//
//
//
//
//}
