<h1>OOP Assignment1

**by Naseem And Gammel**

<h2>Description 

<h3>UndoableStringBuilder And Observer Design-Patten 
	
	
The assignment is around how we can use the Observer Design-pattern  
and add to it our Ex0 project which was about the UndoableStringBuilder

	
	
UndoableStringBuilder take the features of the StringBuilder And add to them
undo function which undo the recent change that was made
to the object by using a stack.

In the assignment we have two interfaces which are used for the observer design-pattern: 
	
     Sender: is the observable  
     Member: is the our observer 

<h3>GroupAdmin
The GroupAdmin class implements the Sender interface 
 GroupAdmin has 2 attributes :
	
	
	1.UndoableStringBuilder  
	2.ArrayList of all registered members 
The Groupadmin adds members by the register function to the ArrayList
and every Change that happen to the UndoableStringbuilder it notifies 
and update all the registered members by changing their UndoableStringBuilder

<h2>The GroupAdmin has these methods : 

    methods to register and unregister observers
    void register(Member obj); //add
    void unregister(Member obj); //remove
    
    it takes a member and add them and remove them from the ArrayList
    
    
    Inserts the string into this character sequence.
    void insert(int offset, String obj);
    
    insert a string into the UndoableStringBuilder then notify and update all the registered members
    
    
     Appends the specified string to this character sequence.
    void append(String obj);
    
    Append a string into the UndoableStringBuilder then notify and update all the registered members 

     Removes the characters in a substring of this sequence.
    void delete(int start, int end);
    
    delete  substring from the UndoableStringBuilder and then notify and update all the registered members 
    
    
    Erases the last change done to the document, reverting
     it to an older state.
    void undo();


<h3>ConcreteMember : 
	
	
The ConcreteMember class implements the Member interface
which will create a member that subscribe to the Groupadmin list 
and every change that happen in the stringbuilder it will be change for this member

it has 1 attributed : 
	
	
		1.Member of type Groupadmin

<h4>the constructor: everytime the user Create new Member he will automatically 
be added to the list of the register members in the GroupAdmin (which is way more efficient than manually adding them)

<h2>the ConcreateMember has these methods : 
	
	
	addme() :
  	 which will add the member to the arraylist of the Groupadmin 
	
 	unregisterme() :
		 will remove the member from the arraylist 
	
	update(UndoableStringBuilder usb) :
 	 will take the new UndoableStringBuilder that has been changed from the Groupadmin
 		and replace the member's ones


<h3>UndoableStringBuilder:
	
this is a class we wrote in the assignment 0 which as we said it takes the 
Stringbuilder and improve on it by adding the undo() function which will 
undo the last changes we did to the string 
	
it has 1 attributed : 
			
	
	1. StringBuilder : hold the string
	2.Stack : hold all the changes
	
	
the method it uses : 
	
	
		1.reverse() :reverse the string
		2.append(String str) :append a string to the current one
		3.undo() :undo the changes that has been made previously 
		4.insert(int offset, String str) :insert a string into a specific place in the current string
		5.delete(int start, int end) :delete a substring
		6.replace(int start, int end, String str) :replace the specific string by another one
		7.tostring() :explain or show the string of the Stringbuilder
	
		
		
		
		
		
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


