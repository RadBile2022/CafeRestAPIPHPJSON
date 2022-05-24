package com.example.cafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide


import kotlinx.android.synthetic.main.activity_order.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class OrderActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        supportActionBar!!.title = "Order"

        val date_n  = SimpleDateFormat("EEEE, dd-MMM-yyyy" , Locale.getDefault()).format(Date())
        val current = LocalDateTime.now()
        val formatted = current.format(DateTimeFormatter.ofPattern("HH:mm:ss"))

        tvTanggal.setText(date_n)
        tvJam.setText(formatted)

        getTVid.text = intent.getStringExtra("intent_id")

        Glide.with(this)
            .load(intent.getStringExtra("intent_image"))
            .placeholder(R.drawable.ic_restaurant)
            .error(R.drawable.ic_restaurant)
            .centerCrop()
            .into(getIVimage)

        getTVnama.text = intent.getStringExtra("intent_nama")

        getTVharga.text = intent.getStringExtra("intent_harga")


        keranjang.setOnClickListener(  object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(v?.context, CartView::class.java);
                startActivity(intent);
            }
        }
        )
        btnCart.setOnClickListener{
            addCart()
        }
    }

    private fun addCart(){
        val nomor_meja  = findViewById<EditText>(R.id.etNomorMeja).text
        val menu_id  = findViewById<TextView>(R.id.etNomorMeja).text
        val jumlah_order  = findViewById<EditText>(R.id.etNomorMeja).text

        if (nomor_meja.toString().trim() == "" ||
            jumlah_order.toString().trim() == "")
        {
            Toast.makeText(this, "Kolom harus diisi !!", Toast.LENGTH_SHORT).show()
        }
        else {
            var requestCall : Call<ResponseModel> =
                ApiService.endpoint.addCart(etNomorMeja.text.toString(),
                getTVid.text.toString().toInt(),
                etJumlahOrder.text.toString().toInt())

            requestCall.enqueue(object : Callback<ResponseModel>{
                override fun onResponse(
                    call: Call<ResponseModel>,
                    response: Response<ResponseModel>
                ) // argument
                {
                    Log.d ("response" , response.body()!!.message.toString())
                    if(response.isSuccessful){
                        Toast.makeText(this@OrderActivity,
                            "Add Cart Succes", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@OrderActivity,
                            "Add Cart Failed", Toast.LENGTH_SHORT).show()
                    }

                } // statement

                override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                    Toast.makeText(this@OrderActivity,
                        "Add Cart Failed", Toast.LENGTH_SHORT).show()
                }

            })

        }
    }
}