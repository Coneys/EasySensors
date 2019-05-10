package com.github.coneys.sample

import android.hardware.Sensor
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.coneys.R
import com.github.coneys.sensor.base.SensorAccuracy
import com.github.coneys.sensor.base.SensorListener
import com.github.coneys.sensor.base.SensorSession
import com.github.coneys.sensor.base.SensorSessions
import com.github.coneys.sensor.rotation.GameRotationSensor
import com.github.coneys.sensor.rotation.RotationValue
import com.github.coneys.settings.SensorSettings

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val gameRotationSensor = GameRotationSensor()


        val session = SensorSession(gameRotationSensor, object : SensorListener<RotationValue> {
            override fun onNewData(t: RotationValue) {
                println("New rotation data $t")
            }

            override fun onNewAccuracy(accuracy: SensorAccuracy) {
                println("New Accuracy $accuracy")
            }

            override fun onUnavailable() {
                println("Rotation sensor unavailable")
            }

        })

        SensorSessions(setOf(session), this)

    }
}
