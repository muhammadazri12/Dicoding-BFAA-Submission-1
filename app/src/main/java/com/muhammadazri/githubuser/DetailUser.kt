package com.muhammadazri.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail_user.*


class DetailUser : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        tv_detail_name.text = user.name
        tv_detail_username.text = user.username
        tv_detail_location.text = user.location
        tv_detail_company.text = user.company
        tv_detail_followers.text = user.followers
        tv_detail_following.text = user.following
        tv_detail_repository.text = user.repository

        Glide.with(this)
            .load(user.photo)
            .apply(RequestOptions())
            .into(img_detail_photo)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}