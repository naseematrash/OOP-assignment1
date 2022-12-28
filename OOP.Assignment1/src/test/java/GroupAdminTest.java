import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {

    @Test
    void register() {
        GroupAdmin a= new GroupAdmin();
        ConcreteMember m1 = new ConcreteMember(a);
        assertEquals(1,a.getMembers().size());
        a.unregister(m1);
        assertEquals(0,a.getMembers().size());
        a.register(m1);
        assertEquals(1,a.getMembers().size());


    }

    @Test
    void unregister() {
        GroupAdmin a= new GroupAdmin();
        ConcreteMember m1 = new ConcreteMember(a);
        ConcreteMember m2 = new ConcreteMember(a);
        ConcreteMember m3 = new ConcreteMember(a);
        ConcreteMember m4 = new ConcreteMember(a);

        assertEquals(4,a.getMembers().size());
        a.unregister(m1);
        assertEquals(3,a.getMembers().size());
        a.unregister(m2);
        assertEquals(2,a.getMembers().size());
        a.unregister(m3);
        assertEquals(1,a.getMembers().size());
        a.unregister(m4);
        assertEquals(0,a.getMembers().size());


    }

    @Test
    void insert() {
        GroupAdmin a= new GroupAdmin();
        ConcreteMember m1 = new ConcreteMember(a);
        ConcreteMember m2 = new ConcreteMember(a);
        a.insert(0,"hi");
        assertEquals(m1.toString(),"hi");
        a.insert(1,"how");
        assertEquals(m1.toString(),"hhowi");

        for(int i=0;i<a.getMembers().size();i++){
            assertEquals(a.getMembers().get(i).toString(),"hhowi");
        }
    }

    @Test
    void append() {
        GroupAdmin a = new GroupAdmin();
        ConcreteMember m1 = new ConcreteMember(a);
        ConcreteMember m2 = new ConcreteMember(a);
        a.append("hello");
        assertEquals(m1.toString(), "hello");
        a.append(" how are you");
        assertEquals(m1.toString(), "hello how are you");

        for (int i = 0; i < a.getMembers().size(); i++) {
            assertEquals(a.getMembers().get(i).toString(), "hello how are you");
        }
    }

    @Test
    void delete() {
        GroupAdmin a = new GroupAdmin();
        ConcreteMember m1 = new ConcreteMember(a);
        ConcreteMember m2 = new ConcreteMember(a);
        a.append("hello how are you");
        a.delete(1,3);
        assertEquals(m1.toString(),"hlo how are you");
        for (int i = 0; i < a.getMembers().size(); i++) {
            assertEquals(a.getMembers().get(i).toString(), "hlo how are you");
        }
    }

    @Test
    void undo() {
        GroupAdmin a = new GroupAdmin();
        ConcreteMember m1 = new ConcreteMember(a);
        ConcreteMember m2 = new ConcreteMember(a);
        a.append("hello how are you");
        a.append("whatsup");
        a.undo();
        assertEquals(m1.toString(),"hello how are you");
        for (int i = 0; i < a.getMembers().size(); i++) {
            assertEquals(a.getMembers().get(i).toString(), "hello how are you");
        }

    }

    @Test
    void notifymembers() {
        /** here we can test this if the code write : all members has been notified and then the
         * stringbuilder has changed its content in every member inside the array of members
         * so we actually have been testing this in every previous tester so it works but here is a test for it:
         * */
        GroupAdmin a = new GroupAdmin();
        ConcreteMember m1 = new ConcreteMember(a);
        ConcreteMember m2 = new ConcreteMember(a);
        a.append("hello how are you");
        a.append("whatsup");
        a.undo();
        assertEquals(m1.toString(),"hello how are you");
        for (int i = 0; i < a.getMembers().size(); i++) {
            assertEquals(a.getMembers().get(i).toString(), "hello how are you");
        }

    }
}