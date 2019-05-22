package com.github.coneys.sensor.geomagnetic

data class NorthAngle(var angle: Float) {
    val angleInt get() = angle.toInt()
}
