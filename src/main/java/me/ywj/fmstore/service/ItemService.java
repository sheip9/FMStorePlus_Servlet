package me.ywj.fmstore.service;

import com.google.gson.Gson;
import me.ywj.fmstore.dao.ItemDao;
import me.ywj.fmstore.dto.ItemDto;
import me.ywj.fmstore.entity.Item;
import me.ywj.fmstore.util.ConvertUtil;
import me.ywj.fmstore.vo.ItemVo;

import java.util.Date;
import java.util.List;

public class ItemService {
    public static void add(ItemDto itemDto) {
        Item item = (Item) ConvertUtil.dtoToEntity(itemDto);
        item.setCrtTime(new Date().getTime());
        ItemDao.insert(item);
    }
    public static void delete(ItemDto itemDto){
        Item item = (Item) ConvertUtil.dtoToEntity(itemDto);
        ItemDao.delete(item);
    }
    public static void edit(ItemDto vluDto, ItemDto condDto){
        Item vluItem = (Item) ConvertUtil.dtoToEntity(vluDto);
        Item condItem = (Item) ConvertUtil.dtoToEntity(condDto);
        ItemDao.update(condItem, vluItem);
    }

    public static List<ItemVo> query() {
        List<Item> getRS = ItemDao.query();
        List<ItemVo> list = ConvertUtil.entityListToVoList(getRS);
        return list;
    }
}
