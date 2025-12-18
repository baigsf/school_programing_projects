using ProductInheritance.Models.DataLayer;
using static Microsoft.EntityFrameworkCore.DbLoggerCategory;
using System.CodeDom.Compiler;

namespace ProductInheritance
{
    public partial class ProductMaintenance : Form
    {
        private MMABooksContext _context;
        private Customer _customer;
       

        public ProductMaintenance()
        {
            InitializeComponent();
        }

        private void ProductMaintenance_Load(object sender, EventArgs e)
        {
            _context = new MMABooksContext();
            _customer = _context.Customers.Find(2);
            lstProducts.Items.Add(_customer.GetCustomerText(";"));
            

            var list = new List<Product>()
            {
                new Book("B1", "The Alchemist", 34.99m, "Paulo Coelho"),
                new Software("S1", "Windows 11", 119.99m, "Microsoft")
            };
            foreach (var item in list)
            {
                lstProducts.Items.Add(item.GetDisplayText("; "));
            }
            var otherList = new List<IDisplayable>
            {
                new Book("B1", "The Alchemist", 34.99m, "Paulo Coelho"),
                new Software("S1", "Windows 11", 119.99m, "Microsoft")
            };
            otherList.ForEach(x => lstProducts.Items.Add(x.GetDisplayString(":")));

            //Step1: Get the data source
            List<Invoice> invoices = _context.Invoices.ToList();

            //Display all invoices in the Inoices List
            invoices.ForEach(x => lstInvoices.Items.Add(x.GetInvoices(",")));

            //Step2: Define a query (using Linq expression)          
            //var selectedInv = from inv in invoices
            //                   where inv.ProductTotal > 100
            //                   select inv;

            //Step3: Execute the query (based of the Linq expression query) and display th filtered data
            // in the Filtered List

            // foreach (var inv in selectedInv)
            //     lstFiltered.Items.Add(inv.GetInvoices(";"));

            //Step2: Define a query (using Linq methods)
            var selectedInv = invoices.Where(inv => inv.ProductTotal > 100)
                                      .OrderBy (inv => inv.InvoiceDate)
                                      .ThenByDescending(inv => inv.ProductTotal)
                                      .Select(inv => new {inv.InvoiceDate, inv.ProductTotal });

            //Step 3: Execute the query (based on the Linq methods query) and display th filtered data
            // in the Filtered List
            foreach (var inv in selectedInv) {
              lstFiltered.Items.Add((inv.InvoiceDate.ToString() + inv.ProductTotal.ToString()));
            }
        }
    }
}
