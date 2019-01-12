package com.obiomaofoamalu.biimovies.movielist

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.obiomaofoamalu.biimovies.R
import kotlinx.android.synthetic.main.fragment_movie_list.*

/**
 * todo: kotlin doc
 */
class MovieListFragment : Fragment() {

    private lateinit var adapter: MovieListAdapter
    private var viewNavigator: IMovieListNavigator? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movie_list, container, false)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (context) {
            is IMovieListNavigator -> viewNavigator = context
            else -> throw RuntimeException(
                context.toString() + " must implement OnFragmentInteractionListener"
            )
        }
    }

    override fun onDetach() {
        super.onDetach()
        viewNavigator = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        context?.let {
            adapter = MovieListAdapter()
//            movieRecyclerView.adapter = adapter
            movieRecyclerView.layoutManager = LinearLayoutManager(it)
        }
    }

    companion object {

        /**
         * TODO: kotlin doc
         */
        fun newInstance() = MovieListFragment()
    }
}


/**
 * TODO: kotlin doc
 */
interface IMovieListNavigator {

    fun addMovieDetailsFragment(id: String)
}
