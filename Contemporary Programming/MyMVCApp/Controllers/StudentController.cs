using Microsoft.AspNetCore.Mvc;
using MyMVCApp.Models;

namespace MyMVCApp.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class StudentController : Controller
    {
        private readonly ILogger<StudentController> _logger;

        public StudentController(ILogger<StudentController> logger)
        {
           _logger = logger;
        }
        [HttpGet]
        public IActionResult GetStudent()
        {
            List<Student> students = new List<Student>
            {
                new Student(1, "Alice", 22, "New York"),
                new Student(2, "Bob", 24, "LA"),
                new Student(3, "Charlie", 23, "Chicago")
            };
            return Ok(students);
        }

        [HttpPost]
        public IActionResult Post([FromBody] List<Student> students)
        {
            if (students == null)
            { return BadRequest("Student Object is null!"); }

            return Ok("Student Data Has Been Successfully Saved. \n" + students[1].Name + "\n" + students[1].Age + "\n" + students[1].City);
        }
    }
}
