import java.util.Scanner;

class Node<T extends Comparable>{

    T data;
    Node<T> right;
    Node<T> left;

    Node(){
        right=null;
        left=null;

    }

    Node(T data){
        this.data=data;
        right=null;
        left=null;
    }
}
class Binary_search_tree<T extends Comparable>{

   Node  insert( Node root,T value){
        Node newnode=new Node(value);

        if(root==null){
            root=newnode;

            return root ;
        }
        if (root.data.compareTo(value)==0){
            return root;
        }

        if(root.data.compareTo(value)>0){

            root.left= insert(root.left,value);
        }

        if (root.data.compareTo(value)<0){
            root.right=insert(root.right,value);
        }
        return root;



   }

   int size(Node<T> root){
        if(root==null){
            return 0;
        }
        return 1+size(root.left)+size(root.right);
   }

   String search(Node<T> root,T value){

        if(root==null){
            return value+" is not present in tree";
        }
        if(root.data.compareTo(value)==0){
            return value+" is  present in tree";
        }
     return root.data.compareTo(value)>0 ?search(root.left,value):search(root.right,value);



   }

    void  preorder(Node root){

        if(root==null){
            System.out.println("tree is empty");
            return;

        }
        else{
            System.out.print(root.data+" ");

            if(root.left!=null){
                preorder(root.left);
            }

            if(root.right!=null){
                preorder(root.right);
            }
        }
    }




}

public class Binary_search {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Node root=null;

        Binary_search_tree bst=new Binary_search_tree();

        root=bst.insert(root,56);
        bst.insert(root,30);
        bst.insert(root,70);
        bst.insert(root,22);
        bst.insert(root,40);
        bst.insert(root,60);
        bst.insert(root,95);
        bst.insert(root,11);
        bst.insert(root,3);
        bst.insert(root,16);
        bst.insert(root,65);
        bst.insert(root,63);
        bst.insert(root,67);
        System.out.println(bst.size(root));
        System.out.println(bst.search(root,65));
       bst.preorder(bst.root);






    }
}
