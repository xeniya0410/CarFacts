package com.example.carfacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.carfacts.ui.theme.CarFactsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarFactsTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    FactListScreen()
                }
            }
        }
    }
}

@Composable
fun FactListScreen() {
    val facts = remember { FactRepository.getFacts() }
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(facts) { fact ->
            // Передаем параметр с именем 'fact'
            FactCard(fact = fact)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun FactCard(fact: FactCard) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = fact.title, style = MaterialTheme.typography.headlineSmall)
            Text(text = fact.description)
            Text(text = fact.date)
            Image(painter = painterResource(id = fact.imageResId), contentDescription = null)
        }
    }
}
