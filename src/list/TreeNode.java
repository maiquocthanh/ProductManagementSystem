package list;

import Model.Product;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    private Product data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(Product data) {
        this.data = data;
    }

    public static TreeNode addSorted(Product[] data, int start, int end) {
        if (end >= start) {
            int mid = (start + end) / 2;
            TreeNode newNode = new TreeNode(data[mid]);
            newNode.leftChild = addSorted(data, start, mid - 1);
            newNode.rightChild = addSorted(data, mid + 1, end);
            return newNode;
        }
        return null;
    }

    public int height() {
        if (isLeaf()) {
            return 1;
        }
        int left = 0;
        int right = 0;
        if (this.leftChild != null) {
            left = this.leftChild.height();
        }
        if (this.rightChild != null) {
            right = this.rightChild.height();
        }
        return (left > right) ? (left + 1) : (right + 1);

    }

    public int numOfLeafNode() {
        if (isLeaf()) {
            return 1;
        }
        int leftLeaves = 0;
        int rightLeaves = 0;
        if (this.leftChild != null) {
            leftLeaves = leftChild.numOfLeafNode();
        }
        if (this.rightChild != null) {
            rightLeaves = rightChild.numOfLeafNode();
        }
        return leftLeaves + rightLeaves;
    }

    public boolean isLeaf() {
        return this.leftChild == null && this.rightChild == null;
    }

    public void insert(Product data) {
        if (data.getSaled() >= this.data.getSaled()) {
            if (this.rightChild == null) {
                this.rightChild = new TreeNode(data);
            } else {
                this.rightChild.insert(data);
            }
        } else {
            if (this.leftChild == null) {
                this.leftChild = new TreeNode(data);
            } else {
                this.getLeftChild().insert(data);
            }
        }
    }

    public void traverseInOrder() {
        if (this.leftChild != null) {
            this.leftChild.traverseInOrder();
        }
        display(this);
        if (this.rightChild != null) {
            this.rightChild.traverseInOrder();
        }
    }

    public void printLevelOrder() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            TreeNode tpmNode = queue.poll();
            display(tpmNode);
            if (tpmNode.getLeftChild() != null) {
                queue.add(tpmNode.getLeftChild());
            }
            if (tpmNode.getRightChild() != null) {
                queue.add(tpmNode.getRightChild());
            }
        }
    }

    public void display(TreeNode node) {
        System.out.printf("%-15s%-15s%-15d%-15d%-15.2f\n", node.getData().getPcode(),
                node.getData().getPro_name(), node.getData().getQuantity(),
                node.getData().getSaled(), node.getData().getPrice());
    }

    public Product getData() {
        return data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return String.valueOf(this.data);
    }

}
