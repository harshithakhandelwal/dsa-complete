package org.example.StacksAndQueues;

class queue {

   private final int[] arr;
   private int start,end,currSize,maxSize;

   public queue(){
     arr = new int[16];
     start = -1;
     end = -1;
     currSize = 0;
   }

   public queue(int maxSize){
     arr = new int[maxSize];
     start = -1;
     end = -1;
     currSize = 0;
     this.maxSize = maxSize;
   }

   public void push(int element){
     if(currSize == maxSize) {
       System.out.println("Queue is full");
       System.exit(1);
     }
     if(end == -1){
       start = 0;
       end = 0;
       arr[end] = element;
     }
     else {
       end = (end + 1)%maxSize;
       arr[end] = element;
     }
       currSize++;
     }

   public int pop() {
     if(start == -1) {
       System.out.println("Queue is empty");
       System.exit(1);
     }
     int element = arr[start];
     if(currSize == 1){
       start = -1;
       end = -1;
     }
     else
       start = start+1;
     currSize--;
     return element;
   }

   public int top(){
     if(start == -1) {
       System.out.println("Queue is empty");
       System.exit(1);
     }
     return arr[start];
   }

   public int size(){
     return currSize;
   }


}
