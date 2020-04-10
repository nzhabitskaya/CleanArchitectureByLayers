package com.chameapp.data.entities.mapper;

import com.chameapp.data.entities.pojos.Item;
import com.chameapp.data.entities.pojos.Trends;
import com.chameapp.domain.model.DomainItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ItemEntityDataMapper {

    @Inject
    ItemEntityDataMapper() {}

    public DomainItem transformItem(Item itemEntity) {
        DomainItem item = null;
        if (itemEntity != null) {
            item = new DomainItem();
            item.setType(itemEntity.getType());
            item.setId(itemEntity.getId());
            item.setUsername(itemEntity.getUsername());
            item.setSource(itemEntity.getSource());
            item.setRating(itemEntity.getRating());
            item.setContentUrl(itemEntity.getContentUrl());
        }
        return item;
    }

    public List<DomainItem> transformTrends(Trends trends) {
        final List<DomainItem> itemList = new ArrayList<>(20);
        for (Item itemEntity : trends.getItems()) {
            final DomainItem item = transformItem(itemEntity);
            if (item != null) {
                itemList.add(item);
            }
        }
        return itemList;
    }
}
