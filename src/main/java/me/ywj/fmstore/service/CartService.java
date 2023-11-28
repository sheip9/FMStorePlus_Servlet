package me.ywj.fmstore.service;

import me.ywj.fmstore.dao.CartDao;
import me.ywj.fmstore.pojo.CartItem;
import me.ywj.fmstore.util.ConvertUtil;
import me.ywj.fmstore.vo.CartItemVo;

import java.util.ArrayList;
import java.util.List;

/**
 * CartService
 *
 * @author sheip9
 * @since 2023/11/6 8:40
 */
public class CartService {
    public static List<CartItemVo> listCart(Long userId){
        ArrayList<CartItem> list = CartDao.query(userId);
        return ConvertUtil.entityListToVoList(list, CartItemVo.class);
    }
}
