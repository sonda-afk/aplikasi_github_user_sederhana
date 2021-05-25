package com.sondari.dicoding.fundamentalsatu

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val listUser = ArrayList<User>()
    private lateinit var rvShow: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvShow = findViewById(R.id.rv_user)
        rvShow.setHasFixedSize(true)

        fromResource()
        showRecylcerList()
    }

    private fun showRecylcerList() {
        rvShow.layoutManager = LinearLayoutManager(this)
        val userAdapter = UserAdapter(fromResource())
        rvShow.adapter = userAdapter

        userAdapter.setOnItemClickCallback(object : UserAdapter.OnItemClickCallback{
            override fun onItemClicked(data: User) {
                val intent = Intent(this@MainActivity, UserDetail::class.java)
                intent.putExtra(UserDetail.EXTRA_USER, data)
                startActivity(intent)
            }
        })
    }


    @SuppressLint("Recycle")
    private fun fromResource(): ArrayList<User> {
        val resource_img: TypedArray = resources.obtainTypedArray(R.array.avatar)
        val resource_username: Array<String> = resources.getStringArray(R.array.username)
        val resource_location: Array<String> = resources.getStringArray(R.array.location)
        val resource_name: Array<String> = resources.getStringArray(R.array.name)
        val resource_company: Array<String> = resources.getStringArray(R.array.company)
        val resource_repository: Array<String> = resources.getStringArray(R.array.repository)
        val resource_followers: Array<String> = resources.getStringArray(R.array.followers)
        val resource_following: Array<String> = resources.getStringArray(R.array.following)

        for (i in resource_username.indices){
            val itemUser = User(
                resource_img.getResourceId(i, -1),
                resource_username[i],
                resource_name[i],
                resource_location[i],
                resource_repository[i],
                resource_company[i],
                resource_followers[i],
                resource_following[i]
            )

            listUser.add(itemUser)
        }
        return listUser

    }


}