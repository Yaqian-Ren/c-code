public class BSTree {
    public Node root = null;

    //
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }

        Node parent = null;
        Node current = root;
        while (current != null) {
            if (key == current.key) {
                throw new RuntimeException("key 重复了: " + key);
            } else if (key < current.key) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }

        // current 就是 key 要插入的位置
        Node node = new Node(key);
        if (key < parent.key) {
            parent.left = node;
        } else {
            parent.right = node;
        }
    }

    public boolean remove(int key) {
        Node parent = null;
        Node current = root;
        while (current != null) {
            if (key == current.key) {
                removeNode(parent, current);
                return true;
            } else if (key < current.key) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }

        return false;
    }

    private void removeNode(Node parent, Node current) {
        if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (current == parent.left) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (current == parent.left) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else {
            Node nextParent = current;
            Node next = current.right;
            while (next.left != null) {
                nextParent = next;
                next = next.left;
            }

            current.key = next.key;

            if (nextParent == current) {
                nextParent.right = next.right;
            } else {
                nextParent.left = next.right;
            }
        }
    }

    // O(树的高度)
    public boolean find(int key) {
        Node current = root;
        while (current != null) {
            if (key == current.key) {
                return true;
            } else if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    private static void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    private static void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key + " ");
        }
    }

    public static void main(String[] args) {
        BSTree tree = new BSTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);

        inorder(tree.root);
        System.out.println();
        postorder(tree.root);
        System.out.println();
    }
}
