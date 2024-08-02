# PJT1-H java관통 project
- 작성자: 김서현
## 1. VideoReview.java , ReviewManager.java 작성
- VideoReview.java
```java
public class VideoReview {
    private int videoNo; // 비디오 번호
    private int reviewNo; // 리뷰 번호
    private String content; // 리뷰 내용

    public VideoReview() {}

    public VideoReview(int videoNo, int reviewNo, String content) {
        this.videoNo = videoNo;
        this.reviewNo = reviewNo;
        this.content = content;
    }

    public int getVideoNo() {
        return videoNo;
    }
    public void setVideoNo(int videoNo) {
        this.videoNo = videoNo;
    }
    public int getReviewNo() {
        return reviewNo;
    }
    public void setReviewNo(int reviewNo) {
        this.reviewNo = reviewNo;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

	@Override
	public String toString() {
		return "Review [videoNo=" + videoNo + ", reviewNo=" + reviewNo + ", content=" + content + "]";
	}
}
```
- ReviewManager.java
```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReviewManager {
    private int reviewNo;  // 리뷰 번호 카운터
    private Map<Integer, List<VideoReview>> videoReviewDb;  // 비디오 번호에 대한 리뷰 목록
    private static ReviewManager instance;  // Singleton instance

    private ReviewManager() {
        reviewNo = 0;
        videoReviewDb = new HashMap<>();
    }

    public static ReviewManager getInstance() {
        if (instance == null) {
            instance = new ReviewManager();
        }
        return instance;
    }

    public void addReview(VideoReview videoReview) {
        reviewNo++;  // 새로운 리뷰 번호 생성
        videoReview.setReviewNo(reviewNo);  // 리뷰 번호를 설정
        videoReviewDb.putIfAbsent(videoReview.getVideoNo(), new ArrayList<>());
        videoReviewDb.get(videoReview.getVideoNo()).add(videoReview);  // 리뷰 추가
    }

    public List<VideoReview> selectReview(int videoNo) {
        return videoReviewDb.getOrDefault(videoNo, new ArrayList<>());  // 리뷰 목록 반환
    }
}
```

## 2. Main.java 작성
- 구현방법 : Veiw를 main에서 직접 구현하여 보여주는 방식으로 진행하기로 함.
1. 첫화면
	- 메뉴 2개(1: 영상정보, 2:종료)
	- 1번 선택시, 영상정보 제공 
	- 2번 선택시, 프로그램을 종료함
	- 그 외, 잘못된 선택이라고 출력하고 다시 입력을 기다림
	- 종료를 입력받기 전까지 계속 프로그램 돌아가도록 하기
2. 영화 목록 보여주는 화면
	- 번호, 제목을 목록으로 보여줌
	- 사용자에게 목록번호를 입력받음
3. 영화 상세정보 화면
	- 번호, 제목, 파트, url을 한줄씩 보여줌
	- 영상에 달려있는 리뷰 목록을 보여줌.(리뷰가 없을시 '현재 등록된 리뷰가 없습니다.'출력)
	- 리뷰 등록 여부 입력받기(1: 입력하기, 2: 아니요)
4. 리뷰입력화면
	- 리뷰내용 입력받기
	- 성공하면 '리뷰가 등록되었습니다.' 출력

## 3. PJT 진행과정에서 느낀점
1. 클래스 다이어그램을 작성한 후, chatGPT에게서 명세서pdf파일에 있는 클래스다이어그램 예시 사진과 유사한 파일을 이끌어내는게 어려웠다.
2. chatGPT를 단순히 코드를 디버깅할때나, 새로운 코드를 작성할때만 활용하는 것이 아니라. 리뷰나 검수에 활용하는 방법은 매우 좋고, 실제로 이런부분에 chatGPT를 활요하면 성능이 좋다는 것을 PJT를 통해 경험할 수 있었다.
3. .jar 파일을 깃허브에 올려 서로의 환경에서 편하게 프로그램을 돌려볼 수 있도록 하려했다. 그런데 add하고 commit을 해도 올라가지 않았다. 그 후, .gitignore파일에서 .jar파일을 무시하고 있는것을 발견하여 그 부분을 지우고 다시 commit해봤지만 .jar파일은 github에 올라가지 않았다.(추후 교수님을 통해 .jar파일은 github에 올라가지 않는다는 것을 알게되었다)
4. github로 협업하면서 branch를 여러번 만들고 또 pr을 하고 merge하고 branch를 원격과 로컬 레포지토리에서 삭제하는 과정을 반복하면서 git사용에 익숙해질 수 있었다.(branch사용에 더욱 유연해짐)
5. 동료의 merge conflict을 해결해보면서 merge가 발생한 상황에서도 당황하지 않고 pr페이지에서 직접 해결해보는 경험을 할 수 있었다.
6. 제한된 시간동안 명세서를 보고 클래스 구조를 설계하고, 다이어그램을 작성해보고, 실제 구현까지 쭉 진행해보고, 회고까지 남기는 개발의 가장 기본적이고 간단한 과정을 직접 경험해볼 수 있었다.
