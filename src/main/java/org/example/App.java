package org.example;

import org.kohsuke.github.*;

public class App
{
    public static void main( String[] args )
    {
        String authToken = "888";
        String owner = "Larisa-Pomidor";
        String repoName = "TestWorkflow";
        String commitSha = "a445a73bf133a92977349c26b3965b2ab2bdbd14";

        try {
            GitHub github = new GitHubBuilder().withOAuthToken(authToken).build();
            GHRepository repository = github.getRepository(owner + "/" + repoName);

            GHCommit commit = repository.getCommit(commitSha);
            PagedIterable<GHCommitStatus> commitStatuses = commit.listStatuses();

            for (GHCommitStatus status : commitStatuses) {
                System.out.println("Context: " + status.getContext());
                System.out.println("State: " + status.getState());
                System.out.println("-------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
