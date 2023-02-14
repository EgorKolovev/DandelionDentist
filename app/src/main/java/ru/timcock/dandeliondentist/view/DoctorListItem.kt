package ru.timcock.dandeliondentist.view

import android.graphics.drawable.Drawable
import java.util.Date

data class DoctorListItem(val doctor_name: String, val doctor_profession: String,
                        val clinic_name:String, val doctor_tags:String,
                        val doctor_avatar: Drawable, val doctor_reviews: String,
                        val doctor_location: String, val suggested_dates: String,
                        val doctor_rating: Double)
