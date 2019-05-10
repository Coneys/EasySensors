package com.github.coneys.sensor.base

interface SensorListener<T> {
    fun onNewData(t: T)
    fun onNewAccuracy(accuracy: SensorAccuracy)
    fun onUnavailable()
}