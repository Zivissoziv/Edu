package NewCoder.Q55;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ziv on 2019/2/24.
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class Q55 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot==null) return null;
        Queue<TreeNode> layer = new LinkedList<>();
        ArrayList<Integer> layerList = new ArrayList<>();

        int start = 0;
        int end = 1;
        layer.add(pRoot);
        boolean left2Rigth = true;
        while(!layer.isEmpty()){
            TreeNode tmp = layer.poll();
            layerList.add(tmp.val);
            start ++;
            if(tmp.left!=null){
                layer.add(tmp.left);
            }
            if(tmp.right!=null){
                layer.add(tmp.right);
            }
            if(start == end){
                end = layer.size();
                start = 0;
                if (left2Rigth){
                    result.add(layerList);
                }else {
                    result.add(reverse(layerList));
                }
                left2Rigth = !left2Rigth;
                layerList = new ArrayList<>();
            }
        }

        return result;

        }


    public ArrayList reverse(ArrayList<Integer> list){
        int i = 0;
        int j = list.size()-1;
        while(i<j){
            int tmp = list.get(i);
            list.set(i,list.get(j));
            list.set(j,tmp);
            i++;
            j--;
        }
        return list;
    }
}

class test{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Q55 q55 = new Q55();
        ArrayList reverse = q55.reverse(list);
        System.out.println(reverse);
    }
}
