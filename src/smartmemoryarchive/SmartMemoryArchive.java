package smartmemoryarchive;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class SmartMemoryArchive {

    public static void main(String[] args) {

        // Sample data (زي بيانات تجريبية)
        List<MediaItem> allItems = Arrays.asList(
                new MediaItem(1, "Family Birthday", "Image",
                        LocalDate.of(2025, 1, 10),
                        Arrays.asList("family", "birthday", "memories")),

                new MediaItem(2, "Trip to Sea", "Video",
                        LocalDate.of(2025, 7, 2),
                        Arrays.asList("travel", "sea", "summer")),

                new MediaItem(3, "Graduation Day", "Image",
                        LocalDate.of(2024, 6, 20),
                        Arrays.asList("graduation", "friends"))
        );

        SearchModule searchModule = new SearchModule();

        System.out.println("=== Smart Memory Archive | Search Module Demo ===\n");

        // 1) Search
        String keyword = "summer";
        System.out.println("Search keyword: " + keyword);
        List<MediaItem> searchResult = searchModule.search(allItems, keyword);
        for (MediaItem item : searchResult) {
            System.out.println(item);
        }

        // 2) Filter By Date
        LocalDate from = LocalDate.of(2025, 1, 1);
        LocalDate to   = LocalDate.of(2025, 12, 31);

        System.out.println("\nFilter By Date: " + from + " -> " + to);
        List<MediaItem> filtered = searchModule.filterByDate(allItems, from, to);
        for (MediaItem item : filtered) {
            System.out.println(item);
        }

        System.out.println("\nDone ✅");
    }
}