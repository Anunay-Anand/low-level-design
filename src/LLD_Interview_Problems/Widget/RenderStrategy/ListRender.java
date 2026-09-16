package LLD_Interview_Problems.Widget.RenderStrategy;

import LLD_Interview_Problems.Widget.Enums.RenderType;
import LLD_Interview_Problems.Widget.WidgetData;
import LLD_Interview_Problems.Widget.WidgetResponse;

public class ListRender implements WidgetRender {
    @Override
    public WidgetResponse render(String widgetKey, WidgetData data) {
        return new WidgetResponse(widgetKey, RenderType.LIST, String.join(",", data.getItems()));
    }
}
