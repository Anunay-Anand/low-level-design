package LLD_Interview_Problems.Widget;

import LLD_Interview_Problems.Widget.Enums.WidgetStatus;

import java.util.UUID;

public class Widget {
    private final UUID id = UUID.randomUUID();
    private final String key;
    private final String name;
    private WidgetStatus status;

    public Widget(String key, String name, WidgetStatus status) {
        this.key = key;
        this.name = name;
        this.status = status;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public WidgetStatus getStatus() {
        return status;
    }
}