package step4_1.VitaBiodome06;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

//특정 파일만 빌드하는 방법 알아내서 VitaBiodome06만 빌드하여 실행

ddd


public class VitaBiodome06 extends HttpServlet {
    HashMap<String,Fruit> fruitHashMap = new HashMap<>();
    @Override
    public void init() {
        fruitHashMap.put("apple", new Fruit("apple",3000,25));
        fruitHashMap.put("melon", new Fruit("melon",17000,12));
        fruitHashMap.put("orange", new Fruit("orange",5000,19));
        fruitHashMap.put("greape", new Fruit("greape",6000,0));
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        resp.setStatus(HttpServletResponse.SC_OK);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
