package LLD_Interview_Problems.Widget.IntegrationAdapters;

import LLD_Interview_Problems.Widget.IntegrationConfig;
import LLD_Interview_Problems.Widget.WidgetData;

import java.util.List;

public class RestIntegrationAdaptor implements IntegrationAdapter {
    @Override
    public WidgetData fetchData(IntegrationConfig integrationConfig) {
        System.out.println("Calling Rest API : \n" + integrationConfig.endpoint());

        return new WidgetData("Available Rooms", List.of("Deluxe Room", "Suite Room"));
    }
}
