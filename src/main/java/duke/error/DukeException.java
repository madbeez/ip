package duke.error;
/**
 * This exception is for non-standard exceptions related to Duke
 */
public class DukeException extends Exception {
    private String errorMessage;
    public DukeException(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
