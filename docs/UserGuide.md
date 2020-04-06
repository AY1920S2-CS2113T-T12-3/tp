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
    3.14. [Exit the Application / Study Area interface](#exit) <br>
    3.15. [Saving the data](#save-tasks) <br>
    3.16. [Clearing old tasks](#clear-old-tasks) <br>
    3.17. [Viewing tasks in calendar format](#calendar) <br>
1. [FAQ](#faq)
1. [Command Summary](#command-summary)
1. [Formats Used](#formats)


<a name="intro"></a>

## 1. Introduction

  OrgaNice! is a command line based application that can help academics with scheduling their tasks and keeping track of them.  Our application supports 2 types of tasks, they are as follows: 
 * **Deadline** Tasks - Used to denote a task that needs to be finished by a deadline.
    
     E.g, Assignments, Projects etc that are due on a specific date. 
 * **Event** Tasks - Used to denote an activity that happens over a period of time.
 
    E.g, Lectures, Tutorial sessions can be stored as events.
   
 The application can add, edit and delete tasks. It also provides methods to search for tasks. Additionally, it has the ability of storing data to a physical location on the computer, so that the tasks always remain in memory.  
    
 As a secondary feature, the application allows students who are in search of a study area to locate one based on different conditions. The different conditions that could be specified include the location, size constraints and port facilities.


<a name="quick-start"></a>

## 2. Quick Start
 
 * Ensure you have Java 11 or above installed in your Computer.
 * Download the latest OrgaNice!.jar from [here](https://github.com/AY1920S2-CS2113T-T12-3/tp/releases) and place it in an empty folder. 
 * Open Command Prompt. **NOTE: Please ensure that the command prompt is at full screen when running the jar file**
 * Navigate to the folder with the jar.
 * Type the following command:  java -jar OrgaNice!.jar to run it.
 
 A text based UI should with appear with the following lines.
  
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
        What is your name?
        ________________________________________________________________________________________________


After providing the User's name, the application will proceed to list out the supported features.
    
    ________________________________________________________________________________________________
         Hello user!
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

Upon success a successful addition message similar to the one in the example would appear.
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

Upon success a successful addition message similar to the one in the example would appear.
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
If a task is done and you want to remove it from the list this command could be used. It deletes the task at the specified index, usually one of the various view command are run to look at the index of the task to be deleted.

#### Usage

##### `delete <index number of task>` - Deletes task at specified index

The command deletes the task at the specifed index, if the index provided is valid.
Upon success a successful deletion message similar to the one in the example would appear.
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
If the work to be completed for a deadline is done but you still want to keep it in the list, this command could be used. It marks the deadline at the specified index as done, usually one of the various view command are run to look at the index of the deadline to be deleted.

#### Usage

#### `done <index of deadline>` - Mark the deadline at the specified index as done

The command deletes the task at the specifed index, if the index provided is valid.
Upon success a successful deletion message similar to the one in the example would appear.
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
If a task has any of it's details altered, you can use this command to edit the appropriate field directly. This saves you the trouble of manually deleting and adding a new task. This command is a multi-stage command so that it is easier for you to do it. This command changes the specified field of the task mentioned by it's index. To view the index of the task, one of the various command to view the list of tasks (view, priority_view, countdown) is run. 

Note: The date and time should be provided in the correct format as mentioned [here](#formats).

#### Multi-Stage

#### Usage 

#### `edit <index number of task>` - Used to edit task at specified index

The interface then displays the task and the set of attributes of the task that can be edited, if the index is valid. You can then enter the field you would like to change and then the new value to change the field into. 

The command edits the task at the specifed index at the field mentioned by you.
Upon success a successful edit message displaying the updated task's information similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
To edit the start time of the event at 2nd index of the list.
#### Multi Stage

#### `edit 2` - Specify the index of task to be edited 

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


#### `3` - Specify field to be edited based on list

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
If you would like to clear the current list of tasks and start on a clean state, this command could be used. Clears the list of tasks stored.

#### Usage

#### `clear` - Clears the list of tasks

The command clears the current list of tasks stored.
Upon success a successful deletion message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
To clear the current list of tasks.

`clear`

Expected outcome:
The list of tasks would be cleared.
Upon success a response similar to the following one would appear:

    ________________________________________________________________________________________________
         The list of tasks is cleared.
    ________________________________________________________________________________________________

<a name="view"></a>

### 3.7. View list of tasks
If you would like to view the current list of tasks, this command could be used. It shows the current list of tasks stored.

#### Usage

#### `view` - Displays the current list of tasks

The command displays the current list of tasks stored.
Upon success a successful deletion message similar to the one in the example would appear.
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
Upon success a successful deletion message similar to the one in the example would appear.
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

The command displays the current list of tasks current list of tasks with the number of days left till each task sorted by their dates.
Upon success a successful deletion message similar to the one in the example would appear.
If the wrong format is used an alert would be displayed.

Example of usage: 
To view the current list of tasks in countdown format.

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
If you would like to quickly find a task based on it's description, this command could be used. It performs a linear search of all tasks stored in the list at the point of execution and list
all the tasks containing the keyword in their description in a numbered list.

### Usage

#### `search <keyword found in task>` - Lists all matching tasks in the list containing the keyword 

The command displays all the tasks with description containg the keyword searched for in a numbered list.
Upon success a successful message similar to the one in the example would appear.
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
         Notes:
         *All dates should follow YYYY-MM-DD format
         *All timing should follow 24 hour clock
    ________________________________________________________________________________________________


<a name="schedule"></a>

### 3.12. Schedule tasks
If you have a bunch of assignments, projects and exams happening over the next few weeks and are stressed out with 
planning a schedule which can fulfill the requirements, our schedule task command can help you by creating a feasible 
schedule. It creates a schedule based on the tasks details provided by you. 

#### Usage

#### `schedule <number of task to be scheduled>` - Used to schedule a set of tasks specified by the user 

Then a set of lines are displayed which specify the format to be used to specify the new tasks to be scheduled. After you input the relevant data. The application would find a feasible schedule satisfying your constraints, if it is possible to do so. If it is possible, the list of events that were created when the task were scheduled is added to the current list of tasks. If it is impossible, a message to alert the user is specified too.
If the wrong format is used an invalid command alert would be displayed.

Example of usage: 

#### `schedule 3` - Schedule 3 tasks

Expected outcome:

    ________________________________________________________________________________________________
         Enter tasks in the following format:
         <task name> /f <Time to finish task in days> /d <Number of
         days left from current day to finish it>
         Enter details for task 1:

#### `math exam /f 2 /d 10` - Details of first task

Expected outcome:

	 Enter details for task 2:
     
#### `physics exam /f 3 /d 7` - Details of second task

Expected outcome:

	 Enter details for task 3:
     
#### `chemistry exam /f 1 /d 4` - Details of third task     

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
   The current version of the application doesn't take into account the other tasks present, however the priority 
values can still be used to decide the task which is more important. In v3.0 our application will support scheduling tasks 
while avoiding tasks present previously and also add support for tasks to be scheduled preemptively (i.e, tasks can be 
scheduled over non contiguous days) .

    
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
   a specific point of time at a specific area.

[comment]: # (@@author )     
<a name="exit"></a>

### 3.14. Exit the Application / Study Area interface
You use this command to exit the application. Before the actual application is exited the 
tasks currently in the list are stored in a file. This command is used for exiting the main interface and the
secondary study area search interface.

#### Usage

#### `bye` - Exit the Application / Study Area interface

The command when issued performs an exit.
Upon success a successful message similar to the one in the example would appear and the application would be exited.
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

### 3.15. Saving the data
The tasklist is saved automatically before the application is executed. There is no need to save manually.

<a name="clear-old-tasks"></a>

### 3.16. Clearing old tasks
The tasklist only includes the tasks which have date beyond the current date. This removes the need for you to manually find and delete the old tasks.

<a name="calendar"></a>

### 3.17. Viewing tasks in calendar format [coming in v3.0]
The tasklist only includes the tasks which have date beyond the current date. This removes the need for you to manually find and delete the old tasks.


[comment]: # (@@author )

<a name="faq"></a>

## 4. FAQ
    Q: How to transfer the task list data from one computer to an other computer?
    A: Just copy the "TaskList.txt" file which could be found at the same directory
       as the jar file and paste it to the location containing the jar file in the other
       computer. This should transfer the required data.
       
    Q: The software says that library/TaskList.txt does not exist. What do I do?
    A: Go to the software's root folder and check to see if the library folder exist. If so, delete the library folder 
       and rerun the software. The software would have created a fresh set of data files required for the system to run.
       
    Q: The software says that library/locations.txt or library/dictionary.txt does not exist. What do I do?
    A: Go to the software's root folder and check to see if the library folder exist. Proceed to check if TaskList.txt 
       exist. If so, transfer it to a temporary folder. Delete the library folder and rerun the software. Transfer the 
       content from the old TaskList.txt to the new TaskList.txt

<a name="command-summary"></a>

[comment]: # (@@author GanapathySanathBalaji)

## 5. Command Summary

### OrgaNice Main Features
`deadline <deadline details> /d <date> /t <due time> /p <priority of deadline>` - Adds a new Deadline task to the list of tasks <br>
`event <event details> /d <date> /s <start time> /e <end time> /p <priority of event>` - Adds a new Event task to the list of tasks <br>
`delete <index number of task>` - Deletes task at specified index <br>
`done <index of deadline>` - Mark the deadline at the specified index as done <br>
`edit <index number of task>` - Used to edit task at specified index <br>
`clear` - Clears the list of tasks <br>
`view` - Displays the current list of tasks <br>
`priority_view` - Displays the current list of tasks sorted by priority <br>
`countdown` - Displays the current list in countdown format <br>
`search <keyword found in task>` - Lists all matching tasks in the list containing the keyword <br>
`bye` - Exit the Application / Study Area interface <br>
`study` - Enter study area search interface <br>

### Study Area Search Interface
`{name\address\faculty} {flags}` - Returns a list of Study Areas, if any of the existing data matches the requirement 
entered. Click [here](#3132-start-search) for more details on how {name\address\faculty} and {flags} should be entered.

<a name="formats"></a>

## 6. Formats Used

Time should be in the form of `HH:MM` (24 Hour Format, HH - Hour, MM - Minute) <br>
Date should be in the form of `YYYY-MM-DD` (YYYY - Year, MM - Month, DD - Day) <br>

