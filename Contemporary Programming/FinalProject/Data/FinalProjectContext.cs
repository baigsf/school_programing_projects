using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using FinalProject.Models;

namespace FinalProject.Data
{
    public class FinalProjectContext : DbContext
    {
        public FinalProjectContext (DbContextOptions<FinalProjectContext> options)
            : base(options)
        {
        }

        public DbSet<FinalProject.Models.TeamMembers> TeamMembers { get; set; } = default!;
        public DbSet<FinalProject.Models.Movies> Movie { get; set; } = default!;
        public DbSet<FinalProject.Models.Books> Books { get; set; } = default!;
        public DbSet<FinalProject.Models.Food> Food { get; set; } = default!;
    }
}
