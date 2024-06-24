package search;

public class BlockSearch {
    public static void main(String[] args) {

        int[] arr = {16, 5, 9, 12, 21, 18,
                32, 23, 37, 26, 45, 34,
                50, 48, 61, 52, 73, 66};

        //创建三个块的对象
        Block b1 = new Block(21, 0, 5);
        Block b2 = new Block(45, 6, 11);
        Block b3 = new Block(73, 12, 17);

        //定义数组用来管理三个块的对象（索引表）
        Block[] blockArr = {b1, b2, b3};

        //定义一个变量用来记录要查找的元素
        int number = 37;

        //调用方法，传递索引表，数组，要查找的元素
        int index = blockSearch(blockArr, arr, number);

        System.out.println(index);
    }

    /**
     * 利用分块查找的原理，查询number的索引
     * <p>
     * 分块查找核心思想：块内无序，块间有序
     * </p>
     * <p>
     * 实现步骤：
     * </p>
     * <p>
     * &nbsp;&nbsp;1.创建数组blockArr存放每一个块对象的信息
     * </p>
     * <p>
     * &nbsp;&nbsp;2.先查找blockArr确定要查找的数据属于哪一块
     * </p>
     * <p>
     * &nbsp;&nbsp;3.再单独遍历这一块数据即可
     * </p>
     *
     * @param blockArr 管理各个块的数组
     * @param arr      待查询的数组
     * @param number   待查询的数据元素
     * @return 返回目标数据的索引
     */
    public static int blockSearch(Block[] blockArr, int[] arr, int number) {
        //1.确定number是在哪一块当中
        int indexBlock = findIndexBlock(blockArr, number);

        if (indexBlock == -1) {
            //表示number不在数组当中
            return -1;
        }

        //2.获取这一块的起始索引和结束索引   --- 30
        // Block b1 = new Block(21,0,5);   ----  0
        // Block b2 = new Block(45,6,11);  ----  1
        // Block b3 = new Block(73,12,17); ----  2
        int startIndex = blockArr[indexBlock].getStartIndex();
        int endIndex = blockArr[indexBlock].getEndIndex();

        //3.遍历
        for (int i = startIndex; i <= endIndex; i++) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 定义一个方法，用来确定number在哪一块当中
     *
     * @param blockArr 管理分块的数组
     * @param number   待查找的数据
     * @return 返回数据应该在的块的索引
     */
    private static int findIndexBlock(Block[] blockArr, int number) { //100
        //从0索引开始遍历blockArr，如果number小于max，那么就表示number是在这一块当中的
        for (int i = 0; i < blockArr.length; i++) {
            if (number <= blockArr[i].getMax()) {
                return i;
            }
        }
        return -1;
    }
}