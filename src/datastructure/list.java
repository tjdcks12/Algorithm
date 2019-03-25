package datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class list {

    public static void main(String[] args){
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(234);
        arrayList.add(1, 345);
        arrayList.remove(1);
    }



    public static class ArrayList{
        private Object data;
        private int size;

        private Object[] arr = new Object[100];


        public boolean add(Object obj) {
            if(this.size < arr.length-1) {
                arr[this.size] = obj;
                this.size++;
                return true;
            }
            return false;
        }

        public boolean add(int index, Object obj) {
            if(this.size < arr.length-1) {

                for(int i = this.size-1; i>=index; i--){
                    arr[i+1] = arr[i];
                }
                arr[index] = obj;
                this.size++;

                return true;
            }
            return false;
        }

        public boolean remove(int index){
            if(this.size > 0) {
                for (int i = index + 1; i < arr.length; i++) {
                    arr[i - 1] = arr[i];
                }
                return true;
            }
            return false;

        }

    }


}
