package image;

public class NotSupportedException extends RuntimeException {

    private  String message;
    public NotSupportedException(String message){
         this.message = message;
    }

}
