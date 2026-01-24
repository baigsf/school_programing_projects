using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProductInheritance
{
    public class Software : Product, IDisplayable
    {
        public Software() { }

        public Software(string code, string description, decimal price, string company) : 
            base(code, description, price)
        {
            Company = company;
        }
        public override string GetDisplayText(string sep)
        {
            return base.GetDisplayText(sep) + sep + Company;
        }

        public string GetDisplayString(string sep)
        {
            return base.GetDisplayText(sep) + sep + Company;
        }

        public string Company { get; set; } 


    }
}
