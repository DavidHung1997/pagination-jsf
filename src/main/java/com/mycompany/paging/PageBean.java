/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paging;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author hunglv
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ManagedBean
@ViewScoped
public class PageBean {

    List<Integer> listDemo;
    private Integer numPageShow;
    private Paging paging;

    @PostConstruct
    public void init() {
        listDemo = new ArrayList<>();
        paging = new Paging();

        paging.startShowPage();
        getListFromDatabase(paging.getPageCurrent(), 5);
    }

    public void getListFromDatabase(int pageNum, int pageSize) {
        listDemo = new ArrayList<>();
        for (int i = 0; i <= pageNum; i++) {
            listDemo.add(i);
        }
    }

    public void previousPage() {
        paging.previous();
        getListFromDatabase(paging.getPageCurrent() - 1, 5);
    }

    public void nextPage() {
        paging.next();
        getListFromDatabase(paging.getPageCurrent() - 1, 5);
    }

    public void pageCurrentSelected(int pageCurrent) {
        paging.currentSelected(pageCurrent);
        getListFromDatabase(paging.getPageCurrent() - 1, 5);
    }

}
