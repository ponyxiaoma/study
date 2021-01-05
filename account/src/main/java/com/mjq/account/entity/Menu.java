package com.mjq.account.entity;

import com.mjq.account.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "`sys_menu`")
public class Menu extends BaseEntity {

    /**
     * menu_id
     */
    @Id
    private Long menuId;

    /**
     * 父级菜单id， 顶级为0
     */
    private Long parentMenuId;

    /**
     * 所属系统
     */
    private Integer systemType;

    /**
     * 1-菜单 2-功能
     */
    private Integer menuType;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单排序
     */
    private Integer sort;

    /**
     * 页面路由
     */
    private String router;

}
