package org.example;

import org.kohsuke.github.*;

public class App
{
    public static void main( String[] args )
    {
        String authToken = "--";
        String owner = "Larisa-Pomidor";
        String repoName = "TestWorkflow";
        String commitSha = "9ab165b15851dfaab5a2af7dff9cd4ad7e7d4be5";

        try {
            GitHub github = new GitHubBuilder().withOAuthToken(authToken).build();
            GHRepository repository = github.getRepository(owner + "/" + repoName);

            GHCommit commit = repository.getCommit(commitSha);
            PagedIterable<GHCommitStatus> commitStatuses = commit.listStatuses();

            for (GHCommitStatus status : commitStatuses) {
                System.out.println("Context: " + status.getContext());
                System.out.println("State: " + status.getState());
                System.out.println("Description: " + status.getDescription());
                System.out.println("-------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
