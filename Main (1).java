import java.io.*;
import java.util.*;

public class Main {
    private static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine().trim();
        huffman_coding(s);
    }

    public static void huffman_coding(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        Integer value;
        for (int i = 0; i < s.length(); i++) {
            value = map.get(s.charAt(i));
            if (value == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), value + 1);
            }
        }
        PriorityQueue<HuffmanNode> hfmn = new PriorityQueue<>(map.size(), new Comparator<HuffmanNode>() {
            @Override
            public int compare(HuffmanNode o1, HuffmanNode o2) {
                return o1.data - o2.data;
            }
        });
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            hfmn.add(new HuffmanNode(entry.getValue(), entry.getKey(), null, null));

        }
        HuffmanNode root;
        HuffmanNode x;
        HuffmanNode y;
        while (hfmn.size() > 1) {
            x = hfmn.peek();
            hfmn.poll();
            y = hfmn.peek();
            hfmn.poll();
            root = new HuffmanNode(x.data + y.data, '-', x, y);
            hfmn.add(root);
        }
        root = hfmn.peek();
        String s1 = "";
        kvl(root, s1);
        System.out.println(sum);
    }

    static void kvl(HuffmanNode root, String s) {
        if (root.left == null && root.right == null) {
            sum += (s.length() * root.data);
            return;
        }
        kvl(root.left, s + "1");
        kvl(root.right, s + "0");
    }
}

class HuffmanNode {
    int data;
    char c;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(int data, char c, HuffmanNode left, HuffmanNode right) {
        this.data = data;
        this.c = c;
        this.left = left;
        this.right = right;
    }
}