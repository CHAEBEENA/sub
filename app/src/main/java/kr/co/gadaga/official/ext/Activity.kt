package kr.co.gadaga.official.ext

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/* 사용안함 */
fun AppCompatActivity.addFragment(@IdRes containerViewId: Int, fragment: Fragment)
        = supportFragmentManager.beginTransaction().add(containerViewId, fragment).commit()

fun AppCompatActivity.replaceFragment(@IdRes containerViewId: Int, fragment: Fragment)
        = supportFragmentManager.beginTransaction().replace(containerViewId, fragment, null).commit()