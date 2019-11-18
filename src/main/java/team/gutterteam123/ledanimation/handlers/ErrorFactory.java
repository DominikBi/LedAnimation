package team.gutterteam123.ledanimation.handlers;

import io.github.splotycode.mosaik.util.ExceptionUtil;
import io.github.splotycode.mosaik.util.StringUtil;
import io.github.splotycode.mosaik.webapi.request.HandleRequestException;
import io.github.splotycode.mosaik.webapi.response.Response;
import io.github.splotycode.mosaik.webapi.response.error.DefaultErrorFactory;

public class ErrorFactory extends DefaultErrorFactory {

    @Override
    public Response generatePage(Throwable throwable) {
        Response response = super.generatePage(throwable);

        while (throwable != null) {
            if (throwable instanceof HandleRequestException) {
                String error = throwable.getLocalizedMessage();
                response.setHeader("message", StringUtil.isEmpty(error) ? "Internal Error" : error);
            }
            throwable = throwable.getCause();
        }

        return response;
    }

}
