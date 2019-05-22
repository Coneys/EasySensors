package com.github.coneys.sample

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.coneys.R
import com.github.coneys.sensor.base.SensorAccuracy
import com.github.coneys.sensor.base.SensorListener
import com.github.coneys.sensor.base.SensorSession
import com.github.coneys.sensor.base.SensorSessions
import com.github.coneys.sensor.geomagnetic.EarthOrientationSensor
import com.github.coneys.sensor.geomagnetic.NorthAngle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val earthOrientationSensor = EarthOrientationSensor()


        val session = SensorSession(earthOrientationSensor, object : SensorListener<NorthAngle> {
            override fun onNewData(t: NorthAngle) {
                println("ROT: New rotation data $t")
                comapss.rotation = 360f - t.angleInt
            }

            override fun onNewAccuracy(accuracy: SensorAccuracy) {
                println("ACC: New Accuracy $accuracy")
            }

            override fun onUnavailable() {
                println("UNAVA: Rotation sensor unavailable")
            }

        })

        val sensors = (getSystemService(Context.SENSOR_SERVICE) as SensorManager).getSensorList(Sensor.TYPE_ALL)
        sensors.forEach {
            println("SENSOR + ${it.name}")

        }

        SensorSessions(setOf(session), this)

    }
}
