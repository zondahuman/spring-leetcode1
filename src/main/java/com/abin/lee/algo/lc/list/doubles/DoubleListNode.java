package com.abin.lee.algo.lc.list.doubles;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

public class DoubleListNode {
    int val;
    DoubleListNode next, prev;

    public DoubleListNode() {
    }

    DoubleListNode(int val){
        this.val = val;
    }

    // for 循环迭代创建双链表
    @Test
    public void test1(){
        DoubleListNode head = createDoubleListNode(new int[]{1, 2, 3, 4, 5, 6,7,8,9});
//        System.out.println("head="+ JsonUtil.toJson(head));
    }

    // 双链表的遍历/查找/修改
    @Test
    public void test2(){
        DoubleListNode head = createDoubleListNode(new int[]{1, 2, 3, 4, 5, 6,7,8,9});
//        DoubleListNode cur = head ;
//        System.out.println("head="+ JsonUtil.toJson(head));
        for(DoubleListNode cur = head; null != cur ; cur=cur.next){
            System.out.println("forward="+cur.val);
        }

    }

    // 双链表的遍历/查找/修改
    @Test
    public void test3(){
        DoubleListNode head = createDoubleListNode(new int[]{1, 2, 3, 4, 5, 6,7,8,9});
        DoubleListNode tail  = null;
//        DoubleListNode cur = head ;
//        System.out.println("head="+ JsonUtil.toJson(head));
        for(DoubleListNode cur = head; null != cur ; cur=cur.next){
            System.out.println("forward="+cur.val);
            tail = cur;
        }
        System.out.println("-----------------------------------------------------");
        for(DoubleListNode cur = tail; null != cur ; cur=cur.prev){
            System.out.println("previous="+cur.val);
        }
    }

    // 在双链表头部插入新元素
    @Test
    public void test4(){
        DoubleListNode head = createDoubleListNode(new int[]{1, 2, 3, 4, 5, 6,7,8,9});
        DoubleListNode tail  = null;
//        DoubleListNode cur = head ;
//        System.out.println("head="+ JsonUtil.toJson(head));
        for(DoubleListNode cur = head; null != cur ; cur=cur.next){
            System.out.println("forward="+cur.val);
            tail = cur;
        }
        DoubleListNode newNode = new DoubleListNode(777);
        newNode.next = head ;
        head.prev = newNode;
        head = newNode;
        System.out.println("-----------------------------------------------------");
        for(DoubleListNode cur = head; null != cur ; cur=cur.next){
            System.out.println("middle="+cur.val);
            tail = cur;
        }
        System.out.println("-----------------------------------------------------");
        for(DoubleListNode cur = tail; null != cur ; cur=cur.prev){
            System.out.println("previous="+cur.val);
        }
    }



    // 在双链表尾部插入新元素
    @Test
    public void test5(){
        DoubleListNode head = createDoubleListNode(new int[]{1, 2, 3, 4, 5, 6,7,8,9});
        DoubleListNode tail  = null;
//        DoubleListNode cur = head ;
//        System.out.println("head="+ JsonUtil.toJson(head));
        for(DoubleListNode cur = head; null != cur ; cur=cur.next){
            System.out.println("forward="+cur.val);
            tail = cur;
        }

        DoubleListNode newNode = new DoubleListNode(777);
        tail.next = newNode ;
        newNode.prev = tail;
//        head = tail;
        System.out.println("-----------------------------------------------------");
        for(DoubleListNode cur = head; null != cur ; cur=cur.next){
            System.out.println("middle="+cur.val);
            tail = cur;
        }
        System.out.println("-----------------------------------------------------");
        for(DoubleListNode cur = tail; null != cur ; cur=cur.prev){
            System.out.println("previous="+cur.val);
        }
    }


    // 在双链表中间插入新元素
    @Test
    public void test6(){
        DoubleListNode head = createDoubleListNode(new int[]{1, 2, 3, 4, 5, 6,7,8,9});
        DoubleListNode tail  = null;
        DoubleListNode temp = head ;
//        System.out.println("head="+ JsonUtil.toJson(head));
//        for(DoubleListNode cur = head; null != cur ; cur=cur.next){
//            System.out.println("forward="+cur.val);
//            tail = cur;
//        }
        for (int i = 0; i <2 ; i++) {
            temp = temp.next ;
        }
        DoubleListNode newNode = new DoubleListNode(777);
        newNode.next = temp.next ;
        newNode.prev = temp;

        temp.next = newNode ;
        temp.next.prev =newNode;

//        head = tail;
        System.out.println("-----------------------------------------------------");
        for(DoubleListNode cur = head; null != cur ; cur=cur.next){
            System.out.println("middle="+cur.val);
            tail = cur;
        }
        System.out.println("-----------------------------------------------------");
        for(DoubleListNode cur = tail; null != cur ; cur=cur.prev){
            System.out.println("previous="+cur.val);
        }
    }



    // 在双链表中删除一个节点
    @Test
    public void test7(){
        DoubleListNode head = createDoubleListNode(new int[]{1, 2, 3, 4, 5, 6,7,8,9});
        DoubleListNode tail  = null;
        DoubleListNode temp = head ;
//        System.out.println("head="+ JsonUtil.toJson(head));
//        for(DoubleListNode cur = head; null != cur ; cur=cur.next){
//            System.out.println("forward="+cur.val);
//            tail = cur;
//        }
        for (int i = 0; i <2 ; i++) {
            temp = temp.next ;
        }
        DoubleListNode toDelete = temp.next ;

        temp.next = toDelete.next ;
        toDelete.next.prev =temp;
        toDelete.next =  null;
        toDelete.prev =  null;
//        head = tail;
        System.out.println("-----------------------------------------------------");
        for(DoubleListNode cur = head; null != cur ; cur=cur.next){
            System.out.println("middle="+cur.val);
            tail = cur;
        }
        System.out.println("-----------------------------------------------------");
        for(DoubleListNode cur = tail; null != cur ; cur=cur.prev){
            System.out.println("previous="+cur.val);
        }
    }


    /**
     * // for 循环迭代创建双链表
     * @param arr
     * @return
     */
    DoubleListNode createDoubleListNode(int[] arr){
        if(null == arr || arr.length == 0){
            return null;
        }
        DoubleListNode head = new DoubleListNode(arr[0]);
        DoubleListNode cur = head ;
        for (int i = 1; i <arr.length ; i++) {
            DoubleListNode newNode = new DoubleListNode(arr[i]);
            cur.next = newNode ;
            newNode.prev = cur;
            cur = cur.next;
        }
        return head ;
    }




    // 在双链表头部删除元素
    @Test
    public void test8(){
        DoubleListNode head = createDoubleListNode(new int[]{1, 2, 3, 4, 5, 6,7,8,9});
        DoubleListNode tail  = null;
        DoubleListNode temp = head ;
//        System.out.println("head="+ JsonUtil.toJson(head));
//        for(DoubleListNode cur = head; null != cur ; cur=cur.next){
//            System.out.println("forward="+cur.val);
//            tail = cur;
//        }
//        for (int i = 0; i <2 ; i++) {
//            temp = temp.next ;
//        }
        DoubleListNode toDelete  = head;
        temp = temp.next ;
        temp.prev = null ;
        head.next = null;

        head = temp;
//        head = tail;
        System.out.println("-----------------------------------------------------");
        for(DoubleListNode cur = head; null != cur ; cur=cur.next){
            System.out.println("middle="+cur.val);
            tail = cur;
        }
        System.out.println("-----------------------------------------------------");
        for(DoubleListNode cur = tail; null != cur ; cur=cur.prev){
            System.out.println("previous="+cur.val);
        }
    }


    // 在双链表尾部删除元素
    @Test
    public void test9(){
        DoubleListNode head = createDoubleListNode(new int[]{1, 2, 3, 4, 5, 6,7,8,9});
        DoubleListNode tail  = null;
        DoubleListNode temp = head ;
//        System.out.println("head="+ JsonUtil.toJson(head));
//        for(DoubleListNode cur = head; null != cur ; cur=cur.next){
//            System.out.println("forward="+cur.val);
//            tail = cur;
//        }
        while (temp.next != null) {
            tail = temp;
            temp = temp.next ;
        }
        DoubleListNode toDelete  = head;
        temp.prev = null ;
        tail.next = null;

//        head = tail;
        System.out.println("-----------------------------------------------------");
        for(DoubleListNode cur = head; null != cur ; cur=cur.next){
            System.out.println("middle="+cur.val);
            tail = cur;
        }
        System.out.println("-----------------------------------------------------");
        for(DoubleListNode cur = tail; null != cur ; cur=cur.prev){
            System.out.println("previous="+cur.val);
        }
    }





}
