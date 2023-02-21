package ru.timcock.dandeliondentist.view

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import ru.timcock.dandeliondentist.R

class DoctorItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private val doctorNameTextView: AppCompatTextView = itemView.findViewById(R.id.templateNameTextView)
    private val clinicNameTextView: AppCompatTextView = itemView.findViewById(R.id.clinicNameTextView)
    private val doctorsPictureImageView: AppCompatImageView = itemView.findViewById(R.id.userPictureImageView)
    private val doctorReviewsTextView: AppCompatTextView = itemView.findViewById(R.id.reviewAmountTextView)
    private val doctorLocationTextView: AppCompatTextView = itemView.findViewById(R.id.locationTextView)
    private val doctorRatingImageView: AppCompatImageView = itemView.findViewById(R.id.userRatingImageView)
    private val doctorDatesTextView: AppCompatTextView = itemView.findViewById(R.id.calendarTextView)

    fun bind(item: DoctorListItem){
        val doctor_name = item.doctor_name
        val clinic_name = item.clinic_name
        val doctor_image = item.doctor_avatar
        val doctor_reviews = item.doctor_reviews
        val doctor_location = item.doctor_location
        val doctor_rating = item.doctor_rating
        val doctor_dates = item.suggested_dates
        doctorRatingImageView.setImageResource(R.drawable.five_star_rating)
//        if(doctor_rating in 4.5..5.0){
//            doctorRatingImageView.setImageResource(R.drawable.five_star_rating)
//        }
//        }else if (doctor_rating in 4.0..4.4){
//            doctorRatingImageView.setImageResource(R.drawable.five_star_rating)
//        }else if (doctor_rating in 3.5..4.0){
//            doctorRatingImageView.setImageResource(R.drawable.five_star_rating)
//        }else if (doctor_rating in 3.0..3.4){
//            doctorRatingImageView.setImageResource(R.drawable.five_star_rating)
//        }else if (doctor_rating in 4.0..){
//            doctorRatingImageView.setImageResource(R.drawable.five_star_rating)
//        }else if (doctor_rating in 4.0..4.4){
//            doctorRatingImageView.setImageResource(R.drawable.five_star_rating)
//        }else if (doctor_rating in 4.0..4.4){
//            doctorRatingImageView.setImageResource(R.drawable.five_star_rating)
//        }

        doctorNameTextView.text = doctor_name
        clinicNameTextView.text = clinic_name
        doctorsPictureImageView.setImageDrawable(doctor_image)
        doctorReviewsTextView.text = doctor_reviews
        doctorLocationTextView.text = doctor_location
        doctorDatesTextView.text = doctor_dates
    }



}