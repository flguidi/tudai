package tp02_2;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    /* ==================== isEmpty: O(1) ==================== */
    public boolean isEmpty() {
        return root == null;
    }

    /* ==================== getRoot: O(1) ==================== */
    public Integer getRoot() {
        if (root == null) {
            return null; // No se puede obtener el valor si el árbol está vacío
        }
        return root.getValue();
    }

    /* ==================== add: O(h) ==================== */
    public void add(Integer value) {
        if (value == null) {
            return;
        }

        if (root == null) {
            root = new Node(value); // Se crea el primer nodo (la raíz del árbol)
        } else {
            addRec(root, value); // Se inserta recursivamente en el árbol
        }
    }

    private void addRec(Node current, Integer value) {
        if (value.equals(current.getValue())) {
            return; // Valores iguales se descartan
        }

        Node newNode = new Node(value); // Se crea el nodo

        // Valor menor -> Subárbol izquierdo
        if (value < current.getValue()) {
            if (current.getLeft() == null) {
                current.setLeft(newNode); // Se inserta a la izquierda del nodo actual
            } else {
                addRec(current.getLeft(), value); // Llamada recursiva en subárbol izquierdo
            }
        }
        // Valor mayor -> Subárbol derecho
        else {
            if (current.getRight() == null) {
                current.setRight(newNode); // Se inserta a la derecha del nodo actual
            } else {
                addRec(current.getRight(), value); // Llamada recursiva en subárbol derecho
            }
        }
    }

    /* ==================== hasValue: O(h) ==================== */
    public boolean hasValue(Integer value) {
        if (value == null) {
            return false;
        }

        return hasValue(root, value);
    }

    private boolean hasValue(Node current, Integer value) {
        if (current == null) {
            return false; // Valor no encontrado
        }

        // Búsqueda recursiva en subárboles
        if (value < current.getValue()) {
            return hasValue(current.getLeft(), value); // Subárbol izquierdo
        } else if (value > current.getValue()) {
            return hasValue(current.getRight(), value); // Subárbol derecho
        }

        return true; // Valor encontrado
    }

    /* ==================== remove: O(h) ==================== */
    public boolean remove(Integer value) {
        if (value == null) {
            return false;
        }
        Node removed = remove(root, value);
        return removed != null;
    }

    private Node remove(Node current, Integer value) {
        // Caso base: nodo no encontrado
        if (current == null) {
            return null;
        }

        // Se busca recursivamente en el subárbol izquierdo o derecho
        if (value < current.getValue()) {
            Node left = remove(current.getLeft(), value);
            current.setLeft(left);
        } else if (value > current.getValue()) {
            Node right = remove(current.getRight(), value);
            current.setRight(right);
        }

        // Se encuentra y elimina el nodo
        else {
            // Caso 1: el nodo a eliminar no tiene hijos
            if (current.getLeft() == null && current.getRight() == null) {
                current = null;
            }
            // Caso 2: el nodo a eliminar tiene un solo hijo
            else if (current.getLeft() == null) {
                current = current.getRight();
            } else if (current.getRight() == null) {
                current = current.getLeft();
            }
            // Caso 3: el nodo a eliminar tiene dos hijos
            else {
                // Se reemplaza el valor del nodo actual con el del NMISD
                Integer minValue = getMinValue(current.getRight());
                current.setValue(minValue);

                // Se elimina el sucesor (NMISD)
                Node right = remove(current.getRight(), minValue);
                current.setRight(right);
            }
        }

        return current; // Nodo eliminado exitosamente
    }

    /* ==================== getMinValue: O(h) ==================== */
    public int getMinValue() {
        // Si el árbol está vacío, se devuelve el entero máximo posible para un entero.
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return getMinValue(root);
    }

    private int getMinValue(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getValue(); // Valor del nodo más izquierdo
    }

    /* ==================== getMaxValue: O(h) ==================== */
    public int getMaxValue() {
        // Si el árbol está vacío, se devuelve el entero mínimo posible para un entero.
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        return getMaxValue(root);
    }

    private int getMaxValue(Node node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node.getValue(); // Valor del nodo más derecho
    }

    /* ==================== printPreOrder: O(n) ==================== */
    public String printPreOrder() {
        return printPreOrder(root);
    }

    private String printPreOrder(Node current) {
        if (current == null) {
            return "";
        }

        return current + " " +
                printPreOrder(current.getLeft()) +
                printPreOrder(current.getRight());
    }

    /* ==================== printInOrder: O(n) ==================== */
    public String printInOrder() {
        return printInOrder(root);
    }

    private String printInOrder(Node current) {
        if (current == null) {
            return "";
        }

        return printInOrder(current.getLeft()) +
                current + " " +
                printInOrder(current.getRight());
    }

    /* ==================== printPostOrder: O(n) ==================== */
    public String printPostOrder() {
        return printPostOrder(root);
    }

    private String printPostOrder(Node current) {
        if (current == null) {
            return "";
        }

        return printPostOrder(current.getLeft()) +
                printPostOrder(current.getRight()) +
                current + " ";
    }

    /* ==================== getHeight: O(n) ==================== */
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node current) {
        if (current == null) {
            return -1;
        }

        int leftHeight = getHeight(current.getLeft());
        int rightHeight = getHeight(current.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }

    /* ==================== getLongestBranch: O(n) ==================== */
    public List<Integer> getLongestBranch() {
        List<Integer> longestBranch = new ArrayList<>();
        return getLongestBranch(root, longestBranch);
    }

    private List<Integer> getLongestBranch(Node current, List<Integer> branch) {
        if (current == null) {
            return branch;
        }

        // Se agrega el valor del nodo actual a la lista
        branch.add(current.getValue());

        // Se calculan las ramas en los subárboles izquierdo y derecho
        List<Integer> leftBranch = getLongestBranch(current.getLeft(), new ArrayList<>(branch));
        List<Integer> rightBranch = getLongestBranch(current.getRight(), new ArrayList<>(branch));

        // Se devuelve la rama más larga de las dos
        return leftBranch.size() > rightBranch.size() ? leftBranch : rightBranch;
    }

    /* ==================== getExternalNodes: O(n) ==================== */
    public List<Integer> getExternalNodes() {
        List<Integer> leaves = new ArrayList<>();
        getExternalNodes(root, leaves);
        return leaves;
    }

    private void getExternalNodes(Node current, List<Integer> leaves) {
        if (current == null) {
            return;
        }

        // Si el nodo actual es una hoja, se agrega a la lista
        if (current.getLeft() == null && current.getRight() == null)
            leaves.add(current.getValue());

        // Se agregan hojas recursivamente en los subárboles izquierdo y derecho
        getExternalNodes(current.getLeft(), leaves);
        getExternalNodes(current.getRight(), leaves);
    }

    /* ==================== getValuesAtLevel: O(n) ==================== */
    public List<Integer> getValuesAtLevel(int level) {
        List<Integer> values = new ArrayList<>();
        getValuesAtLevel(root, 0, level, values);
        return values;
    }

    private void getValuesAtLevel(Node currentNode, int currentLevel, int targetLevel, List<Integer> values) {
        if (currentNode == null) {
            return;
        }

        // Si el nodo actual se encuentra en el nivel indicado, se agrega a la lista
        if (currentLevel == targetLevel) {
            values.add(currentNode.getValue());
        }
        // Si no, se sigue recorriendo los subárboles izquierdo y derecho
        else {
            getValuesAtLevel(currentNode.getLeft(), currentLevel + 1, targetLevel, values);
            getValuesAtLevel(currentNode.getRight(), currentLevel + 1, targetLevel, values);
        }
    }

    /* ==================== sumInternalNodes: O(n) ==================== */
    public int sumInternalNodes() {
        return sumInternalNodes(root);
    }

    private int sumInternalNodes(Node current) {
        if (current == null) {
            return 0;
        }

        // Si el nodo actual es una hoja, se descarta
        if (current.getLeft() == null && current.getRight() == null) {
            return 0;
        }

        // Se suma el valor del nodo actual y los nodos internos de los subárboles derecho e izquierdo
        int sum = current.getValue();
        sum += sumInternalNodes(current.getLeft());
        sum += sumInternalNodes(current.getRight());
        return sum;
    }

    /* ==================== leavesGreaterThan: O(n) ==================== */
    public List<Integer> leavesGreaterThan(int value) {
        List<Integer> leaves = new ArrayList<>();
        leavesGreaterThan(root, value, leaves);
        return leaves;
    }

    private void leavesGreaterThan(Node current, int value, List<Integer> leaves) {
        if (current == null) {
            return;
        }

        // Si el nodo actual es una hoja y es mayor al valor dado, se agrega a la lista
        if (current.getLeft() == null && current.getRight() == null && current.getValue() > value) {
            leaves.add(current.getValue());
        }

        // Búsqueda recursiva en subárboles izquierdo y derecho
        leavesGreaterThan(current.getLeft(), value, leaves);
        leavesGreaterThan(current.getRight(), value, leaves);
    }

}
