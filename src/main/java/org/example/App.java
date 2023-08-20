package org.example;

import org.kohsuke.github.*;

public class App
{
    public static void main( String[] args )
    {
        String authToken = "///";
        String owner = "Larisa-Pomidor";
        String repoName = "TestWorkflow";
        String commitSha = "5a384e1f72b1a5ca6157b4d466632a77d1b11775";

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
