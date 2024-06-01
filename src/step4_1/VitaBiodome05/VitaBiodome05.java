package step4_1.VitaBiodome05;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.HashMap;

@WebServlet(name = "VitaBiodome05", urlPatterns = {"/"}) // 서블릿 이름과 패턴
public class VitaBiodome05 extends HttpServlet {
    HashMap<String, Fruit> fruits = new HashMap<>();
    int requestCount = 1;

    @Override
    public void init() {
        fruits.put("apple", new Fruit("apple", 3000, false, false, 0));
        fruits.put("banana", new Fruit("banana", 7000, true, false, 0));
        fruits.put("orange", new Fruit("orange", 5000, false, false, 0));
        fruits.put("grape", new Fruit("grape", 6000, false, true, 0));
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String url = req.getRequestURI();
        String[] parts = url.split("/");
        if (parts[1].equals("reset")){
            requestCount = 0;
            resp.setStatus(HttpServletResponse.SC_OK);
            out.println("{\"message\": \"Request counts have been reset."+ "\"}");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json; charset=UTF-8");
        System.out.println(requestCount);
        PrintWriter out = resp.getWriter();

        if (requestCount > 5) {
            out.println("{\"message\": \"농장은 더 이상 요청을 처리할 수 없습니다.\"}");
            return;
        }

        String url = req.getRequestURI();
        String[] parts = url.split("/");


        if (parts[1].equals("now")){
            resp.setStatus(HttpServletResponse.SC_OK); // 404 상태 코드 설정
            out.println("{\"message\": \""+ LocalDateTime.now() + "\"}");
            return;
        }


            Fruit fruit = fruits.get(parts[1]);

            if (fruit == null || !fruits.containsKey(parts[1])){
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404 상태 코드 설정
                out.println("{\"message\": \"요청한 과일을 찾을 수 없습니다: " + parts[1] + "\"}");
            } else if(fruit.isFarmChanged()){
                //
                resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
                out.println("{\"message\": \""+fruit.getName()+"은/는 다른 농장으로 이동하였습니다.\"}");
            } else if (fruit.isReserved()) {
                resp.setStatus(HttpServletResponse.SC_FORBIDDEN); // 403 상태 코드 설정
                out.println("{\"message\": \""+fruit.getName()+"은/는 예약된 과일입니다.\"}");
            }else{
                resp.setStatus(HttpServletResponse.SC_OK); // 503 상태 코드 설정
                out.println("{\"message\": \""+fruit.getName()+"의 가격은"+fruit.getPrice()+"입니다.\"}");
            }

            requestCount++;
    }
}

