package com.meow.fore.auth

import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class Repository {


    fun hasUser(): Boolean {
        return Firebase.auth.currentUser != null
    }

    fun getUserId(): String {
        return Firebase.auth.currentUser?.uid.orEmpty()
    }

    fun getUserEmail(): String {
        return Firebase.auth.currentUser?.email.orEmpty()
    }


    // Check username availability


    // Register user


    suspend fun signUp(
        email: String,
        password: String,
        isCompleted: (Boolean) -> Unit
    ) =
        withContext(Dispatchers.IO) {
            Firebase.auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        isCompleted.invoke(true)
                    } else {
                        isCompleted.invoke(false)
                    }
                }.await()
        }


    suspend fun signIn(email: String, password: String, isCompleted: (Boolean) -> Unit) =
        withContext(Dispatchers.IO) {
            Firebase.auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    isCompleted.invoke(true)
                } else {
                    isCompleted.invoke(false)
                }
            }.await()
        }


    fun signOut() {
        Firebase.auth.signOut()
    }

    suspend fun resetPassword(email: String, isCompleted: (Boolean) -> Unit) =
        withContext(Dispatchers.IO) {
            Firebase.auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    isCompleted.invoke(true)
                } else {
                    isCompleted.invoke(false)
                }
            }.await()
        }

}