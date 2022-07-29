package com.geektech.shoppingapp.domain.useCase

import com.geektech.shoppingapp.domain.model.ShopItem
import com.geektech.shoppingapp.domain.repository.ShopListRepository


class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {
    suspend fun addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }
}