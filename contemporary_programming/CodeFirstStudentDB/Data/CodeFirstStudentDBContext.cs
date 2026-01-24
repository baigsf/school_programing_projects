using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using CodeFirstStudentDB.Models;

namespace CodeFirstStudentDB.Data
{
    public class CodeFirstStudentDBContext : DbContext
    {
        public CodeFirstStudentDBContext (DbContextOptions<CodeFirstStudentDBContext> options)
            : base(options)
        {
        }

        public DbSet<CodeFirstStudentDB.Models.Student> Student { get; set; } = default!;
    }
}
