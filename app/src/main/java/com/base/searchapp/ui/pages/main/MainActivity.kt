package com.base.searchapp.ui.pages.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.base.searchapp.R
import com.base.searchapp.ui.base.activity.BaseActivity
import com.base.searchapp.ui.pages.book.BookFragment
import com.base.searchapp.ui.pages.main.viewmodel.MainActivityViewModel
import com.base.searchapp.ui.pages.movie.MovieFragment
import com.base.searchapp.ui.pages.software.SoftwareFragment
import com.base.searchapp.ui.pages.music.MusicFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 *   Created by Emre UYGUN on 12/5/20
 */

class MainActivity : BaseActivity<MainActivityViewModel>() {

    override val viewModelClass = MainActivityViewModel::class.java
    override val layoutViewRes = R.layout.activity_main

    private var fragment: Fragment? = MovieFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)

        fragment?.let {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, fragment ?: MovieFragment())
                    .commit()
        }

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rb_movie -> {
                    fragment = MovieFragment()
                }
                R.id.rb_song -> {
                    fragment = MusicFragment()
                }
                R.id.rb_software -> {
                    fragment = SoftwareFragment()
                }
                R.id.rb_book -> {
                    fragment = BookFragment()
                }
            }

            fragment?.let {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main_container, fragment ?: MovieFragment())
                        .commit()
            }
        }
    }
}
