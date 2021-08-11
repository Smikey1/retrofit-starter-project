package com.kiran.retrofitstarterbatch26.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kiran.retrofitstarterbatch26.R
import com.kiran.retrofitstarterbatch26.ui.adapter.StudentAdapter
import com.kiran.retrofitstarterbatch26.ui.model.Student

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // sample code to be removed
        val studentList = arrayListOf<Student>()
    // here i am going to create a view
        val view:View = inflater.inflate(R.layout.fragment_home,container,false)
        val recyclerView:RecyclerView = view.findViewById(R.id.recycleView)
        val btnFetch:Button=view.findViewById(R.id.btnFetch)
        val btnAdd:Button=view.findViewById(R.id.btnAdd)

        btnFetch.setOnClickListener {
            // to be replaced with retrofit code
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
}