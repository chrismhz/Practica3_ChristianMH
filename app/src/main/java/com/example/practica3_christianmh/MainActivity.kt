package com.example.practica3_christianmh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.example.practica3_christianmh.model.SeguroModel
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    // ---- Manera de conectar con el modelo y que este disponible a todos ----

    private val poliza = SeguroModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtEdad = findViewById<TextInputEditText>(R.id.txtEdad)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val resultados = findViewById<TextView>(R.id.txtResultado)
        val spinner1: Spinner = findViewById(R.id.cmbPolizas)
        val spinner2: Spinner = findViewById(R.id.cmbAlcohol)
        val spinner3: Spinner = findViewById(R.id.cmbLentes)
        val spinner4: Spinner = findViewById(R.id.cmbEnfermedades)
        val nombre = findViewById<TextInputEditText>(R.id.txtNombre)

        // ---- Seccion del spinner ----

        val opcionesPoliza = arrayOf("----------------------------Seleccione----------------------------", "Cobertura amplia", "Daños a terceros")
        val adapPoliza = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesPoliza)
        spinner1.adapter = adapPoliza

        val opcionesAlcohol = arrayOf("----------------------------Seleccione----------------------------", "Si", "No")
        val adapAlcohol = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesAlcohol)
        spinner2.adapter = adapAlcohol

        val opcionesLentes = arrayOf("----------------------------Seleccione----------------------------", "Si", "No")
        val adapLentes = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesLentes)
        spinner3.adapter = adapLentes

        val opcionesEnfe = arrayOf("----------------------------Seleccione----------------------------", "Si", "No")
        val adapEnfe = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesEnfe)
        spinner4.adapter = adapEnfe

        // ---- Evento del boton ----

        btnCalcular.setOnClickListener() {


            if (txtEdad.text.toString().trim().isEmpty()) {
                txtEdad.setError("Ingrese su edad por favor")
                // para no ejecutar nada si la caja esta vacia
                return@setOnClickListener
            } else {
                poliza.cantidadEdad = txtEdad.text.toString().toInt()
            }

            if (nombre.text.toString().trim().isEmpty()) {
                nombre.setError("Ingrese su nombre")
                // para no ejecutar nada si la caja esta vacia
                return@setOnClickListener
            } else {
                poliza.nomb = nombre.text.toString()
            }

            val noPoliza:Int;
            noPoliza = spinner1.selectedItemPosition

            val noAlcohol:Int;
            noAlcohol = spinner2.selectedItemPosition

            val noLente:Int;
            noLente = spinner3.selectedItemPosition

            val noEnfe:Int;
            noEnfe = spinner4.selectedItemPosition

            if (noPoliza == 0){
                Toast.makeText(applicationContext, "Seleccione una poliza", Toast.LENGTH_LONG).show()
            }else{
                poliza.tipoPoliza = opcionesPoliza[noPoliza]
            }

            if (noAlcohol == 0){
                Toast.makeText(applicationContext, "Seleccione una opción", Toast.LENGTH_LONG).show()
            }else{
                poliza.alcohol = opcionesAlcohol[noAlcohol]
            }

            if (noLente == 0){
                Toast.makeText(applicationContext, "Seleccione una opción", Toast.LENGTH_LONG).show()
            }else{
                poliza.lentes = opcionesLentes[noLente]
            }

            if (noEnfe == 0){
                Toast.makeText(applicationContext, "Seleccione una opción", Toast.LENGTH_LONG).show()
            }else{
                poliza.enfermedad = opcionesEnfe[noEnfe]
            }


            // ---- Mostrar resultados ----
            resultados.text = poliza.calcularCuota()
        }

    }
}