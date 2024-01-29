package com.shift.persongeneratorxml.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.shift.persongeneratorxml.R
//import com.shift.persongeneratorxml.databinding.ListItemBinding
import com.shift.persongenxml.PersonModel

class PersonAdapter: ListAdapter<PersonModel, PersonAdapter.Holder>(Comparator()) {
    class Holder(view: View) : RecyclerView.ViewHolder(view){
        //private val binding = ListIte
    }
    class Comparator : DiffUtil.ItemCallback<PersonModel>(){
        override fun areItemsTheSame(oldItem: PersonModel, newItem: PersonModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PersonModel, newItem: PersonModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.person_list, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //holder.
    }
}