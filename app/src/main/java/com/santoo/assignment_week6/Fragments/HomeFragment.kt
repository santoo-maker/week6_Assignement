package com.santoo.assignment_week6.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.santoo.assignment_week6.Adapter.UserAdapter
import com.santoo.assignment_week6.Model.Users
import com.santoo.assignment_week6.R



class HomeFragment() : Fragment() {

    private lateinit var btnDelete : ImageButton

    private lateinit var recyclerView: RecyclerView
     var lstUsers = ArrayList<Users>()

    var fname : String = ""
    var age : Int = 0
    var address : String = ""
    var gender : String = ""
    var removedPosition : Int ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
            loadUser()
//        fname = user.name.toString()
//        age = user.age.toString().toInt()
//        address = user.address.toString()
//        gender = user.gender.toString()

        val adapter = UserAdapter(lstUsers, this@HomeFragment)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        return view
    }

    private fun loadUser() {
        lstUsers.add(Users("Santoo Shrestha", 21, "Koteshwor", "Male"))

        lstUsers.add(Users("Aadarsha Shrestha", 22, "Kapan", "Male"))
        lstUsers.add(Users("Banin Shrestha", 28, "Kathmandu", "Male"))
        lstUsers.add(Users("Dilip Bam", 30, "Sankhamul", "Male"))
        lstUsers.add(Users("Katrina Kaif", 40, "India", "Female"))
    }


}
