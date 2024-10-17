package com.nevrmd.notify.presentation.note

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nevrmd.notify.databinding.NoteItemBinding
import com.nevrmd.notify.domain.NoteEntity

class NoteAdapter(
    private val noteList: List<NoteEntity>,
    private val listener: OnNoteClickListener,
) : RecyclerView.Adapter<NoteAdapter.ViewHolderClass>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val binding = NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderClass(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = noteList[position]
        with(holder) {
            tvTitle.text = currentItem.title
            tvBody.text = currentItem.body
            binding.root.setOnClickListener { listener.onClick(currentItem) }
        }
    }

    override fun getItemCount(): Int = noteList.size

    class ViewHolderClass(val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvTitle: TextView = binding.tvTitle
        val tvBody: TextView = binding.tvBody
    }
}

fun interface OnNoteClickListener {

    fun onClick(note: NoteEntity)
}