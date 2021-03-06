package com.example.maxim.turaevkotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.example.maxim.turaevkotlin.features.artists.ArtistsFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            addFragment(ArtistsFragment())
        }
    }

    @SuppressLint("PrivateResource")
    fun addFragment(f: Fragment/*, cleanStack: Boolean = false*/) {
        val ft = supportFragmentManager.beginTransaction()
//        if (cleanStack) {
//            clearBackStack();
//        }
        ft.replace(R.id.activity_base_content, f)
        ft.addToBackStack(null)
        ft.commit()
    }

//    fun clearBackStack() {
//        val manager = supportFragmentManager;
//        if (manager.backStackEntryCount > 0) {
//            val first = manager.getBackStackEntryAt(0);
//            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//        }
//    }

//    /**
//     * Finish activity when reaching the last fragment.
//     */
//    override fun onBackPressed() {
//        val fragmentManager = supportFragmentManager;
//        if (fragmentManager.backStackEntryCount > 1) {
//            fragmentManager.popBackStack();
//        } else {
//            finish();
//        }
//    }
}
