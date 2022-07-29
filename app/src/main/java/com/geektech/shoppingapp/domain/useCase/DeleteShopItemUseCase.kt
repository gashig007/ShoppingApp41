package com.geektech.shoppingapp.domain.useCase

import com.geektech.shoppingapp.domain.model.ShopItem
import com.geektech.shoppingapp.domain.repository.ShopListRepository


class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {
    suspend fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}