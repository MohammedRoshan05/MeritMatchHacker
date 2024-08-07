package com.example.meritmatch_hacker;
import java.time.LocalDate;

public class ClassTaskDetails {
    String PostedBy;
    String Title;
    String Description;
    int Reward;
    String Status;
    String Resolver;
    int Rating;
    String Deadline;

    public ClassTaskDetails(String postedBy, String title, String description, int reward,
                            String status, String resolver, int rating, String deadline) {
        PostedBy = postedBy;
        Title = title;
        Description = description;
        Reward = reward;
        Status = status;
        Resolver = resolver;
        Rating = rating;
        Deadline = deadline;
    }

    public String getDeadline() {
        return Deadline;
    }

    public void setDeadline(String deadline) {
        Deadline = deadline;
    }

    public String getPostedBy() {
        return PostedBy;
    }

    public void setPostedBy(String postedBy) {
        PostedBy = postedBy;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getReward() {
        return Reward;
    }

    public void setReward(int reward) {
        Reward = reward;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getResolver() {
        return Resolver;
    }

    public void setResolver(String resolver) {
        Resolver = resolver;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }
}
