package com.geektech.shoppingapp.domain.useCase

import androidx.lifecycle.LiveData
import com.geektech.shoppingapp.domain.model.ShopItem
import com.geektech.shoppingapp.domain.repository.ShopListRepository

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}