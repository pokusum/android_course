package com.deniskutyavin.android_course.ui.emailconfirmation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deniskutyavin.android_course.R

abstract class SlotsAdapter : RecyclerView.Adapter<SlotsAdapter.ViewHolder>() {
    var slotsList: List<VerificationCodeSlotView> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_verification_code_slot, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return slotsList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userNameTextView = itemView.findViewById<TextView>(R.id.userNameTextView)
    }
}