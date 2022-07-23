package com.example.helper.di

import android.app.Application
import dagger.Component
import com.example.helper.domain.model.NameModule

@Component(modules = [NameModule::class])
interface NewComponent {
    fun inject(app: Application)
}