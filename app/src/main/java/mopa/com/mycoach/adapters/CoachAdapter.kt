package mopa.com.mycoach.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import mopa.com.mycoach.fragments.CoachFragment
import mopa.com.mycoach.fragments.TimerFragment

class CoachAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return CoachFragment()
            1 -> return TimerFragment()
        }
        return null
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Coach"
            1 -> return "Timer"
        }
        return null
    }
}