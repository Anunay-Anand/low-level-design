package LLD_Interview_Problems.Widget.IntegrationAdapters;

import LLD_Interview_Problems.Widget.IntegrationConfig;
import LLD_Interview_Problems.Widget.WidgetData;

public interface IntegrationAdapter {
     WidgetData fetchData(IntegrationConfig integrationConfig);
}
