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
import javax.faces.bean.ManagedProperty;
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
    List<Integer> listPage;
    Integer pageCurrent;
    Integer totalPage;
    Integer begin;
    Integer end;
    Integer step;
    Integer numPageShow;
    
    @PostConstruct
    public void init(){
        listDemo = new ArrayList<>();
        
        totalPage = 10;
        step = 2; // step must less than 5
        pageCurrent = 1;
        numPageShow = 5;
         
        getListPage(begin=1, end=numPageShow);
        
        getListFromDatabase(pageCurrent, 5);
       
    }
    
    
    public void getListFromDatabase(int pageNum, int pageSize){
        listDemo = new ArrayList<>();
        for (int i = 0; i <= pageNum; i++) {
            listDemo.add(i);
        }
    }
    
    public void getListPage(int start, int end){
        listPage = new ArrayList<>();
        if(start >= 1 && end <= totalPage){
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
    
    public void previousPage(){
        pageCurrent--;
        getListPage(pageCurrent - step, pageCurrent + step);
        getListFromDatabase(pageCurrent - 1, 5);
    }
    
     public void nextPage(){
        pageCurrent++;
        getListPage(pageCurrent - step, pageCurrent + step);
         getListFromDatabase(pageCurrent - 1, 5);
    }
     
     public void pageCurrentSelected(int pageCurrent){
         this.pageCurrent = pageCurrent;
         getListPage(pageCurrent - step, pageCurrent + step);
          getListFromDatabase(pageCurrent - 1, 5);
     }
   
}
