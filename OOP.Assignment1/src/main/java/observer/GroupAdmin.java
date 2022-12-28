package observer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAdmin implements Sender{

    private UndoableStringBuilder stringbuilder;
    private ArrayList<Member> members;


    public List<Member> getMembers() {
        return members;
    }

    public UndoableStringBuilder getStringbuilder() {
        return stringbuilder;
    }


    /**constructor */
    public GroupAdmin(UndoableStringBuilder stringbuilder){

        this.stringbuilder=stringbuilder;
        members=new ArrayList<>();

    }
    public GroupAdmin(){
        this.stringbuilder=new UndoableStringBuilder();
        members=new ArrayList<>();
    }

    public void setStringbuilder(UndoableStringBuilder stringbuilder) {
        this.stringbuilder = stringbuilder;
    }

    @Override
    public void register(Member obj) {
        this.members.add(obj);

    }

    @Override
    public void unregister(Member obj) {
        this.members.remove(obj);

    }

    @Override
    public void insert(int offset, String obj) {
    this.stringbuilder.insert(offset,obj);
    notifymembers();

    }

    @Override
    public void append(String obj) {
        this.stringbuilder.append(obj);
        notifymembers();
    }

    @Override
    public void delete(int start, int end) {
        this.stringbuilder.delete(start,end);
        notifymembers();
    }

    @Override
    public void undo() {
        this.stringbuilder.undo();
        notifymembers();
    }

    public void notifymembers(){
        for(Member member:members)
            member.update(stringbuilder);

    System.out.println("all members has been notified");
    }

    public static void main(String[] args) {
        GroupAdmin a = new GroupAdmin();
        ConcreteMember m1 = new ConcreteMember(a);
        ConcreteMember m2 = new ConcreteMember(a);
        System.out.println(a.members.toString());

        a.append("hello a");


    }
}
