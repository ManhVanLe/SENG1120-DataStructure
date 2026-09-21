import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
 * This class implements a binary search tree using linked nodes.
 * 
 * @author Van Manh Le c3503668
 * @version 1.0, 30/05/2025
 */
public class LinkedBinarySearchTree<K extends Comparable<K>, V> implements BinarySearchTreeADT<K, V> {
    private BinaryNode root;
    private int size;
    /**
     * A node in a binary tree.
     * Each node contains a key-value pair and references to its left and right children.
     */
    private class BinaryNode {
        /**
         * The key-value pair stored in this node.
         */
        KeyValueEntry<K, V> element;
        /**
         * The left child of this node.
         * This is null if the node has no left child.
         */
        BinaryNode left;
        /** 
         * The right child of this node.
         * This is null if the node has no right child.
         */
        BinaryNode right;

        /**
         * Constructs a new BinaryNode with the given element.
         * The left and right children are initialised to null.
         * @param element the element to be stored in the node
         */
        BinaryNode(KeyValueEntry<K, V> element) {
            this.element = element;
            left = null;
            right = null;
        }
    }


    /**
     * Constructs a new empty binary search tree.
     * The tree is initially empty, with no nodes.
     */
    public LinkedBinarySearchTree() {
        root = null;
        size = 0;
    }

    /**
     * Inserts a new key-value pair into the binary search tree. If the key already exists in the tree, the value is updated.
     * This method ensures the BST property is maintained after the insertion. left children are smaller than the parent, and right children are larger.
     * 
     * @param key the key to be inserted
     * @param value the value to be associated with the key
     */
    @Override
    public void insert(K key, V value) {
        root = insert(key, value, root);
    }

    /**
     * Recursive helper method for inserting a key-value pair into the binary search tree.
     * If the key is smaller, it goes to the left; greater goes to the right. if equal, updates value.
     * 
     * @param key - the key to insert
     * @param value - the value to associate with the key
     * @param node - the current node being processed
     * @return the updated node
     */
    private BinaryNode insert(K key, V value, BinaryNode node){
        if (node == null){
            size++;
            return new BinaryNode(new KeyValueEntry<>(key, value));
        }

        int cmp = key.compareTo(node.element.getKey());
        if (cmp < 0)
        node.left = insert(key, value, node.left);
        else if (cmp > 0) 
            node.right = insert(key, value, node.right);
        else
            node.element.setValue(value); //update value if key already exists

        return node;
    }

    /**
     * Removes a node with the specified key from the tree if it exists.
     * @param key the key to be removed
     */
    @Override
    public void remove(K key) {
        root = remove(key, root);   
    }
    /**
     * Recursive helper method for removing a node with the specified key from the tree if it exists.
     * Handles cases of node with zero, one ore two children.
     * @param key - the key to be removed
     * @param node - the current node being processed
     * @return the updated node
     */
    private BinaryNode remove(K key, BinaryNode node) {
        if (node == null)
            return null;

        int compareResult = key.compareTo(node.element.getKey());
        if (compareResult < 0)
            node.left = remove(key, node.left);
        else if (compareResult > 0) 
            node.right = remove(key, node.right);
        else {
            if (node.left == null) {
                size--;
                return node.right;
            }
            if (node.right == null){
                size--;
                return node.left;
            }
            BinaryNode min = findMin(node.right);
            node.element = min.element;
            node.right = remove(min.element.getKey(), node.right);
        }
        return node;
    }
    /**
     * Check whether a key exists in the tree.
     * 
     * @param key the key to be checked
     * @return true if the key exists in the tree, false otherwise
     */
    @Override
    public boolean contains(K key) {
        return contains(key, root);
    }

    /**
     * Recursive helper method for checking if a key exists in the tree.
     * Compares key and tranverses left or right accordingly
     * 
     * @param key the key to be checked
     * @param t the current node being checked
     * @return true if the key exists in the tree, false otherwise
     */
    private boolean contains(K key, BinaryNode t){
        if (t == null)
            return false;
        int compareResult = key.compareTo(t.element.getKey());

        if (compareResult == 0)
            return true;
        else if (compareResult < 0)
            return contains(key, t.left);
        else 
            return contains(key, t.right);
    }
    /**
     * Finds the value associated with a given key.
     * 
     * @param key - the key to find
     * @return the value associated with the key, or null if the key is not found
     */
    @Override
    public V find(K key) {
        return find(key, root);
    }

    /**
     * Recursive helper method for finding the value associated with a given key.
     * Traverses the tree based on comparison
     * @param key - the key to search
     * @param node - the current node being checked
     * @return the value associated with the key, or null if the key is not found
     */
    private V find(K key, BinaryNode node) {
        if (node == null) 
            return null;
        int compareResult = key.compareTo(node.element.getKey());
        if (compareResult == 0 )
            return node.element.getValue();
        else if (compareResult < 0)
            return find(key, node.left);
        else 
            return find(key, node.right);
    }
    /**
     * Return the minimum value stored in the tree.
     */
    @Override
    public V findMin() {
        BinaryNode min = findMin(root);
        if (min != null)
            return min.element.getValue();
        else
            return null;
    }
    /**
     * Helper method to locate the node with the smallest key.
     * Recursively or iteratively follows lefts children.
     * 
     * @param node - the subtree root
     * @return node with the smallest key
     */
    private BinaryNode findMin(BinaryNode node) {
        if (node == null) 
            return null;
        while (node.left != null) 
            node = node.left;
        return node;
    }
    /**
     * Returns the maximum value stored in the tree
     */
    @Override
    public V findMax() {
        BinaryNode max = findMax(root);
        if (max != null)
            return max.element.getValue();
        else 
            return null;
    }
    /**
     * Helper method to locate the node with the largest key.
     * Recursively or iteratively follows rights children.
     * 
     * @param node - the subtree root
     * @return node with the largest key
     */
    private BinaryNode findMax(BinaryNode node) {
        if (node == null) 
            return null;
        while (node.right != null)
            node = node.right;
        return node;
    }

    /**
     * Returns an inorder iterator over the tree elements.
     * Inorder traversal visits nodes in ascending key order.
     * 
     * @return iterator over the values in sorted order
     */
    @Override
    public Iterator<V> inorderIterator() {
        LinkedList<V> list = new LinkedList<>();
        inorderTraversal(root, list);
        return new TreeIterator(list.iterator());
    }

    /**
     * Recursive inorder traversal to collect values.
     * Visits left subtree, current node, then right subtree.
     * 
     * @param node - current subtree root
     * @param list - list to collect values
     */
    private void inorderTraversal(BinaryNode node, LinkedList<V> list){
        if (node == null)
            return;
        inorderTraversal(node.left, list);
        list.add(node.element.getValue());
        inorderTraversal(node.right, list);
    }

    /**
     * Returns a preorder iterator over the tree elements.
     * Preorder traversal visits nodes in the following order:
     * current node, left subtree, right subtree.
     * 
     * @return iterator over the values in sorted order
     */
    @Override
    public Iterator<V> preorderIterator() {
        LinkedList<V> list = new LinkedList<>();
        preorderTraversal(root, list);
        return new TreeIterator(list.iterator());
    }

    /**
     * Recursive preorder traversal to collect values.
     * Visits current node, left subtree, then right subtree.
     * 
     * @param node - current subtree root
     * @param list - list to collect values
     */
    private void preorderTraversal(BinaryNode node, LinkedList<V> list){
        if (node == null) 
            return;
        list.add(node.element.getValue());
        preorderTraversal(node.left, list);
        preorderTraversal(node.right, list);
    }
    /**
     * Returns a postorder iterator over the tree elements.
     * Postorder traversal visits nodes in the following order:
     * left subtree, right subtree, current node.
     * 
     * @return iterator over the values in sorted order
     */
    @Override
    public Iterator<V> postorderIterator() {
        LinkedList<V> list = new LinkedList<>();
        postorderTraversal(root, list);
        return new TreeIterator(list.iterator());
    }
    /**
     * Recursive postorder traversal to collect values.
     * Visits left subtree, right subtree, then current node.
     * 
     * @param node - current subtree root
     * @param list - list to collect values
     */
    private void postorderTraversal(BinaryNode node, LinkedList<V> list){
        if (node == null)
            return;
        postorderTraversal(node.left, list);
        postorderTraversal(node.right, list);
        list.add(node.element.getValue());
    }

    /**
     * Checks if the tree is empty.
     * 
     * @return true if the tree is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Returns the number of elements in the tree.
     * 
     * @return the size of the tree
     */
    @Override
    public int size() {
        return size;
    }
    /**
     * Clears the tree, removing all elements.
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * {@inheritDoc}
     * 
     * This should return the default iterator for the tree, which is the inorderIterator.
     */
    @Override
    public Iterator<V> iterator() {
        return inorderIterator();
    }

    /**
     * An iterator for the tree.
     * This iterator is used to traverse the tree in a specific order.
     */
    private class TreeIterator implements Iterator<V> {
        private Iterator<V> iter;
        /**
         * Constructs a new TreeIterator with the given iterator.
         * This iterator is used to traverse the tree in a specific order.
         * @param iter the iterator to be used for traversal
         */
        public TreeIterator(Iterator<V> iter) {
            this.iter = iter;
        }

        /**
         * Returns true if there are more elements to iterate over.
         * 
         * @return true if there are more elements, false otherwise
         */
        public boolean hasNext()  {
            return iter.hasNext();
        }

        /**
         * This method returns the next element in the iterator.
         * If there are no more elements, it should throw a NoSuchElementException.
         * 
         * @return the next element in the iteration
         */
        public V next() throws NoSuchElementException {
            if (!hasNext()){
                throw new NoSuchElementException("No more elements in tree iterator");
            }
            return iter.next();
        }

    }
}
