package step3_1.BiodomeForever01;

public class LabNote {

    private String fileName;
    private String content;
    private String date;

    public LabNote(String fileName, String content ,String date) {
        this.fileName = fileName;
        this.content = content;
        this.date = date;
    }

    public void NotePrint(){
        System.out.println(this.content);
    }

    public String getFileName() {
        return fileName;
    }
}
