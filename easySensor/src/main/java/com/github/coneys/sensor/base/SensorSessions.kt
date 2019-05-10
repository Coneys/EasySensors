package com.github.coneys.sensor.base

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager.*
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.github.coneys.settings.SensorSettings

class SensorSessions(requestedSessions: Set<SensorSession<*>> = HashSet(),
                     private val lifecycleOwner: LifecycleOwner,
                     private val samplingPeriod: Int = SENSOR_DELAY_GAME) : SensorEventListener, LifecycleObserver {

    private val sensorManager = SensorSettings.sensorManager

    private val sessions = requestedSessions.removeUnavailable()

    init {
        lifecycleOwner.lifecycle.addObserver(this)
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
        val sensorAccuracy = when (accuracy) {
            SENSOR_STATUS_ACCURACY_LOW -> SensorAccuracy.LOW
            SENSOR_STATUS_ACCURACY_MEDIUM -> SensorAccuracy.MEDIUM
            SENSOR_STATUS_ACCURACY_HIGH -> SensorAccuracy.HIGH
            else -> SensorAccuracy.UNRELIABLE
        }

        sessions.first { it.sensor.isEqual(sensor) }.onNewAccuracy(sensorAccuracy)
    }

    override fun onSensorChanged(event: SensorEvent) {
        sessions.first { it.sensor.isEqual(event.sensor) }.onNewValues(event.values)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun doOnPause() {
        sensorManager.unregisterListener(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun doOnResume() {
        sessions.forEach {
            sensorManager.registerListener(this, it.sensor.androidSensor, samplingPeriod)
        }

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stopListening() {
        sensorManager.unregisterListener(this)
        lifecycleOwner.lifecycle.removeObserver(this)
    }

    private fun Set<SensorSession<*>>.removeUnavailable() = this.filter { session ->
        session.sensor.exists.also {
            if (!it) { session.sensorListener.onUnavailable() }
        }
    }

}