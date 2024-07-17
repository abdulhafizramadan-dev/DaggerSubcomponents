package com.gojek.daggersubcomponents.di

import dagger.Module

@Module(subcomponents = [NameComponent::class])
interface SubComponentsModule