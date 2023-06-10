package basic.list;

/**
 * @author xushichao
 * @date 2022/11/10 10:38
 * @desc   Java Program to Create a Dynamic Array
 */
public class DynamicArray {

    private int count;
    private int[] arr;

    public DynamicArray(int length){
        arr = new int[length];
    }

    public void printArray(){
        for(int i=0; i<count; i++){
            System.out.println(arr[i]+" ");
        }
    }

    public void insert(int element) {
        if(arr.length == count) {
            int newArr[] = new int[2 * count];
            for(int i=0; i<count; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[count++] = element;
    }


    public static void main(String[] args) {

        // Creating object of Array(user-defined) class
        DynamicArray numbers = new DynamicArray(3);

        // Adding elements more than size specified above
        // to the array to illustrate dynamic nature
        // using the insert() method

        // Custom input elements
        numbers.insert(10);
        numbers.insert(30);
        numbers.insert(40);
        numbers.insert(50);

        // Calling the printArray() method to print
        // new array been dynamically created
        numbers.printArray();

    }

}
