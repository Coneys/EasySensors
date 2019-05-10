package com.github.coneys.settings

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.hardware.SensorManager
import android.net.Uri

internal class SensorInitProvider : ContentProvider() {

    companion object {
        internal lateinit var appContext: Context
    }

    override fun insert(uri: Uri, values: ContentValues?) = null

    override fun query(
            uri: Uri,
            projection: Array<String>?,
            selection: String?,
            selectionArgs: Array<String>?,
            sortOrder: String?
    ) = null

    override fun onCreate(): Boolean {
        appContext = context.applicationContext
        SensorSettings.sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        return true
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<String>?) = 0

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?) = 0

    override fun getType(uri: Uri): String? = null

}