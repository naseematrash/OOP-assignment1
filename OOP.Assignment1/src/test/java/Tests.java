import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.net.ConnectException;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){
        GroupAdmin admin =new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember(admin);
        ConcreteMember member2 = new ConcreteMember(admin);
        ConcreteMember member3 = new ConcreteMember(admin);

       // logger.info(()->JvmUtilities.objectFootprint(s1));

        //logger.info(()->JvmUtilities.objectFootprint(s1,s2));

        //logger.info(()->JvmUtilities.objectTotalSize(s1));

        //logger.info(() -> JvmUtilities.jvmInfo());
    }
}
