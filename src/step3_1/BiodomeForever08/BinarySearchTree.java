package step3_1.BiodomeForever08;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void add(EnvironmentData data) {
            root = addRecursive(root, data);
        }

        private Node addRecursive(Node current, EnvironmentData data) {
            if (current == null) {
                return new Node(data.getDate(), data);
            }

            if (data.getDate().compareTo(current.getDate()) < 0) {
                current.setLeft(addRecursive(current.getLeft(), data));
            } else if (data.getDate().compareTo(current.getDate()) > 0) {
                current.setRight(addRecursive(current.getRight(), data));
            }

            return current;
        }

        public EnvironmentData search(String date) {
            return searchRecursive(root, date);
        }

        private EnvironmentData searchRecursive(Node current, String date) {
            if (current == null) {
                return null;
            }

            if (date.equals(current.getDate())) {
                return current.getEnvironmentData();
            }

            return date.compareTo(current.getDate()) < 0
                    ? searchRecursive(current.getLeft(), date)
                    : searchRecursive(current.getRight(), date);
        }

        public void update(String date, EnvironmentData newData) {
            root = updateRecursive(root, date, newData);
        }

        private Node updateRecursive(Node current, String date, EnvironmentData newData) {
            if (current == null) {
                return null;
            }

            if (date.equals(current.getDate())) {
                current = new Node(date, newData);
            } else if (date.compareTo(current.getDate()) < 0) {
                current.setLeft(updateRecursive(current.getLeft(), date, newData));
            } else {
                current.setRight(updateRecursive(current.getRight(), date, newData));
            }

            return current;
        }
}

