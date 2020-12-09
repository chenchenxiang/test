package com.chenxiang.flyway.service;

import com.chenxiang.flyway.model.Node;
import org.springframework.stereotype.Component;

/**
 * @author cx
 * @version 1.0
 * @date 2020/8/25 13:39
 */
@Component
public class TestService {




    public String test(){



        return  "chenxiang";

    }


    public String test1(String name){

        return  "arthas" ;

    }

    //数组转链表
    public Node  trance(int[] arr){
      int length=arr.length;
      //声明头结点,假设他的指针指向的内存地址是400
      Node root=new Node(arr[0]);
      //此时other节点也是指向400
      Node other=root;
      for(int i=1 ; i<length;i++){
          //此时temp节点指向的内存地址是401
         Node temp=new Node(arr[i]);
         //让400的节点指向401节点
         other.setNextNode(temp);
         //重新让other节点指向401节点
         other=temp;

      }

      return  root ;

    }

    static{

      System.out.println("55555");

    }








}
