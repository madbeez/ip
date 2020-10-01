# User Guide
Duke is an **app for scheduling and keeping track of various tasks, using a Command Line Interface** (CLI). 
* [Quick Start](#quick-start)
* [Features](#features)
    * [Adding a Todo task: `todo`](#adding-a-todo-task-todo)
    * [Adding a Deadline task: `deadline`](#adding-a-deadline-task-deadline)
    * [Adding an Event task: `event`](#adding-an-event-task-event)
    * [Listing all tasks: `list`](#listing-all-tasks-list)
    * [Marking a task as done: `done`](#marking-a-task-as-done-done)
    * [Deleting a task: `delete`](#deleting-a-task-delete)
    * [Finding a task: `find`](#finding-a-task-find)
    * [Exiting the program: `bye`](#exiting-the-program-bye)
    * [Saving the list](#saving-the-list)
* [Command Summary](#command-summary)

## Quick Start
1. Ensure you have Java 11 or above installed in your Computer.

2. Download the latest duke.jar.

3. Copy the file to the folder you want to use as the home folder for your program.

4. Using the terminal, navigate to the location of the .jar file.

5. Type "java -jar duke.jar" into the terminal and press enter.

6. If you have followed the above steps correctly, you should see a welcome message.

## Features
### Adding a Todo task: `todo`
Adds a new Todo task to the task list.

Format: `todo TASK_DESCRIPTION`

Example:
`todo read textbook`

Expected output:
```
I've added:
  [T][✘] read textbook
Now you have 5 tasks in the list.
```

### Adding a Deadline task: `deadline`
Adds a new Deadline task to the task list.

Format: `deadline TASK_DESCRIPTION /yyyy-MM-dd`

Example:
`deadline CS1010 assignment /2020-12-12`

Expected output:
```
I've added:
  [D][✘] CS1010 assignment (by:Dec 12 2020)
Now you have 6 tasks in the list.
```

### Adding an Event task: `event`
Adds a new Event task to the task list.

Format: `event TASK_DESCRIPTION /yyyy-MM-dd`

Example:
`event Watch movie /2020-12-12`

Expected output:
```
I've added:
  [E][✘] Watch movie (at:Dec 12 2020)
Now you have 7 tasks in the list.
```

### Listing all tasks: `list`
Shows a list of all tasks.

Format: `list`

Expected output:
```
Here are the tasks in your list:
1.[T][✘] read textbook
2.[D][✘] CS1010 assignment (by:Dec 12 2020)
3.[E][✘] Watch movie (at:Dec 12 2020)
```
### Marking a task as done: `done`
Marks the specified task as done.

Format: `done TASK_INDEX`

Example:
`done 2`

Expected output:
```
Nice! I've marked this task as done:
  [D][✓] CS1010 assignment (by:Dec 12 2020)
```

### Deleting a task: `delete`
Deletes the specified task from the task list.

Format: `delete TASK_INDEX`

Example:
`delete 5`

Expected output:
```
Understood. I've removed this task:
  [D][✘] finish homework (by:Nov 11 2021)
Now you have 6 tasks in the list.
```

### Finding a task: `find`
Finds task which description contains any of the given keywords.

Format: `find KEYWORD`

Example:
`find assignment`

Expected output:
```
Here are the matching tasks for your search. 
1.[D][✘] CS1010 assignment (by:Dec 12 2020)
```

### Exiting the program: `bye`
Exits the program.

Format: `bye`

Expected output:
```
Goodbye! See you soon!
```

### Saving the list:

The list of tasks is automatically saved in the hard disk after any changes are made.


## Command Summary

**Action** | **Format, Examples**
------------ | -------------
**todo**|`todo TASK_DESCRIPTION` e.g., `todo study for exams`
**deadline**|`deadline TASK_DESCRIPTION /yyyy-MM-dd` e.g., `deadline CS1010 assignment /2020-12-06`
**event**|`event TASK_DESCRIPTION /yyyy-MM-dd`<br>e.g., `event Birthday party /2020-09-11`
**list**|`list`
**done**|`done TASK_INDEX` e.g., `done 5`
**delete**|`delete TASK_INDEX` e.g., `delete 2`
**find**|`find KEYWORD`e.g., `find test`
**exit**|`bye`
