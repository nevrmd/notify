package com.nevrmd.notify.presentation.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.nevrmd.notify.R
import com.nevrmd.notify.data.NoteRepository
import com.nevrmd.notify.data.database.NoteDatabase
import com.nevrmd.notify.databinding.FragmentNoteBinding
import com.nevrmd.notify.presentation.BaseFragment
import com.nevrmd.notify.presentation.ViewModelFactory

class NoteFragment : BaseFragment<FragmentNoteBinding, NoteViewModel>(
    viewModelClass = NoteViewModel::class.java,
) {

    val args: NoteFragmentArgs by navArgs()

    override fun createViewModelFactory(): ViewModelProvider.Factory {
        val dao = NoteDatabase.getInstance(requireContext()).noteDao
        val repository = NoteRepository(dao)
        return ViewModelFactory(repository)
    }

    // это оnCreateView фрагмента (наследника родителя)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // вызываем super чтобы отнаследоваться от родителя и сохранить binding
        return super.onCreateView(inflater, container, savedInstanceState).also {
            viewModel.saveArgs(args)
            with(binding) {
                etTitle.setText(args.title)
                etBody.setText(args.body)
                fabSave.setOnClickListener {
                    val title = etTitle.text.toString()
                    val body = etBody.text.toString()
                    viewModel.onSaveButtonClick(title, body)
                    Navigation.findNavController(root).navigate(R.id.navigateToHomeFragment)
                }
            }
        }
    }

    // это onCreateView у родителя
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNoteBinding = FragmentNoteBinding.inflate(inflater, container, false)
}