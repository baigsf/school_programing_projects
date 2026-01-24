using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using WebApiDemo.Data;
using WebApiDemo.Models;

namespace WebApiDemo.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class StudentsController : ControllerBase
    {
        private readonly WebApiDemoContext _context;

        public StudentsController(WebApiDemoContext context)
        {
            _context = context;
        }

        //GET: api/Students

        [HttpGet]
        public IActionResult GetStudents()
        {
            var students = _context.Student.ToList();
            return Ok(students);
        }

        [HttpGet("{id}")]
        public IActionResult GetStudent(int id)

        {
            Student student = _context.Student.Find(id);
            if (student == null)
            {
                return NotFound();
            }
            return Ok(student);
        }


        [HttpPost]
        public IActionResult PostStudent(Student student) 
        {
            try
            {
                _context.Student.Add(student);
                _context.SaveChanges();
            }
            catch (Exception ex)
            { 
                return BadRequest(ex.Message);
            }
            return Ok();
        }

        [HttpDelete("{id}")]
        public IActionResult DeleteStudent(int id)
        {
            Student student = _context.Student.Find(id);
            if (student == null)
            {  
                return NotFound(); 
            }
            try
            {
                _context.Student.Remove(student);
                _context.SaveChanges();
            }
            catch (Exception ex)
            {
                return BadRequest(ex.Message);
            }
            return Ok();
        }

        [HttpPut]
        public IActionResult PutStudent(Student student)
        {
            // var s = _context.Student.Find(student.Id);
            // if (s == null)
            //  {  
            //   return NotFound(); 
            // }
            //  s.Name= student.Name;
            // s.Age= student.Age;
            //  _context.Student.Update(s);
            // return Ok();

            try
            {
                _context.Entry(student).State = EntityState.Modified;
                _context.SaveChanges();
            }

            catch (Exception ex) 
            {
                return NotFound();            
            }
            return Ok();
        }

    }
}


