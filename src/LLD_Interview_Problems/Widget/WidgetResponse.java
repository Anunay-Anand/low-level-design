package LLD_Interview_Problems.Widget;

public class WidgetResponse {
    private String widgetKey;
    private String layoutType;
    private Object data;

    public WidgetResponse(widgetBuilder builder) {
        this.widgetKey = builder.widgetKey;
        this.layoutType = builder.layout;
        this.data = builder.data;
    }

    public static class widgetBuilder {

        private String widgetKey;
        private String layout;
        private Object data;

        public widgetBuilder widgetKey(String widgetKey) {
            this.widgetKey = widgetKey;
            return this;
        }

        public widgetBuilder layout(String layout) {
            this.layout = layout;
            return this;
        }

        public widgetBuilder data(Object data) {
            this.data = data;
            return this;
        }

        public WidgetResponse build() {
            return new WidgetResponse(this);
        }
    }
}
