package com.example.helper.utils

import com.example.helper.data.model.ShopItemDBModel
import com.example.helper.domain.model.ShopItem

class ShopListMapper {

    fun mapEntityToDBModel(shopItem: ShopItem) = ShopItemDBModel(
        id = shopItem.id,
        name = shopItem.name,
        count = shopItem.count,
        enabled = shopItem.enabled
    )

    fun mapDBModelToEntity(shopItemDBModel: ShopItemDBModel) = ShopItem(
        id = shopItemDBModel.id,
        name = shopItemDBModel.name,
        count = shopItemDBModel.count,
        enabled = shopItemDBModel.enabled
    )

    fun mapListDBModelToListEntity(shopListDBModel: List<ShopItemDBModel>) = shopListDBModel.map {
        mapDBModelToEntity(it)
    }
}