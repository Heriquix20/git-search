package br.com.hcgv.gitsearch;

public class User {

    private String name;
    private String bio;
    private int followers;
    private int following;
    private int public_repos;

    public User(String name) throws usuarioNaoEncontradoException {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nUserName = " + name +
                "\nBio = " + bio  +
                "Followers = " + followers +
                "\nFollowing = " + following +
                "\nRepositories = " + public_repos;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

    public int getPublic_repos() {
        return public_repos;
    }
}