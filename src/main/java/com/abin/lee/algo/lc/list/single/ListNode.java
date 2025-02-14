package com.abin.lee.algo.lc.list.single;

import com.abin.lee.algo.util.JsonUtil;
import org.junit.Test;

/**
 * 单链表的基本操作
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    private ListNode(int val) {
        this.val = val;
    }

    /**
     * 创建一条单链表
     * // 输入一个数组，转换为一条单链表
     */
    @Test
    public void testSingle1(){
        int[] arr = new int[10];

        for (int i = 0; i <10 ; i++) {
            arr[i] = i;
        }
        System.out.println("arr="+JsonUtil.toJson(arr));
        ListNode listNode = createLinkedList(arr) ;
        System.out.println("listNode="+ JsonUtil.toJson(listNode));
    }

    public static ListNode createLinkedList(int[] arr){
        if(null == arr || arr.length ==0){
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length ; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    /**
     * 单链表的遍历/查找/修改
     * 访问单链表的每一个节点，并打印其值
     */
    @Test
    public void testSingle2(){
        int[] arr = new int[10];

        for (int i = 0; i <10 ; i++) {
            arr[i] = i;
        }
        System.out.println("arr="+JsonUtil.toJson(arr));
        ListNode listNode = createLinkedList(arr) ;
        System.out.println("listNode="+ JsonUtil.toJson(listNode));
        for(ListNode p = listNode; null != p; p = p.next){
            System.out.println("p.val="+ p.val);
        }
    }

    /**
     * 单链表的遍历/查找/修改
     * 访问单链表的每一个节点，并打印其值
     */
    @Test
    public void testSingle3(){
        int[] arr = new int[10];

        for (int i = 0; i <10 ; i++) {
            arr[i] = i;
        }
        System.out.println("arr="+JsonUtil.toJson(arr));
        ListNode listNode = createLinkedList(arr) ;
        System.out.println("listNode="+ JsonUtil.toJson(listNode));
        while( null != listNode){
            System.out.println("listNode.val="+ listNode.val);
            listNode = listNode.next;
        }
    }


    /**
     * 在单链表头部插入新元素
     */
    @Test
    public void testSingle4(){
        int[] arr = new int[10];

        for (int i = 0; i <10 ; i++) {
            arr[i] = i;
        }
        System.out.println("arr="+JsonUtil.toJson(arr));
        ListNode listNode = createLinkedList(arr) ;
        System.out.println("listNode="+ JsonUtil.toJson(listNode));
        ListNode listNodeNew = headInsertLinkedList(listNode);
        System.out.println("listNodeNew="+ JsonUtil.toJson(listNodeNew));

    }

    /**
     * 在单链表头部插入新元素
     * @param arr
     * @return
     */
    public static ListNode headInsertLinkedList(ListNode head){

        ListNode newHead = new ListNode(-1);
        newHead.next = head ;
        head = newHead;
        return head;
    }



    /**
     * 在单链表尾部插入新元素
     */
    @Test
    public void testSingle5(){
        int[] arr = new int[10];

        for (int i = 0; i <10 ; i++) {
            arr[i] = i;
        }
        System.out.println("arr="+JsonUtil.toJson(arr));
        ListNode listNode = createLinkedList(arr) ;
        System.out.println("listNode="+ JsonUtil.toJson(listNode));
        ListNode listNodeNew = headInsertLinkedList(listNode);
        System.out.println("listNodeNew="+ JsonUtil.toJson(listNodeNew));

    }

    /**
     * 在单链表尾部插入新元素
     * @param head
     * @return
     */
    public static ListNode endInsertLinkedList(ListNode head){

        ListNode newHead = new ListNode(-1);
        newHead.next = head ;
        head = newHead;
        return head;
    }
















}
