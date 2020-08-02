package com.rifki.kotlin.mygithubuserapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.rifki.kotlin.mygithubuserapp.adapter.GithubUserAdapter
import com.rifki.kotlin.mygithubuserapp.model.GithubUser
import com.rifki.kotlin.mygithubuserapp.model.GithubUsersData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var listGithubUser : ArrayList<GithubUser> = ArrayList()
    private var title = " Github Users"

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.drawable.ic_github_logo)
        supportActionBar?.setDisplayUseLogoEnabled(true)
        setActionBarTitle(title)

        rv_github_users.setHasFixedSize(true)

        listGithubUser.addAll(GithubUsersData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rv_github_users.layoutManager = LinearLayoutManager(this)
        val listGithubUserAdapter = GithubUserAdapter(listGithubUser)
        rv_github_users.adapter = listGithubUserAdapter

        listGithubUserAdapter.setOnItemClickCallback(object : GithubUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: GithubUser) {
                showSelectedGithubUser(data)
            }
        })
    }

    private fun showSelectedGithubUser(data: GithubUser) {
        val intentDetailGithubUser = Intent(this@MainActivity, DetailActivity::class.java)
        intentDetailGithubUser.putExtra(DetailActivity.EXTRA_DATA, data)
        startActivity(intentDetailGithubUser)
    }
}
