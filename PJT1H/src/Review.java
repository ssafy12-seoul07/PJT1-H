public class Review {
    private int videoNo;      // 비디오 번호
    private String reviewNo;  // 리뷰 번호
    private String content;    // 리뷰 내용

    // 생성자
    public Review(int videoNo, String reviewNo, String content) {
        this.videoNo = videoNo;
        this.reviewNo = reviewNo;
        this.content = content;
    }

    // 비디오 번호 getter
    public int getVideoNo() {
        return videoNo;
    }

    // 비디오 번호 setter
    public void setVideoNo(int videoNo) {
        this.videoNo = videoNo;
    }

    // 리뷰 번호 getter
    public String getReviewNo() {
        return reviewNo;
    }

    // 리뷰 번호 setter
    public void setReviewNo(String reviewNo) {
        this.reviewNo = reviewNo;
    }

    // 리뷰 내용 getter
    public String getContent() {
        return content;
    }

    // 리뷰 내용 setter
    public void setContent(String content) {
        this.content = content;
    }

	@Override
	public String toString() {
		return "Review [videoNo=" + videoNo + ", reviewNo=" + reviewNo + ", content=" + content + "]";
	}
}