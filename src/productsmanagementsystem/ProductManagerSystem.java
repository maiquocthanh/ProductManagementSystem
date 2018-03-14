package productsmanagementsystem;

import Controller.Utility;
import Model.Product;
import list.BinaryTree;
import list.TreeNode;

public class ProductManagerSystem {

    public static void main(String[] args) {
        productMS(new BinaryTree());

    }

    private static void productMS(BinaryTree bst) {
        System.out.printf(" 1.Input & insert data \n 2.In-order traverse \n 3.Breadth-first traverse \n 4.Search by pcode \n 5.Delete by pcode \n 6.Simply balance \n 7.Count number of products \n 8.Exit\n");
        System.out.printf("Please choose your option: ");
        try {
            int option = Utility.inputInt();
            switch (option) {
                case 1:
                    Product p = new Product();
                    p.inputBookInfor();
                    if (bst.contain(p)) {
                        System.out.println("Product is exsiting in the tree");
                        productMS(bst);
                        break;
                    }

                    System.out.println("Product is added successful");
                    bst.insert(p);
                    productMS(bst);
                    break;
                case 2:
                    System.out.printf("%-15s%-15s%-15s%-15s%-15s\n", "PCode", "Name", "Quantity", "Saled", "Price");
                    bst.traverseInOrder();
                    productMS(bst);
                    break;
                case 3:
                    System.out.printf("%-15s%-15s%-15s%-15s%-15s\n", "PCode", "Name", "Quantity", "Saled", "Price");
                    bst.printLevelOrder();
                    productMS(bst);
                    break;
                case 4:
                    System.out.println("Please enter pCode you want to find");
                    String pCode = Utility.inputString();
                    TreeNode tpm_pro_node = bst.find(pCode);
                    if (tpm_pro_node != null) {
                        System.out.println("Product Found");
                        System.out.printf("%-15s%-15s%-15s%-15s%-15s\n", "PCode", "Name", "Quantity", "Saled", "Price");
                        tpm_pro_node.display(tpm_pro_node);
                        productMS(bst);
                    } else {
                        System.out.println("Product not found");
                        productMS(bst);
                    }

                    break;
                case 5:
                    System.out.println("Please enter pCode you want to delete:");
                    String pCodeDelete = Utility.inputString();
                    if (bst.find(pCodeDelete) != null) {
                        bst.delete(bst.find(pCodeDelete).getData());
                        productMS(bst);
                    } else {
                        System.out.println("Product not found");
                        productMS(bst);
                    }
                    break;
                case 6:
                    bst = bst.balancing(bst.getSize());
                    System.out.println("Complete balancing new tree has formed");
                    productMS(bst);
                    break;
                case 7:
                    System.out.printf("Number of Products: %d \n", bst.getSize());
                    productMS(bst);
                    break;
                case 8:
                    System.out.println("--------------See you again-------------");
                    break;
                default:
                    System.out.println("Wrong input please re-enter");
                    productMS(bst);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
