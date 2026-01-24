namespace FinalProject.Models
{
    public class Books
    {
        public int Id { get; set; }

        public string Title { get; set; }

        public string PublishDate { get; set; }

        public string Author { get; set; }

        public string Genre { get; set; }

        public string Rating { get; set; }

        public string Description { get; set; }

        public Books() { }

        public Books(
            int id,
            string title,
            string publishDate,
            string author,
            string genre,
            string rating,
            string description
        )
        {
            Id = id;
            Title = title;
            PublishDate = publishDate;
            Author = author;
            Genre = genre;
            Rating = rating;
            Description = description;
        }
    }
}

