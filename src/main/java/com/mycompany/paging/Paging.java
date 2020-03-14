/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paging;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author hunglv
 */
@Getter
@Setter
@AllArgsConstructor
public class Paging {

    private List<Integer> listPage;
    private Integer pageCurrent;
    private Integer totalPage;
    private Integer begin;
    private Integer end;
    private Integer step;
    private Integer numPageShow;

    public Paging() {
        totalPage = 10;
        step = 2; // step must less than 5
        pageCurrent = 1;
        numPageShow = 5;
    }

    private void getListPageShow(int start, int end) {
        listPage = new ArrayList<>();
        if (start >= 1 && end <= totalPage) {
            for (int i = start; i <= end; i++) {
                listPage.add(i);
            }
            return;
        }
        if (end > totalPage) {
            for (int i = totalPage - numPageShow + 1; i <= totalPage; i++) {
                listPage.add(i);
            }
            return;
        }
        if (start < 1) {
            for (int i = 1; i <= numPageShow; i++) {
                listPage.add(i);
            }
        }
    }

    public void startShowPage() {
        getListPageShow(begin = 1, end = 5);
    }

    public void previous() {
        setPageCurrent(pageCurrent - 1);
        getListPageShow(pageCurrent - step, pageCurrent + step);
    }

    public void next() {
        setPageCurrent(pageCurrent + 1);
        getListPageShow(pageCurrent - step, pageCurrent + step);
    }

    public void currentSelected(int currentPage) {
        setPageCurrent(currentPage);
        getListPageShow(pageCurrent - step, pageCurrent + step);
    }

}
