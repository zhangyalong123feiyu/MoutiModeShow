package com.lenovo.mutimodeshow

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible

object AnimationUtil {

    private var frameAnimationHightOut: FrameAnimation? = null
    private var frameAnimationHightIn: FrameAnimation? = null
    private var frameAnimationPOIn: FrameAnimation? = null
    private var frameAnimationPOOut: FrameAnimation? = null
    private var frameAnimationWorkIn: FrameAnimation? = null
    private var frameAnimationWorkOut: FrameAnimation? = null
    private var hightWayOut: IntArray? = null
    private var hightWayIn: IntArray? = null
    private var workOut: IntArray? = null
    private var workIn: IntArray? = null
    private var parkOut: IntArray? = null
    private var parkIn: IntArray? = null
    private val duration = 1


    fun transitionAnimation(
        currentSence: String,
        lastSence: String,
        driver: ImageView,
        passsenger1: ImageView,
        passsenger2: ImageView,
        passenger3: ImageView,
        framgeImageView: ImageView,
        context: Context
    ) {

        if (!currentSence.equals(lastSence)) {

            Log.e(
                "TAG",
                "current sence is =====" + currentSence + "==========last sence========" + lastSence
            )
            (context as Activity).runOnUiThread(object : Runnable {
                override fun run() {
                    Log.e("TAG","--------------------------------------------")
                    framgeImageView.visibility = View.VISIBLE
                }
            })
            //退场动画
            if (lastSence.equals("expressway")) {
                Log.e("TAG", "  framgeImageView.isVisible" + framgeImageView.isVisible)

                if (frameAnimationHightOut == null) {
                    hightWayOut = getRes(R.array.highwayout, context)
                    frameAnimationHightOut =
                        FrameAnimation(
                            framgeImageView,
                            hightWayOut,
                            duration,
                            false
                        )

                    frameAnimationHightOut?.setAnimationListener(object :
                        FrameAnimation.AnimationListener {
                        override fun onAnimationStart() {
                        }

                        override fun onAnimationEnd() {

                            //入场动画 公园
                            if (currentSence.equals("neighborhood")) {

                                if (frameAnimationPOIn == null) {
                                    frameAnimationPOIn =
                                        FrameAnimation(
                                            framgeImageView,
                                            getRes(R.array.parkin, context),
                                            duration,
                                            false
                                        )
                                    frameAnimationPOIn!!.setAnimationListener(object :
                                        FrameAnimation.AnimationListener {
                                        override fun onAnimationStart() {
                                        }

                                        override fun onAnimationEnd() {
                                            framgeImageView.visibility = View.INVISIBLE
                                            MainViewContorler.passengerVisibleState(
                                                driver,
                                                passsenger1,
                                                passsenger2,
                                                passenger3,
                                                true
                                            )
                                        }

                                        override fun onAnimationRepeat() {
                                        }
                                    })
                                }
                                Log.e("TAG","ssssssssssssssssss =============neighborhood in"+lastSence)
                                frameAnimationPOIn?.play(duration)

                            } else {

                                //入场动画，公司

                                if (frameAnimationWorkIn == null) {
                                    frameAnimationWorkIn =
                                        FrameAnimation(
                                            framgeImageView,
                                            getRes(R.array.workin, context),
                                            duration,
                                            false
                                        )
                                    frameAnimationWorkIn!!.setAnimationListener(object :
                                        FrameAnimation.AnimationListener {
                                        override fun onAnimationStart() {
                                        }

                                        override fun onAnimationEnd() {
                                            framgeImageView.visibility = View.INVISIBLE
                                            MainViewContorler.passengerVisibleState(
                                                driver,
                                                passsenger1,
                                                passsenger2,
                                                passenger3,
                                                true
                                            )
                                        }

                                        override fun onAnimationRepeat() {
                                        }
                                    })
                                }
                                Log.e("TAG","ssssssssssssssssss =============frameAnimationWorkIn in"+lastSence)
                                frameAnimationWorkIn!!.play(duration)


                            }


                        }

                        override fun onAnimationRepeat() {
                        }
                    })

                }
                frameAnimationHightOut?.play(duration)

            } else if (lastSence.equals("workplace")) {

                Log.e("TAG", "beging work out")
                if (frameAnimationWorkOut == null) {
                    frameAnimationWorkOut =
                        FrameAnimation(
                            framgeImageView,
                            getRes(R.array.workout, context),
                            duration,
                            false
                        )

                    frameAnimationWorkOut!!.setAnimationListener(object :
                        FrameAnimation.AnimationListener {
                        override fun onAnimationStart() {
                        }

                        override fun onAnimationEnd() {

                            //入场动画 公园
                            if (currentSence.equals("neighborhood")) {
                                if (frameAnimationPOIn == null) {
                                    frameAnimationPOIn =
                                        FrameAnimation(
                                            framgeImageView,
                                            getRes(R.array.parkin, context),
                                            duration,
                                            false
                                        )
                                    frameAnimationPOIn!!.setAnimationListener(object :
                                        FrameAnimation.AnimationListener {
                                        override fun onAnimationStart() {
                                        }

                                        override fun onAnimationEnd() {
                                            framgeImageView.visibility = View.INVISIBLE
                                            MainViewContorler.passengerVisibleState(
                                                driver,
                                                passsenger1,
                                                passsenger2,
                                                passenger3,
                                                true
                                            )
                                        }

                                        override fun onAnimationRepeat() {
                                        }
                                    })
                                }
                                frameAnimationPOIn!!.play(duration)
                                Log.e("TAG","ssssssssssssssssss =============neighborhood in"+lastSence)
                            } else {


                                if (frameAnimationHightIn == null) {
                                    frameAnimationHightIn =
                                        FrameAnimation(
                                            framgeImageView,
                                            getRes(R.array.highwayin, context),
                                            duration,
                                            false
                                        )
                                    frameAnimationHightIn!!.setAnimationListener(object :
                                        FrameAnimation.AnimationListener {
                                        override fun onAnimationStart() {
                                        }

                                        override fun onAnimationEnd() {
                                            framgeImageView.visibility = View.INVISIBLE
                                            MainViewContorler.passengerVisibleState(
                                                driver,
                                                passsenger1,
                                                passsenger2,
                                                passenger3,
                                                true
                                            )
                                        }

                                        override fun onAnimationRepeat() {
                                        }
                                    })
                                }
                                frameAnimationHightIn!!.play(duration)
                                Log.e("TAG","ssssssssssssssssss =============frameAnimationHightIn in"+lastSence)

                            }
                        }

                        override fun onAnimationRepeat() {
                            TODO("Not yet implemented")
                        }

                    })
                }
                frameAnimationWorkOut!!.play(duration)

            } else {
//                Log.e("TAG", " poi last sence is =======" + lastSence)
//                framgeImageView.post { Runnable { framgeImageView.visibility=View.VISIBLE } }

                if (lastSence.equals("neighborhood")) {
                    Log.e("TAG", " neighborhood in and current sence is =======" + currentSence)
                    if (frameAnimationPOOut == null) {
                        frameAnimationPOOut =
                            FrameAnimation(
                                framgeImageView,
                                getRes(R.array.parkout, context),
                                duration,
                                false
                            )

                        frameAnimationPOOut!!.setAnimationListener(object :
                            FrameAnimation.AnimationListener {
                            override fun onAnimationStart() {
                            }

                            override fun onAnimationEnd() {

                                //入场动画 公园
                                if (currentSence.equals("workplace")) {
                                    if (frameAnimationWorkIn == null) {
                                        frameAnimationWorkIn =
                                            FrameAnimation(
                                                framgeImageView,
                                                getRes(R.array.workin, context),
                                                duration,
                                                false
                                            )
                                        frameAnimationWorkIn!!.setAnimationListener(object :
                                            FrameAnimation.AnimationListener {
                                            override fun onAnimationStart() {
                                            }

                                            override fun onAnimationEnd() {
                                                framgeImageView.visibility = View.INVISIBLE
                                                MainViewContorler.passengerVisibleState(
                                                    driver,
                                                    passsenger1,
                                                    passsenger2,
                                                    passenger3,
                                                    true
                                                )
                                            }

                                            override fun onAnimationRepeat() {
                                            }
                                        })
                                    }
                                    frameAnimationWorkIn!!.play(duration)
                                    Log.e("TAG","ssssssssssssssssss =============workplaceIn in"+currentSence)
                                } else {

                                    if (frameAnimationHightIn == null) {
                                        frameAnimationHightIn =
                                            FrameAnimation(
                                                framgeImageView,
                                                getRes(R.array.highwayin, context),
                                                duration,
                                                false
                                            )
                                        frameAnimationHightIn!!.setAnimationListener(object :
                                            FrameAnimation.AnimationListener {
                                            override fun onAnimationStart() {
                                            }

                                            override fun onAnimationEnd() {
                                                framgeImageView.visibility = View.INVISIBLE
                                                MainViewContorler.passengerVisibleState(
                                                    driver,
                                                    passsenger1,
                                                    passsenger2,
                                                    passenger3,
                                                    true
                                                )
                                            }

                                            override fun onAnimationRepeat() {
                                            }
                                        })
                                    }
                                    frameAnimationHightIn!!.play(duration)
                                    Log.e("TAG","ssssssssssssssssss =============frameAnimationHightIn In in"+lastSence)

                                }
                            }

                            override fun onAnimationRepeat() {
                                TODO("Not yet implemented")
                            }

                        })

                    }
                    frameAnimationPOOut!!.play(duration)

                }

            }
        }
    }

    fun getRes(resId: Int, context: Context): IntArray {
        val typedArray = context.resources.obtainTypedArray(resId)
        val len = typedArray.length()
        val resId = IntArray(len)
        for (i in 0 until len) {
            resId[i] = typedArray.getResourceId(i, -1)
        }
        typedArray.recycle()
        return resId
    }


}
