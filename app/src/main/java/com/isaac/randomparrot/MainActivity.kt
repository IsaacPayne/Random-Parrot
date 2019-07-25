package com.isaac.randomparrot

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.isaac.randomparrot.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        fab.setOnClickListener { loadParrots() }
    }

    private fun loadParrots() {
        viewModel.refreshRandomParrot()

        //    .observe(this, Observer {
        //    pb_loading.visibility = View.VISIBLE
        //    tv_parrot_title.text = getString(R.string.loading)
//
        //    val randomParrot = it[Random.nextInt(0, it.size - 1)]
        //    Log.i("MainActivity", randomParrot.toString())
//
        //    Glide
        //        .with(this)
        //        .load("https://cultofthepartyparrot.com/parrots/" + randomParrot.getBestQualityGif())
        //        .addListener(object : RequestListener<Drawable> {
        //            override fun onLoadFailed(
        //                e: GlideException?,
        //                model: Any?,
        //                target: Target<Drawable>?,
        //                isFirstResource: Boolean
        //            ): Boolean {
        //                pb_loading.visibility = View.GONE
        //                tv_parrot_title.text = getString(R.string.error_loading_parrot)
        //                return false
        //            }
//
        //            override fun onResourceReady(
        //                resource: Drawable?,
        //                model: Any?,
        //                target: Target<Drawable>?,
        //                dataSource: DataSource?,
        //                isFirstResource: Boolean
        //            ): Boolean {
        //                pb_loading.visibility = View.GONE
        //                tv_parrot_title.text = randomParrot.name
        //                return false
        //            }
        //        }).into(iv_parrot_image)
        //})
    }
}
