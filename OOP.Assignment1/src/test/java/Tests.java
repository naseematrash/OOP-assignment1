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


        System.out.println("jvm info: ");
        logger.info(() -> JvmUtilities.jvmInfo());

        System.out.println("objectfootprint: ");
        logger.info(()->JvmUtilities.objectFootprint(admin,member1,member2));
        System.out.println("totalsize: ");
        logger.info(()->JvmUtilities.objectTotalSize(admin,member1,member2));


        System.out.println("objectfootprintfor admin.append ");
        admin.append("hello!");
        logger.info(()->JvmUtilities.objectFootprint(admin));
        System.out.println("totalsize for admin.append ");
        logger.info(()->JvmUtilities.objectTotalSize(admin));



        System.out.println("objectfootprintfor admin.unregister ");
        admin.unregister(member2);
        logger.info(()->JvmUtilities.objectFootprint(admin));
        System.out.println("totalsize for admin.unregister ");
        logger.info(()->JvmUtilities.objectTotalSize(admin));


        System.out.println("objectfootprintfor admin.insert ");
        admin.insert(2,"norway");
        logger.info(()->JvmUtilities.objectFootprint(admin));
        System.out.println("totalsize for admin.insert ");
        logger.info(()->JvmUtilities.objectTotalSize(admin));



        System.out.println("objectfootprintfor admin.delete ");
        admin.delete(1,3);
        logger.info(()->JvmUtilities.objectFootprint(admin));
        System.out.println("totalsize for admin.delete ");
        logger.info(()->JvmUtilities.objectTotalSize(admin));


        System.out.println("objectfootprintfor admin.undo ");
        admin.undo();
        logger.info(()->JvmUtilities.objectFootprint(admin));

        System.out.println("totalsize for admin.undo ");
        logger.info(()->JvmUtilities.objectTotalSize(admin));


        System.out.println("jvm info");
        logger.info(() -> JvmUtilities.jvmInfo());


        System.out.println("objectfootprintfor member2.addme ");
        member2.addme();
        member2.unregisterme();
        logger.info(()->JvmUtilities.objectFootprint(member2));

        System.out.println("totalsize for member2.unregisterme ");
        logger.info(()->JvmUtilities.objectTotalSize(member2));





    }
}
