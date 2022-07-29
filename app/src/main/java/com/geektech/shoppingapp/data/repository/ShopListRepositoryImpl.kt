package com.geektech.shoppingapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.geektech.shoppingapp.App
import com.geektech.shoppingapp.domain.model.ShopItem
import com.geektech.shoppingapp.domain.repository.ShopListRepository
import com.geektech.shoppingapp.utils.ShopListMapper

class ShopListRepositoryImpl : ShopListRepository {

    private val shopList =
        sortedSetOf<ShopItem>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private val mapper = ShopListMapper()

    override suspend fun addShopItem(shopItem: ShopItem) {
        App.db.shopItemDao().addShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override suspend fun deleteShopItem(shopItem: ShopItem) {
        App.db.shopItemDao().deleteShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override suspend fun editShopItem(shopItem: ShopItem) {
        App.db.shopItemDao().editShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override suspend fun getShopItem(shopItemId: Int): ShopItem { //= shopList[shopItemId]
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with ID $shopItemId not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> = Transformations.map(
        App.db.shopItemDao().getAll()
    ) {
        mapper.mapListDBModelToListEntity(it)
    }
}