package smartmemoryarchive;

import java.time.LocalDate;
import java.util.List;

public class MediaItem {

    private int mediaId;
    private String title;
    private String type;
    private LocalDate uploadDate;
    private List<String> tags;

    public MediaItem(int mediaId, String title, String type, LocalDate uploadDate, List<String> tags) {
        this.mediaId = mediaId;
        this.title = title;
        this.type = type;
        this.uploadDate = uploadDate;
        this.tags = tags;
    }

    public int getMediaId() { return mediaId; }
    public String getTitle() { return title; }
    public String getType() { return type; }
    public LocalDate getUploadDate() { return uploadDate; }
    public List<String> getTags() { return tags; }

    @Override
    public String toString() {
        return "MediaItem{" +
                "id=" + mediaId +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", uploadDate=" + uploadDate +
                ", tags=" + tags +
                '}';
    }
}