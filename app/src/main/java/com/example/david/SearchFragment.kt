package com.example.david

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.david.R.*
import com.example.david.databinding.FragmentSearchBinding
import androidx.lifecycle.Observer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class SearchFragment : Fragment(layout.fragment_search) {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var viewModel: SearchViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        setupRecyclerView()

        viewModel.videos.observe(viewLifecycleOwner, Observer { videos ->
            // Update RecyclerView with videos
        })

        binding.searchButton.setOnClickListener {
            val query = binding.searchEditText.text.toString().trim()
            if (query.isNotEmpty()) {
                GlobalScope.launch {
                    viewModel.searchVideos("API_KEY", query)
                }
            }
        }
    }

    private fun setupRecyclerView() {
        // Initialize RecyclerView with Adapter
    }
}
