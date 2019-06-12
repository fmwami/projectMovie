package movie_shop_model;

public class movieResponse {
    public int respCode;
    public String respMessage;
    public movieResponse(int respCode, String respMessage) {
        super();
        this.respCode = respCode;
        this.respMessage = respMessage;
    }
    public movieResponse(int respCode) {
        super();
        this.respCode = respCode;
    }
}
