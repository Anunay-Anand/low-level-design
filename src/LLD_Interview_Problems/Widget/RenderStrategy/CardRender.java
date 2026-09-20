package LLD_Interview_Problems.Widget.RenderStrategy;

import LLD_Interview_Problems.Widget.Enums.RenderType;
import LLD_Interview_Problems.Widget.WidgetData;
import LLD_Interview_Problems.Widget.WidgetResponse;

public class CardRender implements WidgetRender {
    @Override
    public WidgetResponse render(String widgetKey, WidgetData data) {
        return new WidgetResponse.widgetBuilder()
                .widgetKey(widgetKey).layout("CARD")
                .data(data.getItems()).build();
    }
}
