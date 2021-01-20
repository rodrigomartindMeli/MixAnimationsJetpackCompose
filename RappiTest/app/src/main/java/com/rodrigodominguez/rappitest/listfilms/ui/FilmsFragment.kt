package com.rodrigodominguez.rappitest.listfilms.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.rodrigodominguez.rappitest.api.FilmsHelper
import com.rodrigodominguez.rappitest.api.RetrofitBuilder
import com.rodrigodominguez.rappitest.data.Result
import com.rodrigodominguez.rappitest.databinding.MainFragmentBinding
import com.rodrigodominguez.rappitest.listfilms.data.FilmItem
import com.rodrigodominguez.rappitest.util.ViewModelFactory

class FilmsFragment : Fragment() {
    private lateinit var binding: MainFragmentBinding
    private lateinit var adapter: FilmsAdapter
    private lateinit var viewModel: FilmsViewModel

    companion object {
        fun newInstance() =
            FilmsFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupUI()
        setupObservers()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(FilmsHelper(RetrofitBuilder.apiService))
        ).get(FilmsViewModel::class.java)
    }

    private fun setupUI() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        adapter = FilmsAdapter(arrayListOf())
        binding.recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getFilms().observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Result.Status.SUCCESS -> {
                        binding.recyclerView.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        resource.data?.let { films -> refreshList(films.result) }
                    }
                    Result.Status.ERROR -> {
                        binding.recyclerView.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                    }
                    Result.Status.LOADING -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun refreshList(films: List<FilmItem>) {
        adapter.apply {
            addFilms(films)
            notifyDataSetChanged()
        }
    }
}