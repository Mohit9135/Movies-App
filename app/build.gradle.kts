plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
}
//apply plugin: 'com.android.application'
//apply plugin: 'com.google.dagger.hilt.android'


android {
    namespace = "com.example.pagingmovie"
    compileSdk = 34
    buildFeatures {
        viewBinding=true
    }

    defaultConfig {
        applicationId = "com.example.pagingmovie"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures{
        dataBinding=true
    }
}

dependencies {
//    Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.google.code.gson:gson:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    // RxJava3 with retrofit
    implementation ("com.squareup.retrofit2:adapter-rxjava3:2.11.0")
//    Glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.16.0")
//    Paging Library
    val paging_version = "3.3.2"
    implementation("androidx.paging:paging-runtime:$paging_version")
    // optional - RxJava3 support
    implementation("androidx.paging:paging-rxjava3:$paging_version")

//    Dagger Hilt
    implementation ("com.google.dagger:hilt-android:2.52")
    annotationProcessor ("com.google.dagger:hilt-compiler:2.52")

//    Lifecycle
    val lifecycle_version = "2.5.0-alpha04"
    val arch_version = "2.2.0"
    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata:$lifecycle_version")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
//    implementation ("androidx.lifecycle: lifecycle- Viewmodel-ktx:$lifecycle_version")


    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}