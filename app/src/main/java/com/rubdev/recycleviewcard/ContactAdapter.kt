package com.rubdev.recycleviewcard

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.CompactAdapterViewHolder>() {

    //variavel que irá armazenar a lista
    private val list: MutableList<Contact> = mutableListOf()

    //reponsavel por gerenciar cada item da tela
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompactAdapterViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return CompactAdapterViewHolder(view)
    }

    // ele le o item do array e popula o item na view
    override fun onBindViewHolder(holder: CompactAdapterViewHolder, position: Int) {
            holder.bind(list[position])
    }

    override fun getItemCount(): Int {
       return list.size
    }

    fun updateList(list: List<Contact>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }


    //view holder classe que ira gerenciar cada item da lista
    class  CompactAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvPhone: TextView = itemView.findViewById(R.id.tv_phone)
        private val ivPhotograph: ImageView = itemView.findViewById(R.id.iv_photograph)

        fun bind(contact: Contact){
            tvName.text = contact.name
            tvPhone.text = contact.phone

        }
    }

}