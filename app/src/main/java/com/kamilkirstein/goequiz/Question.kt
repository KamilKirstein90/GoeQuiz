package com.kamilkirstein.goequiz

import androidx.annotation.StringRes
// this class will function as model and with the data keyword it indicates that it is using model data
data class Question(@StringRes val textResId : Int, val answer : Boolean) {
}