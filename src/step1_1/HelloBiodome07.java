package step1_1;

public class HelloBiodome07 {

    private static String rangeCheck(char[] code) {
        int count = 1; // 최소 1회는 나타나므로 1로 시작
        String t = "";
        for (int i = 0; i < code.length - 1; i++) {
            if (code[i] == code[i + 1] && code[i] != ' ') {
                // 다음 문자와 현재 문자가 같으면 카운트 증가
                count++;
            }
            else if(code[i] == ' ') {
                t +=(" ");
                continue;
            }
            else{
                // 다음 문자가 다르면 현재까지의 문자와 카운트를 결과에 추가
                t +=(code[i]);
                t +=(count);
                count = 1;
            }
        }

        t+=(code[code.length -1]);
        t+=(count);

        return t;
    }

    public static void main(String[] args) {
        if(args[0].matches("^[cjheyCJHEY ]+$") == false){
            System.out.println("염기서열은 C, J, H, E, Y 다섯가지로만 입력됩니다. 확인하고 다시 입력해주세요");
            return;
        }

        char [] code = args[0].toUpperCase().toCharArray(); //공백을 제거해 char배열로 반환.replaceAll(" ", "")
        System.out.println(rangeCheck(code).replaceAll("\\s+", " "));
    }
}
