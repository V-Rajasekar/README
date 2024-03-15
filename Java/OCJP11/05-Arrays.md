# 05 Arrays

```java
    int [] arr1 = {5, 10, 15};
    int [] arr2 = {'A', 'B'};
    arr1 = arr2;
    System.out.println(arr1.length + arr2.length); // prints 4

    int[] arr1 = { 10, 100, 1000 }; //Line n1
        char[] arr2 = { 'x', 'y', 'z' }; //Line n2
        arr1 = arr2; // Line n3 // compilation error  compilation error as char [] is not compatible with int []
    String arr1 [], arr2, arr3 = null; //Line n1 arr1 is String[], and arr2, arr3 are String. 
    arr2 = arr3 = arr1; // compilation error.

    byte [] arr = new byte[0]; // arr refers array object of size 0
    System.out.println(arr[0]);// index 0 not available, so ArrayIndexOutOfBoundsException is thrown at runtime.

    short[] arr;
    arr = new short[3]; // You can create an array object in the same stmt or next stmt.

    double [] arr = new int[2]; //Line n1 compile error.

    //prints 40, 20, 40 here left operand is evaluated first, so arr[i++] next arr[++i]
    int [] arr = {10, 20, 30}; //Line n1
        int i = 0;
        arr[i++] = arr[++i] = 40; //Line n2
        for(var x : arr) //Line n3
            System.out.println(x);
    }

//Assignment left to right x = y = z <-3 prints 9
     var x = new int[]{1};
        var y = new int[]{2};
        var z = new int[]{3};
        System.out.println((x = y = z)[0] + y[0] + z[0]);
```        