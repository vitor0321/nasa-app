import VersionsApp.composeActivityVersion
import VersionsApp.composeMaterial
import VersionsApp.composeVersion
import VersionsApp.coreVersion
import VersionsApp.googleMaterial
import VersionsApp.gsonVersion
import VersionsApp.hilt
import VersionsApp.hiltCompAndroidx
import VersionsApp.javaxVersion
import VersionsApp.kotlinxCoroutines
import VersionsApp.lifecycleVersion
import VersionsApp.okhttp3Version
import VersionsApp.retrofitVersion
import VersionsApp.systemBarsUiController
import VersionsTest.espressoVersion
import VersionsTest.extJunitVersion
import VersionsTest.junitVersion

object VersionsBuild {
    const val applicationId            = "com.example.nasaApp"
    const val namespace                = "com.nasa.nasa_app"
    const val compileSdk               = 33
    const val minSdk                   = 26
    const val targetSdk                = 33
    const val versionCode              = 1
    const val versionName              = "1.0"
}

object VersionsApp {
    const val coreVersion              = "1.9.0"
    const val kotlinxCoroutines        = "1.6.0"
    const val lifecycleVersion         = "2.5.1"
    const val composeVersion           = "1.2.1"
    const val composeActivityVersion   = "1.6.0"
    const val composeMaterial          = "1.0.0-beta01"
    const val gsonVersion              = "2.9.0"
    const val systemBarsUiController   = "0.24.9-beta"
    const val googleMaterial           = "1.6.1"
    const val detekt                   = "1.21.0"
    const val hilt                     = "2.41"
    const val hiltCompAndroidx         = "1.0.0"
    const val javaxVersion             = "1"
    const val retrofitVersion          = "2.9.0"
    const val okhttp3Version           = "4.9.0"
}

object VersionsTest {
    const val junitVersion             = "4.13.2"
    const val extJunitVersion          = "1.1.3"
    const val espressoVersion          = "3.4.0"
}

object AppModules {
    const val coreModule               = ":core"
}

object AppDependencies {
    const val core                     = "androidx.core:core-ktx:$coreVersion"
    const val lifecycle                = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion"
    const val lifecycleViewmodel       = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
    const val lifecycleLivedata        = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion"
    const val composeActivity          = "androidx.activity:activity-compose:$composeActivityVersion"
    const val gson                     = "com.google.code.gson:gson:$gsonVersion"

    // Material3
    const val materialGoogle           = "com.google.android.material:material:$googleMaterial"
    const val composeUi                = "androidx.compose.ui:ui:$composeVersion"
    const val composeMaterial3         = "androidx.compose.material3:material3:$composeMaterial"
    const val composeUiTooling         = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    // Material3 - Status bar
    const val systemUiController       = "com.google.accompanist:accompanist-systemuicontroller:$systemBarsUiController"

    //Hilt
    const val hiltAndroid              = "com.google.dagger:hilt-android:$hilt"
    const val hiltCompiler             = "com.google.dagger:hilt-android-compiler:$hilt"
    const val hiltCompilerAndroidx     = "androidx.hilt:hilt-compiler:$hiltCompAndroidx"
    const val hiltPlugin               = "com.google.dagger:hilt-android-gradle-plugin:$hilt"

    const val javaxDep                 = "javax.inject:javax.inject:$javaxVersion"
    const val coroutinesCore           = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutines"
    const val retrofit                 = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val retrofitConverter        = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    const val okhttp3                  = "com.squareup.okhttp3:okhttp-bom:$okhttp3Version"
    const val okhttp3Ok                = "com.squareup.okhttp3:okhttp"
    const val okhttp3Interceptor       = "com.squareup.okhttp3:logging-interceptor"
}

object CoreDependencies {

}

object TestDependencies {
    const val junit                    = "junit:junit:$junitVersion"
    const val extJunit                 = "androidx.test.ext:junit:$extJunitVersion"
    const val espresso                 = "androidx.test.espresso:espresso-core:$espressoVersion"

    const val composeJunit4            = "androidx.compose.ui:ui-test-junit4:$composeVersion"
    const val composeTooling           = "androidx.compose.ui:ui-tooling:$composeVersion"
    const val composeManifest          = "androidx.compose.ui:ui-test-manifest:$composeVersion"
}