package observer;

import java.util.ArrayList;
import java.util.List;

public class GroupAdmin implements Sender{
    private UndoableStringBuilder stringbuilder;
    private List<Member> members;


    /**constructor */
    public GroupAdmin(UndoableStringBuilder stringbuilder){
        /*rethinkit*/
        this.stringbuilder=stringbuilder;
        members=new ArrayList<>();

    }
    public GroupAdmin(){
        this.stringbuilder=new UndoableStringBuilder();
        members=new ArrayList<>();
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
    }
}