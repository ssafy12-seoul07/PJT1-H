# PJT1-H java관통 project
* 팀원 : 민서, 서현

## 0. 명세서확인 및 클래스 구성
- 함께 명세서를 보고 클래스 구조를 상의
- video와 review 클래스를 정의하고 각각의 내용을 관리하는 Manager 클래스를 정의하기로 결정
- Manager클래스는 singleton 패턴으로 작성하기로 함(이유: manager객체의 instance는 1개만 있어도 되기 때문에 무분별하게 manager instance를 생성하지 않도록 하기위함)

## 1. 클래스 다이어그램 prompt 명령내용 작성
- Video.java
```
Class : Video
Attributes :
  - no : int
  - title : String
  - part : String
  - url :String
Methods : 
  + getNo() : int
  + setNo(no : int) : void
  + getTitle() : String
  + setTitle(title : String) : void
  + getPart(): String
  + setPart(part : String) : void
  + getUrl(): String
  + setUrl(url : String) : void

```
- VideoManager.java
```
Class : VideoManager
Attributes :
  - videoList : List<Video>
  - instance : VideoManager
Methods : 
-VideoManager()
  + getInstance() : VideoManager
  + selectVideo() : List<Video>
  + selectVideoByNo(no : int) :Video


```

- Review.java
```
Class : Review
Attributes :
  - videoNo : int
  - reviewNo : int
  - content :String
Methods : 
  + getVideoNo() : int
  + setVideoNo(VideoNo:int) : void
  + getReviewNo() : int
  + setReviewNo(reviewNo:int) : void
  + getContent() : String
  + setContent(content:String) : void

```
- ReviewManager.java
```
Class : ReviewManager
Attributes :
  - reviewNo : int
  - videoReviewDb : Map<Integer,List<VideoReview>>
  - instance : ReviewManager
Methods : 
  - ReviewManager()
  + getInstance() : ReviewManager
  + insertReview(videoReview : VideoReview) : int
  + selectReview(videoNo : int) : List<VideoReview>

```
- Main.java
```
Class : Main
Methods :
  + main(args:String[]) : void
```

## 3. 클래스 간의 관계 정의
1. Video aggergation VideoManager
2. Review aggeragion ReviewManager

## 4. ChatGPT에게 검수 받기
1. Review 클래스 이름 변경
   - Review에서 VideoReview로
2. VideoReview 클래스와 ReviewManager 클래스 사이의 관계
   - VideoReview 클래스에서 ReviewManager 클래스로의 연관 관계는 잘 정의되어 있습니다.
   - ReviewManager 클래스의 insertReview 메소드가 int를 반환하는데, 이는 리뷰를 성공적으로 삽입했는지 여부를 반환하는 것으로 보입니다. 하지만 반환값의 의미를 명확히 하는 것이 좋습니다.
3. 비디오와 리뷰 간의 연관 관계
   - 현재 Video 클래스와 VideoReview 클래스 사이에 직접적인 연관 관계는 명시되어 있지 않습니다. VideoReview 클래스가 Video 클래스에 대한 참조를 가지는 것이 명확히 드러나지 않습니다.
   - videoNo와 reviewNo가 각각 Video와 VideoReview 객체를 구분하는 키 역할을 하지만, 이를 더 명확히 나타내기 위해 Video 클래스와 VideoReview 클래스 간의 관계를 추가하는 것이 좋습니다.
4. 메소드명 및 반환타입
   - selectVideo() 메소드가 반환타입으로 List<Video>를 가지고 있습니다. 이는 여러 비디오를 선택하는 것으로 보이는데, 메소드 이름이 이를 명확히 설명하고 있지 않습니다. selectAllVideos()와 같이 더 명확한 이름을 사용하는 것이 좋습니다.
   - selectVideoByNo(int no)는 특정 비디오를 반환하는 메소드로, 이름이 직관적입니다.
5. 싱글톤 패턴
   - VideoManager와 ReviewManager 클래스는 싱글톤 패턴을 사용하고 있습니다. getInstance() 메소드가 각 클래스에서 인스턴스를 반환하는 것을 명시하고 있어 좋습니다.
6. 전반적인 UML 구성:
   - UML 다이어그램의 전반적인 구조는 잘 잡혀 있습니다. 클래스 간의 관계 및 메소드, 속성들이 명확하게 정의되어 있습니다.
