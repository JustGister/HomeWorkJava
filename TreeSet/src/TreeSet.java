public class TreeSet<k, v> {

    private int size = 0;
    private Node root = null;

    private class Node{
        public k key;
        public v value;
        public Node left,right;

        public Node(k key,v value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node findNode(Object key) {
        Node currentNode = root;
        Comparable<k> cKey = (Comparable<k>) key;
        while(currentNode != null) {
            int num = cKey.compareTo(currentNode.key);
            if(num < 0) {
                currentNode = currentNode.left;
            }
            if(num > 0) {
                currentNode = currentNode.right;
            }
            if(num == 0){
                return currentNode;
            }
        }
        return null;
    }

    public v contains(Object key) {
        Node thisNode = findNode(key);
        if(thisNode == null) {
            return null;
        }
        return thisNode.value;
    }

    private v addHelper(k key, v value, Node node) {
        Comparable<k> cKey = (Comparable<k>) key;
        int num = cKey.compareTo(node.key);
        if(num < 0) {
            if(node.left == null) {
                node.left = new Node(key, value);
                size++;
                return null;
            }
            return addHelper(key, value, node.left);
        }
        if(num > 0) {
            if(node.right == null) {
                node.right = new Node(key, value);
                size++;
                return null;
            }
            return addHelper(key, value, node.right);
        }
        if(num == 0){
            v old = node.value;
            node.value = value;
            return old;
        }
        return null;
    }

    public v add(k key,v val) {
        if(root == null) {
            root = new Node(key, val);
            size++;
            return null;
        }
        return addHelper(key, val, root);
    }

    public v remove(Object key) {
        Node child = findNode(key);
        if(child == null) {
            return null;
        }
        if(size==1) {
            root=null;
            size--;
            return child.value;
        }
        Node parent = findParent(key);
        if(child.left != null && child.right != null) {
            Node find = find(child.right);
            Node helpFind = findParent(find.key);
            removeHelper(find, helpFind);
            child.key = find.key;
            v oldVal = child.value;
            child.value = find.value;
            return oldVal;
        }
        else {
            return removeHelper(child, parent);
        }
    }
    private Node findParent(Object key) {
        Comparable<k> cKey = (Comparable<k>) key;
        Node parent = root;
        Node children = root;
        while(children != null) {
            int num = cKey.compareTo(children.key);
            if(num < 0) {
                parent = children;
                children = children.left;
            }
            if(num > 0) {
                parent = children;
                children = children.right;
            }
            if(num == 0) {
                return parent;
            }
        }
        return null;
    }
    private v removeHelper(Node child, Node parent) {
        if(child.left == null && child.right == null) {
            if(parent.left == child) {
                parent.left = null;
            }
            if(parent.right == child) {
                parent.right = null;
            }
            size--;
            return child.value;
        }
        if(parent.left == null) {
            if(parent.left == child) {
                parent.left = child.right;
            }
            if(parent.right == child) {
                parent.right = child.right;
            }
            size--;
            return child.value;
        }
        if(child.right == null) {
            if(parent.left == child) {
                parent.left = child.left;
            }
            if(parent.right == child) {
                parent.right = child.left;
            }
            size--;
            return child.value;
        }
        return null;
    }

    private Node find(Node node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
}
