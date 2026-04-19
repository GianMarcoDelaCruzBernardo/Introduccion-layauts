@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.bienvenidoalcurso

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bienvenidoalcurso.ui.theme.BienvenidoAlCursoTheme
import androidx.compose.material3.ExperimentalMaterial3Api

@Composable
fun EjemploLazyColumn() {
    LazyColumn(modifier = Modifier.fillMaxWidth().height(200.dp)) {
        items(10) { index ->
            Text(text = "Item $index", modifier = Modifier.padding(8.dp))
            HorizontalDivider()
        }
    }
}

@Preview(showBackground = true, name = "1. LazyColumn")
@Composable
fun PreviewLazyColumn() {
    BienvenidoAlCursoTheme { EjemploLazyColumn() }
}

// 2. LazyRow - lista horizontal con scroll
@Composable
fun EjemploLazyRow() {
    LazyRow(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        items(10) { index ->
            Card(modifier = Modifier.padding(4.dp).size(80.dp)) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text(text = "Item $index")
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "2. LazyRow")
@Composable
fun PreviewLazyRow() {
    BienvenidoAlCursoTheme { EjemploLazyRow() }
}

@Composable
fun EjemploGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxWidth().height(200.dp)
    ) {
        items(9) { index ->
            Card(modifier = Modifier.padding(4.dp).height(60.dp)) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text(text = "$index")
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "3. Grid")
@Composable
fun PreviewGrid() {
    BienvenidoAlCursoTheme { EjemploGrid() }
}

@Composable
fun EjemploScaffold() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Mi App") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Default.Add, contentDescription = "Agregar")
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding).fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Contenido principal")
        }
    }
}

@Preview(showBackground = true, name = "4. Scaffold", showSystemUi = true)
@Composable
fun PreviewScaffold() {
    BienvenidoAlCursoTheme { EjemploScaffold() }
}

@Composable
fun EjemploSurface() {
    Surface(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        color = Color(0xFFE3F2FD),
        shadowElevation = 8.dp,
        shape = MaterialTheme.shapes.medium
    ) {
        Text(text = "Esto es un Surface", modifier = Modifier.padding(16.dp), fontSize = 18.sp)
    }
}

@Preview(showBackground = true, name = "5. Surface")
@Composable
fun PreviewSurface() {
    BienvenidoAlCursoTheme { EjemploSurface() }
}

@Composable
fun EjemploChip() {
    var selected by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        FilterChip(selected = selected, onClick = { selected = !selected }, label = { Text("Kotlin") })
        FilterChip(selected = true, onClick = {}, label = { Text("Android") })
        FilterChip(selected = false, onClick = {}, label = { Text("Compose") })
    }
}

@Preview(showBackground = true, name = "6. Chip")
@Composable
fun PreviewChip() {
    BienvenidoAlCursoTheme { EjemploChip() }
}

@Composable
fun EjemploFlowRow() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("FlowRow - elementos que hacen wrap:", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf("Kotlin", "Android", "Compose", "Material3", "Jetpack").forEach {
                AssistChip(onClick = {}, label = { Text(it) })
            }
        }
    }
}

@Preview(showBackground = true, name = "7. FlowRow")
@Composable
fun PreviewFlowRow() {
    BienvenidoAlCursoTheme { EjemploFlowRow() }
}

@OptIn(ExperimentalMaterial3Api::class)
// 8. AlertDialog
@Composable
fun EjemploAlertDialog() {
    var show by remember { mutableStateOf(true) }
    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = { show = true }) { Text("Mostrar Dialog") }
        if (show) {
            AlertDialog(
                onDismissRequest = { show = false },
                title = { Text("Titulo") },
                text = { Text("Este es un AlertDialog de ejemplo.") },
                confirmButton = { TextButton(onClick = { show = false }) { Text("Aceptar") } },
                dismissButton = { TextButton(onClick = { show = false }) { Text("Cancelar") } }
            )
        }
    }
}

@Preview(showBackground = true, name = "8. AlertDialog")
@Composable
fun PreviewAlertDialog() {
    BienvenidoAlCursoTheme { EjemploAlertDialog() }
}

// 9. Card
@Composable
fun EjemploCard() {
    Card(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Titulo de la Card", fontSize = 20.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Contenido de la card con informacion relevante.")
        }
    }
}

@Preview(showBackground = true, name = "9. Card")
@Composable
fun PreviewCard() {
    BienvenidoAlCursoTheme { EjemploCard() }
}

// 10. Checkbox
@Composable
fun EjemploCheckbox() {
    var checked1 by remember { mutableStateOf(true) }
    var checked2 by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = checked1, onCheckedChange = { checked1 = it })
            Text("Opcion 1")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = checked2, onCheckedChange = { checked2 = it })
            Text("Opcion 2")
        }
    }
}

@Preview(showBackground = true, name = "10. Checkbox")
@Composable
fun PreviewCheckbox() {
    BienvenidoAlCursoTheme { EjemploCheckbox() }
}

// 11. FloatingActionButton
@Composable
fun EjemploFloatingActionButton() {
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        FloatingActionButton(onClick = {}) {
            Icon(Icons.Default.Add, contentDescription = "Agregar")
        }
        ExtendedFloatingActionButton(
            onClick = {},
            icon = { Icon(Icons.Default.Edit, contentDescription = null) },
            text = { Text("Editar") }
        )
    }
}

@Preview(showBackground = true, name = "11. FloatingActionButton")
@Composable
fun PreviewFloatingActionButton() {
    BienvenidoAlCursoTheme { EjemploFloatingActionButton() }
}

// 12. Icon
@Composable
fun EjemploIcon() {
    Row(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Blue)
        Icon(Icons.Default.Favorite, contentDescription = "Favorito", tint = Color.Red)
        Icon(Icons.Default.Settings, contentDescription = "Config", tint = Color.Gray)
        Icon(Icons.Default.Person, contentDescription = "Persona", tint = Color(0xFF006D3B))
    }
}

@Preview(showBackground = true, name = "12. Icon")
@Composable
fun PreviewIcon() {
    BienvenidoAlCursoTheme { EjemploIcon() }
}

// 13. ProgressBar
@Composable
fun EjemploProgressBar() {
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Lineal:")
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        LinearProgressIndicator(progress = { 0.7f }, modifier = Modifier.fillMaxWidth())
        Text("Circular:")
        CircularProgressIndicator()
    }
}

@Preview(showBackground = true, name = "13. ProgressBar")
@Composable
fun PreviewProgressBar() {
    BienvenidoAlCursoTheme { EjemploProgressBar() }
}

// 14. RadioButton
@Composable
fun EjemploRadioButton() {
    var selected by remember { mutableStateOf("A") }
    Column(modifier = Modifier.padding(16.dp)) {
        listOf("Opcion A", "Opcion B", "Opcion C").forEach { opcion ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected = selected == opcion.last().toString(), onClick = { selected = opcion.last().toString() })
                Text(opcion)
            }
        }
    }
}

@Preview(showBackground = true, name = "14. RadioButton")
@Composable
fun PreviewRadioButton() {
    BienvenidoAlCursoTheme { EjemploRadioButton() }
}

// 15. Slider
@Composable
fun EjemploSlider() {
    var value by remember { mutableStateOf(0.5f) }
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Valor: ${(value * 100).toInt()}%")
        Slider(value = value, onValueChange = { value = it })
    }
}

@Preview(showBackground = true, name = "15. Slider")
@Composable
fun PreviewSlider() {
    BienvenidoAlCursoTheme { EjemploSlider() }
}

// 16. Spacer
@Composable
fun EjemploSpacer() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Elemento 1")
        Spacer(modifier = Modifier.height(32.dp))
        Text("Elemento 2 (con espacio de 32dp arriba)")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Elemento 3 (con espacio de 8dp arriba)")
    }
}

@Preview(showBackground = true, name = "16. Spacer")
@Composable
fun PreviewSpacer() {
    BienvenidoAlCursoTheme { EjemploSpacer() }
}

// 17. Switch
@Composable
fun EjemploSwitch() {
    var on1 by remember { mutableStateOf(true) }
    var on2 by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text("Notificaciones")
            Switch(checked = on1, onCheckedChange = { on1 = it })
        }
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text("Modo oscuro")
            Switch(checked = on2, onCheckedChange = { on2 = it })
        }
    }
}

@Preview(showBackground = true, name = "17. Switch")
@Composable
fun PreviewSwitch() {
    BienvenidoAlCursoTheme { EjemploSwitch() }
}

// 18. TopAppBar
@Composable
fun EjemploTopAppBar() {
    TopAppBar(
        title = { Text("Mi Aplicacion") },
        navigationIcon = { IconButton(onClick = {}) { Icon(Icons.Default.Menu, contentDescription = "Menu") } },
        actions = {
            IconButton(onClick = {}) { Icon(Icons.Default.Search, contentDescription = "Buscar") }
            IconButton(onClick = {}) { Icon(Icons.Default.MoreVert, contentDescription = "Mas") }
        }
    )
}

@Preview(showBackground = true, name = "18. TopAppBar")
@Composable
fun PreviewTopAppBar() {
    BienvenidoAlCursoTheme { EjemploTopAppBar() }
}

// ===============================================================
// CONTROLES - Columna 2
// ===============================================================

// 19. BottomNavigation
@Composable
fun EjemploBottomNavigation() {
    var selected by remember { mutableStateOf(0) }
    NavigationBar {
        NavigationBarItem(selected = selected == 0, onClick = { selected = 0 }, icon = { Icon(Icons.Default.Home, null) }, label = { Text("Inicio") })
        NavigationBarItem(selected = selected == 1, onClick = { selected = 1 }, icon = { Icon(Icons.Default.Search, null) }, label = { Text("Buscar") })
        NavigationBarItem(selected = selected == 2, onClick = { selected = 2 }, icon = { Icon(Icons.Default.Person, null) }, label = { Text("Perfil") })
    }
}

@Preview(showBackground = true, name = "19. BottomNavigation")
@Composable
fun PreviewBottomNavigation() {
    BienvenidoAlCursoTheme { EjemploBottomNavigation() }
}

// 20. Divider
@Composable
fun EjemploDivider() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Seccion 1")
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), color = Color.Gray)
        Text("Seccion 2")
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), thickness = 3.dp, color = Color(0xFF006D3B))
        Text("Seccion 3")
    }
}

@Preview(showBackground = true, name = "20. Divider")
@Composable
fun PreviewDivider() {
    BienvenidoAlCursoTheme { EjemploDivider() }
}

// 21. OutlinedTextField
@Composable
fun EjemploOutlinedTextField() {
    var texto by remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        OutlinedTextField(value = texto, onValueChange = { texto = it }, label = { Text("Nombre") }, placeholder = { Text("Escribe tu nombre") })
        OutlinedTextField(value = "", onValueChange = {}, label = { Text("Email") }, leadingIcon = { Icon(Icons.Default.Email, null) })
    }
}

@Preview(showBackground = true, name = "21. OutlinedTextField")
@Composable
fun PreviewOutlinedTextField() {
    BienvenidoAlCursoTheme { EjemploOutlinedTextField() }
}

// 22. Snackbar
@Composable
fun EjemploSnackbar() {
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Snackbar { Text("Mensaje de Snackbar simple") }
        Snackbar(action = { TextButton(onClick = {}) { Text("DESHACER") } }) {
            Text("Elemento eliminado")
        }
    }
}

@Preview(showBackground = true, name = "22. Snackbar")
@Composable
fun PreviewSnackbar() {
    BienvenidoAlCursoTheme { EjemploSnackbar() }
}

// 23. TabRow
@Composable
fun EjemploTabRow() {
    var tabSelected by remember { mutableStateOf(0) }
    val tabs = listOf("Inicio", "Buscar", "Perfil")
    Column {
        TabRow(selectedTabIndex = tabSelected) {
            tabs.forEachIndexed { index, titulo ->
                Tab(selected = tabSelected == index, onClick = { tabSelected = index }, text = { Text(titulo) })
            }
        }
        Box(modifier = Modifier.padding(16.dp)) {
            Text("Contenido de: ${tabs[tabSelected]}")
        }
    }
}

@Preview(showBackground = true, name = "23. TabRow")
@Composable
fun PreviewTabRow() {
    BienvenidoAlCursoTheme { EjemploTabRow() }
}

@OptIn(ExperimentalMaterial3Api::class)
// 24. Tooltip
@Composable
fun EjemploTooltip() {
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Tooltip: informacion emergente al mantener presionado un elemento")
        TooltipBox(
            positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
            tooltip = { PlainTooltip { Text("Este es un tooltip!") } },
            state = rememberTooltipState()
        ) {
            Button(onClick = {}) { Text("MantÃ©n presionado") }
        }
    }
}

@Preview(showBackground = true, name = "24. Tooltip")
@Composable
fun PreviewTooltip() {
    BienvenidoAlCursoTheme { EjemploTooltip() }
}