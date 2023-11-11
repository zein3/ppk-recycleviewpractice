package com.polstat.recycleviewpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MahasiswaAdapter(
    private val dataList: Array<Mahasiswa>,
    private val onItemClicked: (Mahasiswa) -> Unit
) :
    RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.row_mahasiswa, parent, false)
        return MahasiswaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        holder.txtNama.text = dataList[position].nama
        holder.txtNim.text = dataList[position].nim
        holder.txtNoHp.text = dataList[position].nohp
        holder.itemView.setOnClickListener { onItemClicked(dataList[position]) }
    }

    override fun getItemCount() = dataList.size

    class MahasiswaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNama: TextView
        val txtNim: TextView
        val txtNoHp: TextView

        init {
            txtNama = itemView.findViewById(R.id.txt_nama_mahasiswa)
            txtNim = itemView.findViewById(R.id.txt_nim_mahasiswa)
            txtNoHp = itemView.findViewById(R.id.txt_nohp_mahasiswa)
        }
    }

}

