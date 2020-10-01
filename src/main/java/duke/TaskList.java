package duke;

import duke.task.Task;

import java.util.ArrayList;

/**
 *Stores the task list and contains operations on the task list
 **/
public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public ArrayList<Task> getTasks() {
        return this.taskList;
    }

    /**
     * Returns a task based on the provided index
     *
     * @param index The index of the desired task
     * @return the task with the corresponding index
     */
    public Task getTask(int index) {
        return taskList.get(index - 1);
    }

    public int getSize() {
        return taskList.size();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void removeTask(int index) {
        taskList.remove(index - 1);
    }

}
