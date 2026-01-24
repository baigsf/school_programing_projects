using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using FinalProject.Data;
using FinalProject.Models;

namespace FinalProject.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class MoviesController : ControllerBase
    {
        private readonly FinalProjectContext _context;

        public MoviesController(FinalProjectContext context)
        {
            _context = context;
        }

        [HttpGet]
        public async Task<ActionResult> Get([FromQuery] int? id)
        {
            if (id == null || id == 0)
            {
                var firstFive = await _context.Movie
                    .OrderBy(m => m.Id)
                    .Take(5)
                    .ToListAsync();
                return Ok(firstFive);
            }

            var item = await _context.Movie.FindAsync(id.Value);
            if (item == null) return NotFound();
            return Ok(item);
        }

        [HttpPost]
        public async Task<ActionResult<Movies>> Post([FromBody] Movies model)
        {
            _context.Movie.Add(model);
            await _context.SaveChangesAsync();
            return CreatedAtAction(nameof(Get), new { id = model.Id }, model);
        }

        [HttpPut("{id:int}")]
        public async Task<IActionResult> Put(int id, [FromBody] Movies model)
        {
            if (id != model.Id) return BadRequest("Route id and body id must match.");

            var exists = await _context.Movie.AnyAsync(m => m.Id == id);
            if (!exists) return NotFound();

            _context.Entry(model).State = EntityState.Modified;
            await _context.SaveChangesAsync();
            return NoContent();
        }

        [HttpDelete("{id:int}")]
        public async Task<IActionResult> Delete(int id)
        {
            var entity = await _context.Movie.FindAsync(id);
            if (entity == null) return NotFound();

            _context.Movie.Remove(entity);
            await _context.SaveChangesAsync();
            return NoContent();
        }
    }
}

