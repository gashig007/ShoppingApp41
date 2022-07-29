package com.geektech.shoppingapp.di

import android.app.Application
import dagger.Component
import com.geektech.shoppingapp.domain.model.NameModule

@Component(modules = [NameModule::class])
interface NewComponent {
    fun inject(app: Application)
}