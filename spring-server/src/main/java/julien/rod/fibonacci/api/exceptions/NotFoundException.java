package julien.rod.fibonacci.api.exceptions;

import julien.rod.fibonacci.api.exceptions.ApiException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-10T14:22:17.308Z")

public class NotFoundException extends ApiException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
