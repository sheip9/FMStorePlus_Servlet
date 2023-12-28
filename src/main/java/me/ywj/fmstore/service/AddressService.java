package me.ywj.fmstore.service;

import lombok.NoArgsConstructor;
import me.ywj.fmstore.dao.ProfileDao;

/**
 * AddressService
 *
 * @author sheip9
 * @since 2023/12/27 19:17
 */
@NoArgsConstructor
public class AddressService {
    private final ProfileDao dao = new ProfileDao();

}
