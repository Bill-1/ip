# Ujin project template

This is a chatbot for marking your activities.

## Starting process
Use ./gradlew run command to see the interface for the chatbot. 

## Messages you can write
You can add tasks to your tasklist with the commands:
* todo <your task>
* event <your task> /from <time> /to <time>
* deadline <your task> /by <time>

Notice that <time> has to be in format MM/DD. 

**list** is for when you want to list your tasks. 
**mark <index>** is for checking the task as done.
**unmark <index>** is for unchecking the task as not done.
**delete <index>** is for deleting the task.
**find <keyword>** is for finding the tasks that has <keyword> in them. 

Note that index has to be number and less than the number of tasks in your tasklist.

Enjoy your app.

