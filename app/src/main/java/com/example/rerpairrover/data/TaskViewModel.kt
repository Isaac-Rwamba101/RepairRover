package com.example.rerpairrover.data

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.rerpairrover.models.Task
import com.example.rerpairrover.navigation.ROUT_LOGIN
import com.example.rerpairrover.navigation.ROUT_VIEW
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class TaskViewModel(var navController: NavController, @SuppressLint("RestrictedApi") var context: android.content.Context) {
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

        val task = Task(name,description,taskId,userId?:"")
        val databaseRef = FirebaseDatabase.getInstance().getReference()
            .child("Tasks/$taskId")
        databaseRef.setValue(task).addOnCompleteListener {
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
            .child("Tasks/$taskId")
        ref.removeValue()
        Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show()
    }

    fun updateTask(taskId:String){
        val ref = FirebaseDatabase.getInstance().getReference()
            .child("Tasks/$taskId")
        ref.removeValue()
        navController.navigate(ROUT_VIEW)
    }

    fun allTasks(
        task: MutableState<Task>,
        tasks: SnapshotStateList<Task>): SnapshotStateList<Task> {
        progress.show()

        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Tasks")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                tasks.clear()
                for (snap in snapshot.children){
                    val retrievedTask = snap.getValue(Task::class.java)
                    task.value = retrievedTask!!
                    tasks.add(retrievedTask)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return tasks
    }

}