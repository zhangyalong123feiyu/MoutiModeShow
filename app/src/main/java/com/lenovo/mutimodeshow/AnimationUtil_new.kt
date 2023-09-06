//package com.lenovo.mutimodeshow
//
//import android.app.Activity
//import android.content.Context
//import android.util.Log
//import android.view.View
//import android.widget.ImageView
//import androidx.core.view.isVisible
//
//object AnimationUtil_new {
//
//    private lateinit var framesAnimation: FrameAnimationManager.FramesAnimation
//    private val duration=0
//
//    fun transitionAnimation(
//        currentSence: String,
//        lastSence: String,
//        driver: ImageView,
//        passsenger1: ImageView,
//        passsenger2: ImageView,
//        passenger3: ImageView,
//        framgeImageView: ImageView,
//        context: Context
//    ) {
//
//        if (!currentSence.equals(lastSence)) {
//            framesAnimation = FrameAnimationManager.getInstance().createFramesAnimation()
//            Log.e(
//                "TAG",
//                "current sence is =====" + currentSence + "==========last sence========" + lastSence
//            )
//            (context as Activity).runOnUiThread(object : Runnable {
//                override fun run() {
//                    framgeImageView.visibility = View.VISIBLE
//                }
//            })
//            //退场动画
//            if (lastSence.equals("expressway")) {
//                Log.e("TAG", "  framgeImageView.isVisible" + framgeImageView.isVisible)
//
//                framesAnimation.setFrameData(framgeImageView,)
//                val frameAnimation =
//                    FrameAnimation(
//                        framgeImageView,
//                        getRes(R.array.highwayout, framgeImageView.context),
//                        duration,
//                        false
//                    )
//                frameAnimation.setAnimationListener(object : FrameAnimation.AnimationListener {
//                    override fun onAnimationStart() {
//                    }
//
//                    override fun onAnimationEnd() {
//
//                        //入场动画 公园
//                        if (currentSence.equals("POI")) {
//                            val frameAnimation =
//                                FrameAnimation(
//                                    framgeImageView,
//                                    getRes(R.array.parkin, framgeImageView.context),
//                                    duration,
//                                    false
//                                )
//
//                            frameAnimation.setAnimationListener(object :
//                                FrameAnimation.AnimationListener {
//                                override fun onAnimationStart() {
//                                }
//
//                                override fun onAnimationEnd() {
//                                    framgeImageView.visibility = View.INVISIBLE
//                                    MainViewContorler.passengerVisibleState(
//                                        driver,
//                                        passsenger1,
//                                        passsenger2,
//                                        passenger3,
//                                        true
//                                    )
//                                }
//
//                                override fun onAnimationRepeat() {
//                                }
//                            })
//                        } else {
//
//                            //入场动画，公司
//
//                            val frameAnimation =
//                                FrameAnimation(
//                                    framgeImageView,
//                                    getRes(R.array.workin, framgeImageView.context),
//                                    duration,
//                                    false
//                                )
//
//                            frameAnimation.setAnimationListener(object :
//                                FrameAnimation.AnimationListener {
//                                override fun onAnimationStart() {
//                                }
//
//                                override fun onAnimationEnd() {
//                                    framgeImageView.visibility = View.INVISIBLE
//                                    MainViewContorler.passengerVisibleState(
//                                        driver,
//                                        passsenger1,
//                                        passsenger2,
//                                        passenger3,
//                                        true
//                                    )
//                                }
//
//                                override fun onAnimationRepeat() {
//                                }
//                            })
//
//                        }
//
//
//                    }
//
//                    override fun onAnimationRepeat() {
//                    }
//                })
//            } else if (lastSence.equals("workplace")) {
//
//                Log.e("TAG", "beging work out")
////                framgeImageView.post { Runnable { framgeImageView.visibility=View.VISIBLE } }
//                val frameAnimation =
//                    FrameAnimation(
//                        framgeImageView,
//                        getRes(R.array.workout, framgeImageView.context),
//                        duration,
//                        false
//                    )
//                frameAnimation.setAnimationListener(object : FrameAnimation.AnimationListener {
//                    override fun onAnimationStart() {
//                    }
//
//                    override fun onAnimationEnd() {
//
//                        //入场动画 公园
//                        if (currentSence.equals("POI")) {
//                            val frameAnimation =
//                                FrameAnimation(
//                                    framgeImageView,
//                                    getRes(R.array.parkin, framgeImageView.context),
//                                    duration,
//                                    false
//                                )
//
//                            frameAnimation.setAnimationListener(object :
//                                FrameAnimation.AnimationListener {
//                                override fun onAnimationStart() {
//                                }
//
//                                override fun onAnimationEnd() {
//                                    framgeImageView.visibility = View.INVISIBLE
//                                    MainViewContorler.passengerVisibleState(
//                                        driver,
//                                        passsenger1,
//                                        passsenger2,
//                                        passenger3,
//                                        true
//                                    )
//                                }
//
//                                override fun onAnimationRepeat() {
//                                }
//                            })
//                        } else {
//
//                            //入场动画，高速
//
//                            val frameAnimation =
//                                FrameAnimation(
//                                    framgeImageView,
//                                    getRes(R.array.highwayin, framgeImageView.context),
//                                    duration,
//                                    false
//                                )
//
//                            frameAnimation.setAnimationListener(object :
//                                FrameAnimation.AnimationListener {
//                                override fun onAnimationStart() {
//                                }
//
//                                override fun onAnimationEnd() {
//                                    framgeImageView.visibility = View.INVISIBLE
//                                    MainViewContorler.passengerVisibleState(
//                                        driver,
//                                        passsenger1,
//                                        passsenger2,
//                                        passenger3,
//                                        true
//                                    )
//                                }
//
//                                override fun onAnimationRepeat() {
//                                }
//                            })
//
//                        }
//
//
//                    }
//
//                    override fun onAnimationRepeat() {
//                    }
//                })
//
//
//            } else {
//                Log.e("TAG", "sssssssssssssssssss")
////                framgeImageView.post { Runnable { framgeImageView.visibility=View.VISIBLE } }
//                val frameAnimation =
//                    FrameAnimation(
//                        framgeImageView,
//                        getRes(R.array.parkout, framgeImageView.context),
//                        duration,
//                        false
//                    )
//                frameAnimation.setAnimationListener(object : FrameAnimation.AnimationListener {
//                    override fun onAnimationStart() {
//                    }
//
//                    override fun onAnimationEnd() {
//
//                        //入场动画 公园
//                        if (currentSence.equals("workplace")) {
//                            val frameAnimation =
//                                FrameAnimation(
//                                    framgeImageView,
//                                    getRes(R.array.workin, framgeImageView.context),
//                                    duration,
//                                    false
//                                )
//
//                            frameAnimation.setAnimationListener(object :
//                                FrameAnimation.AnimationListener {
//                                override fun onAnimationStart() {
//                                }
//
//                                override fun onAnimationEnd() {
//                                    framgeImageView.visibility = View.INVISIBLE
//                                    MainViewContorler.passengerVisibleState(
//                                        driver,
//                                        passsenger1,
//                                        passsenger2,
//                                        passenger3,
//                                        true
//                                    )
//                                }
//
//                                override fun onAnimationRepeat() {
//                                }
//                            })
//                        } else {
//
//                            //入场动画，高速
//
//                            val frameAnimation =
//                                FrameAnimation(
//                                    framgeImageView,
//                                    getRes(R.array.highwayin, framgeImageView.context),
//                                    duration,
//                                    false
//                                )
//
//                            frameAnimation.setAnimationListener(object :
//                                FrameAnimation.AnimationListener {
//                                override fun onAnimationStart() {
//                                }
//
//                                override fun onAnimationEnd() {
//                                    framgeImageView.visibility = View.INVISIBLE
//                                    MainViewContorler.passengerVisibleState(
//                                        driver,
//                                        passsenger1,
//                                        passsenger2,
//                                        passenger3,
//                                        true
//                                    )
//                                }
//
//                                override fun onAnimationRepeat() {
//                                }
//                            })
//
//                        }
//
//
//                    }
//
//                    override fun onAnimationRepeat() {
//                    }
//                })
//
//
//            }
//
//        }
////        MainActivity.lastSence = currentSence
//        Log.e(
//            "TAG",
//            "animation end lastSen " + MainActivity.lastSence + "======currentSence========" + currentSence
//        )
//
//    }
//
//    fun getRes(resId: Int, context: Context): IntArray? {
//        val typedArray = context.resources.obtainTypedArray(resId)
//        val len = typedArray.length()
//        val resId = IntArray(len)
//        for (i in 0 until len) {
//            resId[i] = typedArray.getResourceId(i, -1)
//        }
//        typedArray.recycle()
//        return resId
//    }
//
//
//}
