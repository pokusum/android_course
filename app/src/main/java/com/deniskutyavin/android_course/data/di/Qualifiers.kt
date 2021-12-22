package com.deniskutyavin.android_course.data.di

import javax.inject.Qualifier

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class AppCoroutineScope

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class DefaultCoroutineDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class IoCoroutineDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class MainCoroutineDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainImmediateCoroutineDispatcher