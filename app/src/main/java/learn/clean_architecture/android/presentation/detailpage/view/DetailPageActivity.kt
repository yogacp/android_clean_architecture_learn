package learn.clean_architecture.android.presentation.detailpage.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.ImageView
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_detail_page.*
import kotlinx.android.synthetic.main.fragment_detail_page.*
import learn.clean_architecture.android.R
import learn.clean_architecture.android.presentation.detailpage.contract.DetailPageContract
import learn.clean_architecture.android.presentation.detailpage.presenter.DetailPagePresenter
import javax.inject.Inject

/**
 * Created by Yoga C. Pranata on 05/11/2018.
 * Android Engineer
 */
class DetailPageActivity : AppCompatActivity(), DetailPageContract.View {

    @Inject
    lateinit var mPresenter: DetailPagePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        onAutoAndroidInjector()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)

        val data = intent.extras
        if(data != null) {
            mPresenter.getFootballClub(data)
        }
    }

    override fun onAutoAndroidInjector() {
        AndroidInjection.inject(this)
    }

    override fun onBackPressed() {
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.getItemId()) {
            android.R.id.home -> onBackPressed()
        }
        return true
    }

    override fun loadImageToImageView(imageSource: String, imgView: ImageView) {
        Picasso.get()
            .load(imageSource)
            .fit()
            .centerCrop()
            .into(imgView)
    }

    override fun setupToolbar(title: String?) {
        setSupportActionBar(toolbarDetailFc)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        collapsingToolbarDetailFc.title = title
        collapsingToolbarDetailFc.setExpandedTitleColor(resources.getColor(android.R.color.transparent))
    }

    override fun setContentDetail(fcName: String?, fcDesc: String?, fcImage: String?) {
        tvDetailFcTitle.text = fcName
        tvDetailFcDesc.text = fcDesc
        if (fcImage != null) loadImageToImageView(fcImage, imgDetailFc)
    }

}