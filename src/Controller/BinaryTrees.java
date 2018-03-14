package Controller;

import Controller.Utility;
import Model.Product;

public class BinaryTrees {

    static Product p;

    private Pro_Node root;

    public BinaryTrees() {
        this.root = null;
    }

    public void insert(Product p) {
        Pro_Node newNode = new Pro_Node(p);
        if (root == null) {
            root = newNode;
        } else {
            Pro_Node current = root;
            Pro_Node parent;
            while (true) {
                parent = current;
                if (p.getSaled() <= current.getData().getSaled()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent = newNode;
                        return;
                    }

                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent = newNode;
                    }
                }
            }
        }

    }
/*
    public void insert(Product prod) {
        if (prod.getSaled() >= this.product.getSaled()) {
            if (this.rightChild == null) {
                this.rightChild = new TreeNode(prod);
            } else {

                this.rightChild.insert(prod);
            }
        } else {
            if (this.leftChild == null) {
                this.leftChild = new TreeNode(prod);
            } else {
                this.leftChild.insert(prod);
            }
        }
*/
    

    public void inOrderTraverse(Pro_Node focusNode) {
        if (focusNode != null) {
            inOrderTraverse(focusNode.getLeft());
            System.out.println(focusNode.getData());
            inOrderTraverse(focusNode.getRight());
        }

    }

    public static void main(String[] args) {
        BinaryTrees bt = new BinaryTrees();
        p = new Product();
        p.inputBookInfor();
        bt.insert(p);
        Product p2 = new Product();
        p2.inputBookInfor();
        bt.insert(p);

        System.out.println(String.format("%-5s%-5s%-5s%5s%10s%5s%10s%5s%10s%5s",
                "pcode", "|", "pro_name", "|", "quantity", "|", "saled", "|", "price", "|"));
        bt.inOrderTraverse(bt.root);
        /*
        String option;
        do {
            System.out.println("\n");
            System.out.println("_____________________MENU_______________________");
            System.out.println("\t" + "1.1 Input & nnsert data.................. ");
            System.out.println("\t" + "1.2 In-order traverse.................... ");
            System.out.println("\t" + "1.3 Breadth-first traverse...............");
            System.out.println("\t" + "1.4 Search by bcode......................");
            System.out.println("\t" + "1.5 Delete by pcode......................");
            System.out.println("\t" + "1.6 Simply balancing.....................");
            System.out.println("\t" + "1.7 Coun number of products..............");
            System.out.println("\t" + "1.8 Exit.................................");
            System.out.println("________________________________________________");
            System.out.print("Please enter your option: ");
            option = Utility.inputString();
            System.out.println("");

            switch (option) {
                case "1.1":
                    Product p1 = new Product();
                    p1.inputBookInfor();
                    bt.insert(p1);

                    break;
                case "1.2":
                    System.out.println(String.format("%-5s%-5s%-5s%5s%10s%5s%10s%5s%10s%5s",
                            "pcode", "|", "pro_name", "|", "quantity", "|", "saled", "|", "price", "|"));
                    bt.inOrderTraverse(bt.root);
                    break;
                case "1.3":

                    break;
                case "1.4":

                    break;
                case "1.5":
                    break;
                case "1.6":
                    break;
                case "1.7":
                    break;
                case "1.8":
                    System.out.println("--------------See you again-------------");
                    break;
                default:
                    System.out.println("Input not match!");
                    break;
            }
        } while (!"1.8".equals(option));
        private Pro_Node addRecursive(Pro_Node current, Product p) {
        if (current == null) {
            return new Pro_Node(p);
        }
        if (p.getSaled() < current.getData().getSaled()) {
            current.left =addRecursive(current, p);
        }
        return current;

    }
         */
    }
}

class Pro_Node {

    Product data;
    Pro_Node left;
    Pro_Node right;

    public Pro_Node() {
    }

    public Pro_Node(Product data) {
        this.data = data;
        left = null;
        right = null;
    }

    public Product getData() {
        return data;
    }

    public void setData(Product data) {
        this.data = data;
    }

    public Pro_Node getLeft() {
        return left;
    }

    public void setLeft(Pro_Node left) {
        this.left = left;
    }

    public Pro_Node getRight() {
        return right;
    }

    public void setRight(Pro_Node right) {
        this.right = right;
    }

}
