package LLD_Interview_Problems.Widget;

import java.util.List;

public class WidgetData {
    private final String title;
    private List<String> items;

    public WidgetData(String title, List<String> items) {
        this.title = title;
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getItems() {
        return items;
    }
}
