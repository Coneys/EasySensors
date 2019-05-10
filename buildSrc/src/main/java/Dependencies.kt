
object BuildVersions {
    const val kotlin = "1.3.10"
    const val build_gradle = "3.2.1"
    const val google_services = "3.1.1"
}

object Plugins {
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${BuildVersions.kotlin}"
    const val build_gradle_plugin = "com.android.tools.build:gradle:${BuildVersions.build_gradle}"
    const val google_services_plugin = "com.google.gms:google-services:${BuildVersions.google_services}"
}

object LibraryVersions {
    const val support_library = "28.0.0"
    const val android_architecture_components = "1.1.1"
    const val google_play_services = "11.8.0"
    const val firebase_messaging = "11.8.0"
    const val firebase_analytics = "11.8.0"
    const val firebase_core = "11.8.0"
    const val gson = "2.8.2"
    const val anko = "0.10.7"
    const val dagger = "2.14.1"
    const val retrofit = "2.3.0"
    const val moshi = "2.3.0"
    const val rx_kotlin = "2.2.0"
    const val rx_android = "2.1.0"
    const val glide = "4.8.0"
    const val koin = "1.0.1"
    const val coroutines = "1.0.0"
}

object AndroidXVersions {
    const val appcompat = "1.0.0"
    const val cardView = appcompat
    const val design = appcompat
    const val recyclerView = appcompat
    const val constraintLayout = "1.1.3"
    const val room = "2.0.0"
    const val lifecycle = "2.0.0"
    const val core = "1.1.0-alpha01"
    const val fragment = core
}


object Libraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${BuildVersions.kotlin}"
    const val kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect:${BuildVersions.kotlin}"
    const val rx_kotlin = "io.reactivex.rxjava2:rxkotlin:${LibraryVersions.rx_kotlin}"
    const val rx_android = "io.reactivex.rxjava2:rxandroid:${LibraryVersions.rx_android}"
    const val support_appcompat = "androidx.appcompat:appcompat:${AndroidXVersions.appcompat}"
    const val support_design = "com.google.android.material:material:${AndroidXVersions.design}"
    const val support_cardview = "androidx.cardview:cardview:${AndroidXVersions.cardView}"
    const val support_recyclerview = "androidx.recyclerview:recyclerview:${AndroidXVersions.recyclerView}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${AndroidXVersions.constraintLayout}"
    const val play_services_maps = "com.google.android.gms:play-services-maps:${LibraryVersions.google_play_services}"
    const val play_services_location = "com.google.android.gms:play-services-location:${LibraryVersions.google_play_services}"
    const val firebase_messaging = "com.google.firebase:firebase-messaging:${LibraryVersions.firebase_messaging}"
    const val moshi = "com.squareup.retrofit2:converter-moshi:${LibraryVersions.moshi}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${LibraryVersions.retrofit}"
    const val glide = "com.github.bumptech.glide:glide:${LibraryVersions.glide}"
    const val koin = "org.koin:koin-android:${LibraryVersions.koin}"
    const val koin_view_model = "org.koin:koin-android-viewmodel:${LibraryVersions.koin}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${LibraryVersions.coroutines}"
    const val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibraryVersions.coroutines}"
}

object AndroidXLibraries{
    const val core = "androidx.core:core:${AndroidXVersions.core}"
    const val fragment = "androidx.fragment:fragment:${AndroidXVersions.fragment}"
    const val fragmentTesting= "androidx.fragment:fragment-testing:${AndroidXVersions.fragment}"
    const val coreTesting= "androidx.test:core:${AndroidXVersions.core}"

}

object AndroidArchitectureDependencies {
    const val room = "androidx.room:room-runtime:${AndroidXVersions.room}"
    const val roomRx = "androidx.room:room-rxjava2:${AndroidXVersions.room}"
    const val testing = "androidx.room:room-testing:${AndroidXVersions.room}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${AndroidXVersions.lifecycle}"

}

object KaptDependencies {
    const val room = "androidx.room:room-compiler:${AndroidXVersions.room}"
    const val lifecycle = "androidx.lifecycle:lifecycle-compiler:${AndroidXVersions.lifecycle}"
}