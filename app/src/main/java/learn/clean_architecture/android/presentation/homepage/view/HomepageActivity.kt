package learn.clean_architecture.android.presentation.homepage.view

import android.net.Uri
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_homepage.*
import kotlinx.android.synthetic.main.item_list_football.view.*
import learn.clean_architecture.android.R
import learn.clean_architecture.android.data.responses.teams.Teams
import learn.clean_architecture.android.domain.router.homepage.HomepageRouter
import learn.clean_architecture.android.external.adapter.setUp
import learn.clean_architecture.android.presentation.homepage.contract.HomepageContract
import learn.clean_architecture.android.presentation.homepage.presenter.HomepagePresenter
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by Yoga C. Pranata on 15/10/2018.
 * Android Engineer
 */
class HomepageActivity : AppCompatActivity(), HomepageContract.View, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var mPresenter: HomepagePresenter

    @Inject
    lateinit var mRouter: HomepageRouter

    var mLeague = ""
    var mArrLeagues = ArrayList<String>()
    var mTeamsData = ArrayList<Teams.TeamsData>()

    lateinit var mLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        onAutoAndroidInjector()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        mLayoutManager = GridLayoutManager(applicationContext, 1) as RecyclerView.LayoutManager
        mainSwipeLayout.setOnRefreshListener(this)
        setupToolbar(resources.getString(R.string.menu_football_list))
        initData()
    }

    override fun onAutoAndroidInjector() {
        AndroidInjection.inject(this)
    }

    override fun onBackPressed() {
        finish()
    }

    override fun onRefresh() {
        mPresenter.getListFootballClub(mLeague)
    }

    override fun onPause() {
        super.onPause()
        if (isFinishing) {

        }
    }

    override fun initData() {
        mPresenter.getAllLeagues()
    }

    override fun showProgressBar() {
        mainSwipeLayout.isRefreshing = true
    }

    override fun hideProgressBar() {
        mainSwipeLayout.isRefreshing = false
    }

    override fun showEmptyView() {
        rlLeaguesEmpty.visibility = View.VISIBLE
        rvFootballClubList.visibility = View.GONE
    }

    override fun hideEmptyView() {
        rlLeaguesEmpty.visibility = View.GONE
        rvFootballClubList.visibility = View.VISIBLE
    }

    override fun clearTeamList() {
        mTeamsData.clear()
    }

    override fun showError(message: String) {
        toast(message)
    }

    override fun setupToolbar(title: String?) {
        supportActionBar?.title = title
    }

    override fun setupUiSpinner() {
        spLeagues.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                mLeague = Uri.parse(mArrLeagues[position]).toString()
                mPresenter.getListFootballClub(mLeague)
            }
        }
    }

    override fun loadImageToImageView(imageSource: String, imgView: ImageView, progressBar: ProgressBar) {
        Picasso.get()
            .load(imageSource)
            .fit()
            .centerCrop()
            .into(imgView, object : Callback {
                override fun onSuccess() {
                    progressBar.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                    progressBar.visibility = View.GONE
                }
            })
    }

    override fun setupAdapter(fcList: ArrayList<Teams.TeamsData>?) {
        if (fcList != null) {
            mTeamsData = fcList
            rvFootballClubList.setUp(
                mTeamsData,
                R.layout.item_list_football,
                {
                    loadImageToImageView(it.strTeamBadge!!, imgItemFootball, pbItemFc)
                    tvItemFootball.text = it.strTeam
                },
                {
                    mRouter.goToDetailPage(it.strTeam, it.strDescriptionEN, it.strTeamBadge)
                },
                mLayoutManager
            )
        } else {
            showEmptyView()
        }
    }

    override fun setupLeaguesAdapter(leagues: ArrayList<String>) {
        mArrLeagues = leagues
        mArrLeagues.sortBy { it }
        val mAdapter = ArrayAdapter(
            this,
            R.layout.item_spinner,
            mArrLeagues
        )
        mAdapter.setDropDownViewResource(R.layout.item_spinner)
        spLeagues.adapter = mAdapter
        setupUiSpinner()
    }
}