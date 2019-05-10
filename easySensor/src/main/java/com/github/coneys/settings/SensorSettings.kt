package com.github.coneys.settings

import android.hardware.SensorManager

object SensorSettings {

    internal lateinit var sensorManager: SensorManager

    private val unavailableSensors: MutableList<Int> = ArrayList(0)

    fun turnSensorOff(sensorType: Int) {
        unavailableSensors.add(sensorType)
    }

    fun turnSensorOn(sensorType: Int) {
        unavailableSensors.remove(sensorType)
    }

    internal fun isAvailable(sensorType: Int) = !unavailableSensors.contains(sensorType)

}