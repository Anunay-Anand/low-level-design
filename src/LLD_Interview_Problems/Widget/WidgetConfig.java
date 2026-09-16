package LLD_Interview_Problems.Widget;

import LLD_Interview_Problems.Widget.Enums.IntegrationType;
import LLD_Interview_Problems.Widget.Enums.RenderType;


public class WidgetConfig {
    private final String widgetKey;
    private final IntegrationType integrationType;
    private final RenderType renderType;

    public WidgetConfig(String widgetKey, IntegrationType integrationType, RenderType renderType) {
        this.widgetKey = widgetKey;
        this.integrationType = integrationType;
        this.renderType = renderType;
    }

    public String getWidgetKey() {
        return widgetKey;
    }

    public IntegrationType getIntegrationType() {
        return integrationType;
    }

    public RenderType getRenderType() {
        return renderType;
    }
}