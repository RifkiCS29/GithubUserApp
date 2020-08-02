package com.rifki.kotlin.mygithubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.rifki.kotlin.mygithubuserapp.model.GithubUser
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    private fun setActionBarTitle(name: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = name
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataGithubUser = intent.getParcelableExtra(EXTRA_DATA) as GithubUser

        tv_username.text = dataGithubUser.username.toString()
        tv_name.text = dataGithubUser.name.toString()
        tv_company.text = dataGithubUser.company.toString()
        tv_location.text = dataGithubUser.location.toString()
        tv_repository.text = dataGithubUser.repository.toString()
        tv_followers.text = dataGithubUser.followers.toString()
        tv_following.text = dataGithubUser.following.toString()
        image_avatar.setImageResource(dataGithubUser.avatar)

        setActionBarTitle(dataGithubUser.name.toString())
    }
}
