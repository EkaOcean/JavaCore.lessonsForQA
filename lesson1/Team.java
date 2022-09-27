package lesson1;

public class Team {
    private String teamName;
    TeamPlayers[] teamMemb = new TeamPlayers[4];


    public Team(String teamName, TeamPlayers[] teamMembers) {
        this.teamName = teamName;
        this.teamMemb = teamMembers;
    }

    public String getTeamName() {
        return "Team name: " + teamName;
    }

    public TeamPlayers[] getMembers() {
        return teamMemb;
    }

    public void showResults() {
        for (TeamPlayers players : teamMemb) {
            players.showResult();
        }
    }
    public void showMembersFinishedCourse(){
        for(TeamPlayers players: teamMemb){
            if(players.isOnDistance())
                players.showResult();
        }
    }
}
