package team.gutterteam123.ledanimation.user;

import io.github.splotycode.mosaik.webapi.request.Request;
import io.github.splotycode.mosaik.webapi.response.URLEncode;
import io.github.splotycode.mosaik.webapi.session.impl.LocalSession;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LedSession extends LocalSession {

    private Account account;

    @Override
    public boolean hasPermission(Request request, String permission) {
        return account.isAdmin();
    }
}
