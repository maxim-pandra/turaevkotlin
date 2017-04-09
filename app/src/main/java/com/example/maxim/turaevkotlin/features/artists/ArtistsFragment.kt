package com.example.maxim.turaevkotlin.features.artists

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.maxim.turaevkotlin.R
import com.example.maxim.turaevkotlin.commons.InfiniteScrollListener
import com.example.maxim.turaevkotlin.commons.Artists
import com.example.maxim.turaevkotlin.commons.RxBaseFragment
import com.example.maxim.turaevkotlin.commons.extensions.inflate
import com.example.maxim.turaevkotlin.features.artists.adapter.ArtistsAdapter
import kotlinx.android.synthetic.main.news_fragment.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ArtistsFragment : RxBaseFragment() {

    companion object {
        private val KEY_REDDIT_NEWS = "artists"
    }

    private var artists: Artists? = null
    private var offset: Int = 0
    private val newsManager by lazy { ArtistsManager() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.apply {
            setHasFixedSize(true)
            val linearLayout = LinearLayoutManager(context)
            layoutManager = linearLayout
            clearOnScrollListeners()
            addOnScrollListener(InfiniteScrollListener({ requestNews() }, linearLayout))
        }

        initAdapter()

        if (savedInstanceState != null && savedInstanceState.containsKey(KEY_REDDIT_NEWS)) {
            artists = savedInstanceState.get(KEY_REDDIT_NEWS) as Artists
            (news_list.adapter as ArtistsAdapter).clearAndAddNews(artists!!.news)
        } else {
            requestNews()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val news = (news_list.adapter as ArtistsAdapter).getNews()
        if (artists != null && news.isNotEmpty()) {
            outState.putParcelable(KEY_REDDIT_NEWS, artists?.copy(news = news))
        }
    }

    private fun requestNews() {
        val subscription = newsManager.getNews(offset.toString() ?: "0")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { retrievedNews ->
                            artists = retrievedNews
                            (news_list.adapter as ArtistsAdapter).addNews(retrievedNews.news)
                        },
                        { e ->
                            Snackbar.make(news_list, e.message ?: "hello", Snackbar.LENGTH_LONG).show()
                        }
                )
        subscriptions.add(subscription)
        offset += 10
    }

    private fun initAdapter() {
        if (news_list.adapter == null) {
            news_list.adapter = ArtistsAdapter()
        }
    }
}
