package com.example.diary_droid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


// in < ContactsAdapter > implement members from alt enter - select and create the three method
class ContactsAdapter(val contactsList: ArrayList<Contact>): RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    // implement class ViewHolder > alt enter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_view, parent, false) // for call layout < contact_view >
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactsAdapter.ViewHolder, position: Int) {
        holder.bindItem(contactsList[position])
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        // implement recycler view
        fun bindItem(contact: Contact){

            // call for layout contact_view
            val textName = itemView.findViewById<TextView>(R.id.contact_name)
            val textPhone = itemView.findViewById<TextView>(R.id.contact_phone_namber)

            textName.text = contact.name
            textPhone.text = contact.phoneNumber
        }

    }
}