package step4_1.VitaBiodome04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class VitaBiodome04 {
    public static void main(String[] args) {
        HashMap<String,Fruit> fruits = new HashMap<>(){{
            put("apple",new Fruit("apple",3000,false,false,0));
            put("banana",new Fruit("banana",7000,true,false,0));
            put("orange",new Fruit("orange",5000,false,false,0));
            put("grape",new Fruit("grape",6000,false,true,0));
        }};

        HashMap<String,Integer> fruitAccessCount = new HashMap<>(){{
            put("apple",0);
            put("banana",0);
            put("orange",0);
            put("grape",0);
        }};


        try(  ServerSocket serverSocket = new ServerSocket(8080)) {
            int requestCount = 1;
            while(true){
                Socket client = serverSocket.accept();
                BufferedReader bf = new BufferedReader(new InputStreamReader(client.getInputStream()));

                //요청 읽어오기
                String request = bf.readLine(); //GET 방식으로 서버에 요청한다
                String[] parts = request.split(" "); //공백으로 분리
                String method = parts[0]; //요청방식
                String path = parts[1].replace("/",""); //경로

                String body;
                String status;

                if (method.equals("GET")){
                    if (requestCount > 5){
                        body = "과일 안내 업무가 종료되었습니다.";
                        sendResponse(body,client,"429 Too Many Requests");
                        break;
                    }
                    if(fruitAccessCount.containsKey(path) && fruitAccessCount.get(path) >= 2){
                        body = "이미 정보를 안내한 과일입니다.";
                        status = "410 Gone";
                        sendResponse(body,client,status);
                        continue;
                    }

                    Fruit fruit = fruits.get(path);

                    if (fruit == null && !fruitAccessCount.containsKey(path)){ //농장에 없는 과일을 GET방식으로 조회하는경우
                        body = "농장에 없는 과일입니다";
                        status = "404 Not Found";
                        sendResponse(body ,client ,status);
                        continue;
                    } else if(fruit.isFarmChanged()){
                        body = "다른 농장으로 이동하였습니다.";
                        status = "301 Moved Permanently";
                    } else if (fruit.isReserved()) {
                        body = "예약된 과일입니다.";
                        status = "403 Forbidden";
                    }else{
                        body = String.format("%s 가격은 %d원이며, 곧 수확예정입니다.",fruit.getName(),fruit.getPrice());
                        status = "200 OK";
                    }
                    fruitAccessCount.put(path, fruitAccessCount.get(path) + 1);
                    sendResponse(body ,client ,status);
                    requestCount++;
                }else{
                    body = "현재는 농장의 과일 정보 조회만 가능합니다";
                    status = "405 Method Not Allowed";
                    sendResponse(body,client,status);
                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void sendResponse(String body, Socket client ,String status) throws IOException {
        byte[] bodyByte = body.getBytes("UTF-8"); //한글이 깨지지않게 UTF-8로 인코딩

        String response = "HTTP/1.1 "+ status +"\r\n"; //HTTP 상태코드 404 Not Found 는 요청을 처리 실패했음을 의미(클라이언트 에러)
        response += "Content-Type: text/html; charset=UTF-8\r\n";//charset=UTF-8로 인코딩
        //동적으로 길이를 추가하기위해 본문을 먼저 작성하고 본문의 길이만큼 content-Length 설정
        response += "Content-Length: "+ bodyByte.length +"\r\n"; //content-Length 는 본문의 길이를 바이트로 나타낸다.
        response += "\r\n"; //헤더와 본문을 구분하기위해 빈줄추가
        response += body;

        PrintWriter output = new PrintWriter(client.getOutputStream(),true); //요청에 대한 응답
        output.println(response);
        output.close();

    }
}
