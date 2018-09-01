package mopa.com.mycoach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import mopa.com.mycoach.adapters.CoachAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = CoachAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }
}
