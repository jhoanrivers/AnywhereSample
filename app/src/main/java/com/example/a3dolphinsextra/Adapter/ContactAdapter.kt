package com.example.a3dolphinsextra.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a3dolphinsextra.R
import com.example.a3dolphinsextra.model.ContactModel
import java.util.zip.Inflater

class ContactAdapter(val listContact: List<ContactModel>): RecyclerView.Adapter<ContactAdapter.ContactHolder>() {



    class ContactHolder(view: View) : RecyclerView.ViewHolder(view) {
        var contactName: TextView = view.findViewById<TextView>(R.id.contact_name_tv)

        fun bind(contact: ContactModel) {

            contactName.text = contact.contactFirstName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ContactHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact,parent,false)
        return ContactHolder(view)
    }

    override fun onBindViewHolder(holder: ContactAdapter.ContactHolder, position: Int) {
        holder.bind(listContact[position])
    }

    override fun getItemCount(): Int {
        return listContact.size
    }
}