package step3_1.BiodomeForever08;

public class Node {
    private String date;
    private EnvironmentData environmentData;
    //왼쪽 자식 노드, 오른쪽 자식 노드
    private Node left;
    private Node right;


    public Node(String date, EnvironmentData environmentData) {
        this.date = date;
        this.environmentData = environmentData;
        this.left = null;
        this.right = null;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public EnvironmentData getEnvironmentData() {
        return environmentData;
    }

    public void setEnvironmentData(EnvironmentData environmentData) {
        this.environmentData = environmentData;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
