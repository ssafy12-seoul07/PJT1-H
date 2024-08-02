import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.io.*;

import com.google.gson.Gson;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        VideoManager videoManager = VideoManager.getInstance();
        ReviewManager reviewManager = ReviewManager.getInstance();
        Scanner scanner = new Scanner(System.in);


      	//파일 가져오기
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/video.json")));
        String str = null; //한줄씩 읽어오기 위한 임시변수
        StringBuilder sb = new StringBuilder();
        while((str = br.readLine()) != null) {
            sb.append(str); //한줄식 이어붙인다.
        }
        //sb에 모든 문자열 저장
        Gson gson = new Gson();
        Video[] arr = gson.fromJson(sb.toString(), Video[].class);
        
        // 가져온 파일 videoManager에 추가
        for(int i=0; i<arr.length;i++) {
        	videoManager.addVideo(arr[i]);
        }
       
        while (true) {
        	System.out.println("==============================================================");
            // 메뉴 출력
            System.out.println("메뉴를 선택하세요:");
            System.out.println("1. 영상정보");
            System.out.println("2. 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            System.out.println("==============================================================");
            if (choice == 1) {
            	
                // 영상 목록 출력
                List<Video> videos = videoManager.selectVideos();
                System.out.println("영상 목록:");
                for (Video video : videos) {
                    System.out.println("번호: " + video.getNo() + ", 제목: " + video.getTitle());
                }
                
                System.out.println("==============================================================");
                
                // 사용자에게 영상 번호 입력 받기
                System.out.print("상세 정보를 보고 싶은 영상 번호를 입력하세요: ");
                int videoNo = scanner.nextInt();
                Video selectedVideo = videoManager.selectVideoByNo(videoNo);
                
                System.out.println("==============================================================");
                
                if (selectedVideo != null) {
                    // 영상의 상세 내용 출력
                    System.out.println("영상 상세 정보:");
                    System.out.println("번호: " + selectedVideo.getNo());
                    System.out.println("제목: " + selectedVideo.getTitle());
                    System.out.println("파트: " + selectedVideo.getPart());
                    System.out.println("URL: " + selectedVideo.getUrl());
                    
                    System.out.println("==============================================================");
                    
                    // 해당 영상에 달린 리뷰 출력
                    List<VideoReview> reviews = reviewManager.selectReview(selectedVideo.getNo());
                    System.out.println("리뷰 목록:");
                    if (reviews.isEmpty()) {
                        System.out.println("현재 등록된 리뷰가 없습니다.");
                    } else {
                        for (VideoReview review : reviews) {
                            System.out.println("리뷰 내용: " + review.getContent());
                        }
                    }
                    
                    System.out.println("==============================================================");
                    
                    // 리뷰 등록 여부 질문
                    System.out.print("이 영상에 리뷰를 등록하시겠습니까? (예: 1, 아니오: 0): ");
                    int reviewChoice = scanner.nextInt();
                    
                    System.out.println("==============================================================");
                    
                    //리뷰 내용 등록
                    if (reviewChoice == 1) {
                        System.out.print("리뷰 내용을 입력하세요: ");
                        scanner.nextLine(); // 버퍼 비우기
                        String reviewContent = scanner.nextLine();
                        VideoReview newReview = new VideoReview(selectedVideo.getNo(), 0, reviewContent);
                        reviewManager.addReview(newReview);
                        System.out.println("리뷰가 등록되었습니다: " + reviewContent);
                    }
                }
				else {
                    System.out.println("해당 번호의 영상이 존재하지 않습니다.");
                }
            }
			else if (choice == 2) {
                System.out.println("프로그램을 종료합니다.");
                break;  // 종료
            }
			else {
                System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
            }
        }

        scanner.close();  // 스캐너 닫기
        br.close();// br 닫기
    }
}
