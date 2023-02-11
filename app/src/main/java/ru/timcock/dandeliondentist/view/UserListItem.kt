package ru.timcock.dandeliondentist.view

import android.media.Image
import java.util.Date

data class UserListItem(val doctor_name: String, val doctor_profession: String,val clinic_name:String,
                        val doctor_tags:String, val doctor_avatar: Image, val doctor_reviews: String,
                        val doctor_location: String, val suggested_dates: Date, val doctor_rating: Float)
