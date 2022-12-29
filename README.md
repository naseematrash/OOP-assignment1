# OOP Assignment1

**by Naseem And Gammel**

## Description 

### UndoableStringBuilder And Observer Design-Patten 
The assignment is around how we can use the Observer Design-pattern  
and add to it our Ex0 project which was about the UndoableStringBuilder

UndoableStringBuilder take the features of the StringBuilder And add to them
 undo function which undo the recent change that was made
to the object by using a stack.

In the assignment we have two interfaces which are used for the observer design-pattern: 
Sender: is the observable  
Member: is the our observer  

### GroupAdmin
The GroupAdmin class implements the Sender interface 
 GroupAdmin has 2 attributes :
1.UndoableStringBuilder  
2.ArrayList of all registered members 
The Groupadmin adds members by the register function to the ArrayList
and every Change that happen to the UndoableStringbuilder it notifies 
and update all the registered members by changing their UndoableStringBuilder

##The GroupAdmin has these methods : 

    ####methods to register and unregister observers
    void register(Member obj); //add
    void unregister(Member obj); //remove
    
    it takes a member and add them and remove them from the ArrayList
    
    
    ####Inserts the string into this character sequence.
    void insert(int offset, String obj);
    
    insert a string into the UndoableStringBuilder then notify and update all the registered members
    
    
    #### Appends the specified string to this character sequence.
    void append(String obj);
    
    Append a string into the UndoableStringBuilder then notify and update all the registered members 

    #### Removes the characters in a substring of this sequence.
    void delete(int start, int end);
    
    delete  substring from the UndoableStringBuilder and then notify and update all the registered members 
    
    
    #### Erases the last change done to the document, reverting
    #### it to an older state.
    void undo();


### ConcreteMember : 
The ConcreteMember class implements the Member interface
which will create a member that subscribe to the Groupadmin list 
and every change that happen in the stringbuilder it will be change for this member

it has 1 attributed : 
1.Member of type Groupadmin

####the constructor: everytime the user Create new Member he will automatically 
be added to the list of the register members in the GroupAdmin (which is way more efficient than manually adding them)

##the ConcreateMember has these methods : 
    #### addme() 
    : which will add the member to the arraylist of the Groupadmin 
    #### unregisterme() 
    : will remove the member from the arraylist 
    #### update(UndoableStringBuilder usb) 
    : will take the new UndoableStringBuilder that has been changed from the Groupadmin
    and replace the member's ones


## Tests
All the tests were made with the help of JUnit 5.

### UndoableStringBuilderTest
In this class, we tested all the UndoableStringBuilder functionality.

### ConcreteMemberTest
In this class, we'd tested the functionality of the update method
of the ConcreteMember class.

### GroupAdminTest
This class tests the GroupAdmin class abilities and how it can handle
different situations including passing an already registered member,
checking exceptions with the UndoableStringBuilder, etc.

### JvmUtilities tests (Tests.java)
In this class, we'd tested how our objects interact with
the main memory and how efficient there are. We've used the JvmUtilities
class and put all those tests in the Tests.java file.
