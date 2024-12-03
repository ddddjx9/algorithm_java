package priorityQueue.dataStructure;

import priorityQueue.impl.Priority;

public class Entry implements Priority {
    public String value;
    public int priority;

    public Entry(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    @Override
    public int priority() {
        return priority;
    }

    @Override
    public String toString() {
        return "(" + value + " priority = " + priority + ")";
    }
}
