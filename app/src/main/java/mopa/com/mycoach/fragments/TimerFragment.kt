package mopa.com.mycoach.fragments


import android.content.Context
import android.os.*
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.fragment_timer.*

import mopa.com.mycoach.R


class TimerFragment : Fragment() {

    private var countDownTimer1: CountDownTimer? = null
    private var countDownTimer2: CountDownTimer? = null

    private var timeLeftInMilliseconds = Array<Long>(2){0}
    private var isRunning = Array(2){false}
    private var vibrator: Vibrator? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_timer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        timeLeftInMilliseconds[0] = 3000000 //50min
        timeLeftInMilliseconds[1] = 60000 //1min

        playButton1.setOnClickListener {
            if (!isRunning[0]) startTimer(0)
            else stopTimer(0)
        }

        playButton2.setOnClickListener {
            if (!isRunning[1]) startTimer(1)
            else stopTimer(1)
        }

        replayButton1.setOnClickListener {
            if (!isRunning[0]) {
                timeLeftInMilliseconds[0] = 3000000
                updateTimer(timeLeftInMilliseconds[0], 0)
            } else {
                Toast.makeText(context, "O timer deve estar pausado", Toast.LENGTH_SHORT).show()
            }
        }

        replayButton2.setOnClickListener {
            if (!isRunning[1]) {
                timeLeftInMilliseconds[1] = 60000
                updateTimer(timeLeftInMilliseconds[1], 1)
            } else {
                Toast.makeText(context, "O timer deve estar pausado", Toast.LENGTH_SHORT).show()
            }
        }


    }

    fun startTimer(identifier: Int){
        if (identifier == 0) {
            countDownTimer1 = object : CountDownTimer(timeLeftInMilliseconds[0], 1000) {
                override fun onTick(p0: Long) {
                    timeLeftInMilliseconds[0] = p0
                    updateTimer(timeLeftInMilliseconds[0], 0)
                }

                @RequiresApi(Build.VERSION_CODES.M)
                override fun onFinish() {
                    stopTimer(0)
                    vibrator = context!!.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        vibrator!!.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
                    } else {
                        //deprecated in API 26
                        vibrator!!.vibrate(1000)
                    }
                    updateTimer(0, 0)
                }

            }.start()
            playButton1.setImageDrawable(context!!.getDrawable(R.drawable.ic_pause))
            isRunning[0] = true
        }
        else {
            countDownTimer2 = object : CountDownTimer(timeLeftInMilliseconds[1], 1000) {
                override fun onTick(p0: Long) {
                    timeLeftInMilliseconds[1] = p0
                    updateTimer(timeLeftInMilliseconds[1], 1)
                }

                @RequiresApi(Build.VERSION_CODES.M)
                override fun onFinish() {
                    stopTimer(1)
                    vibrator = context!!.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        vibrator!!.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
                    } else {
                        //deprecated in API 26
                        vibrator!!.vibrate(1000)
                    }
                    updateTimer(0, 1)
                }

            }.start()
            playButton2.setImageDrawable(context!!.getDrawable(R.drawable.ic_pause))
            isRunning[1] = true
        }
    }

    fun stopTimer(identifier: Int){
        when (identifier){
            0 -> {
                countDownTimer1!!.cancel()
                isRunning[0] = false
                playButton1.setImageDrawable(context!!.getDrawable(R.drawable.ic_play))
            }
            1 -> {
                countDownTimer2!!.cancel()
                isRunning[1] = false
                playButton2.setImageDrawable(context!!.getDrawable(R.drawable.ic_play))
            }
        }
    }

    fun updateTimer(time: Long, identifier: Int){
        val hours: Int = (time / 3600000).toInt()
        val minutes: Int = (time / 60000).toInt()
        val seconds: Int = ((time % 60000)/1000).toInt()
        var timeLeft = ""

        if (hours != 0) timeLeft += hours.toString() + ":"
        if (minutes < 10) timeLeft += "0"
        timeLeft += minutes.toString() + ":"
        if (seconds < 10) timeLeft += "0"
        timeLeft += seconds.toString()

        when (identifier){
            0 -> time1.text = timeLeft
            1 -> time2.text = timeLeft
        }
    }
}
