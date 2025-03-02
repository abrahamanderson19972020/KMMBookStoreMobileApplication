package org.abraham.bookstore

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.skydoves.landscapist.coil3.CoilImage
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform
import org.abraham.bookstore.dependencyinjection.ImagePicker

@Composable
@Preview
fun App() {
    var imageUri by remember { mutableStateOf<String?>(null) }
    MaterialTheme {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                // Simulate selecting an image URI
                imageUri = "https://www.example.com/image.jpg" // This could be a local URI or path as well
            }) {
                Text("Upload Image")
            }

            // If an image URI exists, display the image
            imageUri?.let { uri ->
                CoilImage(
                    imageModel = { uri }, // Pass the URI as a lambda
                    modifier = Modifier.fillMaxWidth() // Add additional styling here
                )
            }
        }
    }
}