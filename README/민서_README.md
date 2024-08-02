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