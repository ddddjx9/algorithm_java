package backtrack;

import java.util.HashMap;
import java.util.Map;

public class MapOverlay {
    static Map<Integer, Integer> map = new HashMap<>();
    static int numColors;

    public void findColorMethod(ColoredMap coloredMap, int startNode, int numColors) { // 增加 startNode 参数
        this.numColors = numColors;
        ColorMethod(coloredMap, startNode, new HashMap<>()); // 使用新的 map 来保存当前递归层的着色方案
        map.clear(); // 清除 map 中的记录
    }

    private void ColorMethod(ColoredMap coloredMap, int node, Map<Integer, Integer> tempMap) {
        if (tempMap.size() == coloredMap.getMatrix().length) { // 所有节点都着色了
            // 输出结果
            for (Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
                System.out.println("Node：" + entry.getKey() + " color：" + entry.getValue());
            }
            System.out.println("----------------------------------------");
            return;
        }

        for (int i = 1; i <= numColors; i++) {
            if (checkColor(coloredMap, node, i, tempMap)) { // 使用 tempMap 检查是否合适
                tempMap.put(node, i);
                ColorMethod(coloredMap, getNextUncoloredNode(coloredMap, node, tempMap), new HashMap<>(tempMap));
            }
        }
    }

    public boolean checkColor(ColoredMap coloredMap, int node, int color, Map<Integer, Integer> tempMap) {
        for (int i = 0; i < coloredMap.getMatrix().length; i++) {
            if (coloredMap.getMatrix()[node][i] == 1 && tempMap.getOrDefault(i, -1) == color) {
                return false; // 如果相邻节点颜色相同，则该颜色不合适
            }
        }
        return true;
    }

    // 获取下一个未着色的节点
    private int getNextUncoloredNode(ColoredMap coloredMap, int node, Map<Integer, Integer> tempMap) {
        for (int i = 0; i < coloredMap.getMatrix().length; i++) {
            //找出和该节点相连的节点中没有着色的节点
            if (coloredMap.getMatrix()[node][i] == 1 && !tempMap.containsKey(i)) {
                return i;
            }
        }
        return -1; // 没有找到未着色的节点
    }
}