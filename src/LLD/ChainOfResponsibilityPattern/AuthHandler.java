package LLD.ChainOfResponsibilityPattern;

public class AuthHandler extends BaseHandler {
    @Override
    public void handle(Request request) {
        if(request.user == null) {
            System.out.println("User is not authenticated");
            return;
        }
        System.out.println("AuthHandler: authenticated");
        forward(request);
    }
}
