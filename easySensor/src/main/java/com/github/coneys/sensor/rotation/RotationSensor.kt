package com.github.coneys.sensor.rotation

import android.hardware.Sensor
import android.hardware.SensorManager
import com.github.coneys.sensor.base.PhoneSensor

class GameRotationSensor : RotationSensor(sensorType = Sensor.TYPE_GAME_ROTATION_VECTOR)
class NormalRotationSensor : RotationSensor(sensorType = Sensor.TYPE_ROTATION_VECTOR)

abstract class RotationSensor(sensorType: Int)
    : PhoneSensor<RotationValue>(sensorType) {

    private val orientation = FloatArray(3)
    private val rotationMatrix = FloatArray(9)

    override fun createDataHolder(): RotationValue = RotationValue(0f, 0f)

    override fun applyData(dataHolder: RotationValue, values: FloatArray): RotationValue {

        SensorManager.getRotationMatrixFromVector(rotationMatrix, values)
        SensorManager.getOrientation(rotationMatrix, orientation)

        dataHolder.xAngle = calculateXAngle()
        dataHolder.yAngle = calculateYAngle()

        return dataHolder
    }

    private fun calculateXAngle() = calculateAngle(orientation[2].toDouble())
    private fun calculateYAngle() = calculateAngle(orientation[1].toDouble())

    private fun calculateAngle(orientation: Double) = ((Math.toDegrees(orientation) + 90).toInt()).toFloat()
}