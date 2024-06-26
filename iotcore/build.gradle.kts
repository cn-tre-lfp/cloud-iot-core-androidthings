plugins {
    id("com.android.library")
}

group = "com.trechina"
version = "1.0.0"
android {
    compileSdk = 33

    defaultConfig {
        namespace = "com.trechina.cloudiotcoreandroidthings"
        minSdk = 27
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    @Suppress("UnstableApiUsage")
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    lint {
        disable.add("InvalidPackage")
    }
}

dependencies {
    implementation("com.android.support:support-annotations:28.0.0")
    testImplementation("com.google.truth:truth:0.40")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-core:5.0.0")
    testImplementation("org.robolectric:robolectric:4.0")
    testImplementation("io.jsonwebtoken:jjwt:0.9.0")
    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation(
        "com.android.support.test.espresso:espresso-core:3.0.2"
    )

    // MQTT
    implementation("org.eclipse.paho:org.eclipse.paho.client.mqttv3:1.2.5") {
        exclude("com.google.android", "support-v4")
    }
    implementation("org.eclipse.paho:org.eclipse.paho.android.service:1.1.1") {
        exclude("com.google.android", "support-v4")
    }

    // JWT
    implementation("org.bitbucket.b_c:jose4j:0.7.0")
}
