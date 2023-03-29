import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application").version("7.4.2") apply false
    id("com.android.library").version("7.4.2") apply false
    id("org.jetbrains.kotlin.android").version("1.8.10") apply false
    id("com.google.dagger.hilt.android").version("2.45") apply false
}