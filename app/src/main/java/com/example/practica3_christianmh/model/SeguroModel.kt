package com.example.practica3_christianmh.model

class SeguroModel {
    var tipoPoliza: String = ""
    var cantidadEdad:Int = 0
    var alcohol: String = ""
    var lentes: String = ""
    var enfermedad: String = ""
    var nomb: String = ""

    fun calcularCuota(): String {
        var respuesta:String = ""
        var poliza:Double = 0.0
        var polizaTotal:Double = 0.0
        var cargoEdad:Double = 0.0
        var cargoAlchol:Double = 0.0
        var cargoLentes:Double = 0.0
        var cargoEnfermedad:Double = 0.0

        when (tipoPoliza) {
            "Cobertura amplia" -> {
                respuesta = "Cobertura amplia"
                poliza = 1200.0

                if (cantidadEdad >= 18 && cantidadEdad <= 39) {
                    cargoEdad = poliza * 0.10

                } else if (cantidadEdad >= 40) {
                    cargoEdad = poliza * 0.20

                } else {
                    polizaTotal = 0.0
                }

                when (alcohol) {
                    "Si" -> {
                        cargoAlchol = poliza * 0.10
                    }
                    "No" -> {
                        cargoAlchol = 0.0
                    }
                }

                when (lentes) {
                    "Si" -> {
                        cargoLentes = poliza * 0.05
                    }

                    "No" -> {
                        cargoLentes = 0.0
                    }
                }

                when (enfermedad) {
                    "Si" -> {
                        cargoEnfermedad = poliza * 0.05
                    }

                    "No" -> {
                        cargoEnfermedad = 0.0
                    }
                }

                polizaTotal = poliza + cargoEdad + cargoAlchol + cargoLentes +cargoEnfermedad

            }
            "Daños a terceros" -> {
                respuesta = "Daños a terceros"
                poliza = 950.0

                if (cantidadEdad >= 18 && cantidadEdad <= 39) {
                    cargoEdad = poliza * 0.10

                } else if (cantidadEdad >= 40) {
                    cargoEdad = poliza * 0.20

                } else {
                    polizaTotal = 0.0
                }

                when (alcohol) {
                    "Si" -> {
                        cargoAlchol = poliza * 0.10
                    }
                    "No" -> {
                        cargoAlchol = 0.0
                    }
                }

                when (lentes) {
                    "Si" -> {
                        cargoLentes = poliza * 0.05
                    }

                    "No" -> {
                        cargoLentes = 0.0
                    }
                }

                when (enfermedad) {
                    "Si" -> {
                        cargoEnfermedad = poliza * 0.05
                    }

                    "No" -> {
                        cargoEnfermedad = 0.0
                    }
                }

                polizaTotal = poliza + cargoEdad + cargoAlchol + cargoLentes +cargoEnfermedad
            }
            else -> {
                respuesta = "Opción no válida"
                polizaTotal = 0.0
            }
        }

        return """
            Su nombre es: $nomb
            Tipo de Poliza: $respuesta
            Total a pagar: $ $polizaTotal
            """
    }
}