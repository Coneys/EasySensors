package com.github.coneys.sensor.base


class SensorSession<T>(val sensor: PhoneSensor<T>, val sensorListener: SensorListener<T>) {

    internal fun onNewValues(floatArray: FloatArray) {
        val result = sensor.convertData(floatArray)
        sensorListener.onNewData(result)
    }

    internal fun onNewAccuracy(sensorAccuracy: SensorAccuracy) {
        sensorListener.onNewAccuracy(sensorAccuracy)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SensorSession<*>) return false

        if (sensor != other.sensor) return false

        return true
    }

    override fun hashCode(): Int {
        return sensor.hashCode()
    }

}

