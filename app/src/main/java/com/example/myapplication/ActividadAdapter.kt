package com.example.myapplication

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActividadAdapter(private val actividades: List<Actividad>) :
    RecyclerView.Adapter<ActividadAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cbCompletada: CheckBox = view.findViewById(R.id.cbCompletada)
        val tvTitulo: TextView = view.findViewById(R.id.tvTitulo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_actividad, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val actividad = actividades[position]

        holder.tvTitulo.text = actividad.titulo
        holder.cbCompletada.isChecked = actividad.completada
        tachar(holder.tvTitulo, actividad.completada)

        holder.cbCompletada.setOnClickListener {
            actividad.completada = holder.cbCompletada.isChecked
            tachar(holder.tvTitulo, actividad.completada)
        }
    }

    override fun getItemCount(): Int {
        return actividades.size
    }

    private fun tachar(texto: TextView, completada: Boolean) {
        if (completada) {
            texto.paintFlags = texto.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            texto.paintFlags = texto.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}