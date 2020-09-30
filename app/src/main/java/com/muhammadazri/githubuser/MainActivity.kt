package com.muhammadazri.githubuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var list: ArrayList<User> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_user.setHasFixedSize(true)

        list.addAll(UserData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rv_user.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rv_user.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                showSelectedUser(data)
                val moveDetailUser = Intent(this@MainActivity, DetailUser::class.java)
                moveDetailUser.putExtra(DetailUser.EXTRA_USER, data)
                startActivity(moveDetailUser)
            }
        })
    }

    private fun showSelectedUser(data: User) {
        Toast.makeText(this, data.name, Toast.LENGTH_SHORT).show()
    }
}