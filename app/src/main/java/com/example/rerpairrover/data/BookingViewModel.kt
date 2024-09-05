package com.example.rerpairrover.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.rerpairrover.models.Booking
import com.example.rerpairrover.navigation.ROUT_BOOKINGS
import com.example.rerpairrover.navigation.ROUT_HOME
import com.example.rerpairrover.navigation.ROUT_LOGIN
import com.example.rerpairrover.navigation.ROUT_VIEWBOOKINGS
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class BookingViewModel(var navController: NavController, var context: Context) {
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

    fun uploadBooking(name:String, service:String,date:String, time:String,phone: String,filePath: Uri){
        val bookingId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Bookings/$bookingId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var booking = Booking(name,service,date,time,phone,imageUrl,bookingId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Bookings/$bookingId")
                    databaseRef.setValue(booking).addOnCompleteListener {
                        if (it.isSuccessful){
                            navController.navigate(ROUT_VIEWBOOKINGS)
                            Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun allBookings(
        booking: MutableState<Booking>,
        bookings: SnapshotStateList<Booking>):SnapshotStateList<Booking>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Bookings")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                bookings.clear()
                for (snap in snapshot.children){
                    var retrievedBooking = snap.getValue(Booking::class.java)
                    booking.value = retrievedBooking!!
                    bookings.add(retrievedBooking)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return bookings
    }

    fun updateBooking(bookingId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Bookings/$bookingId")
        ref.removeValue()
        navController.navigate(ROUT_BOOKINGS)
    }


    fun deleteBooking(bookingId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Bookings/$bookingId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}


