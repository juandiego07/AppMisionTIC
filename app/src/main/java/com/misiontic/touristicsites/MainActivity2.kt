package com.misiontic.touristicsites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity2 : AppCompatActivity() {

    var sites: List<DataSites> = listOf(
            DataSites("Central Park", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ee/New_York_City-Manhattan-Central_Park_%28Gentry%29.jpg/1200px-New_York_City-Manhattan-Central_Park_%28Gentry%29.jpg", "es un parque urbano público situado en el distrito metropolitano de Manhattan, en la ciudad de Nueva York, Estados Unidos. El parque tiene forma rectangular y dimensiones aproximadas de 4000 x 800 m, siendo superior en tamaño a las dos naciones más pequeñas del mundo; es casi dos veces más grande que Mónaco y casi ocho veces más que la Ciudad del Vaticano.1\u200B2\u200B3\u200B Si bien, su tamaño es algo inferior a la mitad del Bosque de Bolonia en París y una quinta parte de la Casa de Campo en Madrid.4\u200B", "es un parque urbano público situado en el distrito metropolitano de Manhattan, en la ciudad de Nueva York, Estados Unidos", "10", "40°46′57″N 73°57′58″O", "7°", "Museo 11S, Mirador Empire State"),
            DataSites("Central Park", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ee/New_York_City-Manhattan-Central_Park_%28Gentry%29.jpg/1200px-New_York_City-Manhattan-Central_Park_%28Gentry%29.jpg", "es un parque urbano público situado en el distrito metropolitano de Manhattan, en la ciudad de Nueva York, Estados Unidos. El parque tiene forma rectangular y dimensiones aproximadas de 4000 x 800 m, siendo superior en tamaño a las dos naciones más pequeñas del mundo; es casi dos veces más grande que Mónaco y casi ocho veces más que la Ciudad del Vaticano.1\u200B2\u200B3\u200B Si bien, su tamaño es algo inferior a la mitad del Bosque de Bolonia en París y una quinta parte de la Casa de Campo en Madrid.4\u200B", "es un parque urbano público situado en el distrito metropolitano de Manhattan, en la ciudad de Nueva York, Estados Unidos", "10", "40°46′57″N 73°57′58″O", "7°", "Museo 11S, Mirador Empire State"),
            DataSites("Central Park", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ee/New_York_City-Manhattan-Central_Park_%28Gentry%29.jpg/1200px-New_York_City-Manhattan-Central_Park_%28Gentry%29.jpg", "es un parque urbano público situado en el distrito metropolitano de Manhattan, en la ciudad de Nueva York, Estados Unidos. El parque tiene forma rectangular y dimensiones aproximadas de 4000 x 800 m, siendo superior en tamaño a las dos naciones más pequeñas del mundo; es casi dos veces más grande que Mónaco y casi ocho veces más que la Ciudad del Vaticano.1\u200B2\u200B3\u200B Si bien, su tamaño es algo inferior a la mitad del Bosque de Bolonia en París y una quinta parte de la Casa de Campo en Madrid.4\u200B", "es un parque urbano público situado en el distrito metropolitano de Manhattan, en la ciudad de Nueva York, Estados Unidos", "10", "40°46′57″N 73°57′58″O", "7°", "Museo 11S, Mirador Empire State")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
}