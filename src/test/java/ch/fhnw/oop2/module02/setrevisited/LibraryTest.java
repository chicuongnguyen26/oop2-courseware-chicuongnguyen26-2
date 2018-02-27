package ch.fhnw.oop2.module02.setrevisited;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Dieter Holz
 */
class LibraryTest {

    @Test
    void testAddSame() {
        //given
        Library lib  = new Library();
        Book    book = new Book(123);

        //when
        lib.add(book);
        lib.add(book);

        //then
        assertEquals(1, lib.size());
        assertTrue(lib.contains(book));
        assertSame(book, lib.get(123));
    }


}