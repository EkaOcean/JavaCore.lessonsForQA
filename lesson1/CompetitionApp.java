package lesson1;


public class CompetitionApp {
    public static void main(String[] args) {

        TeamPlayers[] competitors = {new PlayerNumberOne("Alex"), new PlayerNumberTwo("Jane"),
                                     new PlayerNumberThree("Mike"), new PlayerNumberFour("Kate")};
        Competition[] competitions = {new RunDistance(100), new JumpDistance(6)};

        Course course = new Course(competitions);
        Team team = new Team("Winners", competitors);

        System.out.println("                Новая команда");
        System.out.println(team.getTeamName());
        System.out.println();

        System.out.println("                Участники команды");
        team.showResults();
        System.out.println();

        System.out.println("                Участники проходят полосу препятствий");
        course.doIt(team);
        System.out.println();

        System.out.println("                Результаты участников");
        team.showResults();
        System.out.println();

        System.out.println("                Участники, прошедшие соревнования");
        team.showMembersFinishedCourse();
    }
}
