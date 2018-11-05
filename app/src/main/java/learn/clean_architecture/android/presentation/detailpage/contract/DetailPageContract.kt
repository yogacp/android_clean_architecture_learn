package learn.clean_architecture.android.presentation.detailpage.contract

import android.os.Bundle
import android.widget.ImageView

/**
 * Created by Yoga C. Pranata on 05/11/2018.
 * Android Engineer
 */
class DetailPageContract {
    interface View {
        fun onAutoAndroidInjector()
        fun loadImageToImageView(imageSource: String, imgView: ImageView)
        fun setupToolbar(title: String?)
        fun setContentDetail(fcName: String?, fcDesc: String?, fcImage: String?)
    }

    interface UserActionListener {
        fun getFootballClub(bundle: Bundle)
    }
}