package Java;

import java.util.Scanner;

class Node {

    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }

    public void setLeft(Node left){

        this.left = left;
    }

    public void setRight(Node right){

        this.right = right;
    }

    public Node getLeft(){

        return left;

    }

    public Node getRight(){

        return right;

    }

    public void setData(int data){

        this.data = data;
    }

    public int getData(){

        return data;

    }

    public void print(){

        System.out.print(getData() + "->");
    }
}

class BinaryTree{

    Node root;

    BinaryTree(){

        root = null;
    }

    public Node getRootNode(){

        return root;
    }

    /* Insertion into Binary Tree */

    public void Insert(int data){

        Node n1 = new Node(data);

        if(root == null){

            root = n1;
        }
        else{

            Node ParentNode = root;
            Node InsertNode = root;

            while(InsertNode!=null){

                ParentNode = InsertNode;

                if(data<InsertNode.getData()){

                    InsertNode = InsertNode.getLeft();
                }
                else{

                    InsertNode = InsertNode.getRight();
                }
            }

            if(data<ParentNode.getData()){

                ParentNode.setLeft(n1);
            }
            else{

                ParentNode.setRight(n1);
            }
        }
    }

    /* Deletion from Binary Tree */

    /* Deletion when there are no child nodes */

    public void deleteNode(int data){

        Node ParentNode = root;
        Node DeleteNode = root;
        
        if(data == DeleteNode.getData() && DeleteNode.getLeft() == null && DeleteNode.getRight() == null){
            root = null;
        }
        
        while(data != DeleteNode.getData()){

            ParentNode = DeleteNode;

            if(data <= DeleteNode.getData()){

                DeleteNode = DeleteNode.getLeft();

                if(DeleteNode == null){
                    break;
                }
            }
            else{

                DeleteNode = DeleteNode.getRight();

                if(DeleteNode == null){
                    break;
                }
            }
        }


        if(DeleteNode != null){

            /* Deleting Node when no children */

            if(DeleteNode.getLeft() == null && DeleteNode.getRight() == null){

                if(data < ParentNode.getData()){

                    ParentNode.left = null;
                }
                else{

                    ParentNode.right = null;
                }

            }

            /* Deleting Node when having one child */

            if(DeleteNode.getLeft() == null || DeleteNode.getRight() == null){

                if(data < ParentNode.getData()){

                    if(DeleteNode.getLeft() != null){

                        ParentNode.setLeft(DeleteNode.getLeft());
                    }
                    else{

                        ParentNode.setLeft(DeleteNode.getRight());
                    }
                }
                else{

                    if(DeleteNode.getLeft() != null){

                        ParentNode.setRight(DeleteNode.getLeft());
                    }
                    else{
                        ParentNode.setRight(DeleteNode.getRight());
                    }
                }
            }

            /* Deleting Node when having two children */

            if(DeleteNode.getLeft() != null && DeleteNode.getRight() != null){

                Node temp = DeleteNode.getRight();

                if(temp.getLeft() != null){
                    while(temp.getLeft().getLeft() != null){

                        temp = temp.getLeft();
                    }

                    DeleteNode.setData(temp.getLeft().getData());
                    if(temp.getLeft().getRight() != null){
                        temp.setLeft(temp.getLeft().getRight());
                    }
                }
                else{

                    DeleteNode.setData(temp.getData());
                    DeleteNode.right = null;
                }
            }


        }
        else
        {
            System.out.println("Entered Number does not exist");
        }
    }


    /* In-Order Traversal */

    public void PrintInOrder(Node n){

        if(n!= null){

            PrintInOrder(n.getLeft());
            n.print();
            PrintInOrder(n.getRight());
        }

    }

    public static void main(String args[]){

        BinaryTree btree = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose among the following 1. Insert 2. Delete 3. Print");
        int choice = sc.nextInt();

        do{

            switch(choice){

            case 1 :

                System.out.println("Enter number to insert");
                int number = sc.nextInt();
                btree.Insert(number);
                break;

            case 2 :

                System.out.println("Enter number to delete");
                number = sc.nextInt();
                btree.deleteNode(number);
                break;

            case 3 :

                btree.PrintInOrder(btree.getRootNode());
                break;

            default :

                break;

            }

            System.out.println("Enter your Choice");
            choice = sc.nextInt();
        }while(choice != 0);
        sc.close();
    }
}