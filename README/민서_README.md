# PJT1-H java관통 project
* 작성자 : 고민서

## 1. drowIO를 이용한 UML 다이어그램 작성(Diagram.png 파일 첨부)
 - 팀원과 함께 대략적인 클래스와 속성, 메서드를 고려한 뒤 이를 drowIO프로그램을 통해 작성
 - drowIO 프로그램을 통해 각 속성의 접근제어자와 클래스 간의 상속 관계를 표시
 - 작성한 다이어그램 이미지를 ChatGPT를 이용하여 검수 후 수정

## 2. Video.java , VideoManager.java 작성
 - Video.java
```java
public class Video {
    private int no;         // 비디오 번호
    private String title;   // 비디오 제목
    private String part;    // 비디오 파트 (예: 시즌 1, 시즌 2 등)
    private String url;     // 비디오 URL

    // 비디오 생성자
    public Video(int no, String title, String part, String url) {
        this.no = no;
        this.title = title;
        this.part = part;
        this.url = url;
    }

    // 비디오 번호 getter
    public int getNo() {
        return no;
    }

    // 비디오 번호 setter
    public void setNo(int no) {
        this.no = no;
    }

    // 비디오 제목 getter
    public String getTitle() {
        return title;
    }

    // 비디오 제목 setter
    public void setTitle(String title) {
        this.title = title;
    }

    // 비디오 파트 getter
    public String getPart() {
        return part;
    }

    // 비디오 파트 setter
    public void setPart(String part) {
        this.part = part;
    }

    // 비디오 URL getter
    public String getUrl() {
        return url;
    }

    // 비디오 URL setter
    public void setUrl(String url) {
        this.url = url;
    }
}
```

 - VideoManager.java
```java
import java.util.ArrayList;
import java.util.List;

public class VideoManager {
    private List<Video> videoList;  // 비디오 목록
    private static VideoManager instance;  // Singleton instance

    // 생성자
    private VideoManager() {
        videoList = new ArrayList<>();
    }

    // Singleton 인스턴스를 반환하는 메소드
    public static VideoManager getInstance() {
        if (instance == null) {
            instance = new VideoManager();
        }
        return instance;
    }

    // 비디오 목록을 반환하는 메소드
    public List<Video> selectVideos() {
        return videoList;
    }

    // 비디오 번호로 비디오를 선택하여 반환하는 메소드
    public Video selectVideoByNo(int no) {
        for (Video video : videoList) {
            if (video.getNo() == no) {
                return video;
            }
        }
        return null; // 비디오를 찾지 못한 경우 null 반환
    }

    // 비디오를 목록에 추가하는 메소드
    public void addVideo(Video video) {
        videoList.add(video);
    }
}
```

## 3. Main에서 JSON 데이터 받기
 - Main메서드에서 주어진 video.json을 BufferedReader와 StringBuilder를 이용하여 문자열로 받아와서 배열에 저장
 - VideoManager.java의 addVideo메서드를 이용해 배열에 저장된 정보를 Video객체로 videoList에 저장

## 4. Merge Conflict 해결
 - 프로젝트를 진행하며 팀원과 각자 branch를 생성하여 작업 후 master로 merge.
 - 개인 branch인 gomseo branch에서 main.java 파일을 수정하고 master로 push하면서 충돌발생
 - pr페이지에서 직접 editor로 들어가 필요한 코드만 남기고 전부 삭제
 - 충돌을 해결하고 merge완료

## 5. 느낀점
 - git을 이용하면서 각자 작업을 수행하기에 개인 branch의 생성이 편리하고 필수적임을 느꼈습니다.
 - 개인 branch를 master로 push하는 과정에서 conflict의 문제가 발생 시 코드를 확인해준 후 수정이 가능함을 배웠습니다.
 - 또한 master로 merge 후 개인 branch의 삭제를 꼭 수행해야 함을 배웠습니다.
 - git을 활용하는 기본적인 방법을 배우고 체화할 수 있는 프로젝트였다고 생각합니다.
