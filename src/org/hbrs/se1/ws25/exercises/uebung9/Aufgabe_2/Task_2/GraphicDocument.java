package org.hbrs.se1.ws25.exercises.uebung9.Aufgabe_2.Task_2;

import java.util.Objects;

public class GraphicDocument extends CoreDocument{
    private static final int SIZE_BYTES = 1200; //
    private final String url;

    public GraphicDocument(String url) {
        this.url = Objects.requireNonNull(url);
    }

    @Override
    public int size() {
        return SIZE_BYTES;
    }
}
