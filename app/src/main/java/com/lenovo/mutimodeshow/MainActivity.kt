package com.lenovo.mutimodeshow

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lenovo.carcontroler.utils.WebSocketUtil
import com.lenovo.mutimodeshow.bean.PassengerInfo


class MainActivity : AppCompatActivity(), WsListener.PassengerInfoListioner, View.OnClickListener {


    private lateinit var weatherValue: TextView
    private lateinit var frameAnimationC: FrameAnimation
    private var residences: ImageView? = null
    private var highway: ImageView? = null
    private var ai: ImageView? = null
    private val highWayFragment: HighWayFragment? = null
    private val residencesFragment: ResidencesFragment? = null
    private val aiFragment: AIFragment? = null
    private var image: ImageView? = null
    private val TAG = MainActivity::class.java.simpleName

    private lateinit var carBackImg: ImageView
    private lateinit var carMidelImg: ImageView
    private lateinit var carFrontImg: ImageView
    private lateinit var driver: ImageView;
    private lateinit var passsenger1: ImageView;
    private lateinit var passsenger2: ImageView;
    private lateinit var passenger3: ImageView;
    private lateinit var frameImageView: ImageView
    private lateinit var emmotion1View: ImageView;
    private lateinit var emmotion2View: ImageView;
    private lateinit var emmotion3View: ImageView;
    private lateinit var emmotion4View: ImageView

    private lateinit var emotionLayout1: RelativeLayout
    private lateinit var emotionLayout2: RelativeLayout
    private lateinit var emotionLayout3: RelativeLayout
    private lateinit var emotionLayout4: RelativeLayout

    private lateinit var wheel: ImageView;

    private var currentSencce = ""
    companion object{
        var lastSence = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView();
        initData();
    }

    private fun initView() {
//        val fragmentContainer = findViewById<RelativeLayout>(R.id.fragmentContainer)
        residences = findViewById(R.id.residences)
        highway = findViewById(R.id.highway)
        ai = findViewById(R.id.ai)
//        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
//        residences?.setOnClickListener(this)
//        highway?.setOnClickListener(this)
//        ai?.setOnClickListener(this)
        highway?.isSelected = true

//        ft.commit()
        weatherValue=findViewById(R.id.weatherValue)
        carBackImg = findViewById(R.id.carBackImg);
        carMidelImg = findViewById(R.id.carMidelImg);
        carFrontImg = findViewById(R.id.carFrontImg);

        driver = findViewById(R.id.driver);
        passsenger1 = findViewById(R.id.passsenger1);
        passsenger2 = findViewById(R.id.passsenger2);
        passenger3 = findViewById(R.id.passenger3);
        wheel = findViewById(R.id.wheel)

        emmotion1View = findViewById(R.id.emmotion1)
        emmotion2View = findViewById(R.id.emmotion2)
        emmotion3View = findViewById(R.id.emmotion3)
        emmotion4View = findViewById(R.id.emmotion4)

        emotionLayout1 = findViewById(R.id.emotionLayout1)
        emotionLayout2 = findViewById(R.id.emotionLayout2)
        emotionLayout3 = findViewById(R.id.emotionLayout3)
        emotionLayout4 = findViewById(R.id.emotionLayout4)

        frameImageView = findViewById(R.id.frameImageview);


//        val frameAnimation = FrameAnimation(frameImageView, getRes(R.array.highwayin), 0, false)
//        frameAnimation.setAnimationListener(object : FrameAnimation.AnimationListener {
//            override fun onAnimationStart() {
//                frameImageView.visibility = View.VISIBLE
//            }
//
//            override fun onAnimationEnd() {
//                frameImageView.visibility = View.INVISIBLE
//            }
//
//            override fun onAnimationRepeat() {
//            }
//        })
        lastSence = "expressway"


    }

    fun getRes(resId: Int): IntArray? {
        val typedArray = resources.obtainTypedArray(resId)
        val len = typedArray.length()
        val resId = IntArray(len)
        for (i in 0 until len) {
            resId[i] = typedArray.getResourceId(i, -1)
        }
        typedArray.recycle()
        return resId
    }

    private fun initData() {
        val webSocketUtil = WebSocketUtil()
        webSocketUtil.init(this)
        webSocketUtil.getWebListener().setPassengerInfoListioner(this);

    }

    override fun onPassengerInfo(passengerInfo: PassengerInfo?) {
        runOnUiThread {object :Runnable{
            override fun run() {
                weatherValue.text=passengerInfo?.getMessage()?.temperature.toString()
                Toast.makeText(this@MainActivity,passengerInfo?.message?.scene,Toast.LENGTH_SHORT).show()
            }
        }

        }

        if (passengerInfo?.status == 4 || passengerInfo?.status == 5 || passengerInfo?.status == 6) return

        val driverInfo = passengerInfo!!.message.member[0]
        MainViewContorler.updateView(driverInfo, driver, emmotion1View, emotionLayout1)

        val passenger1Info = passengerInfo.message.member[1]
        MainViewContorler.updateView(passenger1Info, passsenger1, emmotion2View, emotionLayout2)

        val passenger2Info = passengerInfo.message.member[2]
        MainViewContorler.updateView(passenger2Info, passsenger2, emmotion3View, emotionLayout3)

        val passenger3Info = passengerInfo.message.member[4]
        MainViewContorler.updateView(passenger3Info, passenger3, emmotion4View, emotionLayout4)

        currentSencce =passengerInfo.message.scene
//        lastSence="expressway"
//        currentSencce="neighborhood"
        AnimationUtil.transitionAnimation(
            currentSencce,
            lastSence,
            driver,
            passsenger1,
            passsenger2,
            passenger3,
            frameImageView,
            this
        )
        if (currentSencce!= lastSence){
            if (currentSencce.equals("expressway")) {
                carBackImg.setImageResource(R.mipmap.carback)
                carMidelImg.setImageResource(R.mipmap.camidel)
                carFrontImg.setImageResource(R.mipmap.carforground)
                highway?.isSelected = true
                residences?.isSelected = false
                ai?.isSelected = false
            } else if (currentSencce.equals("neighborhood")) {
                carBackImg.setImageResource(R.mipmap.carback)
                carMidelImg.setImageResource(R.mipmap.camidel)
                carFrontImg.setImageResource(R.mipmap.carforground)
                residences?.isSelected = false
                highway?.isSelected = false
                ai?.isSelected = true
            } else if(currentSencce.equals("workplace")) {
                carBackImg.setImageResource(R.mipmap.carback)
                carMidelImg.setImageResource(R.mipmap.camidel)
                carFrontImg.setImageResource(R.mipmap.carforground)
                ai?.isSelected = false
                highway?.isSelected = false
                residences?.isSelected = true
            }
        }
        lastSence = currentSencce

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.residences -> {
                v.isSelected = true
                highway?.isSelected = false
                ai?.isSelected = false
                currentSencce = "workplace"
                Log.e("TAG","currentSencce -------------"+currentSencce)
            }
            R.id.highway -> {
                v.isSelected = true
                residences?.isSelected = false
                ai?.isSelected = false
                currentSencce = "expressway"
            }
            R.id.ai -> {
                v.isSelected = true
                highway?.isSelected = false
                residences?.isSelected = false
                currentSencce = "POI"
            }

        }
//        AnimationUtil.transitionAnimation(
//            currentSencce,
//            lastSence,
//            driver,
//            passsenger1,
//            passsenger2,
//            passenger3,
//            frameImageView,
//            this
//        )
    }


}