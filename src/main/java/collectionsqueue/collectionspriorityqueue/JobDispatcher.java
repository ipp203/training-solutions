package collectionsqueue.collectionspriorityqueue;

import collectionsqueue.job.Job;
import collectionsqueue.job.NoJobException;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {
    PriorityQueue<Job> pq = new PriorityQueue<>();

    public Queue<Job> addJob(Job... jobs) {
        for (Job job : jobs) {
            pq.add(job);
        }
        return new PriorityQueue<>(pq);
    }

    public Job dispatchNextJob(Queue<Job> jobs) throws NoJobException {
        try {
            return pq.remove();
        } catch (NoSuchElementException nse) {
            throw new NoJobException("No job available, get a rest!", nse);
        }
    }

}
