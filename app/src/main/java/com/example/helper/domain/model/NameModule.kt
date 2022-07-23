package com.example.helper.domain.model

import dagger.Module
import dagger.Provides

@Module
class NameModule {

    @Provides
    fun provideName(name: String): String {
        return name
    }
}