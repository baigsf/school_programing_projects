namespace MyMVCApp.Models
{
    public class Student
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public int Age { get; set; }
        public string City { get; set; }

        public Student() { }
        public Student(int id, string name, int age, string city)
        {
            Id = id;
            Name = name;
            this.Age = age;
            this.City = city;
        }
    }
}
