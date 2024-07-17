package com.gojek.daggersubcomponents.di

import com.gojek.daggersubcomponents.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface NameComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): NameComponent
    }

    fun inject(activity: MainActivity)
}
