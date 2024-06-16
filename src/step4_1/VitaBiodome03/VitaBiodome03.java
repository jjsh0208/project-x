package step4_1.VitaBiodome03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class VitaBiodome03 {
    public static void main(String[] args) {
        //서버 소켓생성
        try(  ServerSocket serverSocket = new ServerSocket(8080)) {

            while(true){
                //클아이언트의 연결 요청 대기
                //localhost:8080으로 접속하면 연결
                Socket client = serverSocket.accept();

                //클라이언트 소켓으로부터 입력스트림 생성
                BufferedReader bf = new BufferedReader(new InputStreamReader(client.getInputStream()));
//메모 잘해주기
                //요청 읽어오기
                String request = bf.readLine(); //GET 방식으로 서버에 요청한다
                //예) localhost:8080 으로 접속하면 GET / HTTP/1.1
                // 요청방식 / 경로 / HTTP버전
                String[] parts = request.split(" "); //공백으로 분리
                String method = parts[0]; //요청방식
                String path = parts[1]; //경로
                
                if (method.equals("GET") && path.equals("/socket")){ //GET방식이고 경로가 socket이면
                    String Ip = client.getInetAddress().getHostAddress(); //클라이언트 ip 주소
                    int port = client.getPort();

                    String body = "<h1>Client IP : "+Ip +"</h1>";
                    body += "<h1>Client Port : "+port +"</h1>";

                    String response = "HTTP/1.1 200 OK\r\n"; //HTTP 상태코드 200 OK는 성공적으로 처리되었음을 의미
                    response += "Content-Type: text/html\r\n";//응답 헤더 text/html은 응답 본문의 MIME타입이 HTML임을 의미
                    //동적으로 길이를 추가하기위해 본문을 먼저 작성하고 본문의 길이만큼 content-Length 설정
                    response += "Content-Length: "+ body.getBytes().length +"\r\n"; //content-Length 는 본문의 길이를 바이트로 나타낸다. 
                    response += "\r\n"; //헤더와 본문을 구분하기위해 빈줄추가
                    response += body;

                    PrintWriter output = new PrintWriter(client.getOutputStream(),true); //요청에 대한 응답
                    output.println(response);
                    output.close();
                }else{

                    String body = "<h1>Internal Server Error :o</h1>";

                    String response = "HTTP/1.1 500 Internal Server Error\r\n";  //500은 서버 에러
                    response += "Content-Type: text/html\r\n";
                    response += "Content-Length: "+ body.getBytes().length +"\r\n";
                    response += "\r\n"; //헤더와 본문을 구분하기위해 빈줄추가
                    response += body;

                    PrintWriter output = new PrintWriter(client.getOutputStream(),true); //요청에 대한 응답
                    output.println(response);
                    output.close();
                }

//                if (request.startsWith("GET")){
//                    String response = "HTTP/1.1 200 OK\r\n"; //HTTP 상태코드 200 OK는 성공적으로 처리되었음을 의미
//                    response += "Content-Type: text/html\r\n";//응답 헤더 text/html은 응답 본문의 MIME타입이 HTML임을 의미
//                    response += "Content-Length: "+ request.getBytes().length +"\r\n"; //content-Length 는 본문의 길이가 35바이트 임을 의미
//                    response += "\r\n"; //헤더와 본문을 구분하기위해 빈줄추가
//                    response += "<h1>Welcome to Vitamin Storage :)</h1>"; //여기서부터 본문에 전송할 HTML 코드작성
//
//                    PrintWriter output = new PrintWriter(client.getOutputStream(),true); //요청에 대한 응답
//                    output.println(response);
//                    output.close();
//                }else{
//                    String response = "HTTP/1.1 404 Not Found\r\n"; //HTTP 상태코드 404 Not Found 는 요청을 처리 실패했음을 의미(클라이언트 에러)
//                    response += "Content-Type: text/html\r\n";
//                    response += "Content-Length: "+ request.getBytes().length +"\r\n";
//                    response += "\r\n";
//                    response += "<h1>Page Not Found :(</h1>";
//
//                    PrintWriter output = new PrintWriter(client.getOutputStream(),true); //요청에 대한 응답
//                    output.println(response);
//                    output.close();
//                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}