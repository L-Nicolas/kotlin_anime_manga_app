package com.example.kotlinanimemangaapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.example.kotlinanimemangaapp.presentation.navigation.nav_graph.SetupNavGraph
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            FirebaseApp.initializeApp(context)

            SetupNavGraph(navController = rememberNavController())
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
