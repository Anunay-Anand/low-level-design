package LLD_Interview_Problems.Widget.RenderStrategy;

import LLD_Interview_Problems.Widget.WidgetConfig;
import LLD_Interview_Problems.Widget.WidgetData;
import LLD_Interview_Problems.Widget.WidgetResponse;

public interface WidgetRender {
        public WidgetResponse render(String widgetKey, WidgetData data);
}
