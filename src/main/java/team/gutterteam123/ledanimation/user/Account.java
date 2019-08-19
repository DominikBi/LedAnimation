package team.gutterteam123.ledanimation.user;

import io.github.splotycode.mosaik.domparsing.annotation.DomEntry;
import io.github.splotycode.mosaik.domparsing.annotation.FileSystem;
import io.github.splotycode.mosaik.domparsing.annotation.parsing.SerialisedEntryParser;
import io.github.splotycode.mosaik.runtime.LinkBase;
import io.github.splotycode.mosaik.runtime.Links;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@DomEntry("account")
@Getter
@Setter
@NoArgsConstructor
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final FileSystem<Account> FILE_SYSTEM = LinkBase.getInstance().getLink(Links.PARSING_FILEPROVIDER).provide("users", new SerialisedEntryParser());

    private String name, password, salt;

    private boolean admin;

    public Account(String name, boolean admin) {
        this.name = name;
        this.admin = admin;
    }

}
