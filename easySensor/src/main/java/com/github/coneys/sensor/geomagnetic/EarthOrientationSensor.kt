package com.github.coneys.sensor.geomagnetic

import android.hardware.Sensor
import android.hardware.SensorManager
import com.github.coneys.sensor.base.PhoneSensor


class EarthOrientationSensor : PhoneSensor<NorthAngle>(Sensor.TYPE_ROTATION_VECTOR) {

    private val orientation = FloatArray(3)
    private val rotationMatrix = FloatArray(9)

    override fun createDataHolder() = NorthAngle(0f)


    override fun applyData(dataHolder: NorthAngle, values: FloatArray): NorthAngle {
        SensorManager.getRotationMatrixFromVector(rotationMatrix, values)
        SensorManager.getOrientation(rotationMatrix, orientation)

        val azimuth = Math.toDegrees(orientation[0].toDouble())

        val angle = (azimuth + 360) % 360
        return dataHolder.also { it.angle = angle.toFloat() }
    }

}