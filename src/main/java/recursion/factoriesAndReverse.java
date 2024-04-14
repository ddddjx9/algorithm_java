package recursion;

import java.util.Scanner;

public class factoriesAndReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*//1. 测试递归求解阶乘
        int n = sc.nextInt();
        System.out.println(factorial(n));*/

        /*//2. 测试递归反转字符串
        String str = sc.next();
        reverseString(0, str);*/

        /*//3. 测试递归：二分查找
        //二分查找的前提是，待查找的数组必须是有序的，否则查找结果不准
        int[] arr = {4, 3, 9, 8, 6, 7};
        Arrays.sort(arr);
        System.out.println(binarySearch(arr, 9, 0, arr.length - 1));*/

        /*//4. 测试递归：冒泡排序
        int[] arr = {8, 9, 5, 3, 7, 6, 2, 1, 4};
        bubbleSort(arr, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }*/

        //5. 测试递归：插入排序
        int[] arr = {1, 9, 4, 6, 8, 5, 7, 3, 2, 0};
        insertSort1(arr, 0);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static long factorial(int n) {
        //递归，寻找出口
        //发现表达式的某种规律
        //f(n)=f(n-1)*n
        //f(n-1)=f(n-2)*n-1
        //......
        //f(2)=f(1)*2
        //f(1)=1;
        if (n == 1) {
            return 1;
        }
        return factorial(n - 1) * n;
    }

    public static void reverseString(int end, String str) {
        //确定反向：正向递归
        //这样出来的时候就是反向
        //递归出口为：-1
        if (end == str.length()) {
            return;
        }
        reverseString(end + 1, str);
        System.out.print(str.charAt(end));
    }

    //要干什么？
    //要在一个数组中寻找一个目标数字，并返回它的具体索引
    public static int binarySearch(int[] arr, int target, int i, int j) {
        //这是一个重复的过程
        //每次等到最高处和最低处的变量发生改变之后，我们需要再来一次这个过程
        if (i > j) {
            return -1;
        }
        int mid = (i + j) / 2;
        if (target < arr[mid]) {
            //return binarySearch(arr, target, i, mid - 1);
            j = mid - 1;
        } else if (target > arr[mid]) {
            //return binarySearch(arr, target, mid + 1, j);
            i = mid + 1;
        } else {
            return mid;
        }
        return binarySearch(arr, target, i, j);
    }

    public static void bubbleSort(int[] arr, int end) {
        //确定方向：从小到大进行排序，每一次排序后，都会将本次最大值放在数组的最后面
        //所以，每一次结束后，我们的范围都会缩小1，当未排序的的最后的索引为1时，说明
        //已经排序完毕，结束递归
        if (end == 1) {
            return;
        }
        for (int i = 0; i < end; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        bubbleSort(arr, end - 1);
    }

    public static void insertSort1(int[] arr, int low) {
        //插入排序，定义一个指针，指针前面的位置已经有序
        //指针后面的位置无序，需要排序
        //一般我们认为0索引之后的元素都是无序的，然后进行排序
        //在有序的序列里面，只要找到第一个比自己小的元素，那么这个元素的下一个位置
        //就是应该插入的位置
        //确定递归应该结束的出口
        //从第一个元素开始进行有序序列的扩散，所以这个序列的最末尾的索引会越来越大
        //所以，我们确定递归的结束条件为：指针索引为arr.length
        if (low == arr.length) {
            return;
        }
        //1 2 4 8 9 5
        //1 2 4 8 8 5
        //重复交换会导致问题
        //必须另外定义一个新的临时变量用于存储当前指针所指向的位置的元素
        int target = arr[low];
        int j;
        for (j = low - 1; j >= 0; j--) {
            if (arr[j] > target) {
                //后移一位，空出插入位置
                arr[j + 1] = arr[j];
            } else {
                arr[j + 1] = target;
                break;
            }
        }
        if (j == -1) {
            arr[j + 1] = target;
        }

        insertSort1(arr, low + 1);
    }

    public static void insertSort2(int[] arr, int low) {
        //如果从未分界区域的前一个元素开始进行比较，比当前排序元素大，交换位置
        //直到不比当前待排序元素大为止
        if (low == arr.length) {
            return;
        }
        for (int i = low - 1; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
            } else {
                break;
            }
        }
        insertSort2(arr, low + 1);
    }
}
