package com.santoo.assignment_week6.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.santoo.assignment_week6.Model.Users
import com.santoo.assignment_week6.R


class AddStdFragment : Fragment() {
    private lateinit var etFirst : EditText
    private lateinit var etSecond : EditText
    private lateinit var rdoGroup : RadioGroup
    private lateinit var male : RadioButton
    private lateinit var female : RadioButton
    private lateinit var others : RadioButton
    private lateinit var etAddress : EditText
    private lateinit var btnSave : Button

    private var lstUsers = ArrayList<Users>()

    var home = HomeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add_std, container, false)

        etFirst = view.findViewById(R.id.etFirst)
        etSecond = view.findViewById(R.id.etSecond)
        rdoGroup = view.findViewById(R.id.rdoGroup)
        male = view.findViewById(R.id.male)
        female = view.findViewById(R.id.female)
        others = view.findViewById(R.id.others)
        etAddress = view.findViewById(R.id.etAddress)
        btnSave = view.findViewById(R.id.btnSave)

        btnSave.setOnClickListener {
            saveDetails()
        }

        return view
    }

    private fun saveDetails() {

        if(etFirst.length() < 1)
        {
            etFirst.requestFocus()
            etFirst.setError("Field cannot be empty")
        }
        else
        {
            var fullName = etFirst.text.toString()
            var age = etSecond.text.toString().toInt()
            var gender = rdoGroup.checkedRadioButtonId.toString()
            var address = etAddress.text.toString()

            lstUsers.add(Users(fullName,age, address, gender))

            etFirst.setText("")
            etSecond.setText("")
            rdoGroup.check(0)
            etAddress.setText("")
//        lstUsers.add(Users(fullName, age, address, gender))

            Toast.makeText(context, "Student Added", Toast.LENGTH_LONG).show()
        }

    }


}
