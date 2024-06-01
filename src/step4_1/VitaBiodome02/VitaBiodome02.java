package step4_1.VitaBiodome02;

import java.io.*;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VitaBiodome02 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("URL을 입력하세요: ");
        String _url = sc.nextLine();

        try {
            URL url =  new URL(_url);
            try(InputStream is = url.openStream();
                BufferedReader bf = new BufferedReader(new InputStreamReader(is))){
                String line = "";
                while((line = bf.readLine()) != null){
                    System.out.println(line);
                }
            }

            // URL에서 HTML 읽기
            String html = readHtmlFromUrl(_url);
            // 특정 태그의 속성 값 추출
            extractAttributeValues(html, "meta", "content");

            }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static String readHtmlFromUrl(String urlString) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //http 통신을 취해 url주소로 connection을  가져온다
        conn.setRequestMethod("GET"); //get방식 선언

        //inputstream으로 한줄한줄 읽어와 StringBuilder 에 전부 저장한다.
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line); //읽어온 각 라인을 result에 저장
            }
        }
        return result.toString(); //html 문서를 전부 읽어와 문자열로 반환
    }

    private static void extractAttributeValues(String html, String tagName, String attributeName) {
        String regex = "<" + tagName + "[^>]*\\s" + attributeName + "=['\"]([^'\"]*)['\"][^>]*>";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(html);
        // 정규식: 태그 이름 안의 속성 값을 가져오는 정규식을 선언하여 대소문자 상관없이 값을 Matcher로 태그 안의 속성 값만 가져옴

        if(matcher.find()) { //속성의 값이 존재하면
            String attributeValue = matcher.group(1);
            System.out.println(">>> X-UA-Compatible : " + attributeValue);
        }else{
            System.out.println("해당 태그가 존재 하지않습니다.");
        }
    }
}
