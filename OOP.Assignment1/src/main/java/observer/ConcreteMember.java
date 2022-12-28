package observer;



public class ConcreteMember implements Member {
    private GroupAdmin member;


    //private String sentence;

    public ConcreteMember(GroupAdmin m){
        this.member=m;
        member.setStringbuilder(m.getStringbuilder());
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
        this.member.setStringbuilder(usb);

    }
    public String toString(){

    }




}
