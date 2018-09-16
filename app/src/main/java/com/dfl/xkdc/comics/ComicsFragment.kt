package com.dfl.xkdc.comics

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dfl.xkdc.R
import com.dfl.xkdc.XkcdApplication
import com.dfl.xkdc.uimodel.Comic
import kotlinx.android.synthetic.main.comics_fragment.*
import javax.inject.Inject

/**
 * Fragment that displays all comics
 */
class ComicsFragment : Fragment() {

    private val visibleThreshold = 5

    @Inject
    lateinit var presenter: ComicsPresenter
    @Inject
    lateinit var adapter: ComicsAdapter

    var isLoading = false

    companion object {
        fun newInstance(): ComicsFragment {
            return ComicsFragment()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        (activity?.application as XkcdApplication).injector.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.comics_fragment, container, false)
    }

    /**
     * sets recycler view and scroll listener
     * subscribes presenter
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        comicsRecyclerView.adapter = adapter
        comicsRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (recyclerView != null) {
                    val totalItemCount = recyclerView.layoutManager.itemCount
                    val lastVisibleItem = (recyclerView.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
                    if (!isLoading && totalItemCount <= lastVisibleItem + visibleThreshold) {
                        isLoading = true
                        presenter.loadComic()
                    }
                }
            }
        })

        presenter.subscribe()
    }

    /**
     * show comic in adapter
     * @param comic comic to show
     */
    fun show(comic: Comic) {
        adapter.add(comic)
    }

    /**
     * remove comic in adapter
     * @param position position of the comic to remove
     */
    fun remove(position: Int) {
        adapter.remove(position)
    }

    fun showProgress() {
    }

    fun hideProgress() {
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }
}
