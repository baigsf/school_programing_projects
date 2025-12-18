using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProductInheritance
{
    public class Book : Product, IDisplayable
    {
        public Book() { }

        public Book(string code, string description, decimal price, string author) : 
            base(code, description, price)
        {
            Author = author;   
        }

        public string Author { get; set; }

        public string GetDisplayString(string sep)
        {
            return base.GetDisplayText(sep) + sep + Author;
        }

        public override string GetDisplayText(string sep)
        { return base.GetDisplayText(sep) + sep + Author; }

    }
}
