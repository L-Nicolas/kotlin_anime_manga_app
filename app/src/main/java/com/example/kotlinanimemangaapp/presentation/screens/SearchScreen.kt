package com.example.kotlinanimemangaapp.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kotlinanimemangaapp.presentation.navigation.nav_graph.Graph
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

@Composable
fun SearchScreen(
    navController: NavController
) {
    searchMyFriendsFromFirestore()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = "Search Screen",
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.h3,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier
                    .clickable {
                        navController.navigate(Graph.AUTHENTICATION_ROUTE)
                    },
                text = "Login",
                color = Color(0xFFFF0000),
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SearchScreenPreview() {
    SearchScreen(navController = rememberNavController())
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

fun searchMyFriendsFromFirestore() {
    val firestore = FirebaseFirestore.getInstance()
    firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()

    firestore
        .collection("friends")
        .whereEqualTo("id_user", "7OAdq3iVxa9GUSJTrSqZ")
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