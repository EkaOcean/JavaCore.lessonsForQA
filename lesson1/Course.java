package lesson1;

public class Course {
    Competition[] competitions;

    public Course(Competition[] competitions){
        this.competitions = competitions;
    }

    public void doIt(Team team){
        TeamPlayers[] teamMembers = team.getMembers();
        if(teamMembers.length > 0){
            for (TeamPlayers players: teamMembers){
                for (Competition comp: competitions){
                    comp.doIt(players);
                    if (!players.isOnDistance()) break;
                }
            }
        } else {
            System.out.println("В команде нет ни одного игрока");
        }
    }
}
