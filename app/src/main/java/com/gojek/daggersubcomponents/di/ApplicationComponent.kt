package com.gojek.daggersubcomponents.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SubComponentsModule::class])
interface ApplicationComponent {
    fun nameComponent(): NameComponent.Factory
}