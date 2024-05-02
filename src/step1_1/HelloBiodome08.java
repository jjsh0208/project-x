package step1_1;

import java.util.Arrays;
import java.util.Comparator;

public class HelloBiodome08 {
    private static String[] dictionary = {"hello", "where", "this", "biodome", "help", "tree", "new", "is",
            "problem", "please", "need", "we", "isn’t", "there", "a", "your",
            "any", "thanks", "the", "for", "solution", "can", "?", "you"};

    private static final String[] dictionary_kor ={"안녕하세요","새로운","나무를","발견했습니다","신속한","지원","감사합니다","당신의","도움이",
            "필요합니다"};

    public static void main(String[] args) {
        //보너스 문제시 입력유효성검사 주석처리
//		if (args.length == 0 || args[0].matches("^[a-z?]*$") == false || args[0].length() > 100) {
//			System.out.println("100글자 이하 공백을 제외한 영소문자만 입력이 가능합니다.");
//			return;
//		}


        StringBuilder text = new StringBuilder(args[0]);

        System.out.println(Message(text));
    }

    private static String Message(StringBuilder text) {
        Arrays.sort(dictionary_kor, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });

        for (String word : dictionary_kor) {
            if (word.length() == 1) { // 길이가 1인 단어는 처리하지 않습니다.
                continue;
            }

            int index = text.indexOf(word);
            while (index != -1) {
                // 단어 앞에 공백 추가
                if (index != 0 && text.charAt(index - 1) != ' ') {
                    text.insert(index, ' ');
                    index++;
                }
                else if (index + word.length() < text.length() && text.charAt(index + word.length()) != ' ') {
                    text.insert(index + word.length(), ' ');
                }

                index = text.indexOf(word, index + word.length() + 1);
            }
        }

        // 마지막 문자가 물음표가 아닐 경우에만 마침표 추가
        if (text.charAt(text.length() - 1) != '?') {
            text.append('.');
        }
        if(text.charAt(text.length() - 1) == '?'){
            // 마지막 문자 바로 앞의 문자를 삭제
            text.deleteCharAt(text.length() - 1);
            text.append('?');
        }


        return text.toString();
    }

}
