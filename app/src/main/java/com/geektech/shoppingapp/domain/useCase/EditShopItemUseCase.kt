package com.geektech.shoppingapp.domain.useCase

import com.geektech.shoppingapp.domain.model.ShopItem
import com.geektech.shoppingapp.domain.repository.ShopListRepository


class EditShopItemUseCase(private val shopEditRepository: ShopListRepository) {
    suspend fun editShopItem(shopItem: ShopItem) {
        shopEditRepository.editShopItem(shopItem)
    }
}