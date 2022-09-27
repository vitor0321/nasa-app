import VersionsApp.composeActivityVersion
import VersionsApp.composeMaterial
import VersionsApp.composeVersion
import VersionsApp.coreVersion
import VersionsApp.googleMaterial
import VersionsApp.gsonVersion
import VersionsApp.lifecycleVersion
import VersionsApp.systemBarsUiController
import VersionsTest.espressoVersion
import VersionsTest.extJunitVersion
import VersionsTest.junitVersion
import org.gradle.api.JavaVersion

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
    const val lifecycleVersion         = "2.5.1"
    const val composeVersion           = "1.2.1"
    const val composeActivityVersion   = "1.6.0"
    const val composeMaterial          = "1.0.0-beta01"
    const val gsonVersion              = "2.9.0"
    const val systemBarsUiController   = "0.24.9-beta"
    const val googleMaterial           = "1.6.1"
    const val detekt                   = "1.21.0"
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
    const val composeActivity          = "androidx.activity:activity-compose:$composeActivityVersion"
    const val gson                     = "com.google.code.gson:gson:$gsonVersion"

    // Material3
    const val materialGoogle           = "com.google.android.material:material:$googleMaterial"
    const val composeUi                = "androidx.compose.ui:ui:$composeVersion"
    const val composeMaterial3         = "androidx.compose.material3:material3:$composeMaterial"
    const val composeUiTooling         = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    // Material3 - Status bar
    const val systemUiController       = "com.google.accompanist:accompanist-systemuicontroller:$systemBarsUiController"
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