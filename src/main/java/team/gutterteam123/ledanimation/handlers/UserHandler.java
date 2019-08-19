package team.gutterteam123.ledanimation.handlers;

import io.github.splotycode.mosaik.util.Pair;
import io.github.splotycode.mosaik.util.StringUtil;
import io.github.splotycode.mosaik.webapi.handler.anotation.check.Mapping;
import io.github.splotycode.mosaik.webapi.handler.anotation.check.NeedPermission;
import io.github.splotycode.mosaik.webapi.handler.anotation.handle.Get;
import io.github.splotycode.mosaik.webapi.handler.anotation.handle.Post;
import io.github.splotycode.mosaik.webapi.handler.anotation.handle.RequiredGet;
import io.github.splotycode.mosaik.webapi.handler.anotation.handle.RequiredPost;
import io.github.splotycode.mosaik.webapi.request.Request;
import io.github.splotycode.mosaik.webapi.response.Response;
import io.github.splotycode.mosaik.webapi.response.content.ResponseContent;
import io.github.splotycode.mosaik.webapi.response.content.file.CachedStaticFileContent;
import io.github.splotycode.mosaik.webapi.response.content.file.FileResponseContent;
import io.github.splotycode.mosaik.webapi.session.impl.CookieUUIDSessionMatcher;
import team.gutterteam123.ledanimation.LedAnimation;
import team.gutterteam123.ledanimation.devices.Scene;
import team.gutterteam123.ledanimation.user.Account;
import team.gutterteam123.ledanimation.user.LedSession;
import team.gutterteam123.ledanimation.user.PasswordCryptor;

import java.io.File;

public class UserHandler {

    @Mapping("login")
    public ResponseContent login(Request request, Response response) {
        if (request.getSession() == null) {
            return new CachedStaticFileContent("web/static/login.html");
        } else {
            response.redirect("/", false);
            return null;
        }
    }

    @Mapping("doLogin")
    public void doLogin(@RequiredPost("name") String name,
                        @RequiredPost("password") String password,
                        @Post("redirect") String redirect,
                        Request request, Response response) {
        Account account = Account.FILE_SYSTEM.getEntry(name);
        if (account != null && PasswordCryptor.passwordMatch(account, password)) {
            LedAnimation.getInstance().getSessionSystem().start(request);
            ((LedSession) request.getSession()).setAccount(account);
            if (StringUtil.isEmpty(redirect) || redirect.equals("null")) {
                redirect = "/";
            }
            response.redirect(redirect, false);
        } else {
            response.redirect("/login", false);
        }
    }

    @NeedPermission
    @Mapping("logout")
    public void logout(Request request, Response response) {
        LedAnimation.getInstance().getSessionSystem().destroy(request);
        response.redirect("/login", false);
    }

    @Mapping("views/user")
    @NeedPermission
    public ResponseContent view() {
        FileResponseContent content = new FileResponseContent(new File("web/views/user.html"));
        for (Account account : Account.FILE_SYSTEM.getEntries()) {
            content.manipulate().patternCostomWithObj("users", account,
                    new Pair<>("permission", account.isAdmin() ? "Admin" : "Dummy"));
        }
        return content;
    }

    @Mapping(value = "users/create")
    @NeedPermission("create")
    public void create(@RequiredGet(value = "name") String name,
                       @RequiredGet("password") String password,
                       @Get("permission") String permission, Response response) {
        Account account = new Account(name, "on".equals(permission));
        PasswordCryptor.setPassword(account, password);
        Account.FILE_SYSTEM.putEntry(name, account);
        response.redirect("/user", false);
    }

    @NeedPermission("delete")
    @Mapping(value = "users/delete")
    public void delete(@RequiredGet(value = "name") String name, Response response) {
        Account.FILE_SYSTEM.deleteEntry(name);
        response.redirect("/user", false);
    }

}
