package com.nova.ui
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
@Composable
fun HomeScreen(vm:HomeViewModel){
    val greeting by vm.greeting.collectAsState()
    var show by remember{mutableStateOf(greeting.isBlank())}
    Box(Modifier.fillMaxSize(), Alignment.Center){
        if(greeting.isNotBlank()) GreetingBanner(greeting)
    }
    if(show) NameDialog{
        vm.save(it); show=false
    }
}
@Composable
fun GreetingBanner(text:String){
    Card(Modifier.padding(24.dp).fillMaxWidth()){
        Text(text, style=MaterialTheme.typography.headlineMedium, modifier=Modifier.padding(16.dp))
    }
}
@Composable
fun NameDialog(onSave:(String)->Unit){
    var txt by remember{ mutableStateOf(TextFieldValue())}
    AlertDialog(
        onDismissRequest={},
        confirmButton={ TextButton({ onSave(txt.text) }){ Text("Guardar") }},
        title={ Text("¿Cómo te llamas?")},
        text={ OutlinedTextField(value=txt,onValueChange={txt=it}, label={Text("Nombre")}) }
    )
}