package smartmemoryarchive;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SearchModule {

    // Search by keyword in title OR tags
    public List<MediaItem> search(List<MediaItem> allItems, String keyword) {
        List<MediaItem> result = new ArrayList<>();
        if (allItems == null) return result;

        if (keyword == null) keyword = "";
        String k = keyword.toLowerCase().trim();

        for (MediaItem item : allItems) {
            if (item == null) continue;

            boolean matchTitle = item.getTitle() != null &&
                    item.getTitle().toLowerCase().contains(k);

            boolean matchTags = false;
            if (item.getTags() != null) {
                for (String tag : item.getTags()) {
                    if (tag != null && tag.toLowerCase().contains(k)) {
                        matchTags = true;
                        break;
                    }
                }
            }

            if (k.isEmpty() || matchTitle || matchTags) {
                result.add(item);
            }
        }
        return result;
    }

    // Filter items by uploadDate range (from .. to)
    public List<MediaItem> filterByDate(List<MediaItem> items, LocalDate from, LocalDate to) {
        List<MediaItem> result = new ArrayList<>();
        if (items == null) return result;

        for (MediaItem item : items) {
            if (item == null || item.getUploadDate() == null) continue;

            LocalDate d = item.getUploadDate();

            boolean afterFrom = (from == null) || !d.isBefore(from);
            boolean beforeTo  = (to == null)   || !d.isAfter(to);

            if (afterFrom && beforeTo) {
                result.add(item);
            }
        }
        return result;
    }
}
