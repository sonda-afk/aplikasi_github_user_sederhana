package com.sondari.dicoding.fundamentalsatu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class UserDetail : AppCompatActivity(), View.OnClickListener {

    companion object{
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val name:TextView = findViewById(R.id.detail_name)
        val avatar:ImageView = findViewById(R.id.detail_avatar)
        val location:TextView = findViewById(R.id.detail_location)
        val company:TextView = findViewById(R.id.detail_company)
        val repository:TextView = findViewById(R.id.detail_repository)
        val following:TextView = findViewById(R.id.detail_following)
        val followers:TextView = findViewById(R.id.detail_followers)
        val username:TextView = findViewById(R.id.detail_username)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        name.text = user.name
        location.text = user.location
        company.text = user.company
        repository.text = user.repository
        following.text = user.following
        followers.text = user.followers
        username.text = user.username

        Glide.with(this)
                .load(user.avatar)
                .apply(RequestOptions())
                .into(avatar)

        val Back: ImageView = findViewById(R.id.detail_back)
        Back.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.detail_back->{
                val moveIntent = Intent(this@UserDetail, MainActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }


}