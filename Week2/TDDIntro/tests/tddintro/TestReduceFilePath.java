package tddintro;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestReduceFilePath {

    @Test
    public void test() {
        assertEquals("/", ReduceFilePath.reduceFilePath("/"));
        assertEquals("/", ReduceFilePath.reduceFilePath("/srv/../"));
        assertEquals("/srv/www/htdocs/wtf", ReduceFilePath.reduceFilePath("/srv/www/htdocs/wtf/"));
        assertEquals("/srv/www/htdocs/wtf", ReduceFilePath.reduceFilePath("/srv/www/htdocs/wtf"));
        assertEquals("/srv", ReduceFilePath.reduceFilePath("/srv/./././././"));
        assertEquals("/etc/wtf", ReduceFilePath.reduceFilePath("/etc//wtf/"));
        assertEquals("/", ReduceFilePath.reduceFilePath("/etc/../etc/../etc/../"));
        assertEquals("/", ReduceFilePath.reduceFilePath("//////////////"));
    }

}
