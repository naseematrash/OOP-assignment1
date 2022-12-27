package observer;



public class ConcreteMember implements Member {

    private GroupAdmin member;
    private UndoableStringBuilder str;
    public ConcreteMember(GroupAdmin m){
        this.member=m;
        this.str=m.getStringbuilder();
        addme();
    }
    public void addme(){
        member.register(this);
    }


    public void unregisterme(){
        member.unregister(this);
    }
    @Override
    public void update(UndoableStringBuilder usb) {
        this.str=usb;

    }

    public UndoableStringBuilder getStr() {
        return str;
    }
}
