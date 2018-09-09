package com.dfl.xkdc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dfl.xkdc.comics.ComicsFragment

class MainActivity : AppCompatActivity() {

    //https://xkcd.com/json.html
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, ComicsFragment.newInstance())
                .commit()
    }
}