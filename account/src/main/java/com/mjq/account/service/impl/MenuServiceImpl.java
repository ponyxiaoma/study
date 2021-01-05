package com.mjq.account.service.impl;

import com.mjq.account.entity.Menu;
import com.mjq.account.mapper.MenuMapper;
import com.mjq.account.service.MenuService;
import com.mjq.common.web.util.SnowFlakeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Menu save(Menu menu) {
        long menuId = SnowFlakeUtils.getSnowflakeId();
        menu.setMenuId(menuId);
        menuMapper.insertSelective(menu);
        menu = menuMapper.selectByPrimaryKey(menu.getMenuId());
        return menu;
    }

    @Override
    public void saveBatch(List<Menu> list) {
        list.forEach(m ->
                m.setMenuId(SnowFlakeUtils.getSnowflakeId())
        );
        menuMapper.insertList(list);
    }

    @Override
    public Menu update(Menu menu) {
        menu.setParentMenuId(null);
        menu.setCreateBy(null);
        menu.setCreateTime(null);
        menu.setSystemType(null);
        menuMapper.updateByPrimaryKeySelective(menu);
        return menu;
    }
}
