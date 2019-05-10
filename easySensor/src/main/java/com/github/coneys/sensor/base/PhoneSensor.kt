package com.github.coneys.sensor.base

import android.hardware.Sensor
import com.github.coneys.settings.SensorSettings

abstract class PhoneSensor<T>(val sensorType: Int) {

    private val service = SensorSettings.sensorManager
    internal val androidSensor = service.getDefaultSensor(sensorType)

    val exists get() = androidSensor != null && SensorSettings.isAvailable(sensorType)

    private val dataHolder by lazy { createDataHolder() }

    protected abstract fun createDataHolder(): T
    protected abstract fun applyData(dataHolder: T, values: FloatArray): T

    internal fun convertData(values: FloatArray): T = applyData(dataHolder, values)

    fun isEqual(sensor: Sensor) = sensor.type == sensorType
    final override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is PhoneSensor<*>) return false

        if (sensorType != other.sensorType) return false

        return true
    }

    final override fun hashCode(): Int {
        return sensorType
    }


}