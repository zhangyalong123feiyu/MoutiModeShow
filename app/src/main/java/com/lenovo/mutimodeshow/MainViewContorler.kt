package com.lenovo.mutimodeshow

import android.util.Log
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.RelativeLayout
import com.lenovo.mutimodeshow.bean.PassengerInfo


object MainViewContorler {
    private var animationInVisble: Animation? = null
    private var animationVisble: Animation? = null

    fun updateView(
        info: PassengerInfo.MessageDTO.MemberDTO,
        imageView: ImageView,
        emmotonView: ImageView,
        emmotonLayout: RelativeLayout
    ) {
        if (info.gender == null) {
            imageView.post {
                run {
                    imageView.visibility = View.GONE
                    emmotonLayout.visibility = View.GONE
                }
            }
            return
        } else {
            imageView.post {
                run {
                    imageView.visibility = View.VISIBLE
                    emmotonLayout.visibility = View.VISIBLE
                }
            }
        }
        Log.e(
            "TAG",
            "gender info is " + info.gender + "action is" + info.action + "wearing is===" + info.wearing
        )
        if (info.gender.equals("male")) {
            if (info.wearing.equals("hoodie")) {
                when (info.action) {
                    "eating" -> imageView.setImageResource(R.mipmap.man_hoodie_eating)
                    "smoking" -> imageView.setImageResource(R.mipmap.man_hoodie_smoking0261)
                    "drinking" -> imageView.setImageResource(R.mipmap.man_hoodie_drinking0289)
                    "calling" -> imageView.setImageResource(R.mipmap.man_hoodie_calling0439)
                    "playing with phone" -> imageView.setImageResource(R.mipmap.man_hoodie_using_the_phone)
                    "being tired" -> imageView.setImageResource(R.mipmap.man_hoodie_sleepy)
                    "other" -> imageView.setImageResource(R.mipmap.man_hoodie_sleepy)
                }
            }
            if (info.wearing.equals("jacket")) {
                when (info.action) {
                    "eating" -> imageView.setImageResource(R.mipmap.man_coat_eating)
                    "smoking" -> imageView.setImageResource(R.mipmap.man_coat_smoking0261)
                    "drinking" -> imageView.setImageResource(R.mipmap.man_coat_drinking0289)
                    "calling" -> imageView.setImageResource(R.mipmap.man_hoodie_calling0439)
                    "playing with phone" -> imageView.setImageResource(R.mipmap.man_hoodie_using_the_phone)
                    "being tired" -> imageView.setImageResource(R.mipmap.man_hoodie_sleepy)
                    "other" -> imageView.setImageResource(R.mipmap.man_hoodie_sleepy)
                }
            }
            if (info.wearing.equals("shirt")) {
                when (info.action) {
                    "eating" -> imageView.setImageResource(R.mipmap.man_hoodie_eating)
                    "smoking" -> imageView.setImageResource(R.mipmap.man_hoodie_smoking0261)
                    "drinking" -> imageView.setImageResource(R.mipmap.man_hoodie_drinking0289)
                    "calling" -> imageView.setImageResource(R.mipmap.man_hoodie_calling0439)
                    "playing with phone" -> imageView.setImageResource(R.mipmap.man_hoodie_using_the_phone)
                    "being tired" -> imageView.setImageResource(R.mipmap.man_hoodie_sleepy)
                    "other" -> imageView.setImageResource(R.mipmap.man_hoodie_sleepy)
                }
            }
        } else if (info.gender.equals("female")) {
            if (info.wearing.equals("hoodie")) {
                when (info.action) {
                    "eating" -> imageView.setImageResource(R.mipmap.women_hoodie_eating)
                    "smoking" -> imageView.setImageResource(R.mipmap.women_hoodie_smoking0261)
                    "drinking" -> imageView.setImageResource(R.mipmap.women_hoodie_drinking0289)
                    "calling" -> imageView.setImageResource(R.mipmap.women_hoodie_calling0439)
                    "playing with phone" -> imageView.setImageResource(R.mipmap.women_hoodie_using_the_phone)
                    "being tired" -> imageView.setImageResource(R.mipmap.women_hoodie_sleepy)
                    "other" -> imageView.setImageResource(R.mipmap.women_hoodie_sleepy)
                }
            }
            if (info.wearing.equals("jacket")) {
                when (info.action) {
                    "eating" -> imageView.setImageResource(R.mipmap.women_coat_eating)
                    "smoking" -> imageView.setImageResource(R.mipmap.women_coat_smoking0261)
                    "drinking" -> imageView.setImageResource(R.mipmap.women_coat_drinking0289)
                    "calling" -> imageView.setImageResource(R.mipmap.women_hoodie_calling0439)
                    "playing_with_phone" -> imageView.setImageResource(R.mipmap.women_hoodie_using_the_phone)
                    "being_tired" -> imageView.setImageResource(R.mipmap.women_hoodie_sleepy)
                    "other" -> imageView.setImageResource(R.mipmap.women_hoodie_sleepy)
                }
            }
            if (info.wearing.equals("shirt")) {
                when (info.action) {
                    "eating" -> imageView.setImageResource(R.mipmap.women_hoodie_eating)
                    "smoking" -> imageView.setImageResource(R.mipmap.women_hoodie_smoking0261)
                    "drinking" -> imageView.setImageResource(R.mipmap.women_hoodie_drinking0289)
                    "calling" -> imageView.setImageResource(R.mipmap.women_hoodie_calling0439)
                    "playing_with_phone" -> imageView.setImageResource(R.mipmap.women_hoodie_using_the_phone)
                    "being_tired" -> imageView.setImageResource(R.mipmap.women_hoodie_sleepy)
                    "other" -> imageView.setImageResource(R.mipmap.women_hoodie_sleepy)
                }
            }
        }

        Log.e("TAG", "passenger emotion info is ======" + info.emotion)
        when (info.emotion) {
            "happy" -> emmotonView.setImageResource(R.mipmap.happy)
            "angry" -> emmotonView.setImageResource(R.mipmap.angry)
            "calm" -> emmotonView.setImageResource(R.mipmap.calm)
            "sad" -> emmotonView.setImageResource(R.mipmap.lose)
            "other" -> emmotonView.setImageResource(R.mipmap.calm)
        }
    }

    fun passengerVisibleState(
        diverImage: ImageView,
        pass1Image: ImageView,
        pass2Image: ImageView,
        pass3Image: ImageView,
        isShow: Boolean
    ) {
        Log.e("TAG", "show value is ================" + isShow)
        diverImage.post {
            Runnable {
                if (isShow) {
//                    diverImage.visibility = View.VISIBLE
//                    pass1Image.visibility = View.VISIBLE
//                    pass2Image.visibility = View.VISIBLE
//                    pass3Image.visibility = View.VISIBLE
                    setAnimationVisble(diverImage)
                    setAnimationVisble(pass1Image)
                    setAnimationVisble(pass2Image)
                    setAnimationVisble(pass3Image)
                } else {
//                    diverImage.visibility = View.INVISIBLE
//                    pass1Image.visibility = View.INVISIBLE
//                    pass2Image.visibility = View.INVISIBLE
//                    pass3Image.visibility = View.INVISIBLE
                    setAnimationInVisble(diverImage)
                    setAnimationInVisble(pass1Image)
                    setAnimationInVisble(pass2Image)
                    setAnimationInVisble(pass3Image)
                }
            }

        }
    }

    fun setAnimationVisble(img: ImageView) {
        if (animationVisble == null) {
            val animationVisble: Animation = AlphaAnimation(0.1f, 1.0f)
            animationVisble.duration = 100
        }
        img.animation = animationVisble
    }

    fun setAnimationInVisble(img: ImageView) {
        if (animationInVisble == null) {
            val animationInVisble: Animation = AlphaAnimation(1.0f, 0.1f)
            animationInVisble.duration = 100
        }
        img.animation = animationInVisble
    }
}