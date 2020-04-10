package com.chameapp.giphyclientcleanbylayers.model.mapper;

import com.chameapp.domain.model.DomainItem;
import com.chameapp.giphyclientcleanbylayers.di.annotations.PerActivity;
import com.chameapp.giphyclientcleanbylayers.model.ItemModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.inject.Inject;

@PerActivity
public class ItemModelDataMapper {

  @Inject
  public ItemModelDataMapper() {}

  public ItemModel transform(DomainItem item) {
    if (item == null) {
      throw new IllegalArgumentException("Cannot transform a null value");
    }
    final ItemModel itemModel = new ItemModel(Integer.getInteger(item.getId()));
    itemModel.setCoverUrl(item.getContentUrl());
    itemModel.setFullName(item.getUsername());
    itemModel.setEmail(item.getType());
    itemModel.setDescription(item.getSource());
    itemModel.setFollowers(Integer.getInteger(item.getRating()));

    return itemModel;
  }

  public Collection<ItemModel> transform(Collection<DomainItem> itemsCollection) {
    Collection<ItemModel> itemModelsCollection;

    if (itemsCollection != null && !itemsCollection.isEmpty()) {
      itemModelsCollection = new ArrayList<>();
      for (DomainItem user : itemsCollection) {
        itemModelsCollection.add(transform(user));
      }
    } else {
      itemModelsCollection = Collections.emptyList();
    }

    return itemModelsCollection;
  }
}
