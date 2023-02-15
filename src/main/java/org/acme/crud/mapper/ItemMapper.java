package org.acme.crud.mapper;

import org.acme.crud.entity.ItemEntity;
import org.acme.crud.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface ItemMapper {

    ItemEntity toEntity(Item item);

    Item toDomain(ItemEntity entity);

}
