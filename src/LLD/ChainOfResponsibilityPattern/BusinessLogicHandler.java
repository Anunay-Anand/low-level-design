package LLD.ChainOfResponsibilityPattern;

class BusinessLogicHandler extends BaseHandler {
    @Override
    public void handle(Request request) {
        System.out.println("BusinessLogicHandler: Processing request for " + request.user + "...");
    }
}
