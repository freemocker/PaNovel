package cc.aoeiuv020.panovel.bookshelf

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cc.aoeiuv020.panovel.IView
import cc.aoeiuv020.panovel.R
import cc.aoeiuv020.panovel.data.entity.Novel
import cc.aoeiuv020.panovel.list.DefaultNovelItemActionListener
import cc.aoeiuv020.panovel.list.NovelListAdapter
import cc.aoeiuv020.panovel.main.MainActivity
import cc.aoeiuv020.panovel.util.hide
import cc.aoeiuv020.panovel.util.show
import kotlinx.android.synthetic.main.novel_item_big.view.*
import kotlinx.android.synthetic.main.novel_item_list.*

/**
 *
 * Created by AoEiuV020 on 2017.10.15-17:22:28.
 */
class BookshelfFragment : Fragment(), IView {
    private val itemListener = DefaultNovelItemActionListener { message, e ->
        showError(message, e)
    }
    private val mAdapter = NovelListAdapter(itemListener = itemListener) {
        // 以防万一加上问号?支持视图中没有小红点的情况，
        // 显示小红点控件，包括代表正在刷新的圆形进度条，
        it.rdRefreshing?.show()
        // 隐藏用于添加书架的按钮，
        it.ivStar?.hide()
    }
    private val presenter: BookshelfPresenter = BookshelfPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.novel_item_list, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rvNovel.layoutManager = LinearLayoutManager(context)
        rvNovel.adapter = mAdapter
        srlRefresh.setOnRefreshListener {
            forceRefresh()
        }

        presenter.attach(this)
    }

    override fun onDestroyView() {
        presenter.detach()
        super.onDestroyView()
    }


    override fun onStart() {
        super.onStart()
        refresh()
    }

    fun refresh() {
        srlRefresh.isRefreshing = true
        presenter.refresh()
    }

    /**
     * 强行刷新，重新下载小说详情，主要是看最新章，
     */
    private fun forceRefresh() {
        mAdapter.refresh()
        refresh()
    }

    fun showNovelList(list: List<Novel>) {
        mAdapter.data = list
        srlRefresh.isRefreshing = false
    }

    fun showError(message: String, e: Throwable) {
        // 按理说到这里已经不会是正在刷新的状态了，
        srlRefresh.isRefreshing = false
        (activity as? MainActivity)?.showError(message, e)
    }
}