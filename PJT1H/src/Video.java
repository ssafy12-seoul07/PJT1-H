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
