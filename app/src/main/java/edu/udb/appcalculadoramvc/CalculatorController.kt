package edu.udb.appcalculadoramvc

import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class CalculatorController(private val view: MainActivity) {

    private val model = CalculatorModel()

    init {
        // Asociar eventos de clic a los botones
        view.findViewById<Button>(R.id.btn_add).setOnClickListener { performOperation("add") }
        view.findViewById<Button>(R.id.btn_subtract)
            .setOnClickListener { performOperation("subtract") }
        view.findViewById<Button>(R.id.btn_multiply)
            .setOnClickListener { performOperation("multiply") }
        view.findViewById<Button>(R.id.btn_divide).setOnClickListener { performOperation("divide") }
        view.findViewById<Button>(R.id.btn_root2).setOnClickListener { performOperation("root2") }
    }

    private fun performOperation(operation: String) {
        // Obtener los números ingresados por el usuario
        val num1 = view.findViewById<EditText>(R.id.num1).text.toString().toDouble()
        val num2 = view.findViewById<EditText>(R.id.num2).text.toString().toDouble()
        var tvResultado = view.findViewById<TextView>(R.id.result).text
        val txt = tvResultado.toString()
        var num3 = "1.0"
        if (!txt.isNullOrEmpty()) {
            num3 = txt.replace("Resultado: ", "")
        }
        Log.d("M", num3);
        val resultadoNumerico = 1.0
        // Realizar la operación correspondiente
        var result = when (operation) {
            "add" -> model.add(num1, num2)
            "subtract" -> model.subtract(num1, num2)
            "multiply" -> model.multiply(num1, num2)
            "divide" -> model.divide(num1, num2)
            "root2" -> model.root2(num3.toDouble())
            else -> throw IllegalArgumentException("Operación no válida")
        }

        // Actualizar la vista con el resultado
        view.findViewById<TextView>(R.id.result).text = "Resultado: $result"
    }
}
