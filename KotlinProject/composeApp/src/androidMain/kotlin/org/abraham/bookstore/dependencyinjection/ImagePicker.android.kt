package org.abraham.bookstore.dependencyinjection

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher

actual class ImagePicker(private val activity: ComponentActivity) {

    private lateinit var getImage: ActivityResultLauncher<Intent>

    init {
        // Register the activity result contract for picking an image
        getImage = activity.registerForActivityResult(ActivityResultContracts.StartActivityForResult(), ActivityResultCallback { result ->
            if (result.resultCode == Activity.RESULT_OK) { // Use Activity.RESULT_OK
                val selectedImageUri: Uri? = result.data?.data
                // Handle the image URI (e.g., send it to your shared code)
                selectedImageUri?.let { imageUri ->
                    // Do something with the image URI
                    // For example, you can store it in a variable or call a shared method
                }
            }
        })
    }

    actual fun pickImage(): String {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        getImage.launch(intent)
        // Return an empty string for now, you may handle the URI in a better way
        return ""
    }
}