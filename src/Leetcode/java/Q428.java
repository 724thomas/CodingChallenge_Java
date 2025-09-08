package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q428 {
/*
class Codec {

    public String serialize(Node root) {
        List<String> list=new LinkedList<>();
        preorder(root,list);
        return String.join(",",list);
    }

    private void preorder(Node root, List<String> list){
        if(root==null){
            return;
        }else{
            list.add(String.valueOf(root.val));
            list.add(String.valueOf(root.children.size()));
            for(Node child:root.children){
                preorder(child,list);
            }
        }
    }

    public Node deserialize(String data) {
        if(data.isEmpty())
            return null;

        String[] ss=data.split(",");
        Queue<String> q=new LinkedList<>(Arrays.asList(ss));
        return reversePreOrder(q);
    }

    private Node reversePreOrder(Queue<String> q){
        Node root=new Node();
        root.val=Integer.parseInt(q.poll());
        int size=Integer.parseInt(q.poll());
        root.children=new ArrayList<Node>(size);
        for(int i=0;i<size;i++){
            root.children.add(reversePreOrder(q));
        }
        return root;
    }
}
 */
}
