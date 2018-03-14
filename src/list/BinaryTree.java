package list;

import Model.Product;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private TreeNode root;
    private static int size;

    public TreeNode find(String pcode) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.isEmpty() == false) {
            TreeNode tmp_Node = queue.peek();
            if (tmp_Node.getData().getPcode().equals(pcode)) {
                return tmp_Node;
            }
            queue.poll();
            if (tmp_Node.getLeftChild() != null) {
                queue.add(tmp_Node.getLeftChild());
            }
            if (tmp_Node.getRightChild() != null) {
                queue.add(tmp_Node.getRightChild());
            }
        }
        return null;
    }

    public boolean contain(Product data) {
        TreeNode current = root;
        while (current != null) {
            if (data.getPcode().equals(current.getData().getPcode())) {
                return true;
            }
            if (current.getData().getSaled() >= data.getSaled()) {
                current = current.getRightChild();
            } else {
                current = current.getLeftChild();
            }
        }
        return false;
    }

    public BinaryTree balancing(int size) {
        Product[] proArray = new Product[size];
        fillArray(root, proArray, 0);
        return createFromSortedArray(proArray);
    }

    public static BinaryTree createFromSortedArray(Product[] data) {
        BinaryTree bst = new BinaryTree();
        bst.setSize(size);
        if (data != null && data.length > 0) {
            bst.root = TreeNode.addSorted(data, 0, data.length - 1);
        }
        return bst;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode parentOfSuccessor = node;
        TreeNode successor = node;
        TreeNode current = node.getRightChild();
        while (current != null) {
            parentOfSuccessor = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if (successor != node.getRightChild()) {
            parentOfSuccessor.setLeftChild(successor.getRightChild());
            successor.setRightChild(node.getRightChild());
        }
        return successor;
    }

    public void insert(Product data) {
        if (root == null) {
            this.root = new TreeNode(data);
        } else {
            root.insert(data);
        }
        size++;
    }

    public void traverseInOrder() {
        if (this.root != null) {
            this.root.traverseInOrder();
        }
    }

    public void printLevelOrder() {
        if (this.root != null) {
            this.root.printLevelOrder();
        }

    }

    public int fillArray(TreeNode root, Product[] array, int pos) {
        if (root.getLeftChild() != null) {
            pos = fillArray(root.getLeftChild(), array, pos);
        }
        array[pos++] = root.getData();
        if (root.getRightChild() != null) {
            pos = fillArray(root.getRightChild(), array, pos);
        }
        return pos;
    }

    public void delete(Product data) {
        TreeNode current = this.root;
        TreeNode parent = this.root;
        boolean isLeftChild = false;
        if (current == null) {
            return;
        }
        
        while (current != null && current.getData() != data) {
            parent = current;
            if (data.getSaled() < current.getData().getSaled()) {
                current = current.getLeftChild();
                isLeftChild = true;
            } else {
                current = current.getRightChild();
                isLeftChild = false;
            }
        }
        if (current == null) {
            return;
        }
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == root) {
                root = null;
            } else {
                if (isLeftChild) {
                    parent.setLeftChild(null);
                } else {
                    parent.setRightChild(null);
                }
            }
        } else if (current.getRightChild() == null) {
            if (current == root) {
                root = current.getLeftChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        } else if (current.getLeftChild() == null) {
            if (current == root) {
                root = current.getRightChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        } else {
            TreeNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }
        size--;
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int height() {
        if (this.root == null) {
            return 0;
        }
        return this.root.height();
    }

}
