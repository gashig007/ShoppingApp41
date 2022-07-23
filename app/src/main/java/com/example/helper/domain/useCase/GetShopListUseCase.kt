package com.example.helper.domain.useCase

import androidx.lifecycle.LiveData
import com.example.helper.domain.model.ShopItem
import com.example.helper.domain.repository.ShopListRepository

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}