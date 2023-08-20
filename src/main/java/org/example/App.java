package org.example;

import org.kohsuke.github.*;

public class App
{
    public static void main( String[] args )
    {
        String authToken = "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";
        String owner = "Larisa-Pomidor";
        String repoName = "TestWorkflow";
        String commitSha = "20ec40c0ddb0fdb26b41574e3c9f7856211dce86";

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
