  // 查找，依次在二叉树的 根、左子树、右子树 中查找 value，
    // 如果找到，返回结点，否则返回 null
    public Node find(Node root, int value){
        if(root == null){
            return null;
        }
        if(root.val == value){
            return root;
        }
        //先序遍历
        Node tmp = find(root.left,value);
        //左子树没有找到
        if(tmp == null){
            tmp = find(root.right,value);
        }
        return tmp;
    }

    //二叉树的高度
    public int height(Node root){
        //判断左右那个孩子大  返回那个
        if(root == null){
            return 0;
        }
        //简写
       /* return height(root.left) > height(root.right)?
                height(root.left) +1 :height(root.right)+1;*/
       //另一个
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return leftHeight>rightHeight ? leftHeight+1 : rightHeight+1;

    }