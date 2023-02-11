package mx.itson.edu.examenu1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gradosC: TextView = findViewById(R.id.etC)
        val gradosF: TextView = findViewById(R.id.etF)
        val gradosK: TextView = findViewById(R.id.etK)
        val error: TextView = findViewById(R.id.incorrecto)

        val bCelsius: Button = findViewById(R.id.btnGC)
        val bFahrenheit: Button = findViewById(R.id.btnGF)
        val bKelvin: Button = findViewById(R.id.btnGK)


        bCelsius.setOnClickListener{

            when {
                gradosC.text.isNotEmpty() ->{
                    gradosC.setText("")
                    gradosK.setText("")
                    gradosF.setText("")
                    error.setText("Operación incorrecta")
                }

                gradosF.text.isEmpty() -> {
                    var resultado2 = celsiusToKelvin(gradosK.text.toString().toDouble())
                    gradosC.setText(resultado2.toString())
                    gradosK.setText("")
                    error.setText("")
                }

                gradosK.text.isEmpty() -> {
                var resultado = celsiusToFahrenheit(gradosF.text.toString().toDouble())
                gradosC.setText(resultado.toFloat().toString())
                gradosF.setText("")
                error.setText("")
            }
            }
        }

        bFahrenheit.setOnClickListener {

            when{
                gradosF.text.isNotEmpty() ->{
                    gradosF.setText("")
                    gradosK.setText("")
                    gradosC.setText("")
                    error.setText("Operación inválida")
                }

                gradosC.text.isEmpty()->{
                    var resultado2 = fahrenheitToKelvin(gradosK.text.toString().toDouble())
                    gradosF.setText(resultado2.toString())
                    gradosK.setText("")
                    error.setText("")
                }

                gradosK.text.isEmpty()->{
                var resultado = fahrenheitToCelsius(gradosC.text.toString().toDouble())
                gradosF.setText(resultado.toFloat().toString())
                gradosC.setText("")
                error.setText("")
            }
            }
        }

        bKelvin.setOnClickListener {

            when{
                gradosK.text.isNotEmpty() -> {
                    gradosK.setText("")
                    gradosC.setText("")
                    gradosF.setText("")
                    error.setText("Operación inválida")
                }

                gradosC.text.isEmpty()->{
                var resultado2 = kelcinToFahrenheit(gradosF.text.toString().toDouble())
                gradosK.setText(resultado2.toString())
                gradosF.setText("")
                error.setText("")
            }

                gradosF.text.isBlank()->{
                    var resultado = kelvinToCelsius(gradosC.text.toString().toDouble())
                    gradosK.setText(resultado.toFloat().toString())
                    gradosC.setText("")
                    error.setText("")
                }

            }
        }
    }

    fun celsiusToKelvin(k:Double):Double{
        return k - 273.15
    }

    fun kelvinToCelsius(c:Double):Double{
        return c + 273.15
    }

    fun fahrenheitToKelvin(k:Double):Double{
        return (((9 * k ) - 273.15) / 5) + 32
    }

    fun kelcinToFahrenheit(f:Double):Double{
        return (((5 * f ) - 32) / 9) + 273.15
    }

    fun celsiusToFahrenheit(f:Double):Double{
        return (f-32)/ 1.8
    }

    fun fahrenheitToCelsius(c:Double):Double{
        return (c * 1.8) + 32
    }


}