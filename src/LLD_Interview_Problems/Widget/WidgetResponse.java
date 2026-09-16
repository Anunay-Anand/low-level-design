package LLD_Interview_Problems.Widget;

import LLD_Interview_Problems.Widget.Enums.RenderType;

import java.util.UUID;

public class WidgetResponse {
    private String widgetKey;
    private RenderType layoutType;
    private Object data;

    public WidgetResponse(String widgetKey, RenderType renderType, Object data) {
        this.data = data;
        this.widgetKey = widgetKey;
        this.layoutType = renderType;
    }
}
