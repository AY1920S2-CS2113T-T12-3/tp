<style>
img {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: auto;
}
div {
    text-align: center;
    font-size: x-small;
}
</style>
# Developer Guide    

## Table of content
1. [Introduction](#1-introduction)<br>
    1.1. [Purpose](#11-purpose)<br>
    1.2. [Target Reader](#12-target-reader)<br>
    1.3. [Brief Description](#13-brief-description)<br>
    1.4. [Main Features](#14-main-features)
1. [Design](#2-design)<br>
    2.1. [Architecture](#21-architecture)<br>
    2.2. [Task Component](#22-task-component)<br>
    2.3. [Study Area Component](#23-study-area-component)<br>
    2.4. [Notes Component](#24-notes-component)<br>
1. [Implementation](#3-implementation)<br>
    3.1. [Scheduling Tasks](#31-scheduling-tasks)<br>
    3.2. [Listing Study Areas](#32-listing-study-areas)<br>
    3.3. [Operation of Notes](#33-operation-of-notes)<br>
1. [Testing](#4-testing)<br>

[Appendix A: Product Scope](#appendix-a-product-scope)<br>
[Appendix B: User Stories](#appendix-b-user-stories)<br>
[Appendix C: Non-Functional Requirements](#appendix-c-non-functional-requirements)<br>
[Appendix D: Glossary](#appendix-d-glossary)<br>
[Appendix E: Instruction for Manual Testing](#appendix-e-instructions-for-manual-testing)<br>

## 1. Introduction

### 1.1. Purpose

The document is meant to teach you on how OrgaNice! was developed and the design and implementations behind the software.
With this document, you should have a better understanding of the framework of the application. 

### 1.2. Target Reader

The target reader of this developer guide are:

- Project Managers
- Future Developers
- Build Verification Testers

### 1.3. Brief Description

OrgaNice! is a task manager integrated with a Study Area search function. You can use it to manage your tasks, be it events or deadlines. On top of that, 
it is capable of assisting students in finding Study Areas that meets their desired criteria.

### 1.4. Main Features

1. Scheduling Tasks
    - You can manage tasks based on priority for events and countdown for deadlines.
1. Study Area. For more information of the design and implementation for this feature, click [here](#31-scheduling-tasks)
    - You can find a Study Area that meets your criteria. The software however have a limited number of supported 
    criteria. For more information of the design and implementation for this feature, click [here](#32-listing-study-areas)
1. Notes
	- You can enter notes based on school modules. Notes support undo and redo operations.

## 2. Design   
 {Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}    

[comment]: # (@@author GanapathySanathBalaji)
### 2.1. Architecture  
  
![Architecture](images/Architecture.png)
<div>Figure 1. Overall Architecture of OrgaNice!</div>
<br>

1. Duke - Main component which controls the flow of execution.

1. Ui - Component used to get input from the user and display results on the monitor.

1. Parser - Component used to abstract out the command based on user's input, so that the command can be executed later.

1. Command - Component contains information and implementation on how to execute various types of commands.

1. Task - Component contains details about handling the task list and related operations.

1. StudyArea - Component contains details about handling queries for study area search.

1. Notes - Component contains details about Notes related operations.

1. Exception - Component contains the various types of exceptions encountered when OrgaNice! is run.

1. ResourceLoader - Component handles loading and saving of the task list and study area details to local storage.



### 2.2. Task Component  
  

[comment]: # (@@author GanapathySanathBalaji)  
  
The Task component depends on 3 other components,   
  
 1. Command Component - The Command component issues instructions for the Task component to execute based on the user's input.  
 
 2. UI Component - The UI component is used to display the results (and related exceptions) of the commands issued to the Task Component. 
 
 3. ResourceLoader Component - The ResourceLoader component is used to load the list of tasks stored previously when the application is started and is also used to store the current list of tasks to the local storage upon exit.   

![Task Component](images/Task_Component_UML.png)   
<div>Figure 2. Object Diagram for Task Component</div>
<br>
The task component contains 8 separate classes. They are as follows:  
 
  1. Task : Abstract class used to model a generic task. 
   
  2. Event : Specialized task class used to model events.  
  
  3. Deadline : Specialized task class used to model a deadline.   
   
  4. TaskType : Enumeration class used to denote the various task types.   
  
  5. TaskList : Container class used to store list of tasks and handle related operations. 
   
  6. SchedulableTask : Class used to model a task which is scheduled based on user's requirements.  
  
  7. TaskComparator : Contains a custom comparator used to compare two schedulable tasks based on their 
  numberOfDaysLeft attribute.  
  
  8.  TaskScheduler : Class used to check for feasibility and schedule a list of tasks based on user's requirements.     
     

[comment]: # (@@author NizarMohd)

### 2.3. Study Area Component  
   
 The Study Area component depends on 3 other components,  
   
  1. Command Component - The Command component issues instructions for the Study Area component to execute based on the 
  user's input. 
  
  2. UI Component - The UI component is used to display the results (and related exceptions) of the commands issued to 
  the Study Area Component.
  
  3. ResourceLoader Component - The ResourceLoader component is used to load data of all existing Study Areas in NUS 
  into text files when the User first run the software. Eventually, data will be referred from the created text file.   
  
![Study Area Component](images/StudyAreaObjectDiagram.png) 
<div>Figure 3. Object diagram for Study Area Component</div>
<br>
 The Study Area component contains 3 separate classes. They are as follows:  
  
   1. Dictionary : Class to map user input to specific terms used in StudyAreaList.
    
   2. StudyArea : Class that is used to model Study Areas. 
   
   3. StudyAreaList : Class that handles the list of available Study Areas based on User input.  


[comment]: # (@@author terrytay)

### 2.4. Notes Component
![Notes Component](images/NotesComponent.png)
<div>Figure 4. Object diagram for Notes Component</div>
<br>
The Notes component is self-contained apart from calling UI class for Strings output.
<br> 
Inside Notes component, there exists these classes:
  
1. NotesInvoker : Class to start the Notes
	
2. Notes : Class to support operations for the modules in the Notes, acts as interface.
	
3. Modulelist: Class to implement actual modules operations and store modules list.
	
4. Command : Package containing Command interface, Add command, Command Stack classes.
	
5. Parser : Class to parse commands for command-based operations.

## 3. Implementation

### 3.1. Scheduling Tasks 


[comment]: # (@@author GanapathySanathBalaji)

#### 3.1.1 Implementation 
   Inorder to schedule tasks based on the user's requirement a separate SchedulableTask class was created. 
 1. The user's requirements (Name, Time to complete it, Deadline) are captured for each of the tasks to be scheduled. 
 1. The requirements captured are stored in the SchedulableTask object. 
 1. Then, the TaskScheduler object finds the optimum schedule based on the user's requirements using the EDF 
 (Early Deadline First) algorithm.
 1. If a feasible schedule is found it is 
 displayed, else a message stating that a schedule based on the user's requirements can't be made is displayed.
 
	
   The following sequence diagrams explain how tasks are scheduled.
	
 ![Overall Sequence Diagram](images/Schedule_Overall.png)
<div>Figure 5. Overall Sequence Diagram</div>
<br>
 The three reference frames used are as follows:

 * `Get information regarding the tasks from the user`

 ![Sub Diagram 1](images/Schedule_Sub1.png)
 <div>Figure 6. Sub Diagram 1</div>
 <br>
 * `Check and Schedule tasks if feasible`

 ![Sub Diagram 2](images/Schedule_Sub2.png)
 <div>Figure 7. Sub Diagram 2</div>
 <br>
 * `Add the scheduled tasks to current list of tasks`
 
 ![Sub Diagram 3](images/Schedule_Sub3.png)
 <div>Figure 8. Sub Diagram 3</div>
 <br> 
 
#### 3.1.2 Alternatives
Aspect : How to capture user's requirements and handle it.

 - Alternative 1 (Current Choice) : Create a separate SchedulableTask object to store user's requirements for each task 
                                    to be scheduled.
      - Pros : New class object can be customised without affecting core functionality of the product if the attributes provided by 
      the user (to tasks to be scheduled) changes.
      - Cons : New methods similar to previously implemented methods have to be created instead of being reused.
      
 - Alternative 2 : Modify existing event or deadline class to model user's requirements.
      - Pros : It reuses methods and reduces coupling between classes in the TaskComponent.
      - Cons : Major changes would be required throughout various components of the application to accommodate the new feature. 

     Finally the first alternative was implemented as it was easier to implement and maintain it if changes were required to 
the user's requirements (e.g. Changes to the number of parameters provided by the user). 

[comment]: # (@@author NizarMohd)

### 3.2. Listing Study Areas 

#### 3.2.1 Implementation 
The Study Area search is facilitated by StudyAreaList. In this class, it has the list of all existing Study Areas, 
stored internally as an ArrayList. This ArrayList is called studyAreaList. 

To list the Study Area, we iterate through the entire list of all existing Study Area and conduct a check. The check is 
as follows :

If in each Study Area, the Study Area meets all the flags stated by the User, the Study Area is then added to the 
list of available Study Area. If not, the iteration is skipped and move on to the subsequent Study Area.

To do as mentioned above, the StudyAreaList class implements the following main methods :

- searchList() : 
    - This method will iterate through all the Study Areas in the ArrayList studyAreaList while calling other methods 
    to carry out the search. Once process has ended, the method will return a list of the Study Area, availStudyArea, 
    that meets the User requirement.
- getFlagsInfo() : 
    - This method will retrieve the flags entered by User, at the same time validating the User input. The criteria 
    entered by the User will be returned as flags, an Array of Strings of fixed size 5 as the software only supports 5 
    flags in version 2.
- isAvailStudyArea() : 
    - This method does the check mentioned above and returns a boolean value. Based on the flags detected, 
    the method will iterate through the flags array and check if the Study Area's attribute matches each flag stated in
    flags. If isAvailStudyArea returns as true for all flags, the Study Area is then added to the output list, 
    availStudyArea. 

Below would be a sequence diagram to demonstrate how the search algorithm is operated.

 * `User enters search key` 
 
![Study Area Sequence_Diagram_Main](images/user_sL_interaction.png)  
<div>Figure 9. Interaction between User and Study Area Search Interface</div>
<br>

 * `StudyAreaCommand invokes searchList() of StudyAreaList` 
 
![Study_Area_Sequence_Diagram_subModules](images/sL_sA_interaction.png)
<div>Figure 10. Interaction within Study Area Search Interface</div>
<br>

![Study_Area_Sequence_Diagram_subModules2](images/isAvailStudyArea.png)
<div>Figure 11. Interaction when isAvailStudyArea is invoked</div>
<br>
You can refer [here](#appendix-d-glossary) for a detailed explanation on the terms used in this diagram
#### 3.2.2 Alternative 
Aspect: How to search based on User input.

- Alternative 1 (Current Choice) :
 
    Iterate through the list of all existing Study Areas. Then check if each Study Area 
meets User's Criteria
    - Pros : Lesser data structures required. Therefore lesser memory required.
    - Cons : Linear search, therefore, with bigger size of data, search may take longer. 
    
- Alternative 2 : 
    
There exists four flags : port availability, indoor, outdoor, capacity.
Create adjacency lists that maps the flag to the Study Area itself. If the Study Area contains that 
attribute, the Study Area is added in that specific attribute list. Depending on the type of attribute, the adjacency
list can be implemented using different data structure.

For example, let's take only the two study areas as the entire data set.
      
             __________________________________________________________
             Name: Opposite Town Green (Outside Starbucks)
             Address: 2 College Avenue West Education Resource Centre,
             Ground Level
             Faculty: Utown
             Port: true
             Indoor: false
             Maximum number of Pax: 4
             __________________________________________________________
             __________________________________________________________
             Name: Starbucks
             Address: 2 College Avenue West Education Resource Centre,
             Ground Level
             Faculty: Utown
             Port: true
             Indoor: true
             Maximum number of Pax: 5
             __________________________________________________________
             Please enter the location for your desired study area.

     
         
This will result in the following adjacency lists : 
Environment: <br>
Indoor -> {Starbucks} <br>
Outdoor -> {Opposite Town Green (Outside Starbucks)} <br>
*Data Structure* : 2D Array, with only two rows (For indoors and outdoors)<br>
Ports: <br>
Yes -> {Opposite Town Green (Outside Starbucks), Starbucks}<br>
No -> null<br>
*Data Structure* : 2D Array, with only two rows (For Yes and No)<br>
Capacity: 
4 -> {Opposite Town Green (Outside Starbucks)}
5 -> {Starbucks}
*Data Structure* : HashMap<Integer, ArrayList<String>> 

The creation and initialisation of the lists are done when the software is setting up.  Therefore, each flag 
has its own list. Based on user criteria, concatenate an output list with the Study Areas that are found in all
of the relevant flag lists stated by the user. If more than one requirement is entered by the user, only the Study 
Areas appears in all the related attributes specified by the User will be added to the output list.

- Pros : Data is categorised based on flags.
- Cons : More memory is required as more data structures are used. Since methods invoked during the search are also 
linear, time taken to complete the search will be longer if more data are present. Overall, this approach is harder 
to implement.

Therefore, the first alternative is chosen, as it is much easier to implement and lesser memory is used while 
conducting the search.

[comment]: # (@@author terrytay)

### 3.3. Operation of Notes

#### 3.3.1 Implementation 

The NotesInvoker class will create a Notes object. Notes acts as an Interface for the ModulesList class.
Each module is mapped to an ArrayList of notes. This map is stored in the ModuleList class. The ModuleList class
contains operations to add, remove, enter and list modules.
<br>

A ModuleManager class is used to hold operations for a module. These operations are achieved by working together
with the Parser class and Command class. Operations supported are add, list, undo, redo. 

Add operations are fairly simple, primarily using the add method of hashmap library. The implementation of
undo and redo is stated here below.

Each time an AddCommand object is called, CommandStack will determine if operation is add, undo or redo.
<br><br>
If operation is to add notes, the notes will be added to the value in the module key. At the same time, 
this note that is added is also added to a CommandStack list in the CommandStack class. The redoStack list in the 
CommandStack class is then cleared.
<br><br>
If operation is to undo added notes, the CommandStack will remove the last added note from
the CommandStack and pass it to the Command class to execute the undo action by removing it from the module
contained in the hashmap. Also, this note will be added to the redoStack list.
<br><br>
If operation is to redo removed notes, the CommandStack will remove the last added note in redoStack list and
pass it to the Command class to execute the redo action by adding this note into the module contained in the
hashmap.
<br><br>
The reason why we chose two linked lists to support these operations is because it reduces the SLOC needed to
write the logic. An alternative is to actually remember the state of the hashmap before an operation and save
it to another hashmap. However, this approach will take up more memory and reduces the performance of the application. 

[comment]: # (@@author )
## 4. Testing 

## Appendix A: Product Scope 
### Target User Profile  

Mainly NUS students and professors who :
* need to manage their tasks, events and deadlines
* prefer desktop app over other types
* are new to the faculty (or freshmen) , and require knowledge on conducive areas to study
* have specific needs for a conducive Study Area

### Value proposition    

[comment]: # (to be finalised)  

You can efficiently manage tasks, in terms of priority. You can also efficiently find a study area that
meets your needs and is conducive, should you urgently need one.

## Appendix B: User Stories    
 
 |Version| As a ... | I want to ... | So that I can ...| 
 |--------|----------|---------------|------------------|
 |v1.0|new user|see list of commands supported|refer to them when I forget how to use the application|  
 |v1.0|user|add a new task|keep track of it|  
 |v1.0|user|edit a task|change it's details if required| 
 |v1.0|user|delete a task|remove tasks that are cancelled| 
 |v1.0|user|view my list of tasks sorted based on their date|be aware of all the tasks that are due/happening soon|  
 |v1.0|user|view my list of tasks sorted based on their priority|be aware of the more important tasks|  
 |v1.0|user|find a task by name|locate a task without having to go through the entire list|    
 |v1.0|student|find a Study Area based on location and environment|have a conducive space to study|
 |v1.0|professor|locate a Study Area that is outdoors| conduct consultations without worrying of making noise|
 |v2.0|user|mark deadline as done|check to see if I have pending deadlines|
 |v2.0|user|to delete a Module|clean up my finished notes|
 |v2.0|user|create a Module|add notes inside|
 |v2.0|user|undo an added note|increase my efficiency|
 |v2.0|user|redo a removed notes|increase my efficiency|
 |v2.0|user|create a schedule based on requirements|customise my tasks accordingly|

[comment]: # (@@NizarMohd) 
## Appendix C: Non-Functional Requirements    
  
  * Environment Requirement :  
    * Java 8 or above
    * Should work in both 32-bits and 64-bits environment
    * Command Line Interface
    * Should work without internet access <br>
  * Quality Requirement :
    * Usage should be intuitive, and easy to use even by a novice. <br>
  * Performance Requirement :
    * Should respond quickly, buffer time of 2 seconds at most.<br>
  * Reliability Requirement: 
    * Data for Study Areas should be up to date and accurate.<br>
   
    
[comment]: # (@@author NizarMohd)
## Appendix D: Glossary    

 * *flag* - Criteria that are supported by the software. Currently supported flags are, -i for indoors, -o for outdoors,
 -p for Study Areas with ports and -s for the number of people that the Study Area should facilitate 
 * *available Study Area* - Study Areas that matches the User requirement, therefore _available_ for usage
 * *availStudyAreas* - ArrayList of StudyArea objects that contains the list of available Study Areas
 * *isAvail* - This is a boolean value returned by isAvailStudyArea. It returns true if the either one of the alternate 
 paths in [the sequence diagram](#interaction-within-organices-submodule) returns a true value
 * *executeStudyCommand()* - This method executes the Study Area User Interface
 * *hasPorts()* - This method returns true if the Study Area has a port, and false if otherwise
 * *isIndoor()* - This method returns true if the Study Area is indoors, and false if otherwise
 * *isSizeCapable()* - This method returns true if the maximum size of the Study Area is capable of containing the size staed
 by user.
 * *containsSearchKey()* - This method returns true if the Study Area's name,faculty or address contains the search key 
 entered by the user. This method is invoked when under the [default](#interaction-within-organices-submodule) condition as search by name, address or locations 
 does not require any flags, instead it utilises a loose search. 
 * *ports_flag* - refers to "-p" flag
 * *indoor_flag* - refers to "-i" flag
 * *outdoor_flag* - refers to "-o" flag
 * *size_flag* - refers to "-s" flag

[comment]: # (@@NizarMohd)
## Appendix E: Instructions for Manual Testing    
 __NOTE__: These tests are not exhaustive and testers have to do more exploratory testing to ensure the accuracy of the 
 software's features.

### Testing for Study Area Search

#### Search by location, name, address 
 * To test for accuracy of loose search, test "bux" to see if it returns locations related to Starbucks.
 
#### Search by flags only 
 * To test for accuracy of flags, test either "-p", "-i", "-o" or "-s {integer}"
 
 
#### Search with both, (1) location, name or address , and , (2) flags 
 * To test for accuracy, test "{location/name/address} {flags}".
 * Since flags must come as a second argument in this case, test for "{flags} {location/name/address}"
