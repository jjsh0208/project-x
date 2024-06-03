package step4_1.VitaBiodome01;

import java.net.*;
import java.util.Scanner;

public class VitaBiodome01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("URL 주소를 입력하세요 : ");


        String aurl = sc.nextLine();
        try (Url url = new Url(new URL(aurl))){
            System.out.println(">>>");
            System.out.println("url.getAuthority() : "+ url.getUrl().getAuthority());
            System.out.println("url.getContent() : "+url.getUrl().getContent());
            System.out.println("url.getDefaultPort() : "+url.getUrl().getDefaultPort());
            System.out.println("url.getPort() : "+url.getUrl().getPort());
            System.out.println("url.getFile() : "+url.getUrl().getFile());
            System.out.println("url.getHost() : "+url.getUrl().getHost());
            System.out.println("url.getPath() : "+url.getUrl().getPath());
            System.out.println("url.getProtocol() : "+url.getUrl().getProtocol());
            System.out.println("url.getQuery() : "+url.getUrl().getQuery());
            System.out.println("url.getRef() : "+url.getUrl().getRef());
            System.out.println("url.getUserInfo() : "+url.getUrl().getUserInfo());
            System.out.println("url.toExternalForm() : "+url.getUrl().toExternalForm());
            System.out.println("url.toURI(): : "+url.getUrl().toURI());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        //bonus
        String input = sc.nextLine();
        try {
            URL url = new URL(input);
            String host = url.getHost();

            InetAddress address = InetAddress.getByName(host);

            System.out.println("호스트 이름 : "+address.getHostName());
            System.out.println("IP 주소 : "+ address.getHostAddress());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

