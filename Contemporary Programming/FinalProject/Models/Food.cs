namespace FinalProject.Models
{
    public class Food
    {
        public int Id { get; set; }

        public string Name { get; set; }
        public string Category { get; set; }
        public string Calories { get; set; }
        public string IsHot { get; set; }
        public string Description { get; set; }

        public Food() { }

        public Food(
            int id,
            string name,
            string category,
            string calories,
            string isHot,
            string description
        )
        {
            Id = id;
            Name = name;
            Category = category;
            Calories = calories;
            IsHot = isHot;
            Description = description;
        }
    }
}