package LLD_Interview_Problems.Widget;

import LLD_Interview_Problems.Widget.Enums.IntegrationType;
import LLD_Interview_Problems.Widget.IntegrationAdapters.IntegrationAdapter;
import LLD_Interview_Problems.Widget.IntegrationAdapters.MockIntegrationAdaptor;
import LLD_Interview_Problems.Widget.IntegrationAdapters.RestIntegrationAdaptor;

public class IntegrationAdaptorFactory {
    public IntegrationAdapter getAdaptor(IntegrationType type) {
        return switch(type) {
            case MOCK -> new MockIntegrationAdaptor();
            case REST -> new RestIntegrationAdaptor();
        };
    }
}