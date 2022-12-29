package observer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAdmin implements Sender{
    /**
     *  this class have 2  attributes
     *  1. UndoableStringbuilder  (updates the strings)
     *  2. list of members   (the subscribers who wanted the changes that happen to the Undoablestringbuilder)
     */

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

    /**
     *  register : is a function that takes the new member and add them to the list of members
     *  that want to be notified for string changes that happen to UndoableStringbuilder
     */
    @Override
    public void register(Member obj) {
        this.members.add(obj);

    }
    /**
     *  unregister : is a function that take a specific member from the list and remove them from the list
     */
    @Override
    public void unregister(Member obj) {
        this.members.remove(obj);

    }
    /**
     *  insert is a function that insert a text in a place that the user wanted  and notify all members
     */
    @Override
    public void insert(int offset, String obj) {
    this.stringbuilder.insert(offset,obj);
    notifymembers();

    }
    /**
     *  append a text to the String we have in the Undoablestringbuilder  and notify all members
     */
    @Override
    public void append(String obj) {
        this.stringbuilder.append(obj);
        notifymembers();
    }
    /**
     *  delete a part of a string (the user give start and end where he wanna delete)  and notify all members
     */
    @Override
    public void delete(int start, int end) {
        this.stringbuilder.delete(start,end);
        notifymembers();
    }
    /**
     * undo the last changes that happen to the string and notify all members
     * */
    @Override
    public void undo() {
        this.stringbuilder.undo();
        notifymembers();
    }
    /**
     * notify all members in the list  (update the string that they have)
     * */
    public void notifymembers(){
        for(Member member:members)
            member.update(stringbuilder);

    System.out.println("all members has been notified");
    }

}
