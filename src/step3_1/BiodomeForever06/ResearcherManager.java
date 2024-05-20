package step3_1.BiodomeForever06;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResearcherManager {
    private final String FILE_PATH = "C:\\coding\\Project-X\\src\\step3_1\\BiodomeForever06\\";
    private final String FILE_NAME = "researchers_data.txt";
    private ArrayList<Researcher> researchers = new ArrayList<>();
    private boolean isResearcherDuplication(String name){
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH+FILE_NAME))){

            Pattern pattern = Pattern.compile(name); //생성년도와 같은 문자열을 찾기 위해 생성한 정규식패턴

            String info;
            while((info = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(info);
                if (matcher.find()) {
                    int index = info.indexOf(", ")+2;
                    index = info.indexOf(", ",index )+2;
                    String date = info.substring(index,index + 10);

                    System.out.println(name + "는 " +date+ " 에 이미 등록되었습니다.");
                    return true;
                }
            }

            System.out.println("-----------------------------------");
        } catch(FileNotFoundException e){ //지정된 경로에 파일이 존재하지않는 경우
            System.out.println("존재하지 않는 파일입니다. 파일 이름을 다시 확인해주세요.");
        }catch (IOException e) { //파일을 읽을 때 도중에 문제가 생긴 경우
            System.out.println("파일을 읽을 때 문제가 생겼습니다.");
        }

        return true;
    }


    public void addResearcher(String name, String position) {
        if (isResearcherDuplication(name)){ //연구원 중복검사 bonus
            return;
        }

        String year = String.valueOf(LocalDateTime.now().getYear());

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH+FILE_NAME,true))) {

            Researcher researcher = new Researcher(researcherCount(year),name,position);

            researchers.add(researcher);

            bw.write(researcher.toString());
            bw.newLine();
            bw.flush();
            System.out.println("데이터가 성공적으로 저장되었습니다.");
            System.out.println("생성된 연구원 ID: "+researcher.getId()+"\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }



    }

    private int researcherCount(String year) {

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH+FILE_NAME))){

            Pattern pattern = Pattern.compile(year); //생성년도와 같은 문자열을 찾기 위해 생성한 정규식패턴
            int cnt = 0;
            String info;
            while((info = br.readLine()) != null){
                Matcher matcher = pattern.matcher(info);
                if (matcher.find()) {
                    cnt++;
                }
            }

            if (cnt == 0) return 1;

            return cnt;
        } catch(FileNotFoundException e){ //지정된 경로에 파일이 존재하지않는 경우
            System.out.println("존재하지 않는 파일입니다. 파일 이름을 다시 확인해주세요.");
            e.printStackTrace();
            System.exit(1);
        }catch (IOException e) { //파일을 읽을 때 도중에 문제가 생긴 경우
            System.out.println("파일을 읽을 때 문제가 생겼습니다.");
            e.printStackTrace();
            System.exit(1);
        }

        return 1;
    }

    public void readAll() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH+FILE_NAME))){

            System.out.println("전체 연구원 목록:");
            System.out.println("-----------------------------------");
            String info;
            while((info = br.readLine()) != null) System.out.println(info);

            System.out.println("-----------------------------------");
        } catch(FileNotFoundException e){ //지정된 경로에 파일이 존재하지않는 경우
            System.out.println("존재하지 않는 파일입니다. 파일 이름을 다시 확인해주세요.");
        }catch (IOException e) { //파일을 읽을 때 도중에 문제가 생긴 경우
            System.out.println("파일을 읽을 때 문제가 생겼습니다.");
        }

    }

    public void searchResearcher(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH+FILE_NAME))){

            //사용자 입력 값이 ID 형태와 일치하지 않는 경우
            //정규화 \d{숫자길이}
            if (!id.matches("LUMI-\\d{4}-\\d{2}:\\d{3}")){
                System.out.println("입력한 값이 ID의 형태와 일치하지않습니다.");
                return;
            }

            Pattern pattern = Pattern.compile(id); //생성년도와 같은 문자열을 찾기 위해 생성한 정규식패턴

            String info;
            while((info = br.readLine()) != null){
                Matcher matcher = pattern.matcher(info);
                if (matcher.find()) {
                    System.out.println("연구원 정보:");
                    System.out.println("-----------------------------------");
                    System.out.println(info);
                    System.out.println("-----------------------------------");
                    return;
                }
            }
            empty();

        } catch(FileNotFoundException e){ //지정된 경로에 파일이 존재하지않는 경우
            System.out.println("존재하지 않는 파일입니다. 파일 이름을 다시 확인해주세요.");
            e.printStackTrace();
            System.exit(1);
        }catch (IOException e) { //파일을 읽을 때 도중에 문제가 생긴 경우
            System.out.println("파일을 읽을 때 문제가 생겼습니다.");
            e.printStackTrace();
            System.exit(1);
        }catch (SearchException ignored){}

    }
    public void empty() throws SearchException {
        System.out.println("에러: 해당 ID를 가진 연구원 정보가 존재하지 않습니다.");
    }
}
