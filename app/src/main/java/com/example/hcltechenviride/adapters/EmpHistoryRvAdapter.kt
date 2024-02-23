package com.example.hcltechenviride.adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.hcltechenviride.Models.History
import com.example.hcltechenviride.databinding.EmpHistoryRvDesignBinding
import java.time.format.DateTimeFormatter

class EmpHistoryRvAdapter(var context: Context, var historyList: ArrayList<History>) :
    RecyclerView.Adapter<EmpHistoryRvAdapter.ViewHolder>() {
    inner class ViewHolder(var binding: EmpHistoryRvDesignBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = EmpHistoryRvDesignBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return historyList.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.root
        val historyItem = historyList[position]
        holder.binding.cycleID.text = historyItem.cycleID
        holder.binding.timeAndDate.text =
            historyItem.allottedTime!!.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    }
}