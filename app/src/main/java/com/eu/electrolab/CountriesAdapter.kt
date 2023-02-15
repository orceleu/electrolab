package com.eu.electrolab

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.drawerlayout.widget.DrawerLayout

class CountriesAdapter(val mContext:Context,val layoutRes: Int, val values:Array<Country> ):ArrayAdapter<Country>
    (mContext,layoutRes,values){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        return super.getView(position, convertView, parent)
    }
}