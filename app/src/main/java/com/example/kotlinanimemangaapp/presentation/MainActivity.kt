package com.example.kotlinanimemangaapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinanimemangaapp.common.Resource
import com.example.kotlinanimemangaapp.di.AppModule
import com.example.kotlinanimemangaapp.domain.interactor.get_mangas.GetMangasUC
import com.example.kotlinanimemangaapp.presentation.ui.theme.KotlinAnimeMangaAppTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            FirebaseApp.initializeApp(context)
            writeUserInFirestore()
            /*runBlocking {
                val mangaApi = AppModule.provideMangaApi()
                val mangaRepository = AppModule.provideMangaRepository(mangaApi)

                val mangaFlow = GetMangasUC(mangaRepository).invoke()

                mangaFlow.collect { resource ->
                    when (resource) {
                        is Resource.Loading -> {
                            println("Loading...")
                        }
                        is Resource.Success -> {
                            println(resource.data?.toString())
                        }
                        is Resource.Error -> {
                            println(resource.message)
                        }
                    }
                }
            }*/
            KotlinAnimeMangaAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Nicolas")
                }
            }
        }
    }
}

fun readDataFromFirestore() {
    val firestore = FirebaseFirestore.getInstance()
    firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()

    firestore
        .collection("users")
        .document("A2zVFCDfsJ91rVbcUeLT")
        .get()
        .addOnSuccessListener { document ->
            try {
                if (document != null) {
                    document.data?.forEach { (key, value) ->
                        println("$key => $value")
                    }
                } else {
                    println("Error getting documents")
                }
            } catch (ex: Exception) {
                println("Error getting documents")
            }
        }
        .addOnFailureListener { e ->
            println("Error getting documents ${e.message}")
        }
}

fun getAllUsersFromFirestore() {
    val firestore = FirebaseFirestore.getInstance()
    firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()

    firestore
        .collection("users")
        .get()
        .addOnSuccessListener { documents ->
            try {
                if (documents != null) {
                    for (document in documents) {
                        document.data?.forEach { (key, value) ->
                            println("$key => $value")
                        }
                    }
                } else {
                    println("Error getting documents")
                }
            } catch (ex: Exception) {
                println("Error getting documents")
            }
        }
        .addOnFailureListener { e ->
            println("Error getting documents ${e.message}")
        }
}

//fun to writer user in firestore
fun writeUserInFirestore() {
    val firestore = FirebaseFirestore.getInstance()
    firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()

    val user = hashMapOf(
        "name" to "Nicolas",
        "lastName" to "Gomez",
        "age" to 25
    )

    firestore
        .collection("users")
        .add(user)
        .addOnSuccessListener { documentReference ->
            println("DocumentSnapshot added with ID: ${documentReference.id}")
        }
        .addOnFailureListener { e ->
            println("Error adding document ${e.message}")
        }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name !",
        modifier = modifier
    )
}