package step3_1.BiodomeForever03;


public class LabNote {
    private String fileName;
    private String content;

    public LabNote(String fileName, String content ) {
        this.fileName = fileName;
        this.content = content;

    }

    public void NotePrint(){
        System.out.println(this.content);
    }

    public String getContent() {
        return content;
    }

    public String getFileName() {
        return fileName;
    }


}

