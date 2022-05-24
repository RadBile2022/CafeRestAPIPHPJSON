package com.example.cafe

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

//, val listener : CartAdapter
class CartAdapter(context: Context, data: ArrayList<CartModel>) :  ArrayAdapter<CartModel>(context, -1, data), Filterable {
    private val mContext: Context;
    private var dataSet: ArrayList<CartModel>;
    private var dataSetFilter: ArrayList<CartModel>;
    private val headerColor = Color.parseColor("#0062cc");

    init {
        this.mContext = context;
        this.dataSet = data!!;
        this.dataSetFilter = data!!;
    }

    class ViewHolder(row : View?) {
        var layout : LinearLayout? = null;
        var txtNo : TextView? = null;
        var txtMenu: TextView? = null;
        var txtHarga: TextView? = null;
        var txtJml: TextView? = null;
        var txtTotal: TextView? = null;


        init {
            layout = row?.findViewById(R.id.listLayout) as LinearLayout;
            txtNo = row?.findViewById(R.id.TVNo) as TextView;
            txtMenu = row?.findViewById(R.id.TVMenu) as TextView;
            txtHarga = row?.findViewById(R.id.TVHrg) as TextView;
            txtJml= row?.findViewById(R.id.TVJml) as TextView;
            txtTotal= row?.findViewById(R.id.TVTotal) as TextView;
        }
    }

    override fun getViewTypeCount(): Int {
        return this.dataSetFilter.size;
    }

    override fun getItemViewType(position: Int): Int {
        return position;
    }

    override fun getCount(): Int {
        return this.dataSetFilter.size;
    }

    override fun getItem(position: Int): CartModel? {
        return dataSetFilter.get(position);
    }

    private var lastPosition = +3
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val model: CartModel? = getItem(position);
        val viewHolder : ViewHolder;
        val view : View;

        if (convertView == null) {
            val inflater = mContext?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater;
            view = inflater.inflate(R.layout.layout_table_three, parent, false);
            viewHolder = ViewHolder(view);
            view.tag = viewHolder;
        }else{
            view = convertView;
            viewHolder = view.tag as ViewHolder;

            //Prevent cache data
            viewHolder.txtNo?.text = "";
            viewHolder.txtMenu?.text = "";
            viewHolder.txtHarga?.text = "";
            viewHolder.txtJml?.text = "";
            viewHolder.txtTotal?.text = "";
        }

        lastPosition = position

        if(model?.headerNo !=null && model?.headerMenu !=null && model?.headerHarga !=null && model?.headerJml !=null && model?.headerTotal !=null ){
            viewHolder.txtNo?.text = model?.headerNo.toString();
            viewHolder.txtMenu?.text = model?.headerMenu.toString();
            viewHolder.txtHarga?.text = model?.headerHarga.toString();
            viewHolder.txtJml?.text = model?.headerJml.toString();
            viewHolder.txtTotal?.text = model?.headerTotal.toString();

            viewHolder.layout?.setBackgroundColor(headerColor);

            viewHolder.txtNo?.setTypeface(null, Typeface.BOLD);
            viewHolder.txtMenu?.setTypeface(null, Typeface.BOLD);
            viewHolder.txtHarga?.setTypeface(null, Typeface.BOLD);
            viewHolder.txtJml?.setTypeface(null, Typeface.BOLD);
            viewHolder.txtTotal?.setTypeface(null, Typeface.BOLD);

            viewHolder.txtNo?.setTextColor(Color.WHITE);
            viewHolder.txtMenu?.setTextColor(Color.WHITE);
            viewHolder.txtHarga?.setTextColor(Color.WHITE);
            viewHolder.txtJml?.setTextColor(Color.WHITE);
            viewHolder.txtTotal?.setTextColor(Color.WHITE);

        }else{
            viewHolder.txtNo?.text = model?.no.toString();
            viewHolder.txtMenu?.text = model?.menu;
            viewHolder.txtHarga?.text = model?.harga.toString()
            viewHolder.txtJml?.text = model?.jml.toString()
            viewHolder.txtTotal?.text = model?.total.toString()

            viewHolder.layout?.setBackgroundColor(Color.WHITE);

            viewHolder.txtNo?.setTypeface(null, Typeface.NORMAL);
            viewHolder.txtMenu?.setTypeface(null, Typeface.NORMAL);
            viewHolder.txtHarga?.setTypeface(null, Typeface.NORMAL);
            viewHolder.txtJml?.setTypeface(null, Typeface.NORMAL);
            viewHolder.txtTotal?.setTypeface(null, Typeface.NORMAL);

            viewHolder.txtNo?.setTextColor(Color.BLACK);
            viewHolder.txtMenu?.setTextColor(Color.BLACK);
            viewHolder.txtHarga?.setTextColor(Color.BLACK);
            viewHolder.txtJml?.setTextColor(Color.BLACK);
            viewHolder.txtTotal?.setTextColor(Color.BLACK);
        }


        return view as View;
    }

    override fun getFilter() : Filter {
        return object : Filter(){
            override fun publishResults(constraint: CharSequence?, results: FilterResults) {
                dataSetFilter = results?.values!! as ArrayList<CartModel>;
                notifyDataSetChanged();
            }

            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint.toString();
                if (charString.isEmpty()) {
                    dataSetFilter = dataSet;
                } else {
                    val filteredList: ArrayList<CartModel> = ArrayList();
                    for (row in dataSetFilter) {
                        if (row?.menu.toString()!!.toLowerCase()?.contains(charString.toLowerCase())!! ||
                            row?.harga.toString()!!.toLowerCase()?.contains(charString.toLowerCase())!!) {
                            filteredList.add(row)
                        }
                    }
                    dataSetFilter = filteredList
                }
                val filterResults = FilterResults();
                filterResults.values = dataSetFilter;
                filterResults.count = dataSetFilter.size;
                return filterResults;
            }
        };

        return filter;
    }


}