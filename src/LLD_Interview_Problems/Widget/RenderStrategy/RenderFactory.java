package LLD_Interview_Problems.Widget.RenderStrategy;

import LLD_Interview_Problems.Widget.Enums.RenderType;

public class RenderFactory {
    public WidgetRender getRenderer(RenderType type) {
        return switch(type) {
            case RenderType.CARD -> new CardRender();
            case RenderType.LIST -> new ListRender();
        };
    }
}
