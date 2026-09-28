package com.example.lazylayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.lazylayout.ui.theme.LazylayoutTheme

class MainActivity : ComponentActivity() {

    val gadgets = listOf(
        Gadget(
            1,
            "Smartphone",
            "Perangkat komunikasi genggam",
            R.drawable.smartphone
        ),
        Gadget(
            2,
            "Laptop",
            "Komputer portabel untuk bekerja",
            R.drawable.laptop
        ),
        Gadget(
            3,
            "Tablet",
            "Perangkat layar sentuh antara hp dan laptop",
            R.drawable.tablet
        ),
        Gadget(
            4,
            "Smartwatch",
            "Jam tangan pintar pelacak kesehatan",
            R.drawable.smartwatch
        ),
        Gadget(
            5,
            "Earbuds",
            "Perangkat audio nirkabel",
            R.drawable.earbuds
        ),
        Gadget(
            6,
            "Laptop",
            "Perangkat komputasi portabel",
            R.drawable.laptop
        ),
        Gadget(
            7,
            "Smartphone",
            "Perangkat komunikasi genggam",
            R.drawable.smartphone
        ),
        Gadget(
            8,
            "Laptop",
            "Komputer portabel untuk bekerja",
            R.drawable.laptop
        ),
        Gadget(
            9,
            "Tablet",
            "Perangkat layar sentuh antara hp dan laptop",
            R.drawable.tablet
        ),
        Gadget(
            10,
            "Smartwatch",
            "Jam tangan pintar pelacak kesehatan",
            R.drawable.smartwatch
        ),
        Gadget(
            11,
            "Earbuds",
            "Perangkat audio nirkabel",
            R.drawable.earbuds
        ),
        Gadget(
            12,
            "Laptop",
            "Perangkat komputasi portabel",
            R.drawable.laptop
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            LazylayoutTheme {
                GadgetScreen(gadgets)
            }
        }
    }
}

@Composable
fun GadgetScreen(gadgets: List<Gadget>) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 16.dp)
    ) {

        // HEADER - tidak ikut scroll
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 12.dp
                )
            ) {
                Text(
                    text = "Nama: Nadinda Carissa Achsan",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "NIM: 245150401111020",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // HANYA LIST INI YANG SCROLL
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(gadgets) { gadget ->
                GadgetItem(gadget)
            }
        }
    }
}

@Composable
fun GadgetItem(gadget: Gadget) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // GAMBAR DI SEBELAH KIRI
            Image(
                painter = painterResource(
                    id = gadget.imageResId
                ),
                contentDescription = gadget.name,
                modifier = Modifier
                    .size(55.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            // JARAK GAMBAR DAN TEXT
            Spacer(modifier = Modifier.size(12.dp))

            // TEXT DI SEBELAH KANAN
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = gadget.name,
                    style = MaterialTheme.typography.titleSmall
                )

                Text(
                    text = gadget.description,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}