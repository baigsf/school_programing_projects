using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using WebApiDemo.Models;

namespace WebApiDemo.Data
{
    public class WebApiDemoContext : DbContext
    {
        public WebApiDemoContext (DbContextOptions<WebApiDemoContext> options)
            : base(options)
        {
        }

        public DbSet<WebApiDemo.Models.Student> Student { get; set; } = default!;
        public DbSet<WebApiDemo.Models.Course> Course { get; set; } = default!;
    }
}
