namespace FinalProject.Models
{
    public class Movies
    {
        public int Id { get; set; }

        public string Title { get; set; }

        public string ReleaseDate { get; set; }

        public string Genre { get; set; }

        public string Rating { get; set; }

        public string Description { get; set; }

        public Movies() { }

        public Movies(
            int id,
            string title,
            string releaseDate,
            string genre,
            string rating,
            string description
        )
        {
            Id = id;
            Title = title;
            ReleaseDate = releaseDate;
            Genre = genre;
            Rating = rating;
            Description = description;
        }
    }
}