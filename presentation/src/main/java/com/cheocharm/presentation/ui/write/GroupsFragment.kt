package com.cheocharm.presentation.ui.write

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.cheocharm.presentation.R
import com.cheocharm.presentation.databinding.FragmentGroupsBinding
import com.cheocharm.domain.model.Group
import com.cheocharm.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GroupsFragment : BaseFragment<FragmentGroupsBinding>(R.layout.fragment_groups) {
    private val writeViewModel: WriteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewmodel = writeViewModel

        val recyclerView: RecyclerView = binding.rvGroupsGroups
        val groupsAdapter = GroupsAdapter { group -> adapterOnClick(group) }
        val decoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        with(recyclerView) {
            addItemDecoration(decoration)
            adapter = groupsAdapter
        }

        writeViewModel.groups.observe(viewLifecycleOwner) {
            it?.let {
                groupsAdapter.submitList(it)
            }
        }
    }

    private fun adapterOnClick(group: Group) {
        val action = GroupsFragmentDirections.actionWriteDestToPictureFragment()
        findNavController().navigate(action)
    }
}
