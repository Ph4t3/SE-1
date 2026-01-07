package org.hbrs.se1.ws25.exercises.uebung9.Aufgabe_2.Task_2;

import java.nio.charset.Charset;
import java.util.Objects;

public class TextDocument extends CoreDocument{

    public enum Encoding {
        UTF8("UTF-8"),
        UTF16("UTF-16"),
        UTF32("UTF-32");

        private final String code;

        Encoding(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    private final String content;
    private final Encoding encoding;

    public TextDocument(String content, Encoding encoding) {
        this.content = Objects.requireNonNull(content);
        this.encoding = Objects.requireNonNull(encoding);
    }

    @Override
    public int size() {
        // Anzahl Bytes abhängig vom Encoding
        Charset cs = Charset.forName(encoding.getCode());
        return content.getBytes(cs).length;
    }
}
