namespace FinalProject.Models
{
    public class TeamMembers
    {
        public int Id { get; set; }

        public string FullName { get; set; }

        public string Birthdate { get; set; }

        public string CollegeProgram { get; set; }

        public string YearInProgram { get; set; }

        public string Email { get; set; }

        public TeamMembers() { }

        public TeamMembers(
            int id,
            string fullName,
            string birthdate,
            string collegeProgram,
            string yearInProgram,
            string email
        )
        {
            Id = id;
            FullName = fullName;
            Birthdate = birthdate;
            CollegeProgram = collegeProgram;
            YearInProgram = yearInProgram;
            Email = email;
        }
    }
}