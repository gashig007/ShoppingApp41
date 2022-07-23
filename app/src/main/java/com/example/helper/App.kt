package com.example.helper

import android.app.Application
import androidx.room.Room
import com.example.helper.data.local.AppDataBase
import com.example.helper.di.DaggerNewComponent
import com.example.helper.domain.model.ShopItem
import javax.inject.Inject

class App : Application() {

    @Inject
    lateinit var shopItem: ShopItem

    init {
        DaggerNewComponent.create().inject(this)
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "dataBase").fallbackToDestructiveMigration().build()
    }


    companion object {
        lateinit var db: AppDataBase
    }
}