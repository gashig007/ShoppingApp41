package com.geektech.shoppingapp

import android.app.Application
import androidx.room.Room
import com.geektech.shoppingapp.data.local.AppDataBase
import com.geektech.shoppingapp.di.DaggerNewComponent
import com.geektech.shoppingapp.domain.model.ShopItem
import javax.inject.Inject

class App : Application() {

    @Inject
    lateinit var shopItem: ShopItem

    init {
        DaggerNewComponent.create().inject(this)
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "dataBase")
            .fallbackToDestructiveMigration()
            .build()
    }


    companion object {
        lateinit var db: AppDataBase
    }
}