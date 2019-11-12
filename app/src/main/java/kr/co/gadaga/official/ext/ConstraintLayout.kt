package kr.co.gadaga.official.ext

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

fun ConstraintLayout.update(constraintSet: ConstraintSet = ConstraintSet(), update: ConstraintSet.() -> Unit) {
    constraintSet.clone(this)
    constraintSet.update()
    constraintSet.applyTo(this)
}