package com.obiomaofoamalu.biimovies.movielist.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.obiomaofoamalu.biimovies.R
import com.obiomaofoamalu.biimovies.data.repository.MovieRepository
import com.obiomaofoamalu.biimovies.databinding.ItemviewMovieListBinding

class MovieListAdapter(mMovieRepository: MovieRepository) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    //region CLASS VARIABLES -----------------------------------------------------------------------

    private val mViewModel = MovieAdapterViewModel(mMovieRepository)

    //endregion

    //region LIFECYCLE METHODS ---------------------------------------------------------------------

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.itemview_movie_list, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mViewModel.movieList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(position)
    }

    //endregion

    //region INNER CLASS ---------------------------------------------------------------------------

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var mBinding: ItemviewMovieListBinding = DataBindingUtil.bind(itemView)

        fun bindView(position: Int) {

        }
    }

    //endregion

}