package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ActividadesActivity : AppCompatActivity() {

    private val actividades = mutableListOf(
        Actividad("Correr 30 minutos"),
        Actividad("Rutina de fuerza"),
        Actividad("Natación")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividades)

        val etActividad = findViewById<EditText>(R.id.etActividad)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val rvActividades = findViewById<RecyclerView>(R.id.rvActividades)

        val adapter = ActividadAdapter(actividades)
        rvActividades.layoutManager = LinearLayoutManager(this)
        rvActividades.adapter = adapter

        btnAgregar.setOnClickListener {
            val titulo = etActividad.text.toString()

            if (titulo.isNotEmpty()) {
                actividades.add(Actividad(titulo))
                adapter.notifyItemInserted(actividades.size - 1)
                etActividad.setText("")
            }
        }
    }
}