package com.mjq.account.service;

import com.mjq.account.entity.Menu;

import java.util.List;

public interface MenuService {

    Menu save(Menu menu);

    Menu update(Menu menu);

    void saveBatch(List<Menu> list);
}
