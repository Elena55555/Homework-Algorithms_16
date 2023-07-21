package com.sky.HW_16_algorithms;
import java.util.Arrays;
public class StringListImpl implements StringList {
    private  String[] storage;
//    private  int[] numbers;
//
//    private  int[] numbers2;
    private int size;
    public StringListImpl() {
        storage = new String[10];
//        numbers =    new int[7];
//        numbers2 =    new int[7];
    }
    public StringListImpl(int initSize) {
        storage = new String[initSize];
    }
    @Override
    public String add1(String item) {
//        validateSize();

        grow2 ();

        validateItem(item);

        storage[size++] = item;

        return item;
    }

   @Override

   public String add2(int index, String item) {
//        validateSize();

       grow2 ();

        validateItem(item);

        validateIndex(index);

        if (index == size) {

            storage[size++] = item;

            return item;
        }

        System.arraycopy(storage, index, storage, index + 1, size - index);

        storage[index] = item;

        size++;

        return item;

    }
    /*storage[size] = item;*/
    /*size++;*/
    /*Size существует для того, чтобы избежать проверки всего массива, только элементов, которые были сохранены.*/


    @Override

    public String set(int index, String item) {


        validateIndex(index);

        validateItem(item);

        storage[index] = item;  /*  добавим элементы по индексу */

        return item;

    }



    @Override

    public String remove1(String item) {

        validateItem(item);

        int index = indexOf(item);

        if (index == -1) {

            throw new ItemNotFoundException();
        }



       if (index != size) {
//
//            storage[size--] = null; /*   обнуляем если  индекс равен размеру массива поскольку индекс должен быть на единичку меньше чем размер массива  */
//
//            return item;

            System.arraycopy(storage, index + 1, storage, index, size - index);

            /*  вместо этого блока можем сделать  */

            /*  if (index != size) {  */

            /*  System.arraycopy(storage,index+1,storage,index,size-index);  */

        }

        size--;

        return item;
    }


    @Override

    public String remove2(int index) {

        validateIndex(index);

        if (index == -1) {

            throw new ItemNotFoundException();

        }

        String item = storage[index];

        if (index != size) {
//
//            storage[size--] = null; /*   обнуляем если  индекс равен размеру массива поскольку индекс должен быть на единичку меньше чем размер массива  */
//
//            return item;

            System.arraycopy(storage,index+1,storage,index,size-index);
            /*  вместо этого блока можем сделать  */
            /*  if (index != size) {  */
            /*  System.arraycopy(storage,index+1,storage,index,size-index);  */
        }

        size--;

        return item;
    }

    @Override


    public boolean contains(String item) {
        return indexOf(item)!=-1;
    }

    @Override

    public int indexOf(String item) {

        for (int i = 0; i < size; i++) {

            if(storage[i].equals(item)){ /*  если найден элемент*/

                return i; /*   возвратим его индекс*/
            }
        }

        return -1;
    }

    @Override

    public int lastIndexOf(String item) {


        for (int i = size-1 ; i >=0 ; i--) {

            if(storage[i].equals(item)){ /*  если найден элемент*/

                return i; /*   возвратим его индекс*/
            }
        }

        return -1;
    }

    @Override

    public String get(int index) {
//        validateIndex(index);

        return storage[index];
    }

    @Override

    public boolean equals(StringList otherList) {

        return Arrays.equals(this.toArray(),  otherList.toArray() ) ;
    }

    @Override

    public int size() {
        return 0;
    }

    @Override

    public boolean isEmpty() {

        return size == 0;

    }

    @Override

    public void clear() {

        size = 0;
    }

    @Override

    public  String[] toArray() {

        return Arrays.copyOf(storage,size); /* воэвращаем копию нашего массива по размеру сайз без пустых ячеек*/
    }
//    сортировка вставкой.
//
//    Идея данного алгоритма состоит в том, что на каждом шаге цикла вычисляется определенная позиция,
//    а все элементы слева сдвигаются на один вправо до тех пор, пока не будет найдена
//    корректная позиция для найденного элемента. Затем этот элемент устанавливается в найденную позицию.


    @Override


    public void sort(Integer[]arr) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = 1;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1]; // все элементы слева сдвигаются на один вправо до тех пор

                j--;

                arr[j] = temp;


                //элемент устанавливается в найденную позицию

            }
        }
    }


        //чтобы изменить на рекурсивную создадим несколько дополнительных   методов;

    // и исправим данный метод на


    @Override


    public void sort2(Integer[]arr) {


        quickSort(arr, 0, arr.length - 1);

    }



    @Override


     public void quickSort(Integer [] arr, int begin, int end){

        if(begin<end){

            int partitionIndex=partition(arr,begin,end);

            quickSort(arr,begin,partitionIndex-1);

            quickSort(arr,partitionIndex + 1, end);
        }
    }


     @Override


    public int partition(Integer[] arr, int begin, int end) {


        int pivot=arr[end];

        int i = (begin-1);

        for (int j=begin; j< end; j++){

            if (arr[j] <= pivot){

                i++;

                swapElements(arr,i,j);

            }
        }

        swapElements(arr, i + 1, end);

        return i + 1;
     }

     @Override

    public void swapElements(Integer[] arr, int i1, int i2) {
        int temp = arr[i1];
       arr[i1]=arr[i2];
        arr[i2]=temp;
    }
    @Override
    public void grow(){
        storage =Arrays.copyOf(storage,size/2);
    }
    @Override

    public void printArray() {
    }
//    @Override
//
//    public void printArray() {
//        for (int i : numbers) {
//            System.out.println(i);
//        }
//    }
    private   void validateItem(String item){
        if(item==null){
            throw new NullItemException();
        }
    }
//    private void validateSize(){
//
//        if(size==storage.length){
//
//            throw new  NoFreeCellsArrayIsFullException();
//
//        }
//
//    }
    @Override
    public void grow2 (){
        if(size==storage.length){
            grow();
        }

    }

    private void validateIndex(int index){
        if(index<0|| index> size){
            throw new IndexValueIsInvalidException();
        }
    }



}

