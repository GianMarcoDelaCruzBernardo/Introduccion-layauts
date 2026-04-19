package com.example.bienvenidoalcurso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bienvenidoalcurso.ui.theme.BienvenidoAlCursoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BienvenidoAlCursoTheme {
                TarjetaPresentacion()
            }
        }
    }
}

// -------------------------------------------------------
// PARTE 1: Tarjeta basica - modificada con nombre
// -------------------------------------------------------
@Composable
fun GreetingCardBasica() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Bienvenido al Curso de Moviles!", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Hola, Gian Marco!", fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGreetingCardBasica() {
    BienvenidoAlCursoTheme { GreetingCardBasica() }
}

// -------------------------------------------------------
// PARTE 2: Con TextField e Image
// -------------------------------------------------------
@Composable
fun GreetingCardConImagenYTextField() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Bienvenido al Curso de Moviles!", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Hola, Gian Marco!", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = "", onValueChange = {}, label = { Text("Ingresa tu nombre") })
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Logo Android",
            modifier = Modifier.size(100.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGreetingCardConImagenYTextField() {
    BienvenidoAlCursoTheme { GreetingCardConImagenYTextField() }
}

// -------------------------------------------------------
// PARTE 3: Con Boton personalizado
// -------------------------------------------------------
@Composable
fun GreetingCardConBoton() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Bienvenido al Curso de Moviles!", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Hola, Gian Marco!", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = "", onValueChange = {}, label = { Text("Ingresa tu nombre") })
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            modifier = Modifier.fillMaxWidth().height(50.dp)
        ) {
            Text("Mostrar Saludo", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Logo Android",
            modifier = Modifier.size(100.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGreetingCardConBoton() {
    BienvenidoAlCursoTheme { GreetingCardConBoton() }
}

// -------------------------------------------------------
// PARTE 4: Column + Row con dos botones
// -------------------------------------------------------
@Composable
fun GreetingCardColumnRow() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Bienvenido al Curso de Moviles!", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Hola, Gian Marco!", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = {}) { Text("Aceptar") }
            Button(onClick = {}) { Text("Rechazar") }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Logo Android",
            modifier = Modifier.size(100.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGreetingCardColumnRow() {
    BienvenidoAlCursoTheme { GreetingCardColumnRow() }
}

// -------------------------------------------------------
// EJERCICIO FINAL: Tarjeta de Presentacion
// -------------------------------------------------------
@Composable
fun TarjetaPresentacion() {
    val verde = Color(0xFFB5CCBA)
    val verdeOscuro = Color(0xFF006D3B)

    Column(
        modifier = Modifier.fillMaxSize().background(verde).padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "Logo Android",
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Gian Marco", fontSize = 48.sp, fontWeight = FontWeight.Light, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Android Developer Extraordinaire", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = verdeOscuro)
        }
        Column(modifier = Modifier.padding(bottom = 40.dp)) {
            HorizontalDivider(color = verdeOscuro, thickness = 1.dp)
            Spacer(modifier = Modifier.height(8.dp))
            ContactoRow(icono = "\uD83D\uDCDE", dato = "+51 999 999 999")
            ContactoRow(icono = "\uD83D\uDD17", dato = "@GianMarco")
            ContactoRow(icono = "\uD83D\uDCE7", dato = "gianmarco@android.com")
        }
    }
}

@Composable
fun ContactoRow(icono: String, dato: String) {
    val verdeOscuro = Color(0xFF006D3B)
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = icono, color = verdeOscuro, fontSize = 20.sp, modifier = Modifier.width(40.dp))
        Text(text = dato, fontSize = 16.sp, color = Color.Black)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewTarjetaPresentacion() {
    BienvenidoAlCursoTheme { TarjetaPresentacion() }
}