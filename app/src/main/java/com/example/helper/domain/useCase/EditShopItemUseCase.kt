package com.example.helper.domain.useCase

import com.example.helper.domain.model.ShopItem
import com.example.helper.domain.repository.ShopListRepository

class EditShopItemUseCase(private val shopEditRepository: ShopListRepository) {
    suspend fun editShopItem(shopItem: ShopItem) {
        shopEditRepository.editShopItem(shopItem)
    }
}