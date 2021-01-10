package collectionsqueue.collectionsdeque;

import collectionsqueue.job.Job;
import collectionsqueue.job.NoJobException;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class JobQueue {


    public Deque<Job> addJobByUrgency(Job... jobs) {
        Deque<Job> d = new ArrayDeque<>();
        for (Job job : jobs) {
            if (job.isUrgent()) {
                d.addFirst(job);
            } else {
                d.addLast(job);
            }
        }
        return d;
    }

    public Job dispatchUrgentJob(Deque<Job> jobs){
        try {
            if (jobs.peekFirst().isUrgent()) {

                return jobs.getFirst();
            } else {
                throw new NoJobException("No any urgent job");
            }
        } catch (NoSuchElementException | NullPointerException e) {
            throw new NoJobException("No job available, get a rest!", e);
        }
    }

    public Job dispatchNotUrgentJob(Deque<Job> jobs){
        try {
            if (!jobs.peekLast().isUrgent()) {

                return jobs.getLast();
            } else {
                throw new NoJobException("No any noturgent job");
            }
        } catch (NoSuchElementException | NullPointerException e) {
            throw new NoJobException("No job available, get a rest!", e);
        }
    }
}
