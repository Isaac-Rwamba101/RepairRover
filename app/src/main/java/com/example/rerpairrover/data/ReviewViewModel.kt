package com.example.rerpairrover.data

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.rerpairrover.models.Review
import com.example.rerpairrover.navigation.ROUT_LOGIN
import com.example.rerpairrover.navigation.ROUT_VIEW
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ReviewViewModel(var navController: NavController, @SuppressLint("RestrictedApi") var context: android.content.Context) {
    var authViewModel:AuthViewModel
    var progress: ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(ROUT_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadTask(name:String, description:String){
        val taskId = System.currentTimeMillis().toString()
        progress.show()

        val currentUser = FirebaseAuth.getInstance().currentUser
        val userId = currentUser?.uid

        val review = Review(name,description,taskId,userId?:"")
        val databaseRef = FirebaseDatabase.getInstance().getReference()
            .child("Reviews/$taskId")
        databaseRef.setValue(review).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful){
                navController.navigate(ROUT_VIEW)
                Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun deleteTask(taskId:String){
        val ref = FirebaseDatabase.getInstance().getReference()
            .child("Reviews/$taskId")
        ref.removeValue()
        Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show()
    }

    fun updateTask(taskId:String){
        val ref = FirebaseDatabase.getInstance().getReference()
            .child("Reviews/$taskId")
        ref.removeValue()
        navController.navigate(ROUT_VIEW)
    }

    fun allTasks(
        review: MutableState<Review>,
        reviews: SnapshotStateList<Review>): SnapshotStateList<Review> {
        progress.show()

        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Reviews")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                reviews.clear()
                for (snap in snapshot.children){
                    val retrievedReview = snap.getValue(Review::class.java)
                    review.value = retrievedReview!!
                    reviews.add(retrievedReview)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return reviews
    }

}