package com.lenovo.mutimodeshow

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import com.lenovo.mutimodeshow.bean.MyApplication

object AnimationUtilS {

    private var frameAnimationHightOut_parkIn: FrameAnimation? = null
    private var frameAnimationHightOut_workIn: FrameAnimation? = null
    private var frameAnimationWorkOut_HighIn: FrameAnimation? = null
    private var frameAnimationWorkOut_parkIn: FrameAnimation? = null
    private var frameAnimationParkOut_HighIn: FrameAnimation? = null
    private var frameAnimationParkOut_workIn: FrameAnimation? = null

    private var hightWayOut: IntArray? = null
    private var hightWayIn: IntArray? = null
    private var workOut: IntArray? = null
    private var workIn: IntArray? = null
    private var parkOut: IntArray? = null
    private var parkIn: IntArray? = null
    private val duration = 1
    private var highwayoutParkInId = getRes(R.array.highwayout_parkin)
    private var highwayoutWorkInId = getRes(R.array.highwayout_workin)
    private var workOutParkInId = getRes(R.array.workout_parkin)
    private var workOutHighInId = getRes(R.array.workout_highin)
    private var parkOutHighIn = getRes(R.array.parkout_highin)
    private var parkOutWorkIn = getRes(R.array.parkout_workin)
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
                    Log.e("TAG", "--------------------------------------------")
                    framgeImageView.visibility = View.VISIBLE
                }
            })
            //退场动画
            if (lastSence.equals("expressway") && currentSence.equals("neighborhood")) {
                Log.e("TAG", "  framgeImageView.isVisible" + framgeImageView.isVisible)
                frameAnimationHightOut_parkIn=null
                frameAnimationHightOut_parkIn =
                    FrameAnimation(
                        framgeImageView,
                        highwayoutParkInId,
                        duration,
                        false
                    )

                frameAnimationHightOut_parkIn?.setAnimationListener(object :
                    FrameAnimation.AnimationListener {
                    override fun onAnimationStart() {
                    }

                    override fun onAnimationEnd() {
                        framgeImageView.visibility = View.INVISIBLE

                    }

                    override fun onAnimationRepeat() {
                    }
                })


                frameAnimationHightOut_parkIn?.play(duration)

            } else if (lastSence.equals("expressway") && currentSence.equals("workplace")) {

                Log.e("TAG", "beging work out")
                frameAnimationHightOut_workIn=null
                frameAnimationHightOut_workIn =
                    FrameAnimation(
                        framgeImageView,
                        highwayoutWorkInId,
                        duration,
                        false
                    )

                frameAnimationHightOut_workIn!!.setAnimationListener(object :
                    FrameAnimation.AnimationListener {
                    override fun onAnimationStart() {
                    }

                    override fun onAnimationEnd() {
                        framgeImageView.visibility = View.INVISIBLE
                    }

                    override fun onAnimationRepeat() {
                    }

                })
                frameAnimationHightOut_workIn!!.play(duration)

            } else if (lastSence.equals("workplace") && currentSence.equals("expressway")) {

                frameAnimationWorkOut_HighIn=null
                frameAnimationWorkOut_HighIn =
                    FrameAnimation(
                        framgeImageView,
                        workOutHighInId,
                        duration,
                        false
                    )

                frameAnimationWorkOut_HighIn!!.setAnimationListener(object :
                    FrameAnimation.AnimationListener {
                    override fun onAnimationStart() {
                    }

                    override fun onAnimationEnd() {
                        framgeImageView.visibility = View.INVISIBLE
                    }

                    override fun onAnimationRepeat() {
                    }

                })
                frameAnimationWorkOut_HighIn!!.play(duration)

            } else if (lastSence.equals("workplace") && currentSence.equals("neighborhood")) {

                frameAnimationWorkOut_parkIn=null
                frameAnimationWorkOut_parkIn =
                    FrameAnimation(
                        framgeImageView,
                        workOutParkInId,
                        duration,
                        false
                    )

                frameAnimationWorkOut_parkIn!!.setAnimationListener(object :
                    FrameAnimation.AnimationListener {
                    override fun onAnimationStart() {
                    }

                    override fun onAnimationEnd() {
                        framgeImageView.visibility = View.INVISIBLE
                    }

                    override fun onAnimationRepeat() {
                    }

                })
                frameAnimationWorkOut_parkIn!!.play(duration)

            } else if (lastSence.equals("neighborhood") && currentSence.equals("expressway")) {

                frameAnimationParkOut_HighIn=null
                frameAnimationParkOut_HighIn =
                    FrameAnimation(
                        framgeImageView,
                        parkOutHighIn,
                        duration,
                        false
                    )

                frameAnimationParkOut_HighIn!!.setAnimationListener(object :
                    FrameAnimation.AnimationListener {
                    override fun onAnimationStart() {
                    }

                    override fun onAnimationEnd() {
                        framgeImageView.visibility = View.INVISIBLE
                    }

                    override fun onAnimationRepeat() {
                    }

                })
                frameAnimationParkOut_HighIn!!.play(duration)

            } else if (lastSence.equals("neighborhood") && currentSence.equals("workplace")) {

                frameAnimationParkOut_workIn=null
                frameAnimationParkOut_workIn =
                    FrameAnimation(
                        framgeImageView,
                        parkOutWorkIn,
                        duration,
                        false
                    )

                frameAnimationParkOut_workIn!!.setAnimationListener(object :
                    FrameAnimation.AnimationListener {
                    override fun onAnimationStart() {
                    }

                    override fun onAnimationEnd() {
                        framgeImageView.visibility = View.INVISIBLE
                    }

                    override fun onAnimationRepeat() {
                    }

                })
                frameAnimationParkOut_workIn!!.play(duration)

            }

        }
    }

    fun getRes(resId: Int): IntArray {
        val typedArray = MyApplication.context.resources.obtainTypedArray(resId)
        val len = typedArray.length()
        val resId = IntArray(len)
        for (i in 0 until len) {
            resId[i] = typedArray.getResourceId(i, -1)
        }
        typedArray.recycle()
        return resId
    }


}
