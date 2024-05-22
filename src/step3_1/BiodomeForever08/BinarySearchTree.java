package step3_1.BiodomeForever08;

// 필요한 import 구문들
import java.util.ArrayList;

public class BinarySearchTree {
    private Node root; // 이진 탐색 트리의 루트 노드

    public Node getRoot() {
        return root;
    }

    public BinarySearchTree() {
        this.root = null;
    }

    // 노드 추가
    public void add(EnvironmentData data) {
        root = addRecursive(root, data);
    }

    private Node addRecursive(Node current, EnvironmentData data) {
        if (current == null) {
            return new Node(data);
        }

        if (data.getDate().compareTo(current.getData().getDate()) < 0) {
            current.setLeft(addRecursive(current.getLeft(), data));
        } else if (data.getDate().compareTo(current.getData().getDate()) > 0) {
            current.setRight(addRecursive(current.getRight(), data));
        }

        return current;
    }

    // 날짜로 데이터 검색
    public EnvironmentData search(String date) {
        return searchRecursive(root, date);
    }

    private EnvironmentData searchRecursive(Node current, String date) {
        if (current == null) {
            return null;
        }
        String[] c = current.getDate().split(" ");
        if (date.equals(c[0])) {
            return current.getData();
        }

        return date.compareTo(current.getData().getDate()) < 0 ?
                searchRecursive(current.getLeft(), date) : searchRecursive(current.getRight(), date);
    }

    // 데이터 업데이트
    public void update(String date, EnvironmentData newData) {
        root = updateRecursive(root, date, newData);
    }

    private Node updateRecursive(Node current, String date, EnvironmentData newData) {
        if (current == null) {
            return null;
        }

        if (date.equals(current.getData().getDate())) {
            current.setData(newData);
        } else if (date.compareTo(current.getData().getDate()) < 0) {
            current.setLeft(updateRecursive(current.getLeft(), date, newData));
        } else {
            current.setRight(updateRecursive(current.getRight(), date, newData));
        }

        return current;
    }

    // 범위 검색
    public EnvironmentData[] RangeSearch(String startDate, String endDate) {
        ArrayList<EnvironmentData> data = new ArrayList<>();
        RangeRecursive(root, data, startDate, endDate);
        return data.toArray(new EnvironmentData[0]);
    }

    private void RangeRecursive(Node current, ArrayList<EnvironmentData> data, String startDate, String endDate) {
        if (current == null) {
            return;
        }

        if (startDate.compareTo(current.getData().getDate()) <= 0) {
            RangeRecursive(current.getLeft(), data, startDate, endDate);
        }

        if (startDate.compareTo(current.getData().getDate()) <= 0 && endDate.compareTo(current.getData().getDate()) >= 0) {
            data.add(current.getData());
        }

        if (endDate.compareTo(current.getData().getDate()) >= 0) {
            RangeRecursive(current.getRight(), data, startDate, endDate);
        }
    }
}
