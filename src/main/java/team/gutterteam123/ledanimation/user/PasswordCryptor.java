package team.gutterteam123.ledanimation.user;

import io.github.splotycode.mosaik.util.CodecUtil;
import io.github.splotycode.mosaik.util.random.PatternGenerator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PasswordCryptor {

    private static final PatternGenerator SALT_GENERATOR = new PatternGenerator(6, 4);

    public static String cryptPassword(String password, String salt) {
        return CodecUtil.sha256Hex(password + salt);
    }

    public static void setPassword(Account account, String password) {
        account.setSalt(SALT_GENERATOR.build());
        account.setPassword(cryptPassword(password, account.getSalt()));
    }

    public static boolean passwordMatch(Account account, String password) {
        return account.getPassword().equals(cryptPassword(password, account.getSalt()));
    }

}
