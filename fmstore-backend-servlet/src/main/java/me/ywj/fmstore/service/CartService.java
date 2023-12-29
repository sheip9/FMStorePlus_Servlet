package me.ywj.fmstore.service;

import me.ywj.fmstore.dao.CartDao;
import me.ywj.fmstore.dto.CartDto;
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
    private final CartDao dao = new CartDao();
    public List<CartItemVo> listCart(Long userId){
        return dao.query(userId);
    }
    public boolean add(CartDto cartDto){
        CartItem cartItem = ConvertUtil.objConvert(cartDto, CartItem.class);
        return dao.insert(cartItem) >= 0;
    }
}
