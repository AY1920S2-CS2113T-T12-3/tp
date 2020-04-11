[comment]: # (@@author NizarMohd)
<!-- top button was extracted from https://www.w3schools.com/howto/howto_js_scroll_to_top.asp -->
<style>
img {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: auto;
}

#topButton {
  display: none; 
  position: fixed; 
  bottom: 20px;
  right: 30px; 
  z-index: 99; 
  border: none; 
  outline: none; 
  background-color: #0ED7D3; 
  color: white; 
  cursor: pointer; 
  padding: 15px; 
  border-radius: 10px; 
  font-size: 18px; 
  text-alignment: center;
}

#topButton:hover {
  background-color: #15E3DF;
}
</style>

<button onclick="topFunction()" id="topButton" title="Go to top">Top</button>

<script src="jsCodes/topButton.js"></script>

<style>
a.backlink {
	background-color: #0ED7D3;
  color: white;
  padding: 1em 1.5em;
  position: relative;
  text-decoration: none;
}

a.backlink:hover {
  background-color: #15E3DF;
  cursor: pointer;
}

a.backlink:active {
  box-shadow: none;
  top: 5px;
}
</style>

<a href="https://ay1920s2-cs2113t-t12-3.github.io/tp/" class="backlink">Back to OrgaNice!'s main page</a>

# OrgaNice! - User Guide

## Table Of Contents
1. [Introduction](#intro)
1. [Quick Start](#quick-start)
1. [Features](#features) <br>
    3.1. [Add new Deadline task](#add-deadline) <br>
    3.2. [Add new Event task](#add-event) <br>
    3.3. [Delete task](#delete) <br>
    3.4. [Mark deadline as done](#done) <br>
    3.5. [Edit task](#edit) <br>
    3.6. [Clear list of tasks](#clear) <br>
    3.7. [View list of tasks](#view) <br>
    3.8. [View list of tasks sorted by their priority](#priority) <br>
    3.9. [View list of tasks in a countdown format](#countdown) <br>
    3.10. [Search tasks](#search) <br>
    3.11. [View commands supported](#help) <br>
    3.12. [Schedule tasks](#schedule) <br>
    3.13. [Study Area Search Feature](#studyArea) <br>
    3.14. [Notes Taking Feature](#notes) <br>
    3.15. [Calendar View](#315-calendar-view)<br>
    3.16. [Exit the Application / Study Area interface](#exit) <br>
    3.17. [Saving the data](#save-tasks) <br>
    3.18. [Clearing old tasks](#clear-old-tasks) <br>
1. [FAQ](#faq)
1. [Command Summary](#command-summary)
1. [Formats Used](#formats)


<a name="intro"></a>

## 1. Introduction

  OrgaNice! is a task manager integrated with a Study Area search function and a Notes Taking feature. 
  You can use it to manage your tasks, be it events or deadlines. On top of that, 
  it is capable of assisting students in finding Study Areas that meet their desired criteria.
  Also, our Notes Taking feature provides you with a handy way to record notes based on school modules fast.<br>
  
  Our application supports 2 types of tasks, they are as follows: 
 * **Deadline** Tasks - Used to denote a task that needs to be finished by a deadline.
    
     E.g, Assignments, Projects etc that are due on a specific date. 
 * **Event** Tasks - Used to denote an activity that happens over a period of time.
 
    E.g, Lectures, Tutorial sessions can be stored as events.
   
 The application can add, edit and delete tasks. It also provides methods to search for tasks. Additionally, it has the ability to store data to a physical location on the computer, so that the tasks always remain in memory.  
    
<a name="quick-start"></a>

## 2. Quick Start
 
 * Ensure you have Java 11 or above installed in your Computer.
 * Download the latest OrgaNice.jar from [here](https://github.com/AY1920S2-CS2113T-T12-3/tp/releases) and place it in an empty folder. 
 * Open Command Prompt. **NOTE: Please ensure that the command prompt is at full screen BEFORE running the jar file**
 * Navigate to the folder with the jar.
 * Type the following command:  java -jar OrgaNice.jar to run it.
 
 A text based UI should appear with the following lines.
  
        Hello from
        _______/\\\\\_____________________________________________________/\\\\\_____/\\\____________________________________________/\\\____________
        ______/\\\///\\\__________________________________________________\/\\\\\\___\/\\\__________________________________________/\\\\\\\_________
        _____/\\\/__\///\\\____________________/\\\\\\\\___________________\/\\\/\\\__\/\\\___/\\\__________________________________/\\\\\\\\\_______
        _____/\\\______\//\\\___/\\/\\\\\\\____/\\\////\\\___/\\\\\\\\\_____\/\\\//\\\_\/\\\__\///_______/\\\\\\\\______/\\\\\\\\___\//\\\\\\\_______
        _____\/\\\_______\/\\\__\/\\\/////\\\__\//\\\\\\\\\__\////////\\\____\/\\\\//\\\\/\\\___/\\\____/\\\//////_____/\\\/////\\\___\//\\\\\_______
        ______\//\\\______/\\\___\/\\\___\///____\///////\\\____/\\\\\\\\\\___\/\\\_\//\\\/\\\__\/\\\___/\\\___________/\\\\\\\\\\\_____\//\\\_______
        ________\///\\\__/\\\_____\/\\\___________/\\_____\\\___/\\\/////\\\___\/\\\__\//\\\\\\__\/\\\__\//\\\_________\//\\///////_______\///_______
        ____________\///\\\\\/______\/\\\__________\//\\\\\\\\___\//\\\\\\\\/\\_\/\\\___\//\\\\\__\/\\\___\///\\\\\\\\___\//\\\\\\\\\\______/\\\_____
        ______________\/////________\///____________\////////_____\////////\//___\///_____\/////___\///______\////////_____\//////////______\///_____    
    ________________________________________________________________________________________________
         Welcome to OrgaNice! Below would be a list of commands useful for you!
         OrgaNice! Supports the following commands
         Please enter the keywords followed by the information shown in the brackets
         event <event details> /d <date> /s <start time> /e <end time> /p <priority of event>
         ------------------------------------------- Create a new event
         deadline <deadline details> /d <date> /t <due time> /p <priority of deadline>
         ------------------------------------------- Create a new deadline
         view -------------------------------------- View existing events
         priority_view ----------------------------- View existing tasks based on priority
         countdown --------------------------------- View existing tasks based on days left
         clear ------------------------------------- Delete all tasks
         search <keyword found in task> ------------ View existing task that contains the keyword
         delete <index of task> -------------------- Delete the task
         edit <index of task> ---------------------- Edit the task
         done <index of task> ---------------------- Mark the deadline as done
         schedule <number of task to be scheduled> - Schedule tasks
         help -------------------------------------- View List Of Commands Supported
         bye --------------------------------------- Terminate task interface
         study ------------------------------------- Enter Study Area search interface
         notes ------------------------------------- Enter Notes
         calendar ---------------------------------- View existing tasks in Calender view
         Notes:
         *All dates should follow YYYY-MM-DD format
         *All timing should follow 24 hour clock
    ________________________________________________________________________________________________

  * Some example commands you can try:
    * schedule {number of tasks}
    * view
    * search exam
    * bux -i (Inside Study Area Search Interface)
  * Refer to Section 3, Features for details of each command.

<a name="features"></a>
## 3 Features 


[comment]: # (@@author GanapathySanathBalaji)

<a name="add-deadline"></a>

### 3.1. Add new Deadline task
Adds a new deadline task to track a task which needs to be finished before a specific date.

#### Usage

#### `deadline <deadline details> /d <date> /t <due time> /p <priority of deadline>` - Adds a new Deadline task to the list of tasks

The command creates a new Deadline task with the description, date, due time and priority value provided.
Note: The date and time should be provided in the correct format as mentioned [here](#formats).

Upon success, a successful addition message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

#### Example of usage: 
The following adds a Math assignment as a deadline task which is due on 04-05-2020 at 6 pm with a priority value of 2.

`deadline Math assignment /d 2020-05-04 /t 18:00 /p 2`

#### Expected outcome:
The Deadline task would be added to the list.
Upon success a response similar to the following one would appear:

    ________________________________________________________________________________________________
    	 A new task with the following information has been added.
    	 [D][PENDING] math assignment is due on May 4 2020 at 18:00
    	 with priority 2
    ________________________________________________________________________________________________


<a name="add-event"></a>

### 3.2 Add new Event task
Adds a new deadline task to track a task which needs to be finished before a specific date.

#### Usage

#### `event <event details> /d <date> /s <start time> /e <end time> /p <priority of event>` - Adds a new Event task to the list of tasks


The command creates a new Event task with the description, date, start time, end time and priority value provided.
Note: The date and time should be provided in the correct format as mentioned [here](#formats).

Upon success, a successful addition message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

#### Example of usage: 
The following adds a Team Meeting which is set to take place on 06-05-2020 from 9 am to 12 pm with a priority value of 3, as an event to the list of tasks.

`event Team Meeting /d 2020-06-06 /s 09:00 /e 12:00 /p 3`

#### Expected outcome:
The Deadline task would be added to the list.
Upon success a response similar to the following one would appear:

    ________________________________________________________________________________________________
         A new task with the following information has been added.
         [E] Team Meeting at Jun 6 2020 from 09:00 to 12:00 with
         priority 3
    ________________________________________________________________________________________________

<a name="delete"></a>


### 3.3. Delete task
If a task is done and you want to remove it from the list this command could be used. It deletes the task at the specified index, usually, one of the various view commands are run to look at the index of the task to be deleted.

#### Usage

##### `delete <index number of task>` - Deletes task at specified index

The command deletes the task at the specified index, if the index provided is valid.
Upon success, a successful deletion message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
To delete a task at the 3rd index of the list of tasks.

`delete 3`

Expected outcome:
The task would be deleted from the list.
Upon success a response similar to the following one would appear:

    ________________________________________________________________________________________________
         Noted! I have removed this task:
         [E] meeting at Apr 4 2020 from 12:00 to 18:00 with
         priority 2
         Now you have 2 task(s) in your list
    ________________________________________________________________________________________________

<a name="done"></a>

### 3.4. Mark deadline as done
If the work to be completed for a deadline is done but you still want to keep it in the list, this command could be used. It marks the deadline at the specified index as done, usually, one of the various view commands are run to look at the index of the deadline to be deleted.

#### Usage

#### `done <index of deadline>` - Mark the deadline at the specified index as done

The command deletes the task at the specified index, if the index provided is valid.
Upon success, a successful deletion message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
To mark a deadline at the 1st index of the list of tasks as done.

`done 1`

Expected outcome:
The task would be marked as done.
Upon success a response similar to the following one would appear:

    ________________________________________________________________________________________________
    	 Nice! I've marked this deadline as done!
    	 [D][COMPLETED] math assignment is due on May 4 2020 at
    	 18:00 with priority 2
    ________________________________________________________________________________________________


<a name="edit"></a>

### 3.5. Edit task
If a task has any of its details altered, you can use this command to edit the appropriate field directly. This saves you the trouble of manually deleting and adding a new task. This command is a multi-stage command so that it is easier for you to do it. This command changes the specified field of the task mentioned by its index. To view the index of the task, one of the various commands to view the list of tasks (view, priority_view, countdown) is run. 

Note: The date and time should be provided in the correct format as mentioned [here](#formats).

#### Multi-Stage

#### Usage 

#### `edit <index number of task>` - Used to edit task at specified index

The interface then displays the task and the set of attributes of the task that can be edited, if the index is valid. You can then enter the field you would like to change and then the new value to change the field into. 

The command edits the task at the specified index at the field mentioned by you.
Upon success, a successful edit message displaying the updated task's information similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
To edit the start time of the event at 2nd index of the list.
#### Multi Stage

#### `edit 2` - Specify the index of the task to be edited 

Expected outcome:

    ________________________________________________________________________________________________
         The event details are as follows:
         [E] meeting at May 6 2020 from 14:00 to 18:00 with
         priority 4
         Which field of the event to edit? (Enter Corresponding
         Number)
         1. Description
         2. Date
         3. Start Time
         4. End Time
         5. Priority


#### `3` - Specify field to be edited based on the list

Expected outcome:

	 Enter new Start Time:
    
#### `12:00` - Enter the new value to be changed to

Expected outcome:

         Updated Details:
         [E] meeting at May 6 2020 from 12:00 to 18:00 with
         priority 4
    ________________________________________________________________________________________________
    ________________________________________________________________________________________________
         The task at the mentioned index has been edited
         successfully
    ________________________________________________________________________________________________

<a name="clear"></a>

### 3.6. Clear list of tasks
If you would like to clear the current list of tasks and start on a clean slate, this command could be used. Clears the list of tasks stored.

#### Usage

#### `clear` - Clears the list of tasks

The application then asks for another confirmation before the list is cleared.
The command clears the current list of tasks stored.
Upon success, a successful deletion message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
To clear the current list of tasks.

`clear`

Expected outcome:

The application asks for a confirmation message.

    ________________________________________________________________________________________________
         Are you sure that you want to clear the list? [Y/N]

`Y` - Choice

Expected outcome:

The list of tasks would be cleared.
Upon success a response similar to the following one would appear:

    	 The list of tasks is cleared.
    ________________________________________________________________________________________________


<a name="view"></a>

### 3.7. View list of tasks
If you would like to view the current list of tasks, this command could be used. It shows the current list of tasks stored.

#### Usage

#### `view` - Displays the current list of tasks

The command displays the current list of tasks stored.
Upon success, a successful deletion message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
To view the current list of tasks.

`view`

Expected outcome:
The list of tasks would be displayed.
Upon success a response similar to the following one would appear:

    ________________________________________________________________________________________________
         Here is the list of tasks added so far:
         1) [E] exam at May 5 2020 from 12:00 to 14:00 with
         priority 2
         2) [E] meeting at May 6 2020 from 12:00 to 18:00 with
         priority 4
    ________________________________________________________________________________________________

<a name="priority"></a>

### 3.8. View list of tasks sorted by their priority
If you would like to view the more important tasks from the current list of saved tasks first, this command could be used. It shows the current list of tasks after they are sorted based on their priority.

#### Usage

#### `priority_view` - Displays the current list of tasks sorted by priority

The command displays the current list of tasks sorted by their priority.
Upon success, a successful deletion message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
To view the current list of tasks sorted by their priority.

`priority_view`

Expected outcome:
The list of tasks would be displayed after they are sorted based on their priority.
Upon success a response similar to the following one would appear:

    ________________________________________________________________________________________________
         Here is the list of tasks added so far displayed in
         decreasing order of priority:
         1) [E] meeting at May 6 2020 from 12:00 to 18:00 with
         priority 4
         2) [E] exam at May 5 2020 from 12:00 to 14:00 with
         priority 2
    ________________________________________________________________________________________________

<a name="countdown"></a>

### 3.9. View list of tasks in a countdown format
If you would like to view the early tasks from the current list of saved tasks first along with the number of days left till the task, this command could be used. It shows the current list of tasks with the number of days left till each task, after they are sorted based on their date.

#### Usage

#### `countdown` - Displays the current list in countdown format

The command displays the current list of tasks with the number of days left until each task sorted by their dates.
Upon success, a successful deletion message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
To view the current list of tasks in a countdown format.

`countdown`

Expected outcome:
The list of tasks would be displayed in the countdown format.
Upon success a response similar to the following one would appear:

    ________________________________________________________________________________________________
         Here is the list of tasks with sorted based on the number
         of days left:
         1) [E] exam at May 5 2020 from 12:00 to 14:00 with
         priority 2 ---> 40 day(s) left
         2) [E] meeting at May 6 2020 from 12:00 to 18:00 with
         priority 4 ---> 41 day(s) left
    ________________________________________________________________________________________________



<a name="search"></a>

### 3.10. Search tasks
If you would like to quickly find a task based on its description, this command could be used. It performs a linear search of all tasks stored in the list at the point of execution and list
all the tasks containing the keyword in their description in a numbered list.

### Usage

#### `search <keyword found in task>` - Lists all matching tasks in the list containing the keyword 

The command displays all the tasks with a description containing the keyword searched for in a numbered list.
Upon success, a successful message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 

`search exam`

Expected outcome:
All matching tasks in the list would be displayed in a numbered list.
A response similar to the following one would appear:

    ________________________________________________________________________________________________
         The list of tasks containing the mentioned keyword in
         their description are as follows:
         1) [E] exam at May 5 2020 from 12:00 to 14:00 with
         priority 2
    ________________________________________________________________________________________________


<a name="help"></a>
    
### 3.11. View commands supported 
If you are a new user or forgot the syntax of any command, our help command could be used. The command displays the list of commands supported by the application.

#### Usage

#### `help` - Displays list of commands supported 

The command displays the list of commands supported by the application.
If the wrong format is used an invalid command alert would be displayed.

Example of usage: 

`help`

Expected outcome:
The application would be exited successfully.
A response similar to the following one would appear:

    ________________________________________________________________________________________________
         OrgaNice! Supports the following commands
         Please enter the keywords followed by the information shown in the brackets
         event <event details> /d <date> /s <start time> /e <end time> /p <priority of event>
         ------------------------------------------- Create a new event
         deadline <deadline details> /d <date> /t <due time> /p <priority of deadline>
         ------------------------------------------- Create a new deadline
         view -------------------------------------- View existing events
         priority_view ----------------------------- View existing tasks based on priority
         countdown --------------------------------- View existing tasks based on days left
         clear ------------------------------------- Delete all tasks
         search <keyword found in task> ------------ View existing task that contains the keyword
         delete <index of task> -------------------- Delete the task
         edit <index of task> ---------------------- Edit the task
         done <index of task> ---------------------- Mark the deadline as done
         schedule <number of task to be scheduled> - Schedule tasks
         help -------------------------------------- View List Of Commands Supported
         bye --------------------------------------- Terminate task interface
         study ------------------------------------- Enter Study Area search interface
         notes ------------------------------------- Enter Notes
         calendar ---------------------------------- View existing tasks in Calender view
         Notes:
         *All dates should follow YYYY-MM-DD format
         *All timing should follow 24 hour clock
    ________________________________________________________________________________________________


<a name="schedule"></a>

### 3.12. Schedule tasks
If you have a bunch of assignments, projects and exams happening over the next few weeks and are stressed out with planning
 a schedule which can fulfil the requirements, our schedule task command can help you by creating a feasible 
schedule. It creates a schedule based on the details of the tasks provided by you. 

#### Usage

#### `schedule <number of tasks to be scheduled>` - Used to schedule a set of tasks specified by the user 

Then a set of lines are displayed which specify the format to be used to specify the new tasks to be scheduled. After you input the relevant data. The application would find a feasible schedule satisfying your constraints if it is possible to do so. If it is possible, the list of events that was created when the task were scheduled is added to the current list of tasks. If it is impossible, a message to alert the user is specified too.
If the wrong format is used an invalid command alert would be displayed.

Example of usage: 

`schedule 3` - Schedule 3 tasks

Expected outcome:

    ________________________________________________________________________________________________
         Enter tasks in the following format:
         <task name> /f <Time to finish task in days> /d <Number of
         days left from current day to finish it>
         Enter details for task 1:

`math exam /f 2 /d 10` - Details of the first task

Expected outcome:

	 Enter details for task 2:
     
`physics exam /f 3 /d 7` - Details of the second task

Expected outcome:

	 Enter details for task 3:
     
`chemistry exam /f 1 /d 4` - Details of the third task     

Expected outcome:

         Details captured successfully.
         chemistry exam is scheduled from 2020-03-27 to
         2020-03-27
         physics exam is scheduled from 2020-03-28 to
         2020-03-30
         math exam is scheduled from 2020-03-31 to
         2020-04-01
         Tasks successfully scheduled.
    ________________________________________________________________________________________________
    
#### Future Enhancements
   The current version of the application doesn't take into account the other tasks present, however, the priority 
values can still be used to decide the more important task. In v3.0 our application will support scheduling tasks 
while avoiding tasks present previously and also add support for tasks to be scheduled preemptively (i.e, tasks can be 
scheduled over non-contiguous days).

    
[comment]: # (@@author NizarMohd)     
<a name="studyArea"></a>

### 3.13 Study Area Search Feature

You can search for study areas based on criteria that you desire by using this feature. You are free to loosely search. 
For example, if you enter as [this](#search-by-name-address-or-faculty), you will receive a list of  places related 
to the name *Starbucks* as "bux" is a common abbreviation used for it.

<a name="enterStudyArea"></a>
#### 3.13.1 Entering Study Area Search Interface

To enter the Study Area search interface, you can enter 'study' in the main interface. You will then be 
guided to the study area search interface. 

#### Usage

Example of usage: 
`study`

Expected Outcome:

    ________________________________________________________________________________________________
         Please enter the location for your desired study area.
         Enter "help" for a list of supported flags. Flags should
         only come after location, if a criteria for location is
         entered. When you are done with the search, enter "bye".
    ________________________________________________________________________________________________

<a name="studyAreaSearch"></a>
#### 3.13.2 Start Search

You can start the search by entering the criteria desired. Supported criteria include name, address, faculty,
ports availability, environment and size capacity. For  name, address or faculty, you simply have to enter it
as a string. For other supported conditions, flags have to be used. 

Below are the supported flags: 
   * -s {size}  : To locate a study area that can facilitate the size of pax entered.
   * -p         : To locate a study area based on the availability of ports.
   * -i         : To locate a study area that are indoors.
   * -o         : To locate a study area that are outdoors.

Note: 

{name\address\faculty} {flags} is the basic format to search for Study Areas. You can enter either argument, or both.
If both arguments are specified, flags will have to precede either the name,address or faculty.

#### Usage

#### Search by name, address or faculty 

Example of usage:
`bux`

Expected Outcome:

    ________________________________________________________________________________________________
         Here are the available study areas!
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
    ________________________________________________________________________________________________

#### Search by name, address or faculty and with flags

Example of usage:
`bux -o`

Expected Outcome:

    ________________________________________________________________________________________________
         Here are the available study areas!
         __________________________________________________________
         Name: Opposite Town Green (Outside Starbucks)
         Address: 2 College Avenue West Education Resource Centre,
         Ground Level
         Faculty: Utown
         Port: true
         Indoor: false
         Maximum number of Pax: 4
         __________________________________________________________
         Please enter the location for your desired study area.
    ________________________________________________________________________________________________

__NOTE__: When using this format, flags must always come after the location, name or address. Else, the system will 
return an error message.

### Search by flags only 

Example of usage : 
`-s 6`

Expected output:

    ________________________________________________________________________________________________
         Here are the available study areas!
         __________________________________________________________
         Name: EA Level 4
         Address: 9 Engineering Drive 1,EA, Level 4, Outside Staff
         Offices
         Faculty: Engineering
         Port: true
         Indoor: false
         Maximum number of Pax: 6
         __________________________________________________________
         Please enter the location for your desired study area.
    ________________________________________________________________________________________________

#### Future Enhancements

   The current implementation does not include real-time availability of the study areas. In version 3.0 we hope to be
   able to retrieve real-time availability of public study areas, like the ones in U-Town. In order to do so we would 
   require access to real-time data like CCTV monitors of the study areas to detect if there is an available seat at 
   a specific point of time at a specific area. Also, due to time constraint, we were not able to gather an exhaustive 
   list for the study area. At version 3.0 we aim to reach full breadth for the data on study areas in NUS.


[comment]: # (@@author terrytay)     
<a name="notes"></a>

### 3.14 Notes Taking Feature

You can create notes based on modules that you are taking for the semester easily.
These modules can easily be imported or exported for your convenience.

#### 3.14.1 Entering Notes Taking Interface

To enter the Notes Taking interface, you can enter `notes` in the main interface. You will then be 
guided to the Notes Taking interface. 

#### Usage

Example of usage: 
`notes`

Expected Outcome:

    ________________________________________________________________________________________________
        Welcome to OrgaNice's Notes! Notes are stored based on
        modules. To get started: add a module, enter a module and
        start adding notes!
    ________________________________________________________________________________________________
         [add modulecode] to add a module
         [remove modulecode] to add a module
         [enter modulecode] to enter notes for its notes
         [list] to list modules
         [bye] to go back to OrgaNice main page
         [help] to list all the commands again
    ________________________________________________________________________________________________


#### 3.14.2 Adding a Module

For first time users, it is recommended that you create a module first
so that you can add notes into it.

#### Usage 

Example of usage:
`add CS2113T`

Expected Outcome:

    ________________________________________________________________________________________________
        CS2113T has been created
    ________________________________________________________________________________________________


#### 3.14.3 Removing a Module

Sometimes you are done with a module and you want to remove it. We have provided a friendly way to delete
completed module notes.

#### Usage 

Example of usage:
`remove CS2113T`<br>
You will be prompted to enter `Y` for confirmation.

Expected Outcome:

    ________________________________________________________________________________________________
        Are you sure you want to remove CS2113T? [Y/N]
    ________________________________________________________________________________________________
    Y
    ________________________________________________________________________________________________
        CS2113T has been removed
    ________________________________________________________________________________________________

#### 3.14.4 Listing all created/available Modules

It might be helpful if you were able to list all the modules of notes that you have. Check out the step
below to learn how to do so.

#### Usage 

Example of usage:
`list`

Expected Outcome:

    ________________________________________________________________________________________________
        [EE2026, CG1112, CS2040C, CS2113T, CS2107]
    ________________________________________________________________________________________________


#### 3.14.5 Start taking Notes

Now that you have created at least a module, it is time to start taking notes.
In the Notes mainpage, key in the following code below.

#### Usage

Example of usage: 
`enter CS2113T` `add CS2113T is so fun`

Expected Outcome:
    
    enter CS2113T
    ________________________________________________________________________________________________
        Notes for CS2113T
    ________________________________________________________________________________________________
         [add ...message...] to add a note
         [undo] to undo
         [redo] to redo
         [list] to list notes
         [back] to go to notes mainpage
    ________________________________________________________________________________________________
    add CS2113T is so cool and fun
    ________________________________________________________________________________________________
	    SUCCESS
    ________________________________________________________________________________________________

#### 3.14.6 Listing all Notes of specific Module

Apart from writing notes, we know you need to review it. This is how you list
all notes of a module.

#### Usage

Example of usage: 
`list`

Expected Outcome:
    
    list
    ________________________________________________________________________________________________
         CS2113T is fun
         UML diagram is important
         GITHUB is quite frustrating at times
         Reposense is awesome
    ________________________________________________________________________________________________

#### 3.14.7 Quick Correction through Undo and Redo

Sometimes, you make a mistake and you want to quickly correct it. Thankfully, Notes come
with quick undo and redo features.

#### Usage

Example of usage: 
`undo` `redo`

Expected Outcome:
    
    add hi
    ________________________________________________________________________________________________
         SUCCESS
    ________________________________________________________________________________________________
    add bye
    ________________________________________________________________________________________________
         SUCCESS
    ________________________________________________________________________________________________
    undo
    ________________________________________________________________________________________________
         SUCCESS
    ________________________________________________________________________________________________
    list
    ________________________________________________________________________________________________
         hi
    ________________________________________________________________________________________________
    redo
    ________________________________________________________________________________________________
         SUCCESS
    ________________________________________________________________________________________________
    list
    ________________________________________________________________________________________________
         hi
         bye
    ________________________________________________________________________________________________

#### 3.14.8 To go back to Notes mainpage

To visit other modules, you can do the following below.

#### Usage

Example of usage: 
`back` followed by `help`

Expected Outcome:
    
    back
    ________________________________________________________________________________________________
          You are now back at Notes main page.
    ________________________________________________________________________________________________
    help
    ________________________________________________________________________________________________
          [add modulecode] to add a module
          [remove modulecode] to add a module
          [enter modulecode] to enter notes for its notes
          [list] to list modules
          [bye] to go back to OrgaNice main page
          [help] to list all the commands again
    ________________________________________________________________________________________________
    
 
#### 3.14.9 Saving your Notes

To save your notes, we support one way at the moment.

#### Usage

Example of usage:
`bye`

Expected Outcome:

    ________________________________________________________________________________________________
          [add modulecode] to add a module
          [remove modulecode] to add a module
          [enter modulecode] to enter notes for its notes
          [list] to list modules
          [bye] to go back to OrgaNice main page
          [help] to list all the commands again
    ________________________________________________________________________________________________
    bye
    ________________________________________________________________________________________________
         Notes saved successfully.
         Thank you for using notes.
    ________________________________________________________________________________________________

This will bring you to Organice main page. For a list of available commands in Organice,
you can use `help` to get you around. For more information on importing and exporting, please check the FAQ section.

#### Future Enhancements

   Right now, our saving feature is very restrictive to you. In the upcoming v3.0, we are planning to
   release a new auto saving feature where you do not have to worry about losing your notes even if you close
   the terminal abruptly or do not use the `bye` way to save.



[comment]: # (@@author NizarMohd)
### 3.15. Calendar View


#### 3.15.1. Enter Calendar
Example of usage:

`calendar`

Expected output: 

    ________________________________________________________________________________________________
         Enter the month and year that you wish to see:
    ________________________________________________________________________________________________


#### 3.15.2. Enter Desired Month to View

#### To view tasks for current month
Example of usage:
 
`now`

Expected output:

    ________________________________________________________________________________________________
    Tasks for: APRIL, 2020
    -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    |SUN                        |MON                        |TUE                        |WED                        |THU                        |FRI                        |SAT                        |
    -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    |                           |                           |                           |                          1|                          2|                          3|                          4|
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    |                          5|                          6|                          7|                          8|                          9|                         10|                         11|
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    |                         12|                         13|                         14|                         15|                         16|                         17|                         18|
    |                           |                           |                           |                           |                           |                           | [D][N] submit cg2028 r... |
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    |                         19|                         20|                         21|                         22|                         23|                         24|                         25|
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    |                         26|                         27|                         28|                         29|                         30|                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    ________________________________________________________________________________________________

#### To view tasks for future months

*NOTE*: <br>
1. Input for both month and year must be integers. 
1. This feature only supports the current and future months. 
1. Any details that exceed the limit within the designated box for the day, will have the last three displayed characters as ellipses.


Example of usage: 

`5 2020`

Expected output:

    ________________________________________________________________________________________________
    Tasks for: MAY, 2020
    -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    |SUN                        |MON                        |TUE                        |WED                        |THU                        |FRI                        |SAT                        |
    -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    |                         31|                           |                           |                           |                           |                          1|                          2|
    |                           |                           |                           |                           |                           |                           | [E] cs2113 final exam     |
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    |                          3|                          4|                          5|                          6|                          7|                          8|                          9|
    |                           | [D][N] math assignment    |                           |                           |                           |                           |                           |
    |                           | [D][N] physics assignm... |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    |                         10|                         11|                         12|                         13|                         14|                         15|                         16|
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    |                         17|                         18|                         19|                         20|                         21|                         22|                         23|
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    |                         24|                         25|                         26|                         27|                         28|                         29|                         30|
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    |                           |                           |                           |                           |                           |                           |                           |
    -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    ________________________________________________________________________________________________

#### 3.15.3 To escape from Calendar View Command 

In any case that you wish to exit calendar mode after entering it, you can enter "bye" to exit.

Example of usage: 

`bye`

Expected output:

    ________________________________________________________________________________________________
         You are now back in main interface. Enter "help" for a
         list of supported commands
    ________________________________________________________________________________________________


[comment]: # (@@author )     
<a name="exit"></a>

### 3.16. Exit the Application / Study Area interface
You use this command to exit the application. Before the actual application is exited the 
tasks currently in the list are stored in a file. This command is used for exiting the main interface and the
secondary study area search interface.

#### Usage

#### `bye` - Exit the Application / Study Area interface

The command, when issued, performs an exit.
Upon success, a successful message similar to the one in the example would appear and the application would be exited.
If the wrong format is used an invalid command alert would be displayed.

Example of usage: 
`bye`

Expected outcome:
Depending on the current mode of execution, the application would either be exited successfully or would return to the main interface.
A response similar to the following one would appear:
1) If the 'bye' command is given in the main interface

         Goodbye! Hope to see you again!
       ``````````````````````````````````````````````````````````
       ````````````````````````````````:v(v'`````````````````````
       ```````````````````````````,)4|ex` `L}````````````````````
       `````````````````````````!s"'h `M:   ^z_;)T```````````````
       `````````````````````````Z   u|}Z:        "}``````````````
       ``````````````````````:=?)                'B?L'```````````
       `````````````````````'Z                    ;Yp"```````````
       `````````````````````.e                      ?_```````````
       ```````````````````'QDGH                    .5````````````
       ````````````````````I#g'         '_`        ||````````````
       ```````````:mX_``````YhL`      `'q!`   ?     h````````````
       ```````````'Qbs)|L=_V" 'Y}     ^'q@&b=c=_`  ,Z````````````
       ````````````q>     'T,   ,o"    ;"@c.   .sVx~`````````````
       ````````````c!             "bh` `,p       z:``````````````
       `````````````q.              ngDQmh8s     X'``````````````
       ``````````````LY"             :n}>``b;   _V```````````````
       ````````````````q?,                ?;   "V````````````````
       ``````````````KvR                  '  )x_`````````````````
       ``````````````zjL                  GLY"```````````````````
       ```````````````M                 .I)``````````````````````
       ```````````````Lz                `D:``````````````````````
       ``````````````vu`    (I)_;"".      P.`````````````````````
       ``````````````p     :X.':^,"=n    "q``````````````````````
       `````````````)0X?^:)I````````m'   :j``````````````````````
       `````````````.IGD8k'`````````<&G55M```````````````````````
       ``````````````````````````````````````````````````````````




2) If the "bye" command is given during execution of the study area command,


      ________________________________________________________________________________________________
           Thank you for using our study area search service!
      ________________________________________________________________________________________________


[comment]: # (@@author GanapathySanathBalaji)

<a name="save-tasks"></a>

### 3.17. Saving the data
The tasklist is saved automatically before the application is executed. There is no need to save manually.

<a name="clear-old-tasks"></a>

### 3.18. Clearing old tasks
The tasklist only includes the tasks which have date beyond the current date. This removes the need for you to manually find and delete the old tasks.



[comment]: # (@@author )

<a name="faq"></a>

## 4. FAQ
Q: When loading the interface on the command line, why was the logo cut off and certain format disrupted?<br>
A: You need to be using the software at full screen before launching the software. If this happens, exit the software,
go to fullscreen mode, then restart the software. Everything should run smoothly.
<br>

Q: How to transfer the task list data from one computer to an other computer?<br>
A: Just copy the "TaskList.txt" file which could be found at the library folder under directory
   as the jar file and paste it to the library folder under the location containing the jar file in the other
   computer. This should transfer the required data.
<br>   
Q: The software says that library/TaskList.txt does not exist. What do I do?<br>
A: Go to the software's root folder and check to see if the library folder exists. If so, delete the library folder 
   and rerun the software. The software would have created a fresh set of data files required for the system to run.
<br>   
Q: The software says that library/locations.txt or library/dictionary.txt does not exist. What do I do?<br>
A: Go to the software's root folder and check to see if the library folder exists. Proceed to check if TaskList.txt 
   exist. If so, transfer it to a temporary folder. Delete the library folder and rerun the software. Transfer the 
   content from the old TaskList.txt to the new TaskList.txt
<br>   
Q: How do I import and export Notes?<br>
A: Notes are stored in library/notes.txt. To export and import Notes, simply transfer this file to another device 
   with OrgaNice! installed in the same directory /library/. You can open the text file to see how we actually 
   structure our notes information inside to write your own notes.txt.
<br>       

<a name="command-summary"></a>

[comment]: # (@@author GanapathySanathBalaji)

## 5. Command Summary

### OrgaNice Main Features
* `deadline <deadline details> /d <date> /t <due time> /p <priority of deadline>` - Adds a new Deadline task to the list of tasks <br>
e.g. `deadline assignment /d 2020-06-06 /t 12:00 /p 4` <br>

* `event <event details> /d <date> /s <start time> /e <end time> /p <priority of event>` - Adds a new Event task to the list of tasks <br>
e.g. `event exam /d 2020-06-07 /s 09:00 /e 12:00 /p 5`<br>

* `delete <index number of task>` - Deletes task at specified index <br>
e.g. `delete 1`<br>

* `done <index of deadline>` - Mark the deadline at the specified index as done <br>
e.g. `done 1` (Assumption: Task at index 1 is a deadline task) <br>


* `edit <index number of task>` - Used to edit task at specified index <br>
e.g. `edit 1`<br>

* `clear` - Clears the list of tasks <br>

* `view` - Displays the current list of tasks <br>

* `priority_view` - Displays the current list of tasks sorted by priority <br>

* `countdown` - Displays the current list in countdown format <br>

* `search <keyword found in task>` - Lists all matching tasks in the list containing the keyword <br>
e.g. `search project`<br>

* `bye` - Exit the Application / Study Area interface <br>

* `study` - Enter study area search interface <br>

* `notes` - Enter notes taking interface <br>

[comment]: # (@@author )

### Study Area Search Interface

* `name\address\faculty` `flags` - Returns a list of Study Areas, if any of the existing data matches the requirement 
entered. 

Click [here](#3132-start-search) for more details on how `name\address\faculty` and `flags` should be entered.

### Notes Taking Interface

Follow the steps below to quickly get started with taking notes:

* `add [module code]` - Adds a module to the Notes taking interface so that you can start taking notes.

* `enter [module code]` - Enters the interface for the module.

* `add [message here]` - Adds a message to the module.

Click [here](#notes) for more details on how to use Notes.

### Calendar 

* `calendar` - To enter Calendar view.

Click [here](#315-calendar-view) for more details on how to use the Calendar view.


<a name="formats"></a>

## 6. Formats Used

Description of tasks shouldn't contain `/` and `#` characters, as they are used for a special purpose by the application<br>
Time should be in the form of `HH:MM` (24 Hour Format, HH - Hour, MM - Minute) <br>
Date should be in the form of `YYYY-MM-DD` (YYYY - Year, MM - Month, DD - Day) <br>
