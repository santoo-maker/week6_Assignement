package com.santoo.assignment_week6.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.santoo.assignment_week6.Fragments.HomeFragment
import com.santoo.assignment_week6.Model.Users
import com.santoo.assignment_week6.R


class UserAdapter(
    val lstUsers: ArrayList<Users>,
    homeFragment: HomeFragment
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val btnDelete: ImageButton
        val tvName : TextView
        val tvAge : TextView
        val tvAddress : TextView
        val tvGender : TextView

        init {
            btnDelete = view.findViewById(R.id.btnDelete)
            tvName = view.findViewById(R.id.tvName)
            tvAge = view.findViewById(R.id.tvAge)
            tvAddress = view.findViewById(R.id.tvAddress)
            tvGender = view.findViewById(R.id.tvGender)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_details, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var user = lstUsers[position]
        holder.tvName.text = user.name
        holder.tvAge.text = user.age.toString()
        holder.tvAddress.text = user.address
        holder.tvGender.text = user.gender.toString()


        holder.btnDelete.setOnClickListener(View.OnClickListener {
            lstUsers.removeAt(position)
            notifyDataSetChanged()
        })
//        Glide.with(context)
//            .load(actor.actorImage)
//            .into(holder.imgProfile)
    }

    override fun getItemCount(): Int {
        return lstUsers.size
    }






}
