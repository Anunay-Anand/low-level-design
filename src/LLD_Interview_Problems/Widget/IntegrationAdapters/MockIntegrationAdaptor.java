package LLD_Interview_Problems.Widget.IntegrationAdapters;

import LLD_Interview_Problems.Widget.IntegrationConfig;
import LLD_Interview_Problems.Widget.WidgetData;

import java.util.List;

public class MockIntegrationAdaptor implements IntegrationAdapter {
    @Override
    public WidgetData fetchData(IntegrationConfig integrationConfig) {
        System.out.println("Fetch Mock API " + integrationConfig.endpoint());

        return new WidgetData("Available Rooms", List.of("Room 1", "Room 2"));
    }
}
