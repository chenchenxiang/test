package com.chenxiang.flyway.model;

import lombok.Data;

/**
 * @author cx
 * @version 1.0
 * @date 2020/8/31 14:12
 */
@Data
public class Node {

  private int value;

  private  Node nextNode;

   public Node (int value){
       this.value=value;
   }


}
