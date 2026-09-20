package LLD_Interview_Problems.Widget;

import LLD_Interview_Problems.Widget.IntegrationAdapters.IntegrationAdapter;
import LLD_Interview_Problems.Widget.RenderStrategy.RenderFactory;
import LLD_Interview_Problems.Widget.RenderStrategy.WidgetRender;

public class WidgetService {

    private final IntegrationAdaptorFactory integrationAdaptorFactory;
    private final RenderFactory renderFactory;

    WidgetService(IntegrationAdaptorFactory integrationAdaptorFactory, RenderFactory renderFactory) {
        this.integrationAdaptorFactory = integrationAdaptorFactory;
        this.renderFactory = renderFactory;
    }

    public WidgetResponse getWidget(Widget widget, WidgetConfig widgetConfig, IntegrationConfig intConfig) {
        IntegrationAdapter adaptor = integrationAdaptorFactory.getAdaptor(widgetConfig.getIntegrationType());
        WidgetData data = adaptor.fetchData(intConfig);
        WidgetRender widgetRender = renderFactory.getRenderer(widgetConfig.getRenderType());
        WidgetResponse response = widgetRender.render(widget.getKey(), data);
        return response;
    }
}
