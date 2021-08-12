package com.kiran.retrofitstarterbatch26.ui.fragment

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.app.NotificationCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kiran.retrofitstarterbatch26.R
import com.kiran.retrofitstarterbatch26.ui.adapter.StudentAdapter
import com.kiran.retrofitstarterbatch26.ui.model.Student

class HomeFragment : Fragment() {
    private val channelID = "myNotificationChannel"
    private var notificationManager: NotificationManager? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationManager = requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel(channelID, "Retrofit Android", "Data fetch Successfully")
        // sample code to be removed
        val studentList = arrayListOf<Student>()
    // here i am going to create a view
        val view:View = inflater.inflate(R.layout.fragment_home,container,false)
        val recyclerView:RecyclerView = view.findViewById(R.id.recycleView)
        val btnFetch:Button=view.findViewById(R.id.btnFetch)
        val btnAdd:Button=view.findViewById(R.id.btnAdd)
        val myPb: ProgressBar = view.findViewById(R.id.myPb)

        btnFetch.setOnClickListener {
            // to be replaced with retrofit code
            myPb.isVisible=false
            showNotification()
            val adapter = StudentAdapter(studentList,requireContext())
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter=adapter
        }

        btnAdd.setOnClickListener {
            val fragment = parentFragmentManager.beginTransaction()
            fragment.replace(R.id.renderAnyFragment,AddStudentFragment())
            fragment.addToBackStack("home_fragment")
            fragment.commit()
        }

        return  view
    }
    private fun showNotification() {
        val notificationId = 45
        val notification = NotificationCompat.Builder(requireContext(), channelID)
            .setContentTitle("Retrofit Android")
            .setContentText("Data Fetch Successfully")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH).build()
        notificationManager?.notify(notificationId,notification )
    }

    private fun createNotificationChannel(id: String, name: String, channelDescription: String) {
        val importanceLevel = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel(id, name, importanceLevel).apply {
            enableVibration(true);
            enableLights(true)
            description = channelDescription
        }
        notificationManager?.createNotificationChannel(channel)
    }
}