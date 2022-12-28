import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConcreteMemberTest {

    @Test
    void addme() {
        //when we create concretemember we have the function addme() written in the constructor
        GroupAdmin a= new GroupAdmin();
        ConcreteMember m1 = new ConcreteMember(a);
        assertEquals(1,a.getMembers().size());
        ConcreteMember m2 = new ConcreteMember(a);
        ConcreteMember m3 = new ConcreteMember(a);
        ConcreteMember m4 = new ConcreteMember(a);
        assertEquals(4,a.getMembers().size());
        m1.unregisterme();
        m2.unregisterme();
        m3.unregisterme();
        assertEquals(1,a.getMembers().size());
        m1.addme();
        m2.addme();
        assertEquals(3,a.getMembers().size());





    }

    @Test
    void unregisterme() {
        GroupAdmin a= new GroupAdmin();
        ConcreteMember m1 = new ConcreteMember(a);
        ConcreteMember m2 = new ConcreteMember(a);
        ConcreteMember m3 = new ConcreteMember(a);
        ConcreteMember m4 = new ConcreteMember(a);
        assertEquals(4,a.getMembers().size());
        m1.unregisterme();
        m2.unregisterme();
        m3.unregisterme();
        assertEquals(1,a.getMembers().size());


    }

    @Test
    void update() {
        /**
         * the update : updates the stringbuilder for each and every member who is observer to the observable
         * so technically we have checked this in every single test we have done but here another tester to check the
         * update     (every function in groupmember when it change the string in stringbuilder it also update)
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