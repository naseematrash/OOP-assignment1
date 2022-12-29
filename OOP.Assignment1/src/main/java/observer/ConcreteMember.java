package observer;



public class ConcreteMember implements Member {
    private GroupAdmin member;


    /**
     *  constructor
     */
    public ConcreteMember(GroupAdmin m) {
        this.member = m;
        member.setStringbuilder(m.getStringbuilder());
        addme();

    }

    /**
     *  function that the constructor use to add our member to the list of members in Group admin
     */
    public void addme() {
        member.register(this);
    }

    /**
     * function that the member uses if he want to unregister from the members list
     * */
    public void unregisterme() {
        member.unregister(this);
    }

    /**
     *  function that updates the member for any string changes that happens from the Group admin
     * @param usb which is a Undoablestringbuilder
     * it change that undoablestringbuilder to the newer module
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.member.setStringbuilder(usb);

    }
    /**
     *  this function give us what is the string that the member see and hold
     */
    public String toString() {
        return member.getStringbuilder().toString();
    }

}
