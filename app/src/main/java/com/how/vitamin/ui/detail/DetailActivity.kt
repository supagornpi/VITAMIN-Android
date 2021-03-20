package com.how.vitamin.ui.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import com.how.vitamin.R
import com.how.vitamin.base.BaseActivity
import com.how.vitamin.databinding.ActivityDetailBinding
import com.how.vitamin.ui.HouseType

import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailActivity : BaseActivity() {

    companion object {
        private const val KEY_HOUSE = "house"
        fun startActivityWithTransition(
            activity: Activity,
            imageView: ImageView,
            type: HouseType
        ) {
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(KEY_HOUSE, type)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity, imageView, imageView.transitionName
            )
            activity.startActivity(intent, options.toBundle())
        }
    }

    private val binding by binding<ActivityDetailBinding>(R.layout.activity_detail)
    private val house by lazy { intent.getSerializableExtra(KEY_HOUSE) as HouseType }
    private val viewModel: DetailViewModel by viewModel { parametersOf(house) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            house = this@DetailActivity.house
            lifecycleOwner = this@DetailActivity
            viewModel = this@DetailActivity.viewModel
        }
    }

}