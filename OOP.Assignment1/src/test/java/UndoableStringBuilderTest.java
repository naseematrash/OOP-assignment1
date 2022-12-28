import observer.UndoableStringBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class UndoableStringBuilderTest {
    /**
     * Test all the methods with the undo method
     *
     * Extreme cases
     * Empty Stack
     * assert if the stack works properly
     *
     */
    @Test
    void undo() {
        UndoableStringBuilder Tester = new UndoableStringBuilder();
        Tester.append("to be or not to be");
        assertEquals("be or not to be",Tester.delete(0,3).toString());
        Tester.undo();
        assertEquals("to be or not to be" , Tester.toString());
        UndoableStringBuilder Tester2 = new UndoableStringBuilder();
        Tester2.append("Hello ");
        Tester2.append("nice ");
        Tester2.append("world!");
        Tester2.undo();
        assertEquals("Hello nice ", Tester2.toString());
        Tester2.undo();
        assertEquals("Hello " , Tester2.toString());
        Tester2.undo();

        UndoableStringBuilder Tester3 = new UndoableStringBuilder();
        Tester3.append("to be or not to be");
        assertEquals("to be or not to be", Tester3.delete(15,15).toString()); // no change case
        assertEquals("to be or not be" , Tester3.delete(12,15).toString());
        assertEquals("to be or be" , Tester3.delete(8,12).toString());
        assertEquals("to be be" , Tester3.delete(5,8).toString());
        assertEquals("to be" , Tester3.delete(2,5).toString());
        assertEquals("to" , Tester3.delete(2,5).toString());
        assertEquals("" , Tester3.delete(0,2).toString()); // The blank case

        Tester3.undo();
        assertEquals("to" , Tester3.toString());
        Tester3.undo();
        assertEquals("to be" , Tester3.toString());
        Tester3.undo();
        assertEquals("to be be" , Tester3.toString());
        Tester3.undo();
        assertEquals("to be or be" , Tester3.toString());
        Tester3.undo();
        assertEquals("to be or not be" , Tester3.toString());
        Tester3.undo();
        assertEquals("to be or not to be" , Tester3.toString());

        UndoableStringBuilder Tester4 = new UndoableStringBuilder();
        Tester4.append("to  or  to ");
        assertEquals("to be or  to " , Tester4.insert(3,"be").toString());
        assertEquals("to be or not to " , Tester4.insert(9,"not").toString());
        assertEquals("to be or not to be" , Tester4.insert(16,"be").toString());
        Tester4.undo();
        assertEquals("to be or not to " , Tester4.toString());
        Tester4.undo();
        assertEquals("to be or  to " , Tester4.toString());
        Tester4.undo();
        assertEquals("to  or  to ",Tester4.toString());


        UndoableStringBuilder Tester5 = new UndoableStringBuilder();
        Tester5.append("to be or not to be");
        assertEquals("to eat or not to be" , Tester5.replace(3,5, "eat").toString());
        assertEquals("to eat or not to eat" , Tester5.replace(17,19, "eat").toString());
        assertEquals("to eat or not to eat" , Tester5.replace(0 , 0 , "").toString()); // no change case
        Tester5.undo();
        assertEquals("to eat or not to eat",Tester5.toString());
        Tester5.undo();
        assertEquals("to eat or not to be",Tester5.toString());
        Tester5.undo();
        assertEquals("to be or not to be",Tester5.toString());
        Tester5.undo();


        UndoableStringBuilder Tester6 = new UndoableStringBuilder();
        Tester6.append("to be or not to be");
        assertEquals("eb ot ton ro eb ot" , Tester6.reverse().toString());
        assertEquals("to be or not to be" , Tester6.reverse().toString());
        Tester6.undo();
        assertEquals("eb ot ton ro eb ot", Tester6.toString());
        Tester6.undo();
        assertEquals("to be or not to be", Tester6.toString());
        Tester6.undo();

        UndoableStringBuilder Tester7 = new UndoableStringBuilder();
        Tester7.append("go og go og");
        assertEquals("go og go og" , Tester7.reverse().toString());
        Tester7.undo();
        assertEquals("go og go og",Tester7.toString());

    }

    @Test
    void append() {
        UndoableStringBuilder Tester = new UndoableStringBuilder();
        assertEquals("to " , Tester.append("to ").toString());
        assertEquals("to be " , Tester.append("be ").toString());
        assertEquals("to be or " , Tester.append("or ").toString());
        assertEquals("to be or not ", Tester.append("not ").toString());
        assertEquals("to be or not to be" , Tester.append("to be").toString());
        assertNotEquals("to be or not to be" , Tester.append(" ").toString());
        assertNotEquals("to be or not to be" , Tester.append("").toString());
        assertNotEquals("to be or not to be", Tester.append(null)); // the second null case

    }

    @Test
    void delete() {
        UndoableStringBuilder Tester = new UndoableStringBuilder();
        Tester.append("to be or not to be");
        assertEquals("to be or not to be", Tester.delete(15,15).toString()); // no change case
        assertEquals("to be or not be" , Tester.delete(12,15).toString());
        assertEquals("to be or be" , Tester.delete(8,12).toString());
        assertEquals("to be be" , Tester.delete(5,8).toString());
        assertEquals("to be" , Tester.delete(2,5).toString());
        assertEquals("to" , Tester.delete(2,5).toString());
        assertEquals("" , Tester.delete(0,2).toString()); // The blank case
    }

    @Test
    void insert() {
        UndoableStringBuilder Tester = new UndoableStringBuilder();
        Tester.append("to  or  to ");
        assertEquals("to be or  to " , Tester.insert(3,"be").toString());
        assertEquals("to be or not to " , Tester.insert(9,"not").toString());
        assertEquals("to be or not to be" , Tester.insert(16,"be").toString());

    }

    @Test
    void replace() {
        UndoableStringBuilder Tester = new UndoableStringBuilder();
        Tester.append("to be or not to be");
        assertEquals("to eat or not to be" , Tester.replace(3,5, "eat").toString());
        assertEquals("to eat or not to eat" , Tester.replace(17,19, "eat").toString());
        assertEquals("to eat or not to eat" , Tester.replace(0 , 0 , "").toString()); // no change case

    }

    @Test
    void reverse() {
        UndoableStringBuilder Tester = new UndoableStringBuilder();
        Tester.append("to be or not to be");
        assertEquals("eb ot ton ro eb ot" , Tester.reverse().toString()); //normal case
        assertEquals("to be or not to be" , Tester.reverse().toString());
        UndoableStringBuilder Tester2 = new UndoableStringBuilder();
        Tester2.append("go og go og");
        assertEquals("go og go og" , Tester2.reverse().toString()); // same string


    }
}