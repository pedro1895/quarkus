package org.acme.crud.service;

import org.acme.crud.entity.ItemEntity;
import org.acme.crud.mapper.ItemMapper;
import org.acme.crud.model.Item;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;


@ApplicationScoped
public class ItemService {

    private final ItemMapper itemMapper;

    public ItemService(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public List<Item> get() {
        List<ItemEntity> listAll = ItemEntity.findAll().list();
        return listAll.stream().map(itemMapper::toDomain).collect(Collectors.toList());
    }

    public Item get(Long itemId) {
        return itemMapper.toDomain(ItemEntity.findById(itemId));
    }

    @Transactional
    public void create(Item item) {
        ItemEntity ie = itemMapper.toEntity(item);
        ie.persist();
    }

    @Transactional
    public void update(Long itemId, Item item) {
        ItemEntity entity = ItemEntity.findById(itemId);
        entity.setName(item.getName());
        entity.setCount(item.getCount());
        entity.setStatus(item.getStatus());
        entity.persist();
    }

    @Transactional
    public void delete(Long id) {
        ItemEntity.deleteById(id);
    }

}