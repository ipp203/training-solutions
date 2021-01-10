package collectionsqueue.collectionsdeque;

import collectionsqueue.job.Job;
import collectionsqueue.job.NoJobException;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class JobQueue {
    Deque<Job> d = new ArrayDeque<>();

    public Deque<Job> addJobByUrgency(Job... jobs) {
        for (Job job : jobs) {
            if (job.isUrgent()) {
                d.addFirst(job);
            } else {
                d.addLast(job);
            }
        }
        return new ArrayDeque<>(d);
    }

    public Job dispatchUrgentJob(Deque<Job> jobs) throws NoJobException {
        try {
            if (d.peekFirst().isUrgent()) {

                return d.getFirst();
            } else {
                throw new NoJobException("No any urgent job");
            }
        } catch (NoSuchElementException | NullPointerException e) {
            throw new NoJobException("No job available, get a rest!", e);
        }
    }

    public Job dispatchNotUrgentJob(Deque<Job> jobs) throws NoJobException {
        try {
            if (!d.peekLast().isUrgent()) {

                return d.getLast();
            } else {
                throw new NoJobException("No any noturgent job");
            }
        } catch (NoSuchElementException | NullPointerException e) {
            throw new NoJobException("No job available, get a rest!", e);
        }
    }
}
