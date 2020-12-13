package ioprintwriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {
    private List<Production> productions = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();

    public List<Production> getProductions() {
        return new ArrayList<>(productions);
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void readTalents(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                productions.add(new Production(Integer.parseInt(data[0]), data[1]));

            }
        } catch (IOException e) {
            throw new IllegalStateException("", e);
        }
    }

    public void calculateVotes(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                int id = Integer.parseInt(line);
                Vote v = findVoteById(id);
                if (v == null) {
                    votes.add(new Vote(id, 1));
                } else {
                    v.incNum();
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("", e);
        }
    }

    public void writeResultToFile(Path path) {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path))) {
            int maxVote = 0;
            Production winner = null;
            for (Production pr : productions) {
                writer.print(pr.getId() + " ");
                writer.print(pr.getName() + " ");
                int vote = findVoteById(pr.getId()).getNumber();
                writer.println(vote);
                if (vote > maxVote) {
                    maxVote = vote;
                    winner = pr;
                }
            }
            if (winner != null) {
                writer.println("Winner: " + winner.getName());
            }
        } catch (IOException | NullPointerException e) {
            throw new IllegalStateException("", e);
        }
    }

    private Vote findVoteById(int id) {
        for (Vote v : votes) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }
}
