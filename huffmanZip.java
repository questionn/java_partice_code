package com.structure.huffmantree_pac;

import java.util.*;

public class HuffmanCode {
    //采用赫夫曼编码
    //对i like like like java do you like a java  进行编码
    public class TreeNode implements Comparable<TreeNode>{
        Byte data; //存放出现的字符
        int wight; //权值  字符出现的次数
        TreeNode left;
        TreeNode right;

        public TreeNode(Byte data, int wight){
            this.data = data;
            this.wight = wight;
        }

        //因为要构建赫夫曼树，排序
        @Override
        public int compareTo(TreeNode o) {
            return this.wight - o.wight;
        }
    }

    //获取list集合
    public List<TreeNode> getList(String str){
        byte[] bytes = str.getBytes();

        List<TreeNode> nodes = new ArrayList<TreeNode>();
        Map<Byte,Integer> maps = new HashMap<Byte, Integer>();

        //以键值对形势存储
        for (byte b:bytes
             ) {
            Integer count = maps.get(b);
            if(count == null){
                maps.put(b,1);
            }else{
                maps.put(b,count+1);
            }
        }

        //导入到list 集合中
        for (Map.Entry<Byte,Integer> entry:maps.entrySet()
             ) {
            nodes.add(new TreeNode(entry.getKey(),entry.getValue()));
        }

        return nodes;
    }

    //创建赫夫曼树
    public TreeNode createHuffmanTree(List<TreeNode> nodes){

        while (nodes.size() > 1){
            Collections.sort(nodes);

            //
            TreeNode leftNode = nodes.get(0);
            TreeNode rightNode = nodes.get(1);
            //没有data域   null
            TreeNode parent = new TreeNode(null,(leftNode.wight+rightNode.wight));
            //
            parent.left = leftNode;
            parent.right = rightNode;
            //
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    //生成哈夫曼树对应的赫夫曼编码   左边为0   右边为1
    //使用Map集合存储a=100 d=11000 等      {32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011}
    public Map<Byte,String> huffmanMap = new HashMap<Byte, String>();
    //利用StringBuilder拼接
    private StringBuilder stringBuilder = new StringBuilder();

    public void getCodes(TreeNode node, String code, StringBuilder stringBuilder){//节点变化 、 左右子树的code   拼接字符
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);   //每次传入的值变化

        stringBuilder1.append(code); //第一次为空
        if(node != null){
            if(node.data == null) {  //不是叶子节点
                getCodes(node.left, "0", stringBuilder1);
                getCodes(node.right, "1", stringBuilder1);
            }else{
                //证明为叶子节点
                huffmanMap.put(node.data,stringBuilder1.toString());
            }
        }
    }

    //重载getCodes方法，简化调用
    public Map<Byte,String> getCodes(TreeNode node){
        if(node == null){
            return null;
        }

        getCodes(node,"",stringBuilder);
        return huffmanMap;
    }

    //将字符创的byte数组，通过生成的哈夫曼表，返回一个压缩后的byte[]

    //存储进去的byte，是把String的值，当成二进制放入   以补码的形式存入
    public byte[] zip(byte[] bytes, Map<Byte,String> huffmanCodes ){
        StringBuilder stringBuilderCodes = new StringBuilder();

        //生成编码后的String
        for (byte b:bytes
             ) {
            stringBuilderCodes.append(huffmanCodes.get(b));
        }
        //注意：如果将String直接转换为byte[]  ，通过getByte()  那么会把每一个字符转换
        //相当于10101000    装换的话就会变成byte[8]   那么长度大大增加
        //所以只能一个一个转换
        int len = 0;
        if(stringBuilderCodes.length() / 8 == 0){
            len = stringBuilderCodes.length()/8;
        }else{
            len = stringBuilderCodes.length()/8 + 1;
        }
        //新的byte【】
        byte[] huffmanBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilderCodes.length() ; i+=8 ){
            String byteStr;
            if(i+8 > stringBuilderCodes.length()){
                byteStr = stringBuilderCodes.substring(i);
            }else{
                byteStr = stringBuilderCodes.substring(i,i+8);
            }
            //将String依次放入huffmanBytes
            //全部当成二进制存储   结果为10进制
            huffmanBytes[index] = (byte)Integer.parseInt(byteStr,2);
            index++;
        }
        return huffmanBytes;
    }
    //前序遍历
    public void proOrder(TreeNode node){
        if(node == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode cur = node;
        TreeNode tmp = null;
        while(cur != null || !stack.empty()) {
            while (cur != null) {
                System.out.print(cur.wight + " ");
                stack.push(cur);
                cur = cur.left;
            }
            tmp = stack.pop();
            cur = tmp.right;
        }
    }


    //综合
    public byte[] huffmanZip(String str){
        System.out.println("压缩前" + str.length());
        List<TreeNode> list = getList(str);
        TreeNode huffmanTree = createHuffmanTree(list);
        Map<Byte, String> codes = getCodes(huffmanTree);
        byte[] zip = zip(str.getBytes(), codes);
        System.out.println("压缩后" + zip.length);
        float ret = (((float)(str.length())-(float)zip.length)/(float)str.length())*100;
        System.out.println("压缩率" + String.format("%.2f",ret) + "%");
        return zip;
    }
}
