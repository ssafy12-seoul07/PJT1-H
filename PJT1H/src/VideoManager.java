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
