import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VideoManager videoManager = VideoManager.getInstance();
        ReviewManager reviewManager = ReviewManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        // 샘플 비디오 추가
        videoManager.addVideo(new Video(1, "Sample Video 1", "Part 1", "http://example.com/1"));
        videoManager.addVideo(new Video(2, "Sample Video 2", "Part 2", "http://example.com/2"));

        while (true) {
            // 메뉴 출력
            System.out.println("메뉴를 선택하세요:");
            System.out.println("1. 영상정보");
            System.out.println("2. 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // 영상 목록 출력
                List<Video> videos = videoManager.selectVideo();
                System.out.println("영상 목록:");
                for (Video video : videos) {
                    System.out.println("번호: " + video.getNo() + ", 제목: " + video.getTitle());
                }

                // 사용자에게 영상 번호 입력 받기
                System.out.print("상세 정보를 보고 싶은 영상 번호를 입력하세요: ");
                int videoNo = scanner.nextInt();
                Video selectedVideo = videoManager.selectVideoByNo(videoNo);

                if (selectedVideo != null) {
                    // 영상의 상세 내용 출력
                    System.out.println("영상 상세 정보:");
                    System.out.println("번호: " + selectedVideo.getNo());
                    System.out.println("제목: " + selectedVideo.getTitle());
                    System.out.println("파트: " + selectedVideo.getPart());
                    System.out.println("URL: " + selectedVideo.getUrl());

                    // 리뷰 등록
                    System.out.print("리뷰를 입력하세요: ");
                    scanner.nextLine(); // 버퍼 비우기
                    String reviewContent = scanner.nextLine();
                    VideoReview newReview = new VideoReview();
                    reviewManager.addReview(newReview);
                    System.out.println("리뷰가 등록되었습니다: " + reviewContent);
                } else {
                    System.out.println("해당 번호의 영상이 존재하지 않습니다.");
                }
            } else if (choice == 2) {
                System.out.println("프로그램을 종료합니다.");
                break;  // 종료
            } else {
                System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
            }
            System.out.println();  // 줄 바꿈
        }

        scanner.close();  // 스캐너 닫기
    }
}
