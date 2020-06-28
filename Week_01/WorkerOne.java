package com.gaolei;

public class WorkerOne {

    public static void main(String[] args) {
        int[] array = new int[]{1,0,0,3,12};
        moveZeroes(array);
    }

    /*(***
    移动零
     */
    public static void moveZeroes(int[] nums) {
         if (nums == null || nums.length <= 0){
             return;
         }
         int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                if (i > j){
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    /****
     * 加一
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0){
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


    /****
     * 删除排序数组中的重复项
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
       if (nums == null || nums.length <= 0){
           return -1;
       }
       int j = 0,i = 1;
       while (i < nums.length){
           if (nums[j] != nums[i]){
               if (i - j > 1){
                   nums[j] = nums[i];
               }
               j++;
           }
           i++;
       }
      return j + 1;
    }

    /*****
     * 旋转数组
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
       if (nums == null || nums.length <= 0){
           return;
       }
       int[] newArray = new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            newArray[(i+k)%nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArray[i];
        }
    }

    /*****
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
       ListNode newListNote = new ListNode(-1);
       ListNode temp = newListNote;
       while (l1.next != null && l2.next != null){
            if (l1.next.val < l2.next.val){
                temp.next = l1.next;
                temp = temp.next;
                l1 = l1.next;
            }else{
                temp.next = l2.next;
                temp = temp.next;
                l2 = l2.next;
            }

       }
        if (l1 != null){
            temp.next = l1.next;
        }
        if (l2 != null){
            temp.next = l2.next;
        }
       return newListNote;
    }

    public static class ListNode {
        int      val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
