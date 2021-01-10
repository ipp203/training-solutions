package collectionsqueue.collectionspriorityqueue;

import collectionsqueue.job.Job;
import collectionsqueue.job.NoJobException;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {


    public Queue<Job> addJob(Job... jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>();
        Collections.addAll(pq,jobs);
        return pq;
    }

    public Job dispatchNextJob(Queue<Job> jobs) {
        try {
            return jobs.remove();
        } catch (NoSuchElementException nse) {
            throw new NoJobException("No job available, get a rest!", nse);
        }
    }

}
