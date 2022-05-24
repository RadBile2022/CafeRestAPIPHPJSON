package com.example.cafe

import android.content.Context

class CartModel (context: Context?) {
    val mContext: Context? = context;

    var no: Int? = 1;
    var menu = ""
    var harga = 0
    var jml = 0
    var total = 0

    var headerNo: String? = null;
    var headerMenu: String? = null;
    var headerHarga: String? = null;
    var headerJml: String? = null;
    var headerTotal: String? = null;

    fun addHeader(headerNo: String?, headerMenu: String?, headerHrg: String?, headerJml: String?, headerTotal: String?): CartModel {
        val data = CartModel(mContext);
        data.headerNo = headerNo;
        data.headerMenu = headerMenu
        data.headerHarga = headerHrg
        data.headerJml = headerJml
        data.headerTotal = headerTotal
        return data;
    }

    fun addData(no: Int, menu : String, harga : Int, jml : Int, total : Int): CartModel {
        val data = CartModel(mContext);
        data.no = no;
        data.menu = menu
        data.harga = harga
        data.jml = jml
        data.total = total
        return data;
    }
}
//
//data class CartModel (
//    var result : ArrayList<Result>
//){
//
//    data class Result(
//        val no : Int, val menu : String,val  harga : Int, val jml : Int, val  total : Int
//    )
//}