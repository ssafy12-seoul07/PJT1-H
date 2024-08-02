import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReviewManager {
    private int reviewNo;  // 리뷰 번호를 위한 카운터
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
