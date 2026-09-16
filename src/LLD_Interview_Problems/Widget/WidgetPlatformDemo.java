package LLD_Interview_Problems.Widget;

import LLD_Interview_Problems.Widget.Enums.IntegrationType;
import LLD_Interview_Problems.Widget.Enums.RenderType;
import LLD_Interview_Problems.Widget.Enums.WidgetStatus;
import LLD_Interview_Problems.Widget.RenderStrategy.RenderFactory;

public class WidgetPlatformDemo {

    public static void main(String[] args) {

        Widget widget = new Widget(
                "room-offers",
                "Room Offers",
                WidgetStatus.ACTIVE
        );

        // This can come from a database or configuration service.
        WidgetConfig runtimeConfig = new WidgetConfig(
                "room-offers",
                IntegrationType.REST,
                RenderType.CARD
        );

        IntegrationConfig integrationConfig =
                new IntegrationConfig(
                        IntegrationType.REST,
                        "https://hotel-service/rooms"
                );

        WidgetService widgetService =
                new WidgetService(
                        new IntegrationAdaptorFactory(),
                        new RenderFactory()
                );

        WidgetResponse response =
                widgetService.getWidget(
                        widget,
                        runtimeConfig,
                        integrationConfig
                );

        System.out.println(response);

        //Changing only the runtime configuration:
        WidgetConfig runtimeConfig2 = new WidgetConfig(
                "room-offers",
                IntegrationType.MOCK,
                RenderType.LIST
        );
    }
}
