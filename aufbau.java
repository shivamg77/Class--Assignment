public class aufbau {
    static Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int lh = height(root.left);
            int rh = height(root.right);
            if (lh > rh) {
                return (lh + 1);
            } else
                return (rh + 1);

        }

    }

    Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.data) {
            if (node.left != null) {
                insert(node.left, value);
            } else
                node.left = new Node(value);
        } else if (value > node.data) {
            if (node.right != null) {
                insert(node.right, value);
            } else
                node.right = new Node(value);
        }
        return node;
    }

    void add(int data) {
        root = insert(root, data);
    }

    public static void aufbauPrint(Node node) {
        boolean b = false;
        int n = height(root);
        System.out.println(node.data);

        for (int i = 1; i < n; i++) {
            if (node != null) {

                if (b != false) {
                    aufbauPrint(node.right);
                    aufbauPrint(node.left);
                    break;
                } else {

                    aufbauPrint(node.left);
                    aufbauPrint(node.right);
                    break;
                }
            }
        }
        b = !b;
    }

    public static void main(String args[]) {
        aufbau bt = new aufbau();

        bt.add(40);
        bt.add(30);
        bt.add(70);
        bt.add(80);
        bt.add(50);
        bt.add(35);
        bt.add(20);
        bt.aufbauPrint(root);
        System.out.println();

    }
}
