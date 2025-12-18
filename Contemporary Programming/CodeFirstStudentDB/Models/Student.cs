namespace CodeFirstStudentDB.Models
{
    public class Student
    {
        public int StudentId { get; set; }

        public string Name { get; set; }

        public int Age { get; set; }

        public string City { get; set; }

        public Student() { }

        public Student(int studentId, string name, int age, string city)
        {
            StudentId = studentId;
            Name = name;
            Age = age;
            City = city;
        }
    }
}
