package com.hash;



public class HashTable {
    public HashItem[] hashItemsArrays; //哈希数组
    public int tableSize; //哈希表大小
    public int currentSize; //当前哈希表大小

   public HashTable(int tableSize){ //初始化数值
       this.tableSize = tableSize;
       this.currentSize = 0; //当前哈希表大小是0 在插入的时候会增加大小
       this.hashItemsArrays = new HashItem[tableSize]; //初始化哈希表大小
       for (int i = 0; i < hashItemsArrays.length; i++) hashItemsArrays[i] = new HashItem(0);//初始化哈希数组
   }

    //构造哈希函数使用key % 哈希表大小
    private int hashFun(int key) {
        return key % tableSize;
    }

   public int find(int key){
   int index = hashFun(key);
    int i = index;
    while (hashItemsArrays[i].flag == 1 && hashItemsArrays[i].key != key){
        i = hashFun(i + 1);
        if (i==index) return -tableSize; //遍历完整个哈希表

        if(hashItemsArrays[i].flag ==1){    //找到关键字key
            return i;   //返回下标
        }else {
            return -i;  //返回空闲的数组下标数组
        }
    }
       return 0;
   }


    public void insert(int key) throws Exception {
       int index = find(key);
       if (index == 0 && hashItemsArrays[index].flag == 1){
           throw new Exception("关键字已存在");
       }else if(index != -tableSize){
           //没有找到key 在返回值绝对值的位置放入改key
           hashItemsArrays[-index].key = key;
           hashItemsArrays[-index].flag = 1;
           currentSize++;
        }else {
           throw new Exception("hashtable is full!");
       }
    }

    public void list(){
       for (int i =0;i<hashItemsArrays.length;i++ ){
           if (hashItemsArrays[i].flag == 1){
               System.out.println(" i = " + i + " key = " + hashItemsArrays[i].key);
           }
       }
    }

    public static void main(String[] args) throws Exception {
         HashTable hashTable = new HashTable(10);
        hashTable.insert(1);
        hashTable.insert(50);
        System.out.println(hashTable.find(50));
    }
}
