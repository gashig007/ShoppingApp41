package com.example.helper.domain.useCase

import com.example.helper.domain.model.ShopItem
import com.example.helper.domain.repository.ShopListRepository

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {
    suspend fun addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }
}